package iprogr.constructionFirm;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.env.Environment;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileRepository<T extends BaseEntity>implements BaseRepo<T> {

    private final Class clazz;

    private String storageFile;

    private List<T> entities;

    public FileRepository(Class clazz, Environment env) {
        this.clazz = clazz;
        storageFile = clazz.getSimpleName() + "." + env.getProperty("sources.storageFile");
    }

    public T findOne(Integer id) throws IOException {
        return getAll()
                .stream()
                .filter(entity -> entity.getId() != null && entity.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    public T save(T entity) throws IOException {
        if (entity.getId() != null) {
            return update(entity);
        }
        getAll().add(generateId(entity));
        writeFile();
        return entity;
    }

    public T update(T entity) throws IOException {
        // init collection if need;
        getAll();
        for (int i = 0; i < entities.size(); i++) {
            Integer listEntityId = entities.get(i).getId();
            if (listEntityId != null && listEntityId.equals(entity.getId())) {
                entities.set(i, entity);
            }
        }
        writeFile();
        return entity;
    }

    private T generateId(T entity) {
        entity.setId(entities.stream().mapToInt(e -> e.getId()).max().orElse(0) + 1);
        return entity;
    }

    public List<T> getAll() throws IOException {
        if (entities == null) {
            entities = readFile();
        }
        return entities;
    }

    private List<T> readFile() throws IOException {
        List<T> result;
        File dataFile = new File(storageFile);
        if (!dataFile.exists()) {
            dataFile.createNewFile();
        }
        try {
            ObjectMapper mapper = new ObjectMapper();
            JavaType type = mapper.getTypeFactory().constructArrayType(clazz);
            result = new ArrayList<>(Arrays.asList(mapper.readValue(dataFile, type)));
        } catch (JsonMappingException ex) {
            result = new ArrayList<>();
        }
        return result;
    }

    private void writeFile() throws IOException {
        new ObjectMapper()
                .writer(new DefaultPrettyPrinter())
                .writeValue(new File(storageFile), entities);
    }
}

package iprogr.constructionFirm;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public interface BaseRepo<T> {

    T findOne(Integer id)throws IOException;

    T save(T entity) throws IOException;

    List<T> getAll() throws  IOException;
}

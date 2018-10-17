package iprogr.constructionFirm.message;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message {

    public enum MessageStatus {
        PENDING("В ожидании ответа"),
        ANSWERED("Отвечено");

        private String name;

        MessageStatus(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String text;

    private String senderMail;

    private MessageStatus status;

    public Integer getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getSenderMail() {
        return senderMail;
    }

    public MessageStatus getStatus() {
        return status;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setSenderMail(String senderMail) {
        this.senderMail = senderMail;
    }

    public void setStatus(MessageStatus status) {
        this.status = status;
    }
}

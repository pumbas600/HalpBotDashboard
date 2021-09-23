package nz.pumbas.halpbotdashboard.hibernate.models;

public class Topic {

    private Long id;
    private String topic;

    public Topic() { }

    public Topic(Long id, String topic) {
        this.id = id;
        this.topic = topic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}

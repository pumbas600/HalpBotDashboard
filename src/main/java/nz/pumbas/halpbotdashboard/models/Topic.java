package nz.pumbas.halpbotdashboard.models;

public final class Topic {

    private long id;
    private String topic;

    public Topic() { }

    public Topic(long id, String topic) {
        this.id = id;
        this.topic = topic;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}

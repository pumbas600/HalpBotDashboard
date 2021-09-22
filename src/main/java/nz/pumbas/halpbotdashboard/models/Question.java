package nz.pumbas.halpbotdashboard.models;

import java.util.Objects;

public final class Question {

    private long id;
    private long topicId;
    private String topic;
    private String question;
    private String answer;
    private String optionB;
    private String optionC;
    private String optionD;

    public Question() {  }

    public Question(long id, long topicId, String question, String answer, String optionB, String optionC, String optionD) {
        this.id = id;
        this.topicId = topicId;
        this.question = question;
        this.answer = answer;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
    }

    public Question(long id, String topic, String question, String answer, String optionB, String optionC, String optionD) {
        this.id = id;
        this.topic = topic;
        this.question = question;
        this.answer = answer;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
    }

    public long getId() {
        return id;
    }

    public long getTopicId() {
        return topicId;
    }

    public String getTopic() {
        return topic;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public String getOptionB() {
        return optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTopicId(long topicId) {
        this.topicId = topicId;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", topicId=" + topicId +
                ", topic='" + topic + '\'' +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", optionB='" + optionB + '\'' +
                ", optionC='" + optionC + '\'' +
                ", optionD='" + optionD + '\'' +
                '}';
    }
}

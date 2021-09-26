package nz.pumbas.halpbotdashboard.hibernate.models;

import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "QUESTION_MODIFICATIONS")
public class QuestionModification implements Serializable
{
    @Id
    @GeneratedValue
    private Long id;
    private Long modifiedQuestionId;
    private Long topicId;
    private String question;
    private String answer;
    private String optionB;
    private String optionC;
    private String optionD;
    private String explanation;
    private String image;
    private Modification modification;
    private final String dType = this.getClass().getSimpleName();

    public QuestionModification() { }

    public QuestionModification(Long modifiedQuestionId, Long topicId, String question, String answer,
                                String optionB, String optionC, String optionD, String explanation, String image,
                                Modification modification) {
        this.id = null;
        this.topicId = topicId;
        this.question = question;
        this.answer = answer;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.explanation = explanation;
        this.image = image;
        this.modifiedQuestionId = modifiedQuestionId;
        this.modification = modification;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getModifiedQuestionId() {
        return modifiedQuestionId;
    }

    public void setModifiedQuestionId(Long modifiedQuestionId) {
        this.modifiedQuestionId = modifiedQuestionId;
    }

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Modification getModification() {
        return modification;
    }

    public void setModification(Modification modification) {
        this.modification = modification;
    }

    public static QuestionModification of(Question question, Modification modification) {
        return new QuestionModification(question.getId(), question.getTopicId(),
            question.getQuestion(), question.getAnswer(), question.getOptionB(), question.getOptionC(),
            question.getOptionD(), question.getExplanation(), question.getImage(), modification);
    }
}

package nz.pumbas.halpbotdashboard.hibernate.models;

import com.sun.istack.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Validated
@Entity
@Table(name = "QUESTIONS")
public class Question implements Serializable
{
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private Long topicId;

    @NotBlank(message = "Message is required")
    @Length(max = 1023, message = "The question must be less than 1023 characters long")
    private String question;

    @NotBlank(message = "Answer is required")
    @Length(max = 511, message = "The answer must be less than 511 characters long")
    private String answer;

    @NotBlank(message = "Option B is required")
    @Length(max = 511, message = "Option B must be less than 511 characters long")
    private String optionB;

    @Length(max = 511, message = "Option C must be less than 511 characters long")
    private String optionC;

    @Length(max = 511, message = "Option D must be less than 511 characters long")
    private String optionD;

    @Length(max = 2047, message = "The explanation must be less than 511 characters long")
    private String explanation;

    @Length(max = 10, message = "The image link must be less than 255 characters")
    private String image;
    private final String dType = this.getClass().getSimpleName();

    public Question() {  }

    public Question(Long id, Long topicId, String question, String answer, String optionB, String optionC,
                    String optionD, String explanation, String image)
    {
        this.id = id;
        this.topicId = topicId;
        this.question = question;
        this.answer = answer;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.explanation = explanation;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public Long getTopicId() {
        return topicId;
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

    public String getExplanation() {
        return explanation;
    }

    public String getImage() {
        return image;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
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

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return Objects.equals(id, question1.id)
            && Objects.equals(topicId, question1.topicId)
            && Objects.equals(question, question1.question)
            && Objects.equals(answer, question1.answer)
            && Objects.equals(optionB, question1.optionB)
            && Objects.equals(optionC, question1.optionC)
            && Objects.equals(optionD, question1.optionD)
            && Objects.equals(explanation, question1.explanation)
            && Objects.equals(image, question1.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, topicId, question, answer, optionB, optionC, optionD, explanation, image);
    }
}

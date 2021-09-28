package nz.pumbas.halpbotdashboard.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

import nz.pumbas.halpbotdashboard.hibernate.exceptions.BadResourceException;
import nz.pumbas.halpbotdashboard.hibernate.exceptions.ResourceNotFoundException;
import nz.pumbas.halpbotdashboard.hibernate.models.Question;
import nz.pumbas.halpbotdashboard.hibernate.models.Status;
import nz.pumbas.halpbotdashboard.hibernate.models.Topic;
import nz.pumbas.halpbotdashboard.hibernate.services.QuestionService;
import nz.pumbas.halpbotdashboard.hibernate.services.TopicService;

@Controller
public class QuestionsController {

    //Refer to: https://www.dariawan.com/tutorials/spring/spring-boot-thymeleaf-crud-example/

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final int ROWS_PER_PAGE = 25;

    private final QuestionService questionService;
    private final TopicService topicService;

    public QuestionsController(QuestionService questionService, TopicService topicService)
    {
        this.questionService = questionService;
        this.topicService = topicService;
    }

    @GetMapping("/questions")
    public String getQuestions(
        Model model,
        @RequestParam(value = "page", defaultValue = "1") int pageNumber)
    {
        List<Question> questions = this.questionService.list(pageNumber - 1, ROWS_PER_PAGE);
        long questionCount = this.questionService.count();
        long pageCount = (long) Math.ceil(questionCount / (double)ROWS_PER_PAGE);

        boolean hasPrevious = 1 < pageNumber;
        boolean hasNext = pageNumber < pageCount;


        model.addAttribute("hasPrevious", hasPrevious);
        model.addAttribute("previous", pageNumber - 1);
        model.addAttribute("hasNext", hasNext);
        model.addAttribute("next", pageNumber + 1);
        model.addAttribute("current", pageNumber);
        model.addAttribute("pageCount", pageCount);

        model.addAttribute("question", new Question()); //This will be populated by the form.
        model.addAttribute("questions", questions);
        return "questions";
    }

    @PostMapping("/questions/{pageNumber}/add")
    public String addQuestion(
        @PathVariable int pageNumber,
        @ModelAttribute("addedQuestion") Question addedQuestion)
    {
        try {
            addedQuestion.setStatus(Status.ADDED);
            addedQuestion.setEmptyFieldsNull();
            this.questionService.save(addedQuestion);
        }
        catch (BadResourceException e) {
            String errorMessage = e.getMessage();
            this.logger.error(errorMessage);
        }
        return "redirect:/questions?page=" + pageNumber;
    }

    @PostMapping("/questions/{pageNumber}/edit")
    public String editQuestion(
        @PathVariable int pageNumber,
        @ModelAttribute("editedQuestion") Question editedQuestion)
    {
        try {
            Question originalQuestion = this.questionService.findById(editedQuestion.getId());

            // Check that a change has actually been made
            if (!originalQuestion.equals(editedQuestion)) {
                editedQuestion.setStatus(Status.EDITED);
                editedQuestion.setEditedId(editedQuestion.getId());
                editedQuestion.setId(null);
                editedQuestion.setEmptyFieldsNull();

                this.questionService.save(editedQuestion);
            }
         }
        catch (ResourceNotFoundException | BadResourceException e) {
            String errorMessage = e.getMessage();
            this.logger.error(errorMessage);
        }
        return "redirect:/questions?page=" + pageNumber;
    }

    @ModelAttribute("topics")
    public List<Topic> topics() {
        return this.topicService.list();
    }
}

package nz.pumbas.halpbotdashboard.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import nz.pumbas.halpbotdashboard.hibernate.models.Question;
import nz.pumbas.halpbotdashboard.hibernate.models.Topic;
import nz.pumbas.halpbotdashboard.hibernate.services.QuestionService;
import nz.pumbas.halpbotdashboard.hibernate.services.TopicService;

@Controller
public class QuestionsController {

    //Refer to: https://www.dariawan.com/tutorials/spring/spring-boot-thymeleaf-crud-example/

    private final QuestionService questionService;
    private final TopicService topicService;

    public QuestionsController(QuestionService questionService, TopicService topicService) {
        this.questionService = questionService;
        this.topicService = topicService;
    }

    @GetMapping("/questions")
    public String questionsList(Model model) {
        model.addAttribute("question", new Question()); //This will be populated by the form.
        model.addAttribute("questions", questionService.list());
        return "questions";
    }

    @PostMapping("/add-question")
    public ModelAndView addQuestionForm(@ModelAttribute("question") Question question) {
        System.out.println("Got question: " + question);
        return new ModelAndView("redirect:/questions");
    }

    @PostMapping("/edit-question")
    public ModelAndView editQuestionForm(@ModelAttribute("question") Question question) {
        System.out.println("Got edit post");
        return new ModelAndView("redirect:/questions");
    }

    @ModelAttribute("topics")
    public List<Topic> topics() {
        return this.topicService.list();
    }
}

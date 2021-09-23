package nz.pumbas.halpbotdashboard.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import nz.pumbas.halpbotdashboard.hibernate.models.Question;
import nz.pumbas.halpbotdashboard.hibernate.models.Topic;
import nz.pumbas.halpbotdashboard.hibernate.services.QuestionService;

@Controller
public class QuestionsController {

    private final QuestionService questionService;

    //private final List<Question> testQuestions = new ArrayList<>();
    private final List<Topic> topics = new ArrayList<>();

    public QuestionsController(QuestionService questionService) {
//        this.testQuestions.add(new Question(1L, 1L, "This is a question", "Answer", "A", "B", "C"));
//        this.testQuestions.add(new Question(2L, 1L, "This is another question", "Answer", "A", "B", "C"));
//        this.testQuestions.add(new Question(3L, 2L, "And another one", "Answer", "A", "B", "C"));
//        this.testQuestions.add(new Question(4L, 1L, "One more for goodluck!", "Answer", "A", "B", "C"));
        this.topics.add(new Topic(1L, "deformation"));
        this.topics.add(new Topic(2L, "microstructure"));
        this.questionService = questionService;
    }

    @GetMapping("/questions")
    public String questionsList(Model model) {
        model.addAttribute("question", new Question()); //This will be populated by the form.
        model.addAttribute("questions", questionService.list());
        return "questions";
    }

    @PostMapping("/add-question")
    public ModelAndView addQuestionForm(@ModelAttribute Question question) {
        System.out.println("Got question: " + question);
        return new ModelAndView("redirect:/questions");
    }

    @PostMapping("/edit-question")
    public ModelAndView editQuestionForm(@ModelAttribute Question question) {
        System.out.println("Got edit post");
        return new ModelAndView("redirect:/questions");
    }

    @ModelAttribute("topics")
    public List<Topic> topics() {
        return this.topics;
    }
}

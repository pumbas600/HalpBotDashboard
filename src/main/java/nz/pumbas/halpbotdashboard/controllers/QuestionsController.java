package nz.pumbas.halpbotdashboard.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import nz.pumbas.halpbotdashboard.models.Question;
import nz.pumbas.halpbotdashboard.models.Topic;

@Controller
public class QuestionsController {

    private static final List<Question> testQuestions = List.of(
            new Question(1, "deformation", "This is a question", "Answer", "A", "B", "C"),
            new Question(2, "deformation", "This is another question", "Answer", "A", "B", "C"),
            new Question(3, "deformation", "And another one", "Answer", "A", "B", "C"),
            new Question(4, "deformation", "One more for goodluck!", "Answer", "A", "B", "C")
    );

    private static final List<Topic> topics = List.of(
            new Topic(1, "deformation")
    );

    @GetMapping("/questions")
    public String questions(Model model) {
        model.addAttribute("questions", testQuestions);
        model.addAttribute("topics", topics);
        return "questions";
    }

    @PostMapping("/addquestion")
    public String addQuestion(
            @ModelAttribute("question") Question question,
            BindingResult result,
            Model model)
    {
        if (result.hasErrors()) {
            return "error";
        }

        System.out.println("Got question: " + question.question());
        return "questions";
    }
}

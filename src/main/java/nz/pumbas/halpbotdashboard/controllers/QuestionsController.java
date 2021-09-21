package nz.pumbas.halpbotdashboard.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import nz.pumbas.halpbotdashboard.models.Question;

@Controller
public class QuestionsController {

    private static final List<Question> testQuestions = List.of(
            new Question(1, "Deformation", "This is a question", "Answer", "A", "B", "C"),
            new Question(2, "Deformation", "This is another question", "Answer", "A", "B", "C"),
            new Question(3, "Deformation", "And another one", "Answer", "A", "B", "C"),
            new Question(4, "Deformation", "One more for goodluck!", "Answer", "A", "B", "C")
    );

    @GetMapping("/questions")
    public String questions(Model model) {
        model.addAttribute("questions", testQuestions);
        return "questions";
    }
}

package nz.pumbas.halpbotdashboard.hibernate.services;

import org.springframework.stereotype.Service;

import java.util.List;

import nz.pumbas.halpbotdashboard.hibernate.models.Question;
import nz.pumbas.halpbotdashboard.hibernate.repositories.QuestionRepository;

@Service
public class QuestionService
{
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> list() {
        return this.questionRepository.findAll();
    }
}

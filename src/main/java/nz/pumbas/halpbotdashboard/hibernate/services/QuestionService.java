package nz.pumbas.halpbotdashboard.hibernate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import nz.pumbas.halpbotdashboard.hibernate.models.Question;
import nz.pumbas.halpbotdashboard.hibernate.repositories.QuestionRepository;

@Service
public class QuestionService
{
    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> list() {
        return this.questionRepository.findAll();
    }
}

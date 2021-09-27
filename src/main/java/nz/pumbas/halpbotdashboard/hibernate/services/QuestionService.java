package nz.pumbas.halpbotdashboard.hibernate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import nz.pumbas.halpbotdashboard.hibernate.exceptions.BadResourceException;
import nz.pumbas.halpbotdashboard.hibernate.exceptions.ResourceNotFoundException;
import nz.pumbas.halpbotdashboard.hibernate.models.Question;
import nz.pumbas.halpbotdashboard.hibernate.repositories.QuestionRepository;

@Service
public class QuestionService
{
    private final QuestionRepository questionRepository;
    private final TopicService topicService;

    @Autowired
    public QuestionService(QuestionRepository questionRepository, TopicService topicService) {
        this.questionRepository = questionRepository;
        this.topicService = topicService;
    }

    public boolean existsById(@Nullable Long id) {
        return null != id && this.questionRepository.existsById(id);
    }

    public Question findById(@Nullable Long id) throws ResourceNotFoundException, BadResourceException {
        if (null == id)
            throw new BadResourceException("An id must be specified");

        Question question = this.questionRepository.findById(id).orElse(null);
        if (null == question) {
            throw new ResourceNotFoundException("Cannot find the Question with the id: " + id);
        }
        return question;

    }

    public List<Question> list(int pageNumber, int rowsPerPage) {
        List<Question> questions = new ArrayList<>();
        Pageable sortedIdAsc = PageRequest.of(pageNumber, rowsPerPage, Sort.by("id").ascending());
        this.questionRepository.findAll(sortedIdAsc).forEach(questions::add);
        return questions;
    }

    public Question save(Question question) throws BadResourceException {
        if (this.isValidQuestion(question)) {
            return this.questionRepository.save(question);
        }
        throw new BadResourceException("The topic is missing or does not exist");
    }

    public boolean isValidQuestion(Question question) {
        return this.topicService.existsById(question.getTopicId());
    }

    public Long count() {
        return this.questionRepository.count();
    }

    public Iterable<Question> list() {
        return this.questionRepository.findAll();
    }
}

package nz.pumbas.halpbotdashboard.hibernate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import nz.pumbas.halpbotdashboard.hibernate.exceptions.BadResourceException;
import nz.pumbas.halpbotdashboard.hibernate.exceptions.ResourceNotFoundException;
import nz.pumbas.halpbotdashboard.hibernate.models.QuestionModification;
import nz.pumbas.halpbotdashboard.hibernate.repositories.QuestionModificationRepository;

@Service
public class QuestionModificationService
{
    private final QuestionModificationRepository questionModificationRepository;
    private final QuestionService questionService;
    private final TopicService topicService;

    @Autowired
    public QuestionModificationService(
        QuestionModificationRepository questionModificationRepository,
        QuestionService questionService, TopicService topicService)
    {
        this.questionModificationRepository = questionModificationRepository;
        this.questionService = questionService;
        this.topicService = topicService;
    }

    public List<QuestionModification> list(int pageNumber, int rowsPerPage) {
        List<QuestionModification> questions = new ArrayList<>();
        Pageable sortedIdAsc = PageRequest.of(pageNumber, rowsPerPage, Sort.by("ID").ascending());
        this.questionModificationRepository.findAll(sortedIdAsc).forEach(questions::add);
        return questions;
    }


    public QuestionModification save(QuestionModification question) throws BadResourceException {
        if (this.isValidQuestion(question)) {
            return this.questionModificationRepository.save(question);
        }
        throw new BadResourceException("The topic is missing or does not exist");
    }

    public void update(QuestionModification question) throws ResourceNotFoundException, BadResourceException {
        if (this.isValidQuestion(question)) {
            if (!this.questionService.existsById(question.getId())) {
                throw new ResourceNotFoundException("Cannot find the Question with id: " + question.getId());
            }
            this.questionModificationRepository.save(question);
        }
        throw new BadResourceException("The topic is missing or does not exist");
    }

    public boolean isValidQuestion(QuestionModification question) {
        return this.topicService.existsById(question.getTopicId());
    }

    public Long count() {
        return this.questionModificationRepository.count();
    }
}

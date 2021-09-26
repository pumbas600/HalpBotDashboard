package nz.pumbas.halpbotdashboard.hibernate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import nz.pumbas.halpbotdashboard.hibernate.models.Topic;
import nz.pumbas.halpbotdashboard.hibernate.repositories.TopicRepository;

@Service
public class TopicService
{
    private final TopicRepository topicRepository;

    @Autowired
    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public boolean existsById(Long id) {
        return null != id && this.topicRepository.existsById(id);
    }

    public List<Topic> list() {
        return this.topicRepository.findAll();
    }
}

package nz.pumbas.halpbotdashboard.hibernate.services;

import org.springframework.stereotype.Service;

import java.util.List;

import nz.pumbas.halpbotdashboard.hibernate.models.Topic;
import nz.pumbas.halpbotdashboard.hibernate.repositories.TopicRepository;

@Service
public class TopicService
{
    private final TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public List<Topic> list() {
        return this.topicRepository.findAll();
    }
}

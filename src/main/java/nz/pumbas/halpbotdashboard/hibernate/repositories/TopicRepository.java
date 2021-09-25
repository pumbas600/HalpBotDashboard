package nz.pumbas.halpbotdashboard.hibernate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import nz.pumbas.halpbotdashboard.hibernate.models.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long>
{
}
package nz.pumbas.halpbotdashboard.hibernate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import nz.pumbas.halpbotdashboard.hibernate.models.Question;

public interface QuestionRepository extends JpaRepository<Question, Long>
{
}
package nz.pumbas.halpbotdashboard.hibernate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nz.pumbas.halpbotdashboard.hibernate.models.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>
{
}
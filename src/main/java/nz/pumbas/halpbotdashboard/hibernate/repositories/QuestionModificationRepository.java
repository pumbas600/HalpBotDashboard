package nz.pumbas.halpbotdashboard.hibernate.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import nz.pumbas.halpbotdashboard.hibernate.models.Question;
import nz.pumbas.halpbotdashboard.hibernate.models.QuestionModification;

public interface QuestionModificationRepository extends PagingAndSortingRepository<QuestionModification, Long>,
    JpaSpecificationExecutor<QuestionModification>
{
}
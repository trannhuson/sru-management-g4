package fa.training.srumanagementg4.repository;

import fa.training.srumanagementg4.entities.Feedback;
import fa.training.srumanagementg4.entities.QuestionFeedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionFeedbackRepository extends JpaRepository<QuestionFeedback, Long> {
}

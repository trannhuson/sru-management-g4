package fa.training.srumanagementg4.repository;

import fa.training.srumanagementg4.entities.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    @Query(value = "select f from Feedback f " +
            "where f.trainingObjective.id = :subjectId")
    List<Feedback> findFeedbackBySubjectId(@Param("subjectId") Long subjectId);


}

package fa.training.srumanagementg4.repository;

import fa.training.srumanagementg4.entities.InterviewResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterviewResultRepository extends JpaRepository<InterviewResult, Long> {
    @Query("SELECT  i from InterviewResult i where i.trainee.id =?1 and  i.trainingObjective.id =?2")
    InterviewResult getInterviewResultByTraineeAndSubject(Long traineeId, Long subjectId);

    @Query("SELECT  i from InterviewResult i where i.trainer.id =?1 and  i.trainingObjective.id =?2")
    List<InterviewResult> getInterviewResultByTrainerAndSubject(Long trainerId, Long subjectId);

    @Query("SELECT  i from InterviewResult i where i.trainee.id =?1")
    List<InterviewResult> getInterviewResultByTrainee(Long traineeId);

    @Query("SELECT  i from InterviewResult i where i.trainer.id =?1 and i.trainingObjective.id=?2")
    List<InterviewResult> getInterviewResultBySubjecIdAndTrainer(Long trainerId, Long subjectId);

}

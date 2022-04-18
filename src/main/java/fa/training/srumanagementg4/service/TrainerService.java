package fa.training.srumanagementg4.service;

import fa.training.srumanagementg4.dto.ScoreDTO;
import fa.training.srumanagementg4.dto.TraineeDTO;
import fa.training.srumanagementg4.dto.TrainerDTO;
import fa.training.srumanagementg4.dto.TrainingObjectiveDTO;

import java.util.List;

public interface TrainerService {
    TrainerDTO getById(Long id);

    List<TrainingObjectiveDTO> getSubjectByTrainerEmail(String email);

    List<ScoreDTO> getScoreBySubjectId(Long id);

    List<TraineeDTO> getTraineeNotHasScore(Long classId, Long trainingObjectiveId);

    TrainingObjectiveDTO getTrainingObjectiveById(Long id);
}

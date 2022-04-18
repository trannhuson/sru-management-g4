package fa.training.srumanagementg4.service;

import fa.training.srumanagementg4.dto.ScoreDTO;
import fa.training.srumanagementg4.entities.Score;

public interface ScoreService {
    Score saveOrUpdate(ScoreDTO scoreDTO);

    ScoreDTO findScoreTrainee(Long traineeId, Long trainingObjectiveId);
}

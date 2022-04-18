package fa.training.srumanagementg4.service;

import fa.training.srumanagementg4.dto.TrainingObjectiveDTO;
import fa.training.srumanagementg4.entities.TrainingObjective;

import java.util.List;

public interface TrainingObjectiveService {

    void create(TrainingObjectiveDTO trainingObjectiveDTO);

    List<TrainingObjectiveDTO> findAll();

    void delete(Long id);

    void update(TrainingObjectiveDTO trainingObjectiveDTO);

    TrainingObjectiveDTO getByCodeAndClass(String code, String classId);

    List<TrainingObjectiveDTO> getAllTrainingObjectByTrainerAndClass(Long trainerId, Long classId);

    List<TrainingObjectiveDTO> getSubjectByTrainerId(Long trainerId);

    List<TrainingObjectiveDTO> getSubjectByClass(Long classId);

    TrainingObjective findById(Long id);
}

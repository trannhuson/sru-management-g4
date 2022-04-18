package fa.training.srumanagementg4.service.impl;

import fa.training.srumanagementg4.dto.ScoreDTO;
import fa.training.srumanagementg4.dto.TraineeDTO;
import fa.training.srumanagementg4.dto.TrainerDTO;
import fa.training.srumanagementg4.dto.TrainingObjectiveDTO;
import fa.training.srumanagementg4.entities.Score;
import fa.training.srumanagementg4.entities.Trainee;
import fa.training.srumanagementg4.entities.Trainer;
import fa.training.srumanagementg4.entities.TrainingObjective;
import fa.training.srumanagementg4.repository.ScoreRepository;
import fa.training.srumanagementg4.repository.TraineeRepository;
import fa.training.srumanagementg4.repository.TrainerRepository;
import fa.training.srumanagementg4.repository.TrainingObjectiveRepository;
import fa.training.srumanagementg4.service.TrainerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService {
    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    TrainingObjectiveRepository trainingObjectiveRepository;

    @Autowired
    ScoreRepository scoreRepository;

    @Autowired
    TraineeRepository traineeRepository;

    @Override
    public TrainerDTO getById(Long id) {
        Trainer trainer = trainerRepository.getById(id);
        return converToDto(trainer);
    }

    @Override
    public List<TrainingObjectiveDTO> getSubjectByTrainerEmail(String email) {
        List<TrainingObjective> trainingObjectives = trainingObjectiveRepository.getTrainingObjectivesByTrainerEmail(email);
        List<TrainingObjectiveDTO> trainingObjectiveDTOS = new ArrayList<>();
        TrainingObjectiveDTO trainingObjectiveDTO = null;
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        for (TrainingObjective trainingObjective : trainingObjectives) {
            trainingObjectiveDTO = modelMapper.map(trainingObjective, TrainingObjectiveDTO.class);
            trainingObjectiveDTO.setaClass(trainingObjective.getClassClass());
            trainingObjectiveDTOS.add(trainingObjectiveDTO);
        }
        return trainingObjectiveDTOS;
    }

    @Override
    @Transactional
    public List<ScoreDTO> getScoreBySubjectId(Long id) {
        List<Score> scores = scoreRepository.getAllScoreByCSubjectId(id);
        List<ScoreDTO> scoreDTOS = new ArrayList<>();
        ScoreDTO scoreDTO = null;
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        for (Score score : scores) {
            scoreDTO = modelMapper.map(score, ScoreDTO.class);
            scoreDTOS.add(scoreDTO);
        }
        return scoreDTOS;
    }

    @Override
    @Transactional
    public List<TraineeDTO> getTraineeNotHasScore(Long classId, Long trainingObjectiveId) {
        List<Trainee> trainees = traineeRepository.findTraineeNotHasScore(classId, trainingObjectiveId);
        List<TraineeDTO> traineeDTOS = new ArrayList<>();
        TraineeDTO traineeDTO = null;
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        for (Trainee trainee: trainees) {
            traineeDTO = modelMapper.map(trainee, TraineeDTO.class);
            traineeDTOS.add(traineeDTO);
        }
        return traineeDTOS;
    }

    @Override
    public TrainingObjectiveDTO getTrainingObjectiveById(Long id) {
        TrainingObjective trainingObjective = trainingObjectiveRepository.getById(id);
        TrainingObjectiveDTO trainingObjectiveDTO = null;
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        trainingObjectiveDTO = modelMapper.map(trainingObjective, TrainingObjectiveDTO.class);
        trainingObjectiveDTO.setaClass(trainingObjective.getClassClass());
        return trainingObjectiveDTO;
    }

    public TrainerDTO converToDto(Trainer trainer) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return mapper.map(trainer, TrainerDTO.class);
    }
}

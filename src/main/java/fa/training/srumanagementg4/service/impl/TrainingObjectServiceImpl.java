package fa.training.srumanagementg4.service.impl;

import fa.training.srumanagementg4.dto.TrainingObjectiveDTO;
import fa.training.srumanagementg4.entities.TrainingObjective;
import fa.training.srumanagementg4.repository.TrainingObjectiveRepository;
import fa.training.srumanagementg4.service.TrainingObjectiveService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainingObjectServiceImpl implements TrainingObjectiveService {
    @Autowired
    private TrainingObjectiveRepository trainingObjectiveRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TrainingObjectiveDTO trainingObjectiveDTO;


    @Override
    public void create(TrainingObjectiveDTO trainingObjectiveDTO) {
        TrainingObjective map = modelMapper.map(trainingObjectiveDTO, TrainingObjective.class);
        trainingObjectiveRepository.save(map);
    }

    @Override
    public List<TrainingObjectiveDTO> findAll() {
        List<TrainingObjectiveDTO> collect = trainingObjectiveRepository.findAll().stream()
                .map(trainingObjective -> modelMapper.map(trainingObjective, TrainingObjectiveDTO.class)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public void delete(Long id) {
        trainingObjectiveRepository.deleteById(id);
    }

    @Override
    public void update(TrainingObjectiveDTO trainingObjectiveDTO) {
        final TrainingObjective map = modelMapper.map(trainingObjectiveDTO, TrainingObjective.class);
        trainingObjectiveRepository.save(map);
    }

    @Override
    public TrainingObjectiveDTO getByCodeAndClass(String code, String classId) {
        TrainingObjective trainingObjective = trainingObjectiveRepository.getByCodeAndClass(code, Long.valueOf(classId));
        trainingObjectiveDTO = null;

        if (trainingObjective != null) {
            trainingObjectiveDTO = modelMapper.map(trainingObjective, TrainingObjectiveDTO.class);
        }
        return trainingObjectiveDTO;
    }

    @Override
    public List<TrainingObjectiveDTO> getAllTrainingObjectByTrainerAndClass(Long trainerId, Long classId) {
        List<TrainingObjective> trainingObjectives = trainingObjectiveRepository.getAllTrainingObjectByTrainerAndClass(trainerId, classId);
        List<TrainingObjectiveDTO> trainingObjectiveDTOS = new ArrayList<>();
        TrainingObjectiveDTO trainingObjectiveDTO = null;
        for (TrainingObjective trainingObjective : trainingObjectives) {
            trainingObjectiveDTO = modelMapper.map(trainingObjective, TrainingObjectiveDTO.class);
            trainingObjectiveDTOS.add(trainingObjectiveDTO);
        }
        return trainingObjectiveDTOS;
    }

    @Override
    public List<TrainingObjectiveDTO> getSubjectByTrainerId(Long trainerId) {
        List<TrainingObjective> trainingObjectives = trainingObjectiveRepository.getSubjectByTrainerId(trainerId);
        List<TrainingObjectiveDTO> trainingObjectiveDTOS = new ArrayList<>();
        TrainingObjectiveDTO trainingObjectiveDTO = null;
        for (TrainingObjective trainingObjective : trainingObjectives) {
            trainingObjectiveDTO = modelMapper.map(trainingObjective, TrainingObjectiveDTO.class);
            trainingObjectiveDTOS.add(trainingObjectiveDTO);
        }
        return trainingObjectiveDTOS;
    }

    @Override
    public List<TrainingObjectiveDTO> getSubjectByClass(Long classId) {
        List<TrainingObjective> trainingObjectives = trainingObjectiveRepository.getSubjectByClass(classId);
        List<TrainingObjectiveDTO> trainingObjectiveDTOS = new ArrayList<>();
        TrainingObjectiveDTO trainingObjectiveDTO = null;
        for (TrainingObjective trainingObjective : trainingObjectives) {
            trainingObjectiveDTO = modelMapper.map(trainingObjective, TrainingObjectiveDTO.class);
            trainingObjectiveDTOS.add(trainingObjectiveDTO);
        }
        return trainingObjectiveDTOS;
    }

    @Override
    public TrainingObjective findById(Long id) {
        return trainingObjectiveRepository.getById(id);
    }
}

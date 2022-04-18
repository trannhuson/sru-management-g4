package fa.training.srumanagementg4.service.impl;

import fa.training.srumanagementg4.dto.InterviewResultDTO;
import fa.training.srumanagementg4.entities.InterviewResult;
import fa.training.srumanagementg4.repository.InterviewResultRepository;
import fa.training.srumanagementg4.service.InterviewResultService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class InterviewResultSeviceImpl implements InterviewResultService {
    @Autowired
    private InterviewResultRepository interviewResultRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    @Override
    public void saveOrUpdate(InterviewResultDTO interviewResultDTO) {

        InterviewResult interviewResult = modelMapper.map(interviewResultDTO, InterviewResult.class);
        interviewResultRepository.save(interviewResult);
    }
    @Transactional
    @Override
    public InterviewResultDTO getInterviewResultByTraineeAndSubject(Long traineeId, Long subjectId) {
        InterviewResult interviewResult = interviewResultRepository.getInterviewResultByTraineeAndSubject(traineeId, subjectId);
        if(interviewResult == null){
           return null;
        }
        return modelMapper.map(interviewResult, InterviewResultDTO.class);
    }
    @Transactional
    @Override
    public List<InterviewResultDTO> getInterviewResultByTrainerAndSubject(Long trainerId, Long subjectId) {
        List<InterviewResult> interviewResults = interviewResultRepository.getInterviewResultByTrainerAndSubject(trainerId, subjectId);
        List<InterviewResultDTO> interviewResultDTOS = new ArrayList<>();
        InterviewResultDTO interviewResultDTO = null;
        for(InterviewResult interviewResult: interviewResults){
            interviewResultDTO = modelMapper.map(interviewResult, InterviewResultDTO.class);
            interviewResultDTOS.add(interviewResultDTO);
        }
        return interviewResultDTOS;
    }

    @Transactional
    @Override
    public List<InterviewResultDTO> getInterviewResultByTrainee(Long traineeId) {
        List<InterviewResult> interviewResults = interviewResultRepository.getInterviewResultByTrainee(traineeId);

        List<InterviewResultDTO> interviewResultDTOS = new ArrayList<>();
        InterviewResultDTO interviewResultDTO = null;

        for(InterviewResult interviewResult: interviewResults){
            interviewResultDTO = modelMapper.map(interviewResult, InterviewResultDTO.class);
            interviewResultDTOS.add(interviewResultDTO);
        }
        return interviewResultDTOS;
    }

    @Transactional
    @Override
    public List<InterviewResultDTO> getInterviewResultBySubjecIdAndTrainer(Long trainerId, Long subjectId) {
        List<InterviewResult> interviewResults = interviewResultRepository.getInterviewResultBySubjecIdAndTrainer(trainerId, subjectId);

        List<InterviewResultDTO> interviewResultDTOS = new ArrayList<>();
        InterviewResultDTO interviewResultDTO = null;

        for(InterviewResult interviewResult: interviewResults){
            interviewResultDTO = modelMapper.map(interviewResult, InterviewResultDTO.class);
            interviewResultDTOS.add(interviewResultDTO);
        }
        return interviewResultDTOS;
    }

    @Transactional
    @Override
    public InterviewResultDTO getById(Long id) {
        return modelMapper.map(interviewResultRepository.getById(id),InterviewResultDTO.class);
    }
}

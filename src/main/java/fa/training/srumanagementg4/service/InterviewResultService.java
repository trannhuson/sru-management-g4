package fa.training.srumanagementg4.service;

import fa.training.srumanagementg4.dto.InterviewResultDTO;
import fa.training.srumanagementg4.entities.InterviewResult;

import java.util.List;

public interface InterviewResultService {
    void saveOrUpdate(InterviewResultDTO interviewResultDTO);

    InterviewResultDTO getInterviewResultByTraineeAndSubject(Long traineeId, Long subjectId);

    List<InterviewResultDTO> getInterviewResultByTrainerAndSubject(Long trainerId, Long subjectId);

    List<InterviewResultDTO> getInterviewResultByTrainee(Long traineeId);

    List<InterviewResultDTO> getInterviewResultBySubjecIdAndTrainer(Long trainerId, Long subjectId);

    InterviewResultDTO getById(Long id);
}

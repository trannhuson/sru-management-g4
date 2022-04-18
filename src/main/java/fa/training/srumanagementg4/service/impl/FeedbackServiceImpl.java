package fa.training.srumanagementg4.service.impl;

import fa.training.srumanagementg4.dto.FeedbackDTO;
import fa.training.srumanagementg4.dto.QuestionFeedbackDTO;
import fa.training.srumanagementg4.entities.Feedback;
import fa.training.srumanagementg4.entities.QuestionFeedback;
import fa.training.srumanagementg4.entities.TrainingObjective;
import fa.training.srumanagementg4.repository.FeedbackRepository;
import fa.training.srumanagementg4.service.FeedbackService;
import fa.training.srumanagementg4.service.TrainingObjectiveService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private TrainingObjectiveService trainingObjectiveService;

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public Feedback createFeedback(QuestionFeedbackDTO questionFeedbackDTO) {

        TrainingObjective trainingObjective = trainingObjectiveService.findById(Long.parseLong(questionFeedbackDTO.getTrainingObjectiveId()));
        Feedback feedback = new Feedback();
        feedback.setConsultDate(new Date());
        feedback.setTrainingObjective(trainingObjective);

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        QuestionFeedback questionFeedback = modelMapper.map(questionFeedbackDTO, QuestionFeedback.class);
        Set<QuestionFeedback> questionFeedbacks = new HashSet<>();
        questionFeedbacks.add(questionFeedback);
        questionFeedback.setFeedback(feedback);
        feedback.setQuestionFeedbacks(questionFeedbacks);
        return feedbackRepository.save(feedback);
    }

    @Override
    public FeedbackDTO findFeedbackBySubjectId(Long subjectId) {
        List<Feedback> feedbackList = feedbackRepository.findFeedbackBySubjectId(subjectId);
        if (feedbackList == null) {
            return null;
        }
        double totalUsefulCourseForMe = 0.0;
        double totalSatisfied = 0.0;
        double totalKnowledgeableTeacher = 0.0;
        double totalGoodInstructorsTeacher = 0.0;
        double totalFullConveyedContent = 0.0;
        int totalFeedback = 0;

        List<String> courseLikes = new ArrayList<>();
        List<String> improveCourses = new ArrayList<>();

        for (Feedback feedback: feedbackList) {
            totalFeedback += feedback.getQuestionFeedbacks().size();
            Optional<Integer> usefulCourseForme = feedback.getQuestionFeedbacks().stream()
                    .map(QuestionFeedback::getUsefulCourseForMe).findFirst();
            Optional<Integer> satisfied = feedback.getQuestionFeedbacks().stream()
                    .map(QuestionFeedback::getSatisfied).findFirst();
            Optional<Integer> knowledgeableTeacher = feedback.getQuestionFeedbacks().stream()
                    .map(QuestionFeedback::getKnowledgeableTeacher).findFirst();
            Optional<Integer> goodInstructorsTeacher = feedback.getQuestionFeedbacks().stream()
                    .map(QuestionFeedback::getGoodInstructorsTeacher).findFirst();
            Optional<Integer> fullConveyedContent = feedback.getQuestionFeedbacks().stream()
                    .map(QuestionFeedback::getFullConveyedContent).findFirst();

            List<String> courseLikeList = feedback.getQuestionFeedbacks().stream()
                    .map(QuestionFeedback::getCourseLikes).collect(Collectors.toList());
            courseLikes.addAll(courseLikeList);
            List<String> improveCourseList = feedback.getQuestionFeedbacks().stream()
                    .map(QuestionFeedback::getImproveCourse).collect(Collectors.toList());
            improveCourses.addAll(improveCourseList);

            totalUsefulCourseForMe += usefulCourseForme.get();
            totalSatisfied += satisfied.get();
            totalKnowledgeableTeacher += knowledgeableTeacher.get();
            totalGoodInstructorsTeacher += goodInstructorsTeacher.get();
            totalFullConveyedContent += fullConveyedContent.get();
        }

        FeedbackDTO feedbackDTO = new FeedbackDTO(String.format("%.1f", totalUsefulCourseForMe/totalFeedback),
                String.format("%.1f", totalSatisfied/totalFeedback), String.format("%.1f", totalKnowledgeableTeacher/totalFeedback),
                String.format("%.1f", totalGoodInstructorsTeacher/totalFeedback), String.format("%.1f", totalFullConveyedContent/totalFeedback),
                courseLikes, improveCourses, String.valueOf(totalFeedback));
        return feedbackDTO;
    }
}

package fa.training.srumanagementg4.service.impl;

import fa.training.srumanagementg4.dto.FeedbackDTO;
import fa.training.srumanagementg4.dto.QuestionFeedbackDTO;
import fa.training.srumanagementg4.entities.Feedback;
import fa.training.srumanagementg4.entities.QuestionFeedback;
import fa.training.srumanagementg4.entities.TrainingObjective;
import fa.training.srumanagementg4.repository.FeedbackRepository;
import fa.training.srumanagementg4.repository.TrainingObjectiveRepository;
import fa.training.srumanagementg4.service.FeedbackService;
import fa.training.srumanagementg4.service.TrainingObjectiveService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * @author SonTN9
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class FeedbackServiceImplTest {

    @Autowired
    private FeedbackService feedbackService;

    @MockBean
    private FeedbackRepository feedbackRepository;

    @MockBean
    private TrainingObjectiveService trainingObjectiveService;

    @Captor
    private ArgumentCaptor<Feedback> captor;

    /**
     * @author SonTN9
     *
     */
    @Test
    void createFeedback() {
        QuestionFeedbackDTO questionFeedbackDTO = new QuestionFeedbackDTO();
        questionFeedbackDTO.setTrainingObjectiveId("1");
        TrainingObjective trainingObjective = new TrainingObjective();
        trainingObjective.setId(1L);
        trainingObjective.setName("JPL");
        when(trainingObjectiveService.findById(1L)).thenReturn(trainingObjective);
        feedbackService.createFeedback(questionFeedbackDTO);
        Mockito.verify(feedbackRepository).save(captor.capture());
        Feedback feedback = captor.getValue();
        assertEquals(feedback.getTrainingObjective().getId(), trainingObjective.getId());

    }

    /**
     * @author SonTN9
     *
     */
    @Test
    void findFeedbackBySubjectIdWhenSuccess() {
        QuestionFeedback questionFeedbackOne = new QuestionFeedback();
        questionFeedbackOne.setFullConveyedContent(5);
        questionFeedbackOne.setGoodInstructorsTeacher(4);
        questionFeedbackOne.setKnowledgeableTeacher(4);
        questionFeedbackOne.setSatisfied(5);
        questionFeedbackOne.setUsefulCourseForMe(5);
        questionFeedbackOne.setImproveCourse("Day de hieu");
        questionFeedbackOne.setCourseLikes("Rat hieu");

        QuestionFeedback questionFeedbackSecond = new QuestionFeedback();
        questionFeedbackSecond.setFullConveyedContent(5);
        questionFeedbackSecond.setGoodInstructorsTeacher(5);
        questionFeedbackSecond.setKnowledgeableTeacher(4);
        questionFeedbackSecond.setSatisfied(4);
        questionFeedbackSecond.setUsefulCourseForMe(5);
        questionFeedbackSecond.setImproveCourse("Day de hieu 2");
        questionFeedbackSecond.setCourseLikes("Rat hieu 2");

        Feedback feedbackOne = new Feedback();
        feedbackOne.setId(1L);
        Set<QuestionFeedback> questionFeedbacksOne = new HashSet<>();
        questionFeedbacksOne.add(questionFeedbackOne);
        feedbackOne.setQuestionFeedbacks(questionFeedbacksOne);

        Feedback feedbackSecond = new Feedback();
        feedbackSecond.setId(2L);
        Set<QuestionFeedback> questionFeedbacksSecond = new HashSet<>();
        questionFeedbacksSecond.add(questionFeedbackSecond);
        feedbackSecond.setQuestionFeedbacks(questionFeedbacksSecond);

        when(feedbackRepository.findFeedbackBySubjectId(1L)).thenReturn(Arrays.asList(feedbackOne, feedbackSecond));
        FeedbackDTO feedbackDTO = feedbackService.findFeedbackBySubjectId(1L);

        assertEquals(feedbackDTO.getTotalFeedback(), String.valueOf(2));
        assertEquals(feedbackDTO.getTotalFullConveyedContent(), String.valueOf(5.0));
        assertEquals(feedbackDTO.getTotalGoodInstructorsTeacher(), String.valueOf(4.5));
    }

    /**
     * @author SonTN9
     *
     */
    @Test
    void findFeedbackBySubjectIdWhenFeedbackIsNull() {
        when(feedbackRepository.findFeedbackBySubjectId(1L)).thenReturn(null);
        FeedbackDTO feedbackDTO = feedbackService.findFeedbackBySubjectId(1L);
        assertNull(feedbackDTO);
    }
}
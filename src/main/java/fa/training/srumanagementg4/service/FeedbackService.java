package fa.training.srumanagementg4.service;

import fa.training.srumanagementg4.dto.FeedbackDTO;
import fa.training.srumanagementg4.dto.QuestionFeedbackDTO;
import fa.training.srumanagementg4.entities.Feedback;
import fa.training.srumanagementg4.entities.QuestionFeedback;

import java.util.List;

public interface FeedbackService {
    Feedback createFeedback(QuestionFeedbackDTO questionFeedbackDTO);
    FeedbackDTO findFeedbackBySubjectId(Long subjectId);
}

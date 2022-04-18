package fa.training.srumanagementg4.dto;

import fa.training.srumanagementg4.entities.QuestionFeedback;
import fa.training.srumanagementg4.entities.TrainingObjective;
import fa.training.srumanagementg4.utils.Constant;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.util.HashSet;
import java.util.Set;

public class QuestionFeedbackDTO {

    @NotBlank
    private String accountTrainee;
    @NotBlank
    private String className;
    @NotBlank
    private String trainerAccount;
    @NotBlank
    private String nameSubject;
    @NotBlank
    private String courseLikes;
    @NotBlank
    private String improveCourse;
    @Pattern(regexp = Constant.VALID_RATE, message = "Useful Course for me is in the range 1 - 5")
    private String usefulCourseForMe;
    @Pattern(regexp = Constant.VALID_RATE, message = "Satisfied is in the range 1 - 5")
    private String satisfied;
    @Pattern(regexp = Constant.VALID_RATE, message = "Knowledgeable teacher is in the range 1 - 5")
    private String knowledgeableTeacher;
    @Pattern(regexp = Constant.VALID_RATE, message = "Good instructors teacher is in the range 1 - 5")
    private String goodInstructorsTeacher;
    @Pattern(regexp = Constant.VALID_RATE, message = "Full conveyed content teacher is in the range 1 - 5")
    private String fullConveyedContent;
    private String trainingObjectiveId;

    public QuestionFeedbackDTO() {
    }

    public QuestionFeedbackDTO(String accountTrainee, String className, String trainerAccount, String nameSubject, String courseLikes, String improveCourse,
                               String usefulCourseForMe, String satisfied, String knowledgeableTeacher, String goodInstructorsTeacher, String fullConveyedContent) {
        this.accountTrainee = accountTrainee;
        this.className = className;
        this.trainerAccount = trainerAccount;
        this.nameSubject = nameSubject;
        this.courseLikes = courseLikes;
        this.improveCourse = improveCourse;
        this.usefulCourseForMe = usefulCourseForMe;
        this.satisfied = satisfied;
        this.knowledgeableTeacher = knowledgeableTeacher;
        this.goodInstructorsTeacher = goodInstructorsTeacher;
        this.fullConveyedContent = fullConveyedContent;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTrainerAccount() {
        return trainerAccount;
    }

    public void setTrainerAccount(String trainerAccount) {
        this.trainerAccount = trainerAccount;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public String getAccountTrainee() {
        return accountTrainee;
    }

    public void setAccountTrainee(String accountTrainee) {
        this.accountTrainee = accountTrainee;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public String getCourseLikes() {
        return courseLikes;
    }

    public void setCourseLikes(String courseLikes) {
        this.courseLikes = courseLikes;
    }

    public String getImproveCourse() {
        return improveCourse;
    }

    public void setImproveCourse(String improveCourse) {
        this.improveCourse = improveCourse;
    }

    public String getUsefulCourseForMe() {
        return usefulCourseForMe;
    }

    public void setUsefulCourseForMe(String usefulCourseForMe) {
        this.usefulCourseForMe = usefulCourseForMe;
    }

    public String getSatisfied() {
        return satisfied;
    }

    public void setSatisfied(String satisfied) {
        this.satisfied = satisfied;
    }

    public String getKnowledgeableTeacher() {
        return knowledgeableTeacher;
    }

    public void setKnowledgeableTeacher(String knowledgeableTeacher) {
        this.knowledgeableTeacher = knowledgeableTeacher;
    }

    public String getGoodInstructorsTeacher() {
        return goodInstructorsTeacher;
    }

    public void setGoodInstructorsTeacher(String goodInstructorsTeacher) {
        this.goodInstructorsTeacher = goodInstructorsTeacher;
    }

    public String getFullConveyedContent() {
        return fullConveyedContent;
    }

    public void setFullConveyedContent(String fullConveyedContent) {
        this.fullConveyedContent = fullConveyedContent;
    }

    public String getTrainingObjectiveId() {
        return trainingObjectiveId;
    }

    public void setTrainingObjectiveId(String trainingObjectiveId) {
        this.trainingObjectiveId = trainingObjectiveId;
    }
}

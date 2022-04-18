package fa.training.srumanagementg4.dto;
import java.util.List;

public class FeedbackDTO {

    private String totalUsefulCourseForMe;
    private String totalSatisfied;
    private String totalKnowledgeableTeacher;
    private String totalGoodInstructorsTeacher;
    private String totalFullConveyedContent;
    private List<String> courseLikes;
    private List<String> improveCourses;
    private String totalFeedback;

    public FeedbackDTO() {
    }

    public FeedbackDTO(String totalUsefulCourseForMe, String totalSatisfied, String totalKnowledgeableTeacher, String totalGoodInstructorsTeacher,
                       String totalFullConveyedContent, List<String> courseLikes, List<String> improveCourses, String totalFeedback) {
        this.totalUsefulCourseForMe = totalUsefulCourseForMe;
        this.totalSatisfied = totalSatisfied;
        this.totalKnowledgeableTeacher = totalKnowledgeableTeacher;
        this.totalGoodInstructorsTeacher = totalGoodInstructorsTeacher;
        this.totalFullConveyedContent = totalFullConveyedContent;
        this.courseLikes = courseLikes;
        this.improveCourses = improveCourses;
        this.totalFeedback = totalFeedback;
    }

    public String getTotalUsefulCourseForMe() {
        return totalUsefulCourseForMe;
    }

    public void setTotalUsefulCourseForMe(String totalUsefulCourseForMe) {
        this.totalUsefulCourseForMe = totalUsefulCourseForMe;
    }

    public String getTotalSatisfied() {
        return totalSatisfied;
    }

    public void setTotalSatisfied(String totalSatisfied) {
        this.totalSatisfied = totalSatisfied;
    }

    public String getTotalKnowledgeableTeacher() {
        return totalKnowledgeableTeacher;
    }

    public void setTotalKnowledgeableTeacher(String totalKnowledgeableTeacher) {
        this.totalKnowledgeableTeacher = totalKnowledgeableTeacher;
    }

    public String getTotalGoodInstructorsTeacher() {
        return totalGoodInstructorsTeacher;
    }

    public void setTotalGoodInstructorsTeacher(String totalGoodInstructorsTeacher) {
        this.totalGoodInstructorsTeacher = totalGoodInstructorsTeacher;
    }

    public String getTotalFullConveyedContent() {
        return totalFullConveyedContent;
    }

    public void setTotalFullConveyedContent(String totalFullConveyedContent) {
        this.totalFullConveyedContent = totalFullConveyedContent;
    }

    public List<String> getCourseLikes() {
        return courseLikes;
    }

    public void setCourseLikes(List<String> courseLikes) {
        this.courseLikes = courseLikes;
    }

    public List<String> getImproveCourses() {
        return improveCourses;
    }

    public void setImproveCourses(List<String> improveCourses) {
        this.improveCourses = improveCourses;
    }

    public String getTotalFeedback() {
        return totalFeedback;
    }

    public void setTotalFeedback(String totalFeedback) {
        this.totalFeedback = totalFeedback;
    }
}

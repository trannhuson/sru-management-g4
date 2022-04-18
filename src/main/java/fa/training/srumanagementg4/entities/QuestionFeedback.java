package fa.training.srumanagementg4.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "question_feedback")
public class QuestionFeedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_feedback")
    private Feedback feedback;

    @Column(name = "course_likes")
    private String courseLikes;

    @Column(name = "improve_course")
    private String improveCourse;

    @Column(name = "useful_course_for_me")
    private Integer usefulCourseForMe;

    @Column(name = "satisfied")
    private Integer satisfied;

    @Column(name = "knowledgeable_teacher")
    private Integer knowledgeableTeacher;

    @Column(name = "good_instructors_teacher")
    private Integer goodInstructorsTeacher;

    @Column(name = "full_conveyed_content")
    private Integer fullConveyedContent;

    public QuestionFeedback() {
    }

    public QuestionFeedback(Long id, Feedback feedback, String courseLikes, String improveCourse, Integer usefulCourseForMe,
                            Integer satisfied, Integer knowledgeableTeacher, Integer goodInstructorsTeacher, Integer fullConveyedContent) {
        this.id = id;
        this.feedback = feedback;
        this.courseLikes = courseLikes;
        this.improveCourse = improveCourse;
        this.usefulCourseForMe = usefulCourseForMe;
        this.satisfied = satisfied;
        this.knowledgeableTeacher = knowledgeableTeacher;
        this.goodInstructorsTeacher = goodInstructorsTeacher;
        this.fullConveyedContent = fullConveyedContent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
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

    public Integer getUsefulCourseForMe() {
        return usefulCourseForMe;
    }

    public void setUsefulCourseForMe(Integer usefulCourseForMe) {
        this.usefulCourseForMe = usefulCourseForMe;
    }

    public Integer getSatisfied() {
        return satisfied;
    }

    public void setSatisfied(Integer satisfied) {
        this.satisfied = satisfied;
    }

    public Integer getKnowledgeableTeacher() {
        return knowledgeableTeacher;
    }

    public void setKnowledgeableTeacher(Integer knowledgeableTeacher) {
        this.knowledgeableTeacher = knowledgeableTeacher;
    }

    public Integer getGoodInstructorsTeacher() {
        return goodInstructorsTeacher;
    }

    public void setGoodInstructorsTeacher(Integer goodInstructorsTeacher) {
        this.goodInstructorsTeacher = goodInstructorsTeacher;
    }

    public Integer getFullConveyedContent() {
        return fullConveyedContent;
    }

    public void setFullConveyedContent(Integer fullConveyedContent) {
        this.fullConveyedContent = fullConveyedContent;
    }
}

package fa.training.srumanagementg4.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fa.training.srumanagementg4.enums.Gender;
import fa.training.srumanagementg4.enums.StatusInterview;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "trainee")
public class Trainee extends Users implements Serializable {

    @Column(name = "branch")
    private String branch;

    @Column(name = "parent_department")
    private String parentDepartment;

    @Column(name = "rec_interview_date")
    private Date recInterviewDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "rec_interview_status")
    private StatusInterview recInterviewStatus;

    @Column(name = "note")
    private String note;

    @ManyToOne
    @JoinColumn(name = "trainee_status")
    private Status status;

    @Column(name = "university")
    private String university;

    @Column(name = "faculty")
    private String faculty;

    @Column(name = "image")
    private String image;

    @OneToMany(mappedBy = "trainee")
    private Set<Mistake> mistakes = new HashSet<>();

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_class")
    private Class classRoom;

    @OneToMany(mappedBy = "trainee")
    private Set<Certificate> certificates = new HashSet<>();


    @OneToMany(mappedBy = "trainee", cascade = CascadeType.ALL)
    private Set<InterviewResult> interviewResults = new HashSet<>();

    @OneToMany(mappedBy = "trainee")
    private Set<Score> scores = new HashSet<>();
    public Trainee() {
    }

    public Trainee(Long id, String account, String password, String fullName,
                   Gender gender, String email, String phoneNumber, String facebook,
                   Set<Attendance> attendances, Set<Role> roles, String branch, String parentDepartment, Date recInterviewDate, StatusInterview recInterviewStatus, String note, Status status, String university, String faculty, String image, Set<Mistake> mistakes, Class classRoom,
                   Set<Score> scores) {
        super(id, account, password, fullName, gender, email, phoneNumber, facebook, attendances, roles);
        this.branch = branch;
        this.parentDepartment = parentDepartment;
        this.recInterviewDate = recInterviewDate;
        this.recInterviewStatus = recInterviewStatus;
        this.note = note;
        this.status = status;
        this.university = university;
        this.faculty = faculty;
        this.image = image;
        this.mistakes = mistakes;
        this.classRoom = classRoom;
        this.scores = scores;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getParentDepartment() {
        return parentDepartment;
    }

    public void setParentDepartment(String parentDepartment) {
        this.parentDepartment = parentDepartment;
    }

    public String getRecInterviewDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(recInterviewDate);
    }

    public void setRecInterviewDate(Date recInterviewDate) {
        this.recInterviewDate = recInterviewDate;
    }

    public StatusInterview getRecInterviewStatus() {
        return recInterviewStatus;
    }

    public void setRecInterviewStatus(StatusInterview recInterviewStatus) {
        this.recInterviewStatus = recInterviewStatus;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Set<Mistake> getMistakes() {
        return mistakes;
    }

    public void setMistakes(Set<Mistake> mistakes) {
        this.mistakes = mistakes;
    }

    public Class getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(Class classRoom) {
        this.classRoom = classRoom;
    }

    public Set<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(Set<Certificate> certificates) {
        this.certificates = certificates;
    }

    public Set<InterviewResult> getInterviewResults() {
        return interviewResults;
    }

    public void setInterviewResults(Set<InterviewResult> interviewResults) {
        this.interviewResults = interviewResults;
    }

    public Set<Score> getScores() {
        return scores;
    }

    public void setScores(Set<Score> scores) {
        this.scores = scores;
    }
}

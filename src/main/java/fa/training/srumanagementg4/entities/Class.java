package fa.training.srumanagementg4.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fa.training.srumanagementg4.enums.ClassStatus;
import fa.training.srumanagementg4.enums.StatusEnum;
import fa.training.srumanagementg4.enums.TypeClass;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "class")
public class Class implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "plan_count")
    private int planCount;

    @Column(name = "open_date")
    private Date openDate;

    @Column(name = "end_date")
    private Date endDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private TypeClass type;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusEnum status;

    @Column(name = "note")
    private String note;

    @OneToMany(mappedBy = "classRoom", cascade = CascadeType.ALL)
    private Set<Trainee> trainees = new HashSet<>();

    @OneToMany(mappedBy = "classIssue", cascade = CascadeType.ALL)
    private Set<Issue> issues = new HashSet<>();

    @OneToMany(mappedBy = "classClass", cascade = CascadeType.ALL)
    private Set<TrainingObjective> trainingObjectives = new HashSet<>();

    @Column(name="active")
    private boolean active;

    public Class() {
    }

    public Class(Long id, String name, int planCount, Date openDate, Date endDate, TypeClass type, StatusEnum status,
                 String note, Set<Trainee> trainees, Set<TrainingObjective> trainingObjectives) {
        this.id = id;
        this.name = name;
        this.planCount = planCount;
        this.openDate = openDate;
        this.endDate = endDate;
        this.type = type;
        this.status = status;
        this.note = note;
        this.trainees = trainees;
        this.trainingObjectives = trainingObjectives;
    }

    public Class(Long id, String name, int planCount) {
        this.id = id;
        this.name = name;
        this.planCount = planCount;
    }

    public Class(Long id, String name, int planCount, Date openDate, Date endDate, TypeClass type, StatusEnum status, Set<Trainee> trainees) {
        this.id = id;
        this.name = name;
        this.planCount = planCount;
        this.openDate = openDate;
        this.endDate = endDate;
        this.type = type;
        this.status = status;
        this.trainees = trainees;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpenDate() {

        return new SimpleDateFormat("yyyy-MM-dd").format(openDate);
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public String getEndDate() {

        return new SimpleDateFormat("yyyy-MM-dd").format(endDate);
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Set<Trainee> getTrainees() {
        return trainees;
    }

    public void setTrainees(Set<Trainee> trainees) {
        this.trainees = trainees;
    }

    public TypeClass getType() {
        return type;
    }

    public void setType(TypeClass type) {
        this.type = type;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public int getPlanCount() {
        return planCount;
    }

    public void setPlanCount(int planCount) {
        this.planCount = planCount;
    }

    public Set<Issue> getIssues() {
        return issues;
    }

    public void setIssues(Set<Issue> issues) {
        this.issues = issues;
    }

    public Set<TrainingObjective> getTrainingObjectives() {
        return trainingObjectives;
    }

    public void setTrainingObjectives(Set<TrainingObjective> trainingObjectives) {
        this.trainingObjectives = trainingObjectives;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

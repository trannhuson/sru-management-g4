package fa.training.srumanagementg4.entities;

import fa.training.srumanagementg4.enums.StatusEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private StatusEnum type;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "learn_time")
    private float learnTime;

    @OneToMany(mappedBy = "status", cascade = CascadeType.ALL)
    private Set<Trainee> listTrainee = new HashSet<>();

    public Status() {
    }

    public Status(Long id, StatusEnum type, Date startDate, Date endDate, float learnTime, Set<Trainee> listTrainee) {
        this.id = id;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        this.learnTime = learnTime;
        this.listTrainee = listTrainee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatusEnum getType() {
        return type;
    }

    public void setType(StatusEnum type) {
        this.type = type;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public float getLearnTime() {
        return learnTime;
    }

    public void setLearnTime(float learnTime) {
        this.learnTime = learnTime;
    }

    public Set<Trainee> getListTrainee() {
        return listTrainee;
    }

    public void setListTrainee(Set<Trainee> listTrainee) {
        this.listTrainee = listTrainee;
    }
}

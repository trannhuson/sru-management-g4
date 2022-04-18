package fa.training.srumanagementg4.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mistake")
public class Mistake {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "note")
    private String noteMistake;

    @ManyToOne
    @JoinColumn(name = "trainee_id")
    private Trainee trainee;

    @Column(name = "created_date")
    private Date createdDate;

    public Mistake() {
    }

    public Mistake(Long id, String name, String description, String note, Trainee trainee, Date createdDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.noteMistake = note;
        this.trainee = trainee;
        this.createdDate = createdDate;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNoteMistake() {
        return noteMistake;
    }

    public void setNoteMistake(String note) {
        this.noteMistake = note;
    }

    public Trainee getTrainee() {
        return trainee;
    }

    public void setTrainee(Trainee trainee) {
        this.trainee = trainee;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}

package fa.training.srumanagementg4.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_training_objective")
    private TrainingObjective trainingObjective;

    @Column(name = "consult_date")
    private Date consultDate;


    @OneToMany(mappedBy = "feedback", cascade = CascadeType.ALL)
    private Set<QuestionFeedback> questionFeedbacks = new HashSet<>();

    public Feedback() {
    }

    public Feedback(Long id, TrainingObjective trainingObjective, Date consultDate, Set<QuestionFeedback> questionFeedbacks) {
        this.id = id;
        this.trainingObjective = trainingObjective;
        this.consultDate = consultDate;
        this.questionFeedbacks = questionFeedbacks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TrainingObjective getTrainingObjective() {
        return trainingObjective;
    }

    public void setTrainingObjective(TrainingObjective trainingObjective) {
        this.trainingObjective = trainingObjective;
    }

    public Date getConsultDate() {
        return consultDate;
    }

    public void setConsultDate(Date consultDate) {
        this.consultDate = consultDate;
    }

    public Set<QuestionFeedback> getQuestionFeedbacks() {
        return questionFeedbacks;
    }

    public void setQuestionFeedbacks(Set<QuestionFeedback> questionFeedbacks) {
        this.questionFeedbacks = questionFeedbacks;
    }
}

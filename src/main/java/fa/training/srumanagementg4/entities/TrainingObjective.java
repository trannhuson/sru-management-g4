package fa.training.srumanagementg4.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "training_objective")
public class TrainingObjective {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class classClass;

    @OneToMany(mappedBy = "trainingObjective", cascade = CascadeType.ALL)
    private Set<Score> scores = new HashSet<>();

    @OneToMany(mappedBy = "trainingObjective", cascade = CascadeType.ALL)
    private Set<Feedback> feedbacks = new HashSet<>();

    @OneToMany(mappedBy = "trainingObjective", cascade = CascadeType.ALL)
    private Set<InterviewResult> interviewResults = new HashSet<>();

    public TrainingObjective() {
    }

    public TrainingObjective(Long id, String name, String code, Trainer trainer, Class classClass, Set<Score> scores, Set<Feedback> feedbacks) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.trainer = trainer;
        this.classClass = classClass;
        this.scores = scores;
        this.feedbacks = feedbacks;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Set<Score> getScores() {
        return scores;
    }

    public void setScores(Set<Score> scores) {
        this.scores = scores;
    }

    public Set<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(Set<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public Class getClassClass() {
        return classClass;
    }

    public void setClassClass(Class classClass) {
        this.classClass = classClass;
    }

    public Set<InterviewResult> getInterviewResults() {
        return interviewResults;
    }

    public void setInterviewResults(Set<InterviewResult> interviewResults) {
        this.interviewResults = interviewResults;
    }
}

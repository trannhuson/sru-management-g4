package fa.training.srumanagementg4.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fa.training.srumanagementg4.enums.Gender;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "trainer")
public class Trainer extends Users implements Serializable {

    @OneToMany(mappedBy = "trainer")
    private Set<TrainingObjective> trainingObjectives = new HashSet<>();

    @OneToMany(mappedBy = "trainer", cascade = CascadeType.ALL)
    private Set<InterviewResult> interviewResults = new HashSet<>();

    public Trainer() {
    }

    public Trainer(Long id, String account, String password, String fullName,
                   Gender gender, String email, String phoneNumber, String facebook,
                   Set<Attendance> attendances, Set<Role> roles, Set<TrainingObjective> trainingObjectives) {
        super(id, account, password, fullName, gender, email, phoneNumber, facebook, attendances, roles);
        this.trainingObjectives = trainingObjectives;
    }

    public Set<TrainingObjective> getTrainingObjectives() {
        return trainingObjectives;
    }

    public void setTrainingObjectives(Set<TrainingObjective> trainingObjectives) {
        this.trainingObjectives = trainingObjectives;
    }

    public Set<InterviewResult> getInterviewResults() {
        return interviewResults;
    }

    public void setInterviewResults(Set<InterviewResult> interviewResults) {
        this.interviewResults = interviewResults;
    }
}

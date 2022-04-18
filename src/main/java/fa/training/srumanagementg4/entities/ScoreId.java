package fa.training.srumanagementg4.entities;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ScoreId implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long idTrainee;
    private Long idTrainingObjective;

    public ScoreId() {
    }

    public ScoreId(Long idTrainee, Long idTrainingObjective) {
        this.idTrainee = idTrainee;
        this.idTrainingObjective = idTrainingObjective;
    }

    public ScoreId(Long id, Long idTrainee, Long idTrainingObjective) {
        this.id = id;
        this.idTrainee = idTrainee;
        this.idTrainingObjective = idTrainingObjective;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getIdTrainee() {
        return idTrainee;
    }

    public void setIdTrainee(Long idTrainee) {
        this.idTrainee = idTrainee;
    }

    public Long getIdTrainingObjective() {
        return idTrainingObjective;
    }

    public void setIdTrainingObjective(Long idTrainingObjective) {
        this.idTrainingObjective = idTrainingObjective;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScoreId)) return false;
        ScoreId scoreId = (ScoreId) o;
        return Objects.equals(getId(), scoreId.getId()) &&
                Objects.equals(getIdTrainee(), scoreId.getIdTrainee()) &&
                Objects.equals(getIdTrainingObjective(), scoreId.getIdTrainingObjective());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getIdTrainee(), getIdTrainingObjective());
    }
}

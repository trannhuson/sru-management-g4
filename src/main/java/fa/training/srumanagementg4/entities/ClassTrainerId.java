package fa.training.srumanagementg4.entities;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ClassTrainerId implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;

    private Long classId;
    private Long trainerId;

    public ClassTrainerId() {
    }

    public ClassTrainerId(Long id, Long classId, Long trainerId) {
        this.id = id;
        this.classId = classId;
        this.trainerId = trainerId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Long getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Long trainerId) {
        this.trainerId = trainerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClassTrainerId)) return false;
        ClassTrainerId that = (ClassTrainerId) o;
        return getId().equals(that.getId()) &&
                getClassId().equals(that.getClassId()) &&
                getTrainerId().equals(that.getTrainerId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getClassId(), getTrainerId());
    }
}

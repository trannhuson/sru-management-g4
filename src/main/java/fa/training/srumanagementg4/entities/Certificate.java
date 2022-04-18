package fa.training.srumanagementg4.entities;

import fa.training.srumanagementg4.enums.Rate;

import javax.persistence.*;

@Entity
@Table(name = "certificate")
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "trainee_id")
    private Trainee trainee;

    @Enumerated(EnumType.STRING)
    @Column(name = "final_grade")
    private Rate rate;

    @Column(name = "completion_level")
    private String completionLevel;

    @Column(name = "provider")
    private String provider;

    @Column(name = "group_of")
    private String groupOf;

    @Column(name = "sub_group")
    private String subGroup;

    @Column(name = "code")
    private String code;

    public Certificate() {
    }

    public Certificate(Long id, Trainee trainee, Rate rate, String completionLevel, String provider, String groupOf, String subGroup, String code) {
        this.id = id;
        this.trainee = trainee;
        this.rate = rate;
        this.completionLevel = completionLevel;
        this.provider = provider;
        this.groupOf = groupOf;
        this.subGroup = subGroup;
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Trainee getTrainee() {
        return trainee;
    }

    public void setTrainee(Trainee trainee) {
        this.trainee = trainee;
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    public String getCompletionLevel() {
        return completionLevel;
    }

    public void setCompletionLevel(String completionLevel) {
        this.completionLevel = completionLevel;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getGroupOf() {
        return groupOf;
    }

    public void setGroupOf(String groupOf) {
        this.groupOf = groupOf;
    }

    public String getSubGroup() {
        return subGroup;
    }

    public void setSubGroup(String subGroup) {
        this.subGroup = subGroup;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

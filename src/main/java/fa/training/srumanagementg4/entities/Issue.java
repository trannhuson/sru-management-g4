package fa.training.srumanagementg4.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "issue")
public class Issue implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "created_date")
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class classIssue;

    @OneToMany(mappedBy = "issue", cascade = CascadeType.ALL)
    private Set<Solution> solutions = new HashSet<>();

    public Issue() {
    }

    public Issue(Long id, String name, Date createdDate) {
        this.id = id;
        this.name = name;
        this.createdDate = createdDate;
    }

    public Issue(String name, Date createdDate) {
        this.name = name;
        this.createdDate = createdDate;
    }

    public Set<Solution> getSolutions() {
        return solutions;
    }

    public void setSolutions(Set<Solution> solutions) {
        this.solutions = solutions;
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Class getClassIssue() {
        return classIssue;
    }

    public void setClassIssue(Class classIssue) {
        this.classIssue = classIssue;
    }
}

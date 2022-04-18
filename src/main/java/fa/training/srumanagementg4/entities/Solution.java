package fa.training.srumanagementg4.entities;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "solution")
public class Solution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name_solution")
    private String nameSolution;

    @Column(name = "created_date")
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "issue_id")
    private Issue issue;

    public Solution() {
    }

    public Solution(Long id, String name, Issue issue) {
        this.id = id;
        this.nameSolution = name;
        this.issue = issue;
    }

    public Solution(String nameSolution, Date createdDate, Issue issue) {
        this.nameSolution = nameSolution;
        this.createdDate = createdDate;
        this.issue = issue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameSolution() {
        return nameSolution;
    }

    public void setNameSolution(String nameSolution) {
        this.nameSolution = nameSolution;
    }

    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    public String getCreatedDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(createdDate);
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}

package prototype.hifi.dnick.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class TestResult {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private User user;
    private Double points;
    public TestResult(User user, Double points){
        this.user=user;
        this.points=points;
    }
    public TestResult() {

    }
}

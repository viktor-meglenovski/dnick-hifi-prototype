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
    private int points;
    public TestResult(User user, int points){
        this.user=user;
        this.points=points;
    }
    public TestResult() {

    }
}

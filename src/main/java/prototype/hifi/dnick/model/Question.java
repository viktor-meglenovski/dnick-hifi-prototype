package prototype.hifi.dnick.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;

    @ElementCollection
    private List<String> answers;

    private char correctAnswer;

    public Question(String text, List<String> answers, char correctAnswer) {
        this.text = text;
        this.answers=answers;
        this.correctAnswer = correctAnswer;
    }

    public Question() {

    }
}

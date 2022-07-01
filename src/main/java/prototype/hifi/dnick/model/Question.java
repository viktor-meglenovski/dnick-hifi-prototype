package prototype.hifi.dnick.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;
    @ManyToOne
    private Topic topic;

    //answers
    private String a;
    private String b;
    private String c;
    private String d;

    private char correctAnswer;

    public Question(String text, Topic topic, String a, String b, String c, String d, char correctAnswer) {
        this.text = text;
        this.topic = topic;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.correctAnswer = correctAnswer;
    }

    public Question() {

    }
}

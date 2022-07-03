package prototype.hifi.dnick.model;

import lombok.Data;

@Data
public class UserAnswer {
    private Long id;
    private char answer;

    public UserAnswer(Long id, char answer) {
        this.id = id;
        this.answer = answer;
    }
    public UserAnswer(){}
}

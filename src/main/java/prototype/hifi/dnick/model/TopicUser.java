package prototype.hifi.dnick.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class TopicUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Topic topic;
    private Boolean completed;
    public TopicUser(User user, Topic topic, Boolean completed){
        this.user=user;
        this.topic=topic;
        this.completed=completed;
    }

    public TopicUser() {

    }
}

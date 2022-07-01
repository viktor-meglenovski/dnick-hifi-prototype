package prototype.hifi.dnick.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Topic {
    @Id
    private String id;
    private String title;
    private String videoUrl;
    private String text;
    public Topic(String id, String title, String videoUrl, String text){
        this.id=id;
        this.title=title;
        this.videoUrl=videoUrl;
        this.text=text;
    }
    public Topic() {

    }
}

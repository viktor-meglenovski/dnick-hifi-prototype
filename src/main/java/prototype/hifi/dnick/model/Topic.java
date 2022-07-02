package prototype.hifi.dnick.model;

import lombok.Data;
import org.springframework.stereotype.Controller;

import javax.persistence.*;

@Data
@Entity
public class Topic {
    @Id
    private String id;
    private String title;
    private String imageUrl;
    private String videoUrl;
    @Column(length=65000)
    private String text;
    public Topic(String id, String title, String imageUrl, String videoUrl, String text){
        this.id=id;
        this.title=title;
        this.imageUrl=imageUrl;
        this.videoUrl=videoUrl;
        this.text=text;
    }
    public Topic() {

    }
}

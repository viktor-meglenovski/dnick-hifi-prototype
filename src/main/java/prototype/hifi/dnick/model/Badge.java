package prototype.hifi.dnick.model;

import lombok.Data;
import prototype.hifi.dnick.model.enumerations.Badges;

import javax.persistence.*;

@Data
@Entity
public class Badge {
    @Id
    @Enumerated(value = EnumType.STRING)
    private Badges badges;
    private String text;

    public Badge(Badges badges, String text) {
        this.badges = badges;
        this.text = text;
    }

    public Badge() {

    }
}

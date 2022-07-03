package prototype.hifi.dnick.service;

import prototype.hifi.dnick.model.Badge;
import prototype.hifi.dnick.model.User;

import java.util.List;

public interface BadgeService {
    Badge getScore100();
    Badge getScoreOver90();
    Badge getFiveTests();
    Badge getThreeTests();
    Badge getOneTest();

    void checkForScore100(User user,Double points);
    void checkForScoreOver90(User user, Double points);
    void checkForFiveTests(User user);
    void checkForThreeTests(User user);
    void checkForOneTest(User user);

    List<Badge> getAllBadges();

}

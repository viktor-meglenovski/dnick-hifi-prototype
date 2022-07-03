package prototype.hifi.dnick.service;

import prototype.hifi.dnick.model.Badge;
import prototype.hifi.dnick.model.TestResult;
import prototype.hifi.dnick.model.User;

import java.util.List;

public interface BadgeService {
    Badge getScore100();
    Badge getScoreOver90();
    Badge getFiveTests();
    Badge getThreeTests();
    Badge getOneTest();

    void checkForScore100(User user,int points);
    void checkForScoreOver90(User user, int points);
    void checkForFiveTests(User user);
    void checkForThreeTests(User user);
    void checkForOneTest(User user);

    void checkForAll(TestResult testResult);

    List<Badge> getAllBadges();

}

package prototype.hifi.dnick.service;

import prototype.hifi.dnick.model.TestResult;
import prototype.hifi.dnick.model.User;

public interface TestResultService {
    TestResult saveNewResult(User user, Double points);
    void initResultsForUser(User user);
}

package prototype.hifi.dnick.service;

import prototype.hifi.dnick.model.TestResult;
import prototype.hifi.dnick.model.User;

import java.util.List;

public interface TestResultService {
    TestResult saveNewResult(User user, Double points);
    void initResultsForUser(User user);
    List<TestResult> getTopThreeResultsForUser(User user);
    int getNumberOfTestsForUser(User user);
}

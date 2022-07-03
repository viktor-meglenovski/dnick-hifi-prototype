package prototype.hifi.dnick.service;

import prototype.hifi.dnick.model.Question;
import prototype.hifi.dnick.model.TestResult;
import prototype.hifi.dnick.model.User;
import prototype.hifi.dnick.model.UserAnswer;

import java.util.List;

public interface TestService {
    List<Question> generateQuestions();
    TestResult calculateResultsForUser(User user, List<UserAnswer> userAnswers);
}

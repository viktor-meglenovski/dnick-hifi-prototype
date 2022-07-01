package prototype.hifi.dnick.service.impl;

import org.springframework.stereotype.Service;
import prototype.hifi.dnick.model.TestResult;
import prototype.hifi.dnick.model.User;
import prototype.hifi.dnick.repository.TestResultRepository;
import prototype.hifi.dnick.service.TestResultService;

@Service
public class TestResultServiceImpl implements TestResultService {
    private final TestResultRepository testResultRepository;

    public TestResultServiceImpl(TestResultRepository testResultRepository) {
        this.testResultRepository = testResultRepository;
    }

    @Override
    public TestResult saveNewResult(User user, Double points) {
        return testResultRepository.save(new TestResult(user,points));
    }

    @Override
    public void initResultsForUser(User user) {
        for(int i=0;i<3;i++){
            testResultRepository.save(new TestResult(user,0.0));
        }
    }
}

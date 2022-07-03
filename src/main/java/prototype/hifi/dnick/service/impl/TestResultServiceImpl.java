package prototype.hifi.dnick.service.impl;

import org.springframework.stereotype.Service;
import prototype.hifi.dnick.model.TestResult;
import prototype.hifi.dnick.model.User;
import prototype.hifi.dnick.repository.TestResultRepository;
import prototype.hifi.dnick.service.TestResultService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestResultServiceImpl implements TestResultService {
    private final TestResultRepository testResultRepository;

    public TestResultServiceImpl(TestResultRepository testResultRepository) {
        this.testResultRepository = testResultRepository;
    }


    @Override
    public TestResult saveNewResult(User user, int points) {
        return testResultRepository.save(new TestResult(user,points));
    }

    @Override
    public void initResultsForUser(User user) {
        for(int i=0;i<3;i++){
            testResultRepository.save(new TestResult(user,0));
        }
    }

    @Override
    public List<TestResult> getTopThreeResultsForUser(User user) {
        return testResultRepository.findAllByUser(user).stream().sorted(Comparator.comparing(TestResult::getPoints).reversed()).limit(3).collect(Collectors.toList());
    }

    @Override
    public int getNumberOfTestsForUser(User user) {
        return testResultRepository.findAllByUser(user).stream().filter(x->x.getPoints()>0).collect(Collectors.toList()).size();
    }
}

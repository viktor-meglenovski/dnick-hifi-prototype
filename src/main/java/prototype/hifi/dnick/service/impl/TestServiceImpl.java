package prototype.hifi.dnick.service.impl;

import org.springframework.stereotype.Service;
import prototype.hifi.dnick.model.Question;
import prototype.hifi.dnick.model.TestResult;
import prototype.hifi.dnick.model.User;
import prototype.hifi.dnick.model.UserAnswer;
import prototype.hifi.dnick.repository.QuestionRepository;
import prototype.hifi.dnick.service.BadgeService;
import prototype.hifi.dnick.service.TestResultService;
import prototype.hifi.dnick.service.TestService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class TestServiceImpl implements TestService {
    private final QuestionRepository questionRepository;
    private final TestResultService testResultService;
    private final BadgeService badgeService;

    public TestServiceImpl(QuestionRepository questionRepository, TestResultService testResultService, BadgeService badgeService) {
        this.questionRepository = questionRepository;
        this.testResultService = testResultService;
        this.badgeService = badgeService;
    }


    @Override
    public List<Question> generateQuestions() {
        List<Question> allQuestions=questionRepository.findAll();
        int size=allQuestions.size();
        List<Question> toReturn=new ArrayList<>();
        Random random=new Random();
        while(toReturn.size()<8){
            Question q=allQuestions.get(random.nextInt(size));
            if(!toReturn.contains(q))
                toReturn.add(q);
        }
        return toReturn;
    }

    @Override
    public TestResult calculateResultsForUser(User user, List<UserAnswer> userAnswers) {
        int correct=0;
        for(UserAnswer ua : userAnswers){
            Question q=questionRepository.findById(ua.getId()).get();
            if(q.getCorrectAnswer()==ua.getAnswer())
                correct++;
        }
        int points=(int)((double)correct/8*100);
        TestResult tr= testResultService.saveNewResult(user,points);
        badgeService.checkForAll(tr);
        return tr;
    }
}

package prototype.hifi.dnick.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import prototype.hifi.dnick.model.TestResult;
import prototype.hifi.dnick.model.User;
import prototype.hifi.dnick.model.UserAnswer;
import prototype.hifi.dnick.service.TestService;
import prototype.hifi.dnick.service.TopicService;
import prototype.hifi.dnick.service.UserService;

import java.security.Principal;
import java.util.List;

@Controller
public class TestController {
    private final TopicService topicService;
    private final TestService testService;
    private final UserService userService;

    public TestController(TopicService topicService, TestService testService, UserService userService) {
        this.topicService = topicService;
        this.testService = testService;
        this.userService = userService;
    }

    @GetMapping("/test")
    public String getTestPage(Model model){
        model.addAttribute("questions",testService.generateQuestions());
        model.addAttribute("bodyContent","test");
        return "master-template";
    }
    @PostMapping("/test")
    public String testAnswers(Principal principal, Model model, @RequestBody List<UserAnswer> userAnswers){
        User user=userService.findByUsername(principal.getName());
        model.addAttribute("results",testService.calculateResultsForUser(user,userAnswers));
        return "testResults";
    }
}

package prototype.hifi.dnick.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import prototype.hifi.dnick.model.User;
import prototype.hifi.dnick.service.TestResultService;
import prototype.hifi.dnick.service.TopicService;
import prototype.hifi.dnick.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/myprofile")
public class ProfileController {
    private final UserService userService;
    private final TopicService topicService;
    private final TestResultService testResultService;

    public ProfileController(UserService userService, TopicService topicService, TestResultService testResultService) {
        this.userService = userService;
        this.topicService = topicService;
        this.testResultService = testResultService;
    }

    @GetMapping
    public String getMyProfilePage(Principal principal, Model model){
        User user=userService.findByUsername(principal.getName());
        model.addAttribute("user",user);
        model.addAttribute("topics",topicService.findAllForUser(user));
        model.addAttribute("testResults",testResultService.getTopThreeResultsForUser(user));
        model.addAttribute("bodyContent","myprofile");
        return "master-template";
    }
}

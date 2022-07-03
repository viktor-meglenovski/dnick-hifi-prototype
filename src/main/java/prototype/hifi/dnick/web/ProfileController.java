package prototype.hifi.dnick.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import prototype.hifi.dnick.model.User;
import prototype.hifi.dnick.service.BadgeService;
import prototype.hifi.dnick.service.TestResultService;
import prototype.hifi.dnick.service.TopicService;
import prototype.hifi.dnick.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping()
public class ProfileController {
    private final UserService userService;
    private final TopicService topicService;
    private final TestResultService testResultService;
    private final BadgeService badgeService;

    public ProfileController(UserService userService, TopicService topicService, TestResultService testResultService, BadgeService badgeService) {
        this.userService = userService;
        this.topicService = topicService;
        this.testResultService = testResultService;
        this.badgeService = badgeService;
    }

    @GetMapping("/myprofile")
    public String getMyProfilePage(Principal principal, Model model){
        User user=userService.findByUsername(principal.getName());
        model.addAttribute("user",user);
        model.addAttribute("allBadges",badgeService.getAllBadges());
        model.addAttribute("numberOfTests",testResultService.getNumberOfTestsForUser(user));
        model.addAttribute("highestScore",testResultService.getTopThreeResultsForUser(user).get(0).getPoints());
        model.addAttribute("bodyContent","myprofile");
        return "master-template";
    }
    @GetMapping("/learn")
    public String getLearnPage(Principal principal, Model model){
        User user=userService.findByUsername(principal.getName());
        model.addAttribute("user",user);
        model.addAttribute("topics",topicService.findAllForUser(user));
        model.addAttribute("bodyContent","learn");
        return "master-template";
    }
}

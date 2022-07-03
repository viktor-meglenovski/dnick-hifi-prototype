package prototype.hifi.dnick.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import prototype.hifi.dnick.model.User;
import prototype.hifi.dnick.service.BadgeService;
import prototype.hifi.dnick.service.TestResultService;
import prototype.hifi.dnick.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/results")
public class ResultsController {
    private final UserService userService;
    private final TestResultService testResultService;
    private final BadgeService badgeService;

    public ResultsController(UserService userService, TestResultService testResultService, BadgeService badgeService) {
        this.userService = userService;
        this.testResultService = testResultService;
        this.badgeService = badgeService;
    }

    @GetMapping()
    public String viewResults(Principal principal, Model model){
        User user=userService.findByUsername(principal.getName());
        model.addAttribute("user",user);
        model.addAttribute("testResults",testResultService.getTopThreeResultsForUser(user));
        model.addAttribute("badges", badgeService.getAllBadges());
        model.addAttribute("bodyContent","results");
        return "master-template";
    }
}

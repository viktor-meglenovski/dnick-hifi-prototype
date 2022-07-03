package prototype.hifi.dnick.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import prototype.hifi.dnick.model.User;
import prototype.hifi.dnick.service.TopicService;
import prototype.hifi.dnick.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/topic")
public class TopicController {
    private final UserService userService;
    private final TopicService topicService;
    public TopicController(UserService userService, TopicService topicService) {
        this.userService = userService;
        this.topicService = topicService;
    }

    @GetMapping("/details/{id}")
    public String viewTopic(@PathVariable String id, Principal principal, Model model){
        User user=userService.findByUsername(principal.getName());
        model.addAttribute("topic",topicService.findTopicForUser(id,user));
        model.addAttribute("bodyContent","topic");
        return "master-template";
    }
    @GetMapping("/markCompleted/{id}")
    public String markAsCompleted(@PathVariable String id, Principal principal){
        User user=userService.findByUsername(principal.getName());
        topicService.markAsCompleted(id,user);
        return "redirect:/learn";
    }
    @GetMapping("/markNotCompleted/{id}")
    public String markAsNotCompleted(@PathVariable String id, Principal principal){
        User user=userService.findByUsername(principal.getName());
        topicService.markAsNotCompleted(id,user);
        return "redirect:/learn";
    }
}

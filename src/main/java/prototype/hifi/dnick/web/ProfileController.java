package prototype.hifi.dnick.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import prototype.hifi.dnick.model.User;
import prototype.hifi.dnick.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/myprofile")
public class ProfileController {
    private final UserService userService;

    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getMyProfilePage(Principal principal, Model model){
        User user=userService.findByUsername(principal.getName());
        model.addAttribute("user",user);
        model.addAttribute("bodyContent","myprofile");
        return "master-template";
    }
}

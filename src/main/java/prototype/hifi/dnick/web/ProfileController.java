package prototype.hifi.dnick.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myprofile")
public class ProfileController {

    @GetMapping
    public String getMyProfilePage(Model model){
        model.addAttribute("bodyContent","myprofile");
        return "master-template";
    }
}

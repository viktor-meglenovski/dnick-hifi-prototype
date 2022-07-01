package prototype.hifi.dnick.web;

import org.h2.engine.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/tema")
public class TopicController {
    @GetMapping("/{id}")
    public String viewTopic(@PathVariable String id, Principal principal, Model model){
        model.addAttribute("bodyContent","topic");
        return "master-template";
    }
}

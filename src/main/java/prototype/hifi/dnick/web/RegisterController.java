package prototype.hifi.dnick.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import prototype.hifi.dnick.model.enumerations.Role;
import prototype.hifi.dnick.model.exceptions.InvalidArgumentsException;
import prototype.hifi.dnick.model.exceptions.PasswordsDoNotMatchException;
import prototype.hifi.dnick.service.AuthService;
import prototype.hifi.dnick.service.UserService;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final AuthService authService;
    private final UserService userService;

    public RegisterController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @GetMapping
    public String getRegisterPage(@RequestParam(required = false) String error, Model model) {
        if(error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }else model.addAttribute("hasError", false);
        model.addAttribute("bodyContent","register");
        return "master-template";
    }

    @PostMapping
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String repeatedPassword,
                           @RequestParam String name,
                           @RequestParam String surname
                           ) throws UnsupportedEncodingException {
        try{
            this.userService.register(username, password, repeatedPassword, name, surname, Role.ROLE_USER);
            return "redirect:/login";
        } catch (RuntimeException exception) {
            return "redirect:/register?error=" + URLEncoder.encode(exception.getMessage(),"UTF-8");
        }
    }
}

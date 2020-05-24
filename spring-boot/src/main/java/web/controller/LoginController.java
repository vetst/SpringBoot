package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.service.InitService;
import web.service.UserService;

@Controller
@RequestMapping("/")
public class LoginController {

    private InitService initService;

    @Autowired
    public LoginController(InitService initService) {
        this.initService = initService;
    }

    @GetMapping(value = "login")
    public String loginPage() {
        initService.addAdminAndUser();
        return "login";
    }
}

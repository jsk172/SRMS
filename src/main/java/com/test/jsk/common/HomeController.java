package com.test.jsk.common;

import com.test.jsk.config.SecurityUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication.getPrincipal() instanceof SecurityUser){
            SecurityUser userDetails = (SecurityUser) authentication.getPrincipal();
            model.addAttribute("member", userDetails.getMember());
        } else {
            model.addAttribute("member", null);
        }

        return "index";
    }
}

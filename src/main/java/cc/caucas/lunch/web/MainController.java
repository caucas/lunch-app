package cc.caucas.lunch.web;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Georgy Davityan.
 */
@Controller
public class MainController {

    private Authentication auth = SecurityContextHolder.getContext().getAuthentication();

    @RequestMapping("/")
    public String login() {
        return auth != null && auth.isAuthenticated()
                && !(auth instanceof AnonymousAuthenticationToken) ? "redirect:dashboard" : "home";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/?logout";
    }

}

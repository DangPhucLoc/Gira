package cybersoft.Gira;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class WelcomeResource {
    @GetMapping("/hello")
    public String welcome(HttpServletRequest request) {
        return """
               Welcome %s to Gira Application 
               """.formatted(request.getRemoteAddr());
    }
}

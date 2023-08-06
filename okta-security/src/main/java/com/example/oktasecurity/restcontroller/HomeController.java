package com.example.oktasecurity.restcontroller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin("http://localhost:4200")
public class HomeController {
    @GetMapping("/")
    public String home(@AuthenticationPrincipal OidcUser user) {
        return user.getFullName();
    }
    @GetMapping("/tokenID")
    public OidcIdToken sign(@AuthenticationPrincipal OidcUser user)
    {
        return user.getIdToken();
    }
    @GetMapping("/api/whoami")
    public Map<String, Object> whoami(Authentication authentication) {
        // return information about the token
        return (Map<String, Object>) authentication.getDetails();
    }
}

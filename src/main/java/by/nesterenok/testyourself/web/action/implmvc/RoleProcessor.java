package by.nesterenok.testyourself.web.action.implmvc;

import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public interface RoleProcessor {

    default String processPage(String targetPage) {
        Authentication authentication = SecurityContextHolder.getContext()
            .getAuthentication();
        Set<String> roles = authentication.getAuthorities()
            .stream()
            .map(r -> r.getAuthority())
            .collect(Collectors.toSet());
       if (roles.contains("ROLE_USER")) {
            return "user/" + targetPage;
        } else if (roles.contains("ROLE_MENTOR")) {
            return "mentor/" + targetPage;
        } else {
            return "guest/" + targetPage;
        }
    }

    default String processUrl() {
        Authentication authentication = SecurityContextHolder.getContext()
            .getAuthentication();
        Set<String> roles = authentication.getAuthorities()
            .stream()
            .map(r -> r.getAuthority())
            .collect(Collectors.toSet());
        if (roles.contains("ROLE_GUEST")) {
            return "/guest";
        } else if (roles.contains("ROLE_USER")) {
            return "/user";
        } else if (roles.contains("ROLE_MENTOR")) {
            return "/mentor";
        } else {
            return "/guest";
        }
    }

    default String processUrl(String targetUrl) {
        Authentication authentication = SecurityContextHolder.getContext()
            .getAuthentication();
        Set<String> roles = authentication.getAuthorities()
            .stream()
            .map(r -> r.getAuthority())
            .collect(Collectors.toSet());
        if (roles.contains("ROLE_GUEST")) {
            return "/guest/" + targetUrl;
        } else if (roles.contains("ROLE_USER")) {
            return "/user/" + targetUrl;
        } else if (roles.contains("ROLE_MENTOR")) {
            return "/mentor/" + targetUrl;
        } else {
            return "/error";
        }
    }
}

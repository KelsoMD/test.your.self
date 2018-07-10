package by.nesterenok.testyourself.web.controllers;

import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public interface RoleProcessor {

    String ROLE_USER = "ROLE_USER";
    String ROLE_MENTOR = "ROLE_MENTOR";
    String ROLE_GUEST = "ROLE_GUEST";
    String USER = "user/";
    String MENTOR = "mentor/";
    String GUEST = "mentor/";
    String GUEST_BEFORE = "/guest";
    String USER_BEFORE = "/user";
    String MENTOR_BEFORE = "/mentor";
    String GUEST_DOUBLE = "/guest/";
    String USER_DOUBLE = "/user/";
    String MENTOR_DOUBLE = "/mentor/";
    String ERROR = "/error";

    default String processPage(String targetPage) {
        Authentication authentication = SecurityContextHolder.getContext()
            .getAuthentication();
        Set<String> roles = authentication.getAuthorities()
            .stream()
            .map(r -> r.getAuthority())
            .collect(Collectors.toSet());
        if (roles.contains(ROLE_USER)) {
            return USER + targetPage;
        } else if (roles.contains(ROLE_MENTOR)) {
            return MENTOR + targetPage;
        } else {
            return GUEST + targetPage;
        }
    }

    default String processUrl() {
        Authentication authentication = SecurityContextHolder.getContext()
            .getAuthentication();
        Set<String> roles = authentication.getAuthorities()
            .stream()
            .map(r -> r.getAuthority())
            .collect(Collectors.toSet());
        if (roles.contains(ROLE_GUEST)) {
            return GUEST_BEFORE;
        } else if (roles.contains(ROLE_USER)) {
            return USER_BEFORE;
        } else if (roles.contains(ROLE_MENTOR)) {
            return MENTOR_BEFORE;
        } else {
            return GUEST_BEFORE;
        }
    }

    default String processUrl(String targetUrl) {
        Authentication authentication = SecurityContextHolder.getContext()
            .getAuthentication();
        Set<String> roles = authentication.getAuthorities()
            .stream()
            .map(r -> r.getAuthority())
            .collect(Collectors.toSet());
        if (roles.contains(ROLE_GUEST)) {
            return GUEST_DOUBLE + targetUrl;
        } else if (roles.contains(ROLE_USER)) {
            return USER_DOUBLE + targetUrl;
        } else if (roles.contains(ROLE_MENTOR)) {
            return MENTOR_DOUBLE + targetUrl;
        } else {
            return ERROR;
        }
    }
}

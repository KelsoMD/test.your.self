package by.nesterenok.testyourself.spring.configuration;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class SuccessHandler implements AuthenticationSuccessHandler {

    public static final String ROLE_USER = "ROLE_USER";
    public static final String ROLE_MENTOR = "ROLE_MENTOR";
    public static final String ROLE_MODERATOR = "ROLE_MODERATOR";
    public static final String USER = "/user";
    public static final String MENTOR = "/mentor";
    public static final String MODERATOR = "/moderator";
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {

        handle(request, response, authentication);
        clearAuthenticationAttributes(request);
    }

    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
        throws IOException {

        String targetUrl = determineTargetUrl(authentication);

        if (response.isCommitted()) {
            return;
        }

        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    protected String determineTargetUrl(Authentication authentication) {
        boolean isUser = false;
        boolean isModerator = false;
        boolean isMentor = false;
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority()
                .equals(ROLE_USER)) {
                isUser = true;
                break;
            } else if (grantedAuthority.getAuthority()
                .equals(ROLE_MENTOR)) {
                isMentor = true;
                break;
            } else if (grantedAuthority.getAuthority()
                .equals(ROLE_MODERATOR)) {
                isModerator = true;
                break;
            }
        }

        if (isUser) {
            return USER;
        } else if (isMentor) {
            return MENTOR;
        } else if (isModerator) {
            return MODERATOR;
        } else {
            throw new IllegalStateException();
        }
    }

    protected void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }

    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }

    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }
}

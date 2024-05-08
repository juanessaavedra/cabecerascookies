package services.impl.LoginCookie;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;

public interface LoginServiceCookie {
    Optional<String> getUserName(HttpServletRequest request);
}

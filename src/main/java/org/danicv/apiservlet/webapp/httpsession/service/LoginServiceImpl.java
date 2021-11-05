package org.danicv.apiservlet.webapp.httpsession.service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Arrays;
import java.util.Optional;

public class LoginServiceImpl implements LoginService {
    @Override
    public Optional<String> getUsername(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            req.getCookies();
        } else {
            cookies = new Cookie[0];
        }
        return Arrays.stream(cookies).filter(c -> "username".equals(c.getName())).map(c -> c.getValue()).findAny();
    }
}

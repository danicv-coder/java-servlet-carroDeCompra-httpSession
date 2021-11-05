package org.danicv.apiservlet.webapp.httpsession.service;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;

public interface LoginService {
    Optional<String> getUsername(HttpServletRequest request );
}

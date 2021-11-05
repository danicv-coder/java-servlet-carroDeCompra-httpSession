package org.danicv.apiservlet.webapp.httpsession.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.danicv.apiservlet.webapp.httpsession.service.LoginService;
import org.danicv.apiservlet.webapp.httpsession.service.LoginServiceSessionImpl;

import java.io.IOException;
import java.util.Optional;

@WebFilter({"/carro/*"})
public class LoginFiltro implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LoginService session = new LoginServiceSessionImpl();
        Optional<String> username = session.getUsername((HttpServletRequest) request);
        if (username.isPresent()) {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo sentimos no estas autorizado " +
                    "para ingresar a esta pagina");
        }
    }
}

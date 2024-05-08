package Filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.impl.LoginSession.LoginServiceSession;
import services.impl.LoginSession.LoginServiceSessionImpl;

import java.io.IOException;
import java.util.Optional;

@WebFilter({"/ver-carro", "/agregar-carro", "/actualizar-carro"}) //Con /carro/* Significa que todas las rutas que tengan este nombre se les aplicara, pero debemos renombrar nuestras rutas
public class LoginFiltro implements Filter { //Estas son todas las rutas privadas que requieren sesion
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LoginServiceSession service = new LoginServiceSessionImpl();
        Optional<String> username = service.getUserName((HttpServletRequest) servletRequest);
        if (username.isPresent()) {
            filterChain.doFilter(servletRequest, servletResponse); //Llamada del servlet
        } else {
            ((HttpServletResponse)servletResponse).sendError(HttpServletResponse.SC_UNAUTHORIZED, "" +
                    "Lo sentimos no estas autorizado para ingresar a esta pagina");
        }
    }
}

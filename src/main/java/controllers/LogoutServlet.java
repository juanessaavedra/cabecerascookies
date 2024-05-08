package controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import services.impl.LoginCookie.LoginServiceCookieImpl;
import services.impl.LoginSession.LoginServiceSession;
import services.impl.LoginSession.LoginServiceSessionImpl;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Inject LoginServiceSession auth;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Validar que existe la cookie, si existe, la cerramos, sino, no hacemos nada

        Optional<String> username = auth.getUserName(req);
        if(username.isPresent()) {

            HttpSession session = req.getSession();
            session.invalidate(); //Tambien borraria carro de compras, toddo lo guardado en nuestra sesion de usuario

            /* Cookie usernameCookie = new Cookie("username", "");
            usernameCookie.setMaxAge(0);
            resp.addCookie(usernameCookie); */
        }
        resp.sendRedirect(req.getContextPath() + "/login.html");
    }
}

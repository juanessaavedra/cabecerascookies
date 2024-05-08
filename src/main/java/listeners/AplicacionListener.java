package listeners;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener //No lleva nada, de forma opcional si queremos le ponemos nombre
public class AplicacionListener implements ServletContextListener /*Aplicacion en general  */, ServletRequestListener, HttpSessionListener {

    //Creamos los metodos para cuando se crea y se destruye

    private ServletContext servletContext;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().log("Inicializando la aplicacion");
        //Log es para registrar evento en la consola
        servletContext = sce.getServletContext();
        servletContext.setAttribute("mensaje", "algun valor global de la app");//Este mensaje es del contexto de la aplicacion, los podemos usar despues en los servlet.
        //Atributos alojados en contextos y alcances distintos
        //En los servlet es durante toda la aplicacion, si es en el request, ese atributo solo va tener el alcance del request. Lo mismo para el objeto sesion
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        servletContext.log("Destruyendo la aplicación");
    }


    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        servletContext.log("Inicializando el request");
        sre.getServletRequest().setAttribute("mensaje", "guardando algun valor para el request");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        servletContext.log("Destruyendo el request");
    }
}



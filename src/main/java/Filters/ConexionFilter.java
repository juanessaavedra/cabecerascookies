/*
package Filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;
import services.impl.ServiceJdbException;
import config.ConexionBaseDatos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebFilter("/*")
public class ConexionFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        try(Connection conn = ConexionBaseDatos.getConnection()) {

            if(conn.getAutoCommit()) {
                conn.setAutoCommit(false);
            }

            try {
                servletRequest.setAttribute("conn", conn); //Queda guardada y disponible para todoo el request. Para poderselo pasar a la clase service
            filterChain.doFilter(servletRequest,servletResponse); //doFilter es el resultado de una peticion,
            conn.commit(); //Si sale todoo bien
            }
            catch (SQLException | ServiceJdbException e) { //Capturamos la excepcion
                conn.rollback(); //En caso de error, al usar el rollback, el error continua y se cierra la conexion en....
                ((HttpServletResponse) servletResponse).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
                e.printStackTrace(); //Mostrar la traza
            }

    } catch (SQLException throwables)  {
        throwables.printStackTrace();
    }
        //El serviceJdbcException es como un puente de comunicacion entre la clase service cuando ocurre un error
        //Y la clase conexionFilter para que realice el rollback, ocurre el error en service, se lanza la excepcion y la capturamos en el filtro para el rollback, es como lanzar la excepcion.
} //Por eso no estamos obligados a usar el try catch en el servlet, pero si en el filtro
}


 */
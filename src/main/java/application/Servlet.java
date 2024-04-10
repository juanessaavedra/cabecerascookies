package application;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@WebServlet ("/update")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Configuración de la respuesta HTTP
        resp.setContentType("text/html;charset=UTF-8"); // Establece el tipo de contenido como HTML con codificación UTF-8
        resp.setHeader("refresh", "1"); // Configura el encabezado de actualización para que la página se refresque cada segundo

        LocalTime hora = LocalTime.now(); // Obtiene la hora actual del sistema
        DateTimeFormatter df = DateTimeFormatter.ofPattern("hh:mm:ss"); // Formatea la hora en formato hh:mm:ss

        try (PrintWriter out = resp.getWriter()) {
            // Comienza la escritura de la respuesta HTML
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Hora actual</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Hora actual: " + hora.format(df) + "</h1>");
            out.println("</body>");
            out.println("</html>");
            // Fin de la respuesta HTML
        }
        // El bloque try-with-resources asegura que el PrintWriter se cierre correctamente después de su uso
    }
}

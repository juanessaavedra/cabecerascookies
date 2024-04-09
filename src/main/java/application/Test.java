package application;

import java.io.*;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(value = "/test")
/*  esta anotación establece la URL relativa a la cual este servlet responderá. En este caso, el servlet estará activo en el contexto de la aplicación
en la ruta "/test". Por lo tanto, para acceder a este servlet, deberías usar la URL completa de la aplicación seguida de "/test". Por ejemplo, si tu aplicación
está en http://localhost:8080/myapp, entonces la URL completa sería http://localhost:8080/myapp/test.*/

public class Test extends HttpServlet { //La clase hereda todos los metodos del HttpServlet


    /* Se ha sobrescrito para manejar las solicitudes HTTP GET. Esto significa que cuando se envía una solicitud GET al servlet,
     el contenedor servlet llamará a este método doGet para procesar esa solicitud y generar una respuesta apropiada. */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html"); //Establece el tipo de contenido de la respuesta que el servidor enviará al cliente como "text/html". Le dice al navegador del cliente qué tipo de contenido esperar del servidor.
        // Obtiene información sobre la solicitud HTTP entrante
        String metodoHttp = req.getMethod(); //está extrayendo el método de la solicitud HTTP y almacenándolo en la variable metodoHttp. Esto es útil para determinar qué tipo de acción el cliente está solicitando al servidor.
        String requestUri = req.getRequestURI(); // URI de la solicitud
        String requestUrl = req.getRequestURL().toString(); // URL de la solicitud
        String contexPath = req.getContextPath();// Contexto de la aplicación
        String servletPath = req.getServletPath(); // Ruta del servlet
        String ipCliente = req.getRemoteAddr(); // Dirección IP del cliente
        String ip = req.getLocalAddr();  // Dirección IP del servidor
        int port = req.getLocalPort(); // Puerto del servidor
        String scheme = req.getScheme();  // Esquema de la solicitud (http, https)
        String host = req.getHeader("host");  // Host de la solicitud
        String url = scheme + "://" + host + contexPath + servletPath; // Construye la URL completa
        String url2 = scheme + "://" + ip + ":" + port + contexPath + servletPath; // Construye otra URL con IP y puerto
        try (PrintWriter out = resp.getWriter()) {
            // Escribe el HTML de la respuesta
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<title>Cabeceras HTTP Request</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Cabeceras HTTP Request!</h1>");
            out.println("<ul>");
            out.println("<li> metodo http: " + metodoHttp + "</li>");
            out.println("<li> request uri " + requestUri + "</li>");
            out.println("<li> request url " + requestUrl + "</li>");
            out.println("<li> context path: " + contexPath + "</li>");
            out.println("<li> servlet path: " + servletPath + "</li>");
            out.println("<li> ip local: " + ip + "</li>");
            out.println("<li> ip cliente: " + ipCliente + "</li>");
            out.println("<li> puerto local: " + port + "</li>");
            out.println("<li> scheme: " + scheme + "</li>");
            out.println("<li> host: " + host+ "</li>");
            out.println("<li> url: " + url + "</li>");
            out.println("<li> url2: " + url2+ "</li>");

            // Obtiene todas las cabeceras HTTP de la solicitud
            Enumeration<String> headerNames = req.getHeaderNames();
            while(headerNames.hasMoreElements()) {
                String cabecera = headerNames.nextElement();
                out.println("<li>" + cabecera + ":" + req.getHeader(cabecera) + "</li>");
            }
            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
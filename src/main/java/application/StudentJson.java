package application;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mapping.dtos.StudentsDTO;
import model.Students;
import services.impl.StudentsServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/student.json.")
public class StudentJson extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletInputStream jsonStream = req.getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        Students students = mapper.readValue(jsonStream, Students.class);
        resp.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<title>Producto</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<ul>");
            out.println("<li>Id: " + students.getId() + "</li>");
            out.println("<li>Nombre: " + students.getName() + "</li>");
            out.println("<li>Email: " + students.getEmail() + "</li>");
            out.println("<li> Semestre: " + students.getSemester() + "</li>");
            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        {
            StudentsServiceImpl service = new StudentsServiceImpl();
            List<StudentsDTO> students = service.listStudents();
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(students);
            resp.setContentType("application/json");
            resp.getWriter().write(json);
        }
    }
}

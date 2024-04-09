package services.impl;

import mapping.dtos.StudentsDTO;
import services.StudentsService;

import java.util.ArrayList;
import java.util.List;

public class StudentsServiceImpl implements StudentsService {

    @Override
    public List<StudentsDTO> listStudents() {
        List<StudentsDTO> students = new ArrayList<>();

        // Datos quemados de estudiantes
        students.add(new StudentsDTO(1, "Juan", "juan@example.com", "4th semester"));
        students.add(new StudentsDTO(2, "María", "maria@example.com", "3rd semester"));
        students.add(new StudentsDTO(3, "Pedro", "pedro@example.com", "2nd semester"));

        return students;
    }
    }


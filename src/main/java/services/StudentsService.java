package services;

import mapping.dtos.StudentsDTO;

import java.util.List;

public interface StudentsService {
    List<StudentsDTO> listStudents();
}

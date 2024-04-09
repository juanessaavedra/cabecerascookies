package mapping.mappers;

import mapping.dtos.StudentsDTO;
import model.Students;

public class StudentsMapper {
    public static StudentsDTO mapFromModel (Students students) {
        return new StudentsDTO(students.getId(), students.getName(), students.getEmail(), students.getSemester());
    }

    public static Students mapFromDTO (StudentsDTO studentsDTO) {
        return Students.builder().
                id(studentsDTO.id())
                .name(studentsDTO.name())
                .email(studentsDTO.email())
                .semester(studentsDTO.semester())
                .build();
    }
}

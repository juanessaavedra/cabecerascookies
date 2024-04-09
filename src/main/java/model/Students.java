package model;


import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class Students {
    private int id;
    private String name;
    private String email;
    private String semester;

}

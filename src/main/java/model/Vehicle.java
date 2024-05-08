package model;

import jakarta.enterprise.context.SessionScoped;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@SessionScoped


public class Vehicle  implements Serializable {
    private int id;
    private String name;
    private String type;
    private double price;

}

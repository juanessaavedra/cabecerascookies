package model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder


public class Vehicle {
    private int id;
    private String name;
    private String type;
    private double price;

}

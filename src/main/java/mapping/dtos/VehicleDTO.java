package mapping.dtos;

import lombok.Builder;

@Builder
public record VehicleDTO(int id, String name, String type, double price) {

}

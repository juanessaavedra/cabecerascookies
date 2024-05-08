package mapping.mappers;

import mapping.dtos.VehicleDTO;
import model.Vehicle;

public class VehicleMapper {
    public static Vehicle mapFrom(VehicleDTO vehicleDTO) {
        return Vehicle.builder()
                .id(vehicleDTO.id())
                .name(vehicleDTO.name())
                .type(vehicleDTO.type())
                .price(vehicleDTO.price())
                .build();

    }

    public static VehicleDTO mapFrom(Vehicle vehicle) {
        return VehicleDTO.builder()
                .id(vehicle.getId())
                .name(vehicle.getName())
                .type(vehicle.getType())
                .price(vehicle.getPrice())
                .build();
    }
}

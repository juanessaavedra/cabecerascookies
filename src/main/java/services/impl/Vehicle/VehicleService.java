package services.impl.Vehicle;

import mapping.dtos.VehicleDTO;
import model.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleService  {


    List<VehicleDTO> listVehicle();

    Optional<VehicleDTO> findById(int id);


    void save (VehicleDTO vehicleDTO);

    void delete(Integer id);




}

package services.impl.Vehicle;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import mapping.dtos.VehicleDTO;
import model.Vehicle;
import repository.Repository;
import repository.VehicleRepositoryJdbcImpl;
import services.impl.ServiceJdbException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class VehicleServiceImpl implements VehicleService {

    @Inject
    private Repository<VehicleDTO> vehicleRepository;


    @Override
        public List<VehicleDTO> listVehicle() {
            try {
                return vehicleRepository.listar();
            } catch (SQLException throwables) {
                throw new ServiceJdbException(throwables.getMessage(), throwables.getCause());
            }
    }

    @Override
    public Optional<VehicleDTO> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void save(VehicleDTO vehicleDTO) {

    }

    @Override
    public void delete(Integer id) {

    }


}

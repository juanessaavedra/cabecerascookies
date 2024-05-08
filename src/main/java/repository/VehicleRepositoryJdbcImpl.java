package repository;

import annotations.MysqlConn;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import mapping.dtos.VehicleDTO;
import model.Vehicle;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class VehicleRepositoryJdbcImpl implements Repository<VehicleDTO>{


    @Inject
    @MysqlConn
    private Connection conn;


    @Override
    public List<VehicleDTO> listar() throws SQLException {
        List<VehicleDTO> vehicles = new ArrayList<>();
        //Para realizar una consulta necesitamos la conexion a la base de datos, la conexion, entonces la conexion se tiene
        //Que pasar al repositorio, se pasa al service y el servlet lo obtiene del request, de los atributos del request con GetAtribute y se lo pasa al service y el service se lo pasa al Repository
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT v.* order by v.id ASC)")) {
            while (rs.next()) {

                VehicleDTO v = getVehicle(rs);
                vehicles.add(v);
            }
        }

        return mapper.mapFrom.vehicles;
    }

    @Override
    public VehicleDTO porId(int id) throws SQLException {
        return null;
    }

    @Override
    public void guardar(VehicleDTO vehicleDTO) throws SQLException {

    }

    @Override
    public void eliminar(int id) throws SQLException {

    }


}

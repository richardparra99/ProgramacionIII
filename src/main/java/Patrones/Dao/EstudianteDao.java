package Patrones.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class EstudianteDao implements Dao<Estudiante> {
    private Connection conexion;
    public static final String TABLA = "estudiante";

    public EstudianteDao() {
        String host = "jdbc:mysql//localHost:3306/testDb";
        String user = "root";
        String password = "root";

        try {
            this.conexion = DriverManager.getConnection(host, user, password);
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
    }

    @Override
    public void insert(Estudiante objet) {
        String query = "INSERT INTO" + this.TABLA + "(Nombre, Apellidos, Edad, CarnetIdentidad) VALUES (?, ?, ?, ?)";
        try (PreparedStatement declaracion = conexion.prepareStatement(query)) {
            declaracion.setString(1, objet.getNombre());
            declaracion.setString(2, objet.getApellidos());
            declaracion.setString(3, objet.getEdad() + "");
            declaracion.setString(4, objet.getCarnetIdentidad());
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
    }

    @Override
    public void update(Estudiante objet) {
        String query = "UPDATE" + this.TABLA + "SET Nombre = ?, Apellidos = ?, Edad = ?, CarnetIdentidad = ?) WHERE id (?, ?, ?, ?)";
        try (PreparedStatement declaracion = conexion.prepareStatement(query)) {
            declaracion.setString(1, objet.getNombre());
            declaracion.setString(2, objet.getApellidos());
            declaracion.setString(3, objet.getEdad() + "");
            declaracion.setString(4, objet.getCarnetIdentidad());
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
    }

    @Override
    public void delete(Estudiante objet) {

    }

    @Override
    public void deleteByID(int id) {

    }

    @Override
    public Estudiante get(int id) {
        return null;
    }

    @Override
    public List<Estudiante> getAll() {
        return null;
    }
}

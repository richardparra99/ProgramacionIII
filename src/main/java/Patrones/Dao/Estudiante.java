package Patrones.Dao;

public class Estudiante {
    public String nombre;
    public String apellidos;
    public int edad;
    public String carnetIdentidad;

    public Estudiante(String nombre, String apellidos, int edad, String carnetIdentidad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.carnetIdentidad = carnetIdentidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public String getCarnetIdentidad() {
        return carnetIdentidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setCarnetIdentidad(String carnetIdentidad) {
        this.carnetIdentidad = carnetIdentidad;
    }
}

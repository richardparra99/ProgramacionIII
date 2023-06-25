package Patrones.Factory;

public class Tallarin implements ProductoComida{

    @Override
    public void preparar() {
        System.out.println("=== PREPARANDO ===");
        System.out.println("Estirar la masa");
        System.out.println("Preparar salsa");
        System.out.println("Agregar Ingredientes");
        System.out.println("--------------------");


    }

    @Override
    public void cocinar() {
        System.out.println("=== COCINANDO TALLARIN ===");
        System.out.println("colocar en un plato hondo los tallarines");
    }

    @Override
    public void servir() {
        System.out.println("=== SERVIR TALLARIN ===");
        System.out.println("Cortar la carne");
        System.out.println("Pelar la papa, cortar el resto de ingredientes");
        System.out.println("--------------------------");
    }
}

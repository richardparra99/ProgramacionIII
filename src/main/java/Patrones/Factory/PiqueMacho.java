package Patrones.Factory;

public class PiqueMacho implements ProductoComida{
    @Override
    public void preparar() {
        System.out.println("=== PREPARANDO PIQUE ===");
        System.out.println("Cortar la carne");
        System.out.println("Pelar la papa, cortar el resto de ingredientes");
        System.out.println("--------------------------");
    }

    @Override
    public void cocinar() {
        System.out.println("=== COCINANDO PIQUE ===");
        System.out.println("Sellar la carne ¡, agregar a una olla aguar y el resto de los ingredientes");
        System.out.println("Fritar las papas");
        System.out.println("--------------------------");
    }

    @Override
    public void servir() {
        System.out.println("=== SERVIR PIQUE ===");
        System.out.println("Colocar en un plato plano la carne mezclada");
        System.out.println("Pelar la papa, cortar el resto de ingredientes");
        System.out.println("--------------------------");
    }
}

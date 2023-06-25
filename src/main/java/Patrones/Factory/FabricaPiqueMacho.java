package Patrones.Factory;

public class FabricaPiqueMacho extends FabricaComida{
    @Override
    ProductoComida crearComida() {
        return new PiqueMacho();
    }
}

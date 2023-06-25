package Patrones.Factory;

public class FabricaTallarin extends FabricaComida{
    @Override
    ProductoComida crearComida() {
        return new Tallarin();
    }
}

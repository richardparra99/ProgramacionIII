package Patrones.Factory;

public class FabricaMain {
    public static void main(String[] args) {
        FabricaTallarin fabricaTallarin = new FabricaTallarin();
        FabricaPiqueMacho fabricaPiqueMacho = new FabricaPiqueMacho();

        // creamos clientes
        Cliente juanito = new Cliente(fabricaTallarin);
        Cliente pepito = new Cliente(fabricaPiqueMacho);

        // orden de comida
        juanito.ordenarComida();
        System.out.println("***Termino de ordenar comida juanito***");
        pepito.ordenarComida();
        System.out.println("***Termino de ordenar comida pepito***");

        System.out.println("implementar el patron de diseño facorti para resolver un problema en una tienda , en producto en linea, se hace una rebiciendo de codigo, la logoica para vender el producto esta muy dispersa, el sitio cuenta");
        System.out.println("4 tipo de producto: de vidrio de la madera reciclado y metal, cuando un cliente hace una orden, recien se fabrica la orden. Esta cantidad de producto genero codigo, repetido 4 veces, por lo que hay 4 procesos de venta");
        System.out.println("");
    }

}

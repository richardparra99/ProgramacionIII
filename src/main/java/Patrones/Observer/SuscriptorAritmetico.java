package Patrones.Observer;

import Patrones.Observer.Observer;

public class SuscriptorAritmetico implements Observer {
    private int previo;
    private int numero;
    private String operacion;

    public SuscriptorAritmetico(String operacion) {
        this.operacion = operacion;
        this.previo = 1;
    }

    @Override
    public void actualizar(String mensaje) {
        try {
            numero = Integer.parseInt(mensaje);
            int resultado = 0;
            switch (this.operacion){
                case "suma":
                    resultado = numero + previo;
                    break;
                case "resta":
                    resultado = numero - previo;
                    break;
                case "multiplicacion":
                    resultado = numero * previo;
                    break;
                case "division":
                    resultado = numero / previo;
                    break;
            }
            System.out.println(resultado);
            previo = numero;

        }catch (Exception e){
            System.out.println("ha ocurrido el siguiente problema" + e.getMessage());
        }
    }
}

package MetodoQuickSort;

import Interfaz.Panel;

import java.util.Date;

public class Ordenamiento {
    private Panel panel;
    private int length;

    public Ordenamiento(Panel fr) {
        this.panel = fr;
    }
    public long obtenerTiempo(){
        return new Date().getTime();
    }

    // int[] arreglo, indice, indice
    public void intercambiar(int[] arreglo, int reemplazado, int reemplazo){
        int temporal = arreglo[reemplazado];
        arreglo[reemplazado] = arreglo[reemplazo];
        arreglo[reemplazo] = temporal;
        panel.setNumeros(arreglo);
    }
    public int numeroAleatorio(int desde, int hasta){
        return (int) (Math.random() * (hasta - desde + 1) + desde);
    }
    public int[] generarArreglo(int longitud){
        int[] generado = new int[longitud];
        int limite = (int) (longitud * 1.5);
        for (int indice = 0; indice < generado.length; indice++) {
            generado[indice] = numeroAleatorio(-limite, limite);
        }
        return generado;
    }
    public void ordenarSimple(int[] arreglo){
        int cambios = 0;
        //  1 2 3 4
        //  5 8 3
        // arregloA = {5,89,-4,6,-8}
        // cualquier valor de los mencionados esta dentro de arregloA
        // arrreglo [1]
        for (int pos = 0; pos < arreglo.length - 1; pos++) {
            if (arreglo[pos] > arreglo[pos + 1]){
                // intercambiar(1, pos+1, 1) = una posicion ++ cambio
                intercambiar(arreglo, pos,pos + 1);
                // estamos en 2 que es igual a 8, si cambios es igual + 1 (2+1) igual 3
                // si 3 no cumple con la primera condicion va ser 3 (cambios++) igual a 3 + 1
                cambios++;
            }
        }
        if (cambios > 0){
            ordenarSimple(arreglo);
        }
    }
    public void mostrarArreglo(int[] arreglo){
        System.out.print("[ ");
        for (int posicion = 0; posicion < arreglo.length; posicion++) {
            if (posicion != 0)
                System.out.print(", ");
            System.out.print(arreglo[posicion]);
        }
        System.out.println(" ]");
    }
    public void dividirArreglo(int[] arreglo, int inicio, int fin){
        int pivote = arreglo[arreglo.length - 1];
        for (int posi = 0; posi < arreglo.length; posi++) {
            if (arreglo[posi] < pivote){
                intercambiar(arreglo, inicio, fin);
            }
        }
    }
    public void quickSort(int[] arreglo, int inicio, int fin) {
        if (inicio < fin) {
            int posPivote = particion(arreglo, inicio, fin);
            quickSort(arreglo, inicio, posPivote - 1);
            quickSort(arreglo, posPivote + 1, fin);
        }
    }

    public int particion(int[] arreglo, int inicio, int fin) {
        int pivote = arreglo[inicio];
        int i = inicio + 1;
        for (int j = inicio + 1; j <= fin; j++) {
            if (arreglo[j] < pivote) {
                intercambiar(arreglo, i, j);
                i++;
            }
        }
        intercambiar(arreglo, inicio, i - 1);
        return i - 1;
    }
    /*public void OrdenarQuicksort(int[] numero){
        int pivote = numero[numero.length - 1];
        for (int pos = 0; pos < numero.length - 1; pos++) {
            if (numero[pos] < pivote){

            }
        }
    }*/
}

package Interfaz;

import MetodoQuickSort.MetodoBurbuja;
import MetodoQuickSort.Ordenamiento;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Panel extends JPanel implements Runnable {
    private int ancho = 50;
    private int[] numeros = new int[10];
    //private int[] numeros = {6,11,-2,5,7,-7,1,28,10};

    private MetodoBurbuja burbuja = new MetodoBurbuja(this);
    private Ordenamiento ordenamiento = new Ordenamiento(this);

    public Panel() {
        setLayout(null);
        this.setSize(1000, 500);
        this.setPreferredSize(getSize());
        llenarArray();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        dibujarArray(g, 20, 400);

    }

    public void dibujarArray(Graphics g, int x, int y) {
        //g.drawRect(x, y,20,200);
        for (Integer num: numeros) {
            g.drawRect(x, y-num, ancho, num);
            x += ancho + 10;
            //g.drawRect();
        }
    }

    private void llenarArray() {
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int) (Math.random() * 100);
            //System.out.println(numeros[i]);
        }
    }

    @Override
    public void run() {
        ordenamiento.ordenarSimple(numeros);
        //burbuja.bubbleSort(numeros);
    }

    public int[] getNumeros() {
        return numeros;
    }

    public void setNumeros(int[] numeros) {
        this.numeros = numeros;
        repaint();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Arrays.toString(numeros));
    }
}

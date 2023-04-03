package Interfaz;

import javax.swing.*;
import java.awt.*;

public class VentanaQuickSort extends JFrame{

    private JPanel panel = new Panel();

    public VentanaQuickSort(){
        iniciarComponentes();
        Thread hilo = new Thread((Runnable) panel);
        hilo.start();
    }
    public void iniciarComponentes(){
        this.setSize(2000, 2000);
        this.setTitle("Primera Tarea");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().add(panel, BorderLayout.CENTER);
        this.pack();
        this.setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        VentanaQuickSort ventana = new VentanaQuickSort();
        ventana.setVisible(true);
    }
}

package MetodoQuickSort;

import Interfaz.Panel;

public class MetodoBurbuja {
    private Panel panel;

    public MetodoBurbuja(Panel panel) {
        this.panel = panel;
    }

    public void bubbleSort(int[] array) {
        int n = array.length;
        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (array[j - 1] > array[j]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                    panel.setNumeros(array);
                }
            }
        }
    }
}

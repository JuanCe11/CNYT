package calculadora.graficas;

import org.jfree.chart.*;
import org.jfree.data.category.*;

import calculadora.Matriz;
import calculadora.CalculadoraException;
import calculadora.DeutschJozsa;

public class SimulacionDeutschJozsa {
    public static void main(String[] args) {
        try {
            graficar(DeutschJozsa.simulacionU0());
        } catch (CalculadoraException e) {
            e.printStackTrace();
        }
    }

    private static void graficar(Matriz estadoFinal) {
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        String sitio1 = "Probabilidad";
        String[] nombres = {"000","001","010","011","100","101","110","111"};
        for (int i = 0; i < estadoFinal.getNumeros().length; i++) {
            data.setValue(estadoFinal.getNumeros()[i][0].getReal(),sitio1,nombres[i]);
        }
        JFreeChart chart = ChartFactory.createBarChart("Simulacion Deutsch-Jozsa","Estados","Probabilidad",data);
        ChartFrame frame = new ChartFrame("Simulacion Deutsch-Jozsa",chart);
        frame.pack();
        frame.setVisible(true);
    }
}
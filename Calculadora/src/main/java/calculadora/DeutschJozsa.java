package calculadora;

public class DeutschJozsa {
    private static Matriz prueba;
    private static Matriz hadamart;
    private static Matriz uno;
    private static Matriz cero;

    /**
     * Crea las matrices necasarias para la simulaci�n
     */
    private static void crearMatrices() {
        double[][] u0d = {{1,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},
                {0,0},{1,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},
                {0,0},{0,0},{1,0},{0,0},{0,0},{0,0},{0,0},{0,0},
                {0,0},{0,0},{0,0},{1,0},{0,0},{0,0},{0,0},{0,0},
                {0,0},{0,0},{0,0},{0,0},{0,0},{1,0},{0,0},{0,0},
                {0,0},{0,0},{0,0},{0,0},{1,0},{0,0},{0,0},{0,0},
                {0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{1,0},{0,0},
                {0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{1,0}};

        double raiz = (double)1/Math.sqrt(2);

        double[][] had = {{raiz,0},{raiz,0},
                {raiz,0},{raiz*-1,0}};

        double[][] cerod = {{1,0},{0,0}};
        double[][] unod = {{0,0},{1,0}};

        try {
            prueba = new Matriz(8,8,u0d);
            hadamart = new Matriz(2,2,had);
            cero = new Matriz(2,1,cerod);
            uno = new Matriz(2,1,unod);
        } catch (CalculadoraException e) {
            e.printStackTrace();
        }
    }


    public static Matriz simulacionU0() throws CalculadoraException {
        crearMatrices();
        Matriz phi0 = CalculadoraMatrices.productoTensorial(cero, uno);
        phi0 = CalculadoraMatrices.productoTensorial(phi0, cero);
        Matriz HH = CalculadoraMatrices.productoTensorial(hadamart, hadamart);
        Matriz HHH = CalculadoraMatrices.productoTensorial(HH, hadamart);
        Matriz phi1 = CalculadoraMatrices.matrizPorMatriz(HHH, phi0);
        Matriz HHI = CalculadoraMatrices.productoTensorial(HH, CalculadoraMatrices.identidad(hadamart));
        Matriz phi2 = CalculadoraMatrices.matrizPorMatriz(prueba, phi1);
        Matriz phi3 = CalculadoraMatrices.matrizPorMatriz(HHI, phi2);
        return CalculadoraMatrices.moduloAlCuadrado(phi3);
    }

}

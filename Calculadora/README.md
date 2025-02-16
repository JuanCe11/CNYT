# CNYT 
## Autor: Juan Sebastian Gómez López
En este repositorio se encuentran librerias para diversas operaciones cuanticas.

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/168232d62aef43e583b2ee12403cf4a7)](https://www.codacy.com/manual/JuanCe28/CNYT?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=JuanCe28/CNYT&amp;utm_campaign=Badge_Grade)

## Laboratorio 1 
Para este laboratorio se pedia realizar las siguientes funciones:
1. Suma
2. Producto
3. Resta
4. División
5. Módulo
6. Conjugado
7. Conversión entre representaciones polar y cartesiano
8. Retornar la fase de un número complejo.

Para darle solucion a estos problemas se utilizo el lenguaje de programacion de java. La solución de estos puntos se encuentran en los archivos Calculadora.java y Complejo.java. Las pruebas de esta parte estan en el archivo NumerosComplejosTest.java.

## Laboratorio 2
Para este laboratorio se pedia realizar las siguientes funciones:
1. Adición de vectores complejos.
2. Inversa de vectores complejos.
3. Multiplicación escalar de vectores complejos.
4. Adición de matrices complejos.
5. Inversa de matrices complejos.
6. Multiplicación escalar de matrices complejas.
7. Matriz transpuesta
8. Matriz conjugada
9. Matriz adjunta
10. Función para calcular la "acción" de una matriz sobre un vector.
11. Norma de matrices
12. Distancia entrematrices
13. Revisar si es unitaria
14. Revisar si es Hermitian
15. Producto tensor.

La solución a estos puntos se encuentra en el archivo CalculadoraMatrices.java, y esta utiliza la clase Matriz.java para la solucion de los problemas. Las pruebas de esta parte estan en el archivo MatricesTest.java y TestProfesor.java

## Laboratorio 3
Para este laboratorio se pedia realizar las siguientes funciones:
1. Los experimentos de la canicas con coeficiente booleanos
2. Experimentos de las múltiples rendijas clásico probabilístico, con más de dos rendijas.
3. Experimento de las múltiples rendijas cuántico.

La solución a estos puntos se encuentra en el archivo CalculadoraDinamica.java y utiliza la clase Respuesta.java para dar algunas respuestas especificas. Las pruebas de esta parte estan en el archivo DinamicaTest.java y ProyectoTest.java. Adicional hay pruebas graficas de los sistemas en el paquete test.graficas en las clases: Clasica.java, Probabilisitico.java y Rendijas.java

## Laboratorio 4
Para este laboratorio se pedia realizar las siguientes funciones:
1. Sistema de la posición de la partícula en una recta. Usuario especifica el número de puntos posibles y un vector ket y el sistema calcula las probabilidades de encontrar partícula en una posición. El sistema puede recibir dos vectores y calcular la probabilidad de transitar de el uno al otro después de hacer la observación
2. Ahora con una matriz que describa un observable y un vector ket, el sistema revisa que la matriz sea hermitiana, y si lo es, calcula la media y la varianza del observable en el estado dado.
3. El sistema calcula los valores propios del observable y la probabilidad de que el sistema transite a alguno de los vectores propios después de la observación.

La solución a estos puntos se encuentra en el archivo CalculadoraCuantica.java. Las pruebas de esta parte estan en el archivo TeoriaCuanticaTest.java.

## Esfera de Bloch
1. Ejercicio de calentamiento. Grafique una esfera que representará el planeta Tierra. Grafique como puntos sobre la esfera cada una de las ciudades dadas, asegúrese de crear también una etiqueta con el nombre de la ciudad. Expanda la lista con 5 ciudades de su elección.
2. Ejercicio la esfera de Bloch. Grafique una esfera. Use su función ket_a_Bloch para graficar como flechas cada uno de los siguientes kets básicos: 
|0>, |1>, |in>,|out>,|+>,|->

La solución a estos puntos se encuentra en el archivo Esfera de bloch.ipynb. Las pruebas de esta parte estan en el archivo TeoriaCuanticaTest.java.

## Implementación de Algoritmo de Deutsch y Deutsch-Jozsa

Las simulaciones a estos puntos se encuentran en el archivo Deutsch.java, DeutschJozsa.java la parte grafica esta en SimulacionDeutsch.java y SimulacionDeutschJozsa.java. Los test de estas simulaciones esatn en el archivo DeutschTest.java y DeutschJozsaTest.java.  
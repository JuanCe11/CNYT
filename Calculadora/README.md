# Laboratorio 1 
Para este laboratorio se pedia realizar las siguientes funciones:
1. Suma
2. Producto
3. Resta
4. División
5. Módulo
6. Conjugado
7. Conversión entre representaciones polar y cartesiano
8. Retornar la fase de un número complejo.\


Para darle solucion a estos problemas se utilizo el lenguaje de programacion de java. A continuación se muestra como utilizar la solucion.
```
import Calculadora;
import Complejo;
```
En el archivo CalculadoraTest.java se muestran las pruebas realizadas al programa. 
### Punto 1. Suma
Para el punto 1 se resuelve en los metodos de suma de la clase Calculadora.
```
public Complejo suma(int[] complejo1, int[] complejo2){
	Complejo c1 = new Complejo(complejo1[0],complejo1[1]);
	Complejo c2 = new Complejo(complejo2[0],complejo2[1]);
	Complejo res = new Complejo(c1.getReal() + c2.getReal(), c1.getImaginaria() + c2.getImaginaria());
	return res;
}
```
En este metodo entran dos vectores con la parte real e imaginara y se crean los dos numeros complejos en la clase Complejo y se devuelve un numero Complejo con la respuesta. Para este metodo tambien se pueden ingresar dos objetos de la clase Complejo.
### Punto 2. Resta
El punto 2 se resuelve en los metodos de resta de la clase Calculadora.
```
public Complejo resta(int[] complejo1, int[] complejo2){
	Complejo c1 = new Complejo(complejo1[0],complejo1[1]);
	Complejo c2 = new Complejo(complejo2[0],complejo2[1]);
	Complejo res = new Complejo(c1.getReal() - c2.getReal(), c1.getImaginaria() - c2.getImaginaria());
	return res;	
}
```
Este metodo es practicamente igual al de la suma.
### Punto 3. multiplicacion
Se resuelve en los metodos de multiplicacion de la clase Calculadora.
```
public Complejo multiplicacion(int[] complejo1, int[] complejo2){
	Complejo c1 = new Complejo(complejo1[0],complejo1[1]);
	Complejo c2 = new Complejo(complejo2[0],complejo2[1]);
	double real = (c1.getReal() * c2.getReal()) + (-1 * c1.getImaginaria() * c2.getImaginaria());
	double imaginaria = (c1.getReal() * c2.getImaginaria()) + (c1.getImaginaria() * c2.getReal());
	Complejo res = new Complejo(real, imaginaria);
	return res;	
}
```
Para la solución se realiza la simulación de la multiplicación de polinomios para el coeficiente de la parte real (se encuentra en la variable real) y el coeficiente de la parte imaginaria (variable imaginaria).
### Punto 4. división
Se resuelve en los metodos de division de la clase Calculadora.
```
public Complejo division(int[] complejo1, int[] complejo2) {
	Complejo c1 = new Complejo(complejo1[0],complejo1[1]);
	Complejo c2 = new Complejo(complejo2[0],complejo2[1]);
	Complejo c3 = c2.conjugado();
	Complejo numerador = multiplicacion(c1,c3);
	double modulo = Math.pow(c2.getReal(), 2) + Math.pow(c2.getImaginaria(), 2);
	double real =  (numerador.getReal() / modulo);
	double imaginaria =  (numerador.getImaginaria() / modulo);
	Complejo res = new Complejo(real, imaginaria);
	return res;
}
```
Para la solución se realiza la simulación de multiplicar los números por el conjugado del denominador y se calcula el coeficiente de la parte real (se encuentra en la variable real) y el coeficiente de la parte imaginaria (variable imaginaria).
### Punto 5. Modulo
Se resuelve en los metodos de modulo de la clase Calculadora.
```
public double modulo(int[] com1){
	Complejo c1 = new Complejo(com1[0],com1[1]);
	return c1.getModulo();
}
```
Se puede hallar el resultado accediendo al metodo en calculadora pero el cálculo se realiza en la clase Complejo de la siguiente manera:
```
public void setModulo() {
	this.modulo = Math.sqrt(Math.pow(real, 2) + Math.pow(imaginaria, 2));		
}
```
En el cual se mira calcula la raiz de la suma de la parte real y la parte imaginaria al cuadrado.
### Punto 6. Conjugado
Se resuelve en los metodos de conjugado de la clase Calculadora.
```
public Complejo conjugado(Complejo c1){
	return c1.conjugado();
}
```
Se puede hallar el resultado accediendo al metodo en calculadora pero el cálculo se realiza en la clase Complejo de la siguiente manera:
```
public Complejo conjugado() {
	return new Complejo(real,imaginaria*-1);
}
```
En el cual se devuelve un nuevo complejo con la parte imaginara del signo contrario.
### Punto 7. Conversiones
Se resuelve en los metodos de recPol de la clase Calculadora.
```
public double[] recPol(int[] com1) {
	Complejo c1 = new Complejo(com1[0],com1[1]);
	double [] pol = new double[2];
	pol[0] =  c1.getModulo();
	pol[1] = c1.getFase();
	return pol;
}
```
En el cual se crea el numero complejo usando la representacion rectangular y devuelve un vector con los valores del modulo y la fase del número.\
El proceso inverso se realiza en los metodos polRec de la clase Calculadora.
```
public double[] polRec(int[] com1) {
	Complejo c1 = new Complejo(com1[0],com1[1],0);
	double [] rec = new double[2];
	rec[0] =  c1.getReal();
	rec[1] = c1.getImaginaria();	
	return rec;
}
```
### Punto 8. Retornar la fase
Se resuelve en los metodos de fase de la clase Calculadora.
```
public double fase(int[] com1) {
	Complejo c1 = new Complejo(com1[0],com1[1]);
	double fase;
	fase = c1.getFase();
	return fase;
}
```
En el cual se crea el numero complejo usando la representacion rectangular y devuelve la fase del mismo. Sin embargo el cálculo de la fase se realiza en la clase Complejo en el metodo setFase.
```
private void setFase() {
	fase = (double) Math.toDegrees(Math.atan(imaginaria/real));
	if(real<0 && imaginaria<0 || real<0 && imaginaria>0) {
		fase+=180;
	}else if (real>0 && imaginaria<0) {
		fase+=360;
	}
}
```
Se calcula la fase con la tangente y se evalua en qué cuadrante se encuentra para hacer la corrección.

package frgp.utn.edu.ar.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import frgp.utn.edu.ar.main.MatrizAdyacencia;

class MatrizAdyacenciaTest {

	private MatrizAdyacencia mat= new MatrizAdyacencia(2);
	
	@Test
	public void agregarElementoTest() {
		int X=1;
		int Y=1;
		mat.agregarElemento(X, Y);
		assertTrue(mat.existeElemento(X, Y),"Existe dentro de la matriz");
	}
	
	@Test
	public void agregarElementoSimetriaTest() {
		int X=0;
		int Y=1;
		mat.agregarElemento(X, Y);
		assertEquals(true,mat.existeElemento(Y, X));
	}
	
	@Test
	public void eliminarElementoTest() {
		int X=0;
		int Y=1;
		mat.eliminarElemento(X, Y);
		assertFalse(mat.existeElemento(X, Y));
	}
	
	@Test
	public void eliminarElementoSimetricoTest() {
		int X=0;
		int Y=1;
		mat.eliminarElemento(X, Y);
		assertFalse(mat.existeElemento(Y, X));
	}
	
	@Test
	public void contarRelacionesTest() {
		//Este test estaba mal porque no se le habia agregado ningun elemento a la matriz
		int X=0;
		int Y=1;
		mat.agregarElemento(X, Y);
		//Despues de agregar un elemento, se pregunta cuantos hay, y se compara con 1 (Elemento)
		assertEquals(mat.getCantidadElementos(),1);
	}
	
	
	//Hay que revisar esta funcion, solo se le agrega un elemento, y solo se chequea ese elemento
	//Corregido, chequeenlo por las dudas.
	@Test
	public void  existenTodosLosElementoTest() {
		int X=0;
		int Y=1;
		//acá agregue la 2da posicion que falta ya que la simetrica se agrega sola y nuestra matriz es 2x2
		int X2=0;
		int Y2=0;
		int cantidad=0;
		mat.agregarElemento(X, Y);
		mat.agregarElemento(X2, Y2);

		cantidad=mat.getCantidadElementos();
		for( int i=0; i<cantidad-1; i++)
		{
			for(int j=0; j<=cantidad-1; j++)
			{
				//A la funcion existe le pasamos la posicion del doble for que es la posicion en la que esta recorriendo la matriz
				assertFalse(mat.existeElemento(i, j)); 
			}
		}
	}
	
	@Test
	public void agregarElementoFilaNegativaTest() {
		int X=-1;
		int Y=1;
		//Se cambia el try catch por un assertion
		Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			mat.agregarElemento(X, Y);});
	
	}

	
	@Test
	public void agregarElementoColumnaNegativaTest(){
		int X=1;
		int Y=-2;
		
		//Se cambia el try catch por un assertion
		Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			mat.agregarElemento(X, Y);});
		};
		
	
	
	@Test
	public void agregarElementoFueraRangoTest() {
		int Y=3;
		boolean error = false;
		
		try {
			if (Y>1 || Y<0) throw new ArrayIndexOutOfBoundsException();
		} catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			error = true;
		}
		assertTrue(error);
	}
	
	
}

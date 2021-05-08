package frgp.utn.edu.ar.test;

import static org.junit.jupiter.api.Assertions.*;

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
		//mat.agregarElemento(Y, X); Esta linea no va, pide que se verifique si se agrego tambien en su posicion opuesta, no hay que volver a agregarlo
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
	@Test
	public void  existenTodosLosElementoTest() {
		int X=0;
		int Y=1;
		int cantidad=0;
		mat.agregarElemento(X, Y);
		cantidad=mat.getCantidadElementos();
		for( int i=0; i<cantidad-1; i++)
		{
			for(int j=0; j<=cantidad-1; j++)
			{
				assertFalse(mat.existeElemento(Y, X)); 
			}
		}
	}
	
	@Test
	public void agregarElementoFilaNegativaTest() {
		int X=-1;
		int Y=1;
		boolean error = false;
		
		try {
			mat.agregarElemento(X, Y);
		} catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			error = true;
		}
		assertTrue(error);
	}

	
	@Test
	public void agregarElementoColumnaNegativaTest() {
		int X=1;
		int Y=-2;
		boolean error = false;
		
		try {
			mat.agregarElemento(X, Y);
		} catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			error = true;
		}
		assertTrue(error);
	}
	
	/*
	@Test
	public void agregarElementoFueraRangoTest() {
		
	}
	*/
	
}

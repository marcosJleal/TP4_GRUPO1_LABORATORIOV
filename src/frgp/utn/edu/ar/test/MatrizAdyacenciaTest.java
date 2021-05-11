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
	
		int X=0;
		int Y=1;
		mat.agregarElemento(X, Y);
	
		assertEquals(mat.getCantidadElementos(),1);
	}
	
	
	
	@Test
	public void  existenTodosLosElementoTest() {
		int X=0;
		int Y=1;
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
				
				assertFalse(mat.existeElemento(i, j)); 
			}
		}
	}
	
	@Test
	public void agregarElementoFilaNegativaTest() {
		int X=-1;
		int Y=1;
	
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
	        int i=4,j=2;
	        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
	            mat.agregarElemento(i, j);
	          });
	    }
	
	
}

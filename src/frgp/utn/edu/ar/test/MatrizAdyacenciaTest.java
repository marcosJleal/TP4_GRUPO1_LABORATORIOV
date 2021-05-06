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
		mat.agregarElemento(Y, X);
		assertEquals(true,mat.existeElemento(Y, X));
	}
}

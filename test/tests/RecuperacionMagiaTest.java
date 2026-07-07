package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelos.Auror;

class RecuperacionMagiaTest {

	@Test
	public void recuperarMagiaIncrementaElNivel() {

		Auror auror = new Auror();
		auror.gastoPuntosMagia(80);
		double antes = auror.obtenerNivelMagia();
		auror.recuperarMagia();
		assertTrue(auror.obtenerNivelMagia() > antes);
	}

	@Test
	public void recuperarMagiaNoSuperaElMaximo() {

		Auror auror = new Auror();
		auror.recuperarMagia();
		assertEquals(100, auror.obtenerNivelMagia(), 0.01);
	}
}

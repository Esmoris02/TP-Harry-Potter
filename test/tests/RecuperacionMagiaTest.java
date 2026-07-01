package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelos.Auror;

class RecuperacionMagiaTest {

	@Test
	public void recuperarMagiaIncrementaElNivel() {

		Auror auror = new Auror();
		auror.gastoNivelMagia(80);
		double antes = auror.obtenerNivelMagia();
		auror.recuperarMana();
		assertTrue(auror.obtenerNivelMagia() > antes);
	}

	@Test
	public void recuperarMagiaNoSuperaElMaximo() {

		Auror auror = new Auror();
		auror.recuperarMana();
		assertEquals(100, auror.obtenerNivelMagia(), 0.01);
	}
}

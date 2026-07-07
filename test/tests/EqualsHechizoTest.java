package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import hechizos.Expelliarmus;
import hechizos.Protego;

//Valida el correcto funcionamiento de equals() y hashCode()
public class EqualsHechizoTest {

	@Test
	public void dosHechizosDelMismoTipoSonIguales() {

		Expelliarmus h1 = new Expelliarmus();
		Expelliarmus h2 = new Expelliarmus();

		assertEquals(h1, h2);

	}

	@Test
	public void dosHechizosDistintosNoSonIguales() {

		Expelliarmus h1 = new Expelliarmus();
		Protego h2 = new Protego();

		assertNotEquals(h1, h2);

	}

	@Test
	public void dosHechizosIgualesTienenElMismoHashCode() {

		Expelliarmus h1 = new Expelliarmus();
		Expelliarmus h2 = new Expelliarmus();

		assertEquals(h1.hashCode(), h2.hashCode());

	}

}
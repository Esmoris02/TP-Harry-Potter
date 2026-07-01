package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import hechizos.ExpectoPatronum;
import hechizos.Expelliarmus;
import hechizos.Protego;
import modelos.Auror;
import modelos.Comandante;

class HechizoTest {

	  @Test
	    public void expectoPatronumCura() {

	        Auror auror = new Auror();
	        auror.reducirVida(50);
	        double antes = auror.obtenerPuntosVida();
	        new ExpectoPatronum().ejecutar(auror, auror);
	        auror.aplicarEfectos(auror.efectosAAplicar);
	        assertTrue(auror.obtenerPuntosVida() > antes);
	    }
	  
	  @Test
	    public void expelliarmusProduceDaño() {

	        Auror auror = new Auror();
	        Comandante enemigo = new Comandante();
	        double vidaInicial = enemigo.obtenerPuntosVida();
	        new Expelliarmus().ejecutar(auror, enemigo);
	        enemigo.aplicarEfectos(enemigo.efectosAAplicar);
	        assertTrue(enemigo.obtenerPuntosVida() < vidaInicial);
	    }
	  
	  @Test
	    public void protegoGeneraEscudo() {
	        Auror auror = new Auror();
	        new Protego().ejecutar(auror, auror);
	        auror.aplicarEfectos(auror.efectosAAplicar);
	        assertTrue(auror.obtenerNivelProteccion() > 0);
	    }

}

package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import efectos.Aturdimiento;
import efectos.Curacion;
import efectos.Daño;
import efectos.Proteccion;
import modelos.Auror;

class EfectoTest {
	
	@Test
    public void aplicarAturdimientoMarcaAlPersonaje() {

        Auror auror = new Auror();
        new Aturdimiento().aplicar(auror);
        assertTrue(auror.estaAturtido());
    }

	@Test
    public void unaCuracionRecuperaVida() {

        Auror auror = new Auror();
        auror.reducirVida(40);
        double vida = auror.obtenerPuntosVida();
        new Curacion(20).aplicar(auror);
        assertEquals(vida + 20, auror.obtenerPuntosVida(), 0.01);
    }

    @Test
    public void unaCuracionNoSuperaLaVidaMaxima() {

        Auror auror = new Auror();
        new Curacion(500).aplicar(auror);
        assertEquals(150, auror.obtenerPuntosVida(),0.01);
    }
    
    @Test
    public void aplicarDanioReduceLaVida() {

        Auror auror = new Auror();
        double vidaInicial = auror.obtenerPuntosVida();
        new Daño(20).aplicar(auror);
        assertEquals(vidaInicial - 20, auror.obtenerPuntosVida(), 0.01);
    }
    
    @Test
    public void aplicarProteccionAsignaEscudo() {

        Auror auror = new Auror();
        new Proteccion(50).aplicar(auror);
        assertEquals(50, auror.obtenerNivelProteccion(),0.01);
    }

}

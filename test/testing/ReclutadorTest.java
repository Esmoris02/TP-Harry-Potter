package testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fabricas.Reclutador;
import hechizos.AvadaKedabra;
import hechizos.Confringo;
import hechizos.ExpectoPatronum;
import hechizos.Expelliarmus;
import hechizos.Hechizo;
import hechizos.Protego;
import modelos.Auror;
import modelos.Comandante;
import modelos.Estudiante;
import modelos.Mago;
import modelos.Mortifago;
import modelos.Profesor;
import modelos.Seguidor;

public class ReclutadorTest {
    
    // TEST 1: Verificar que siempre crea un Mago (no importa el tipo)
    @Test
    public void testCrearMagoSiempreDevuelveMago() {
        for (int i = 0; i < 50; i++) {
            Mago mago = Reclutador.crearMago();
            assertNotNull(mago);
            assertTrue(mago instanceof Mago);
            assertTrue(mago.estaSaludable());
            assertTrue(mago.getPuntosVida() > 0);
        }
    }
    
    // TEST 2: Verificar que siempre crea un Mortifago
    @Test
    public void testCrearMortifagoSiempreDevuelveMortifago() {
        for (int i = 0; i < 50; i++) {
            Mortifago mortifago = Reclutador.crearMortifago();
            assertNotNull(mortifago);
            assertTrue(mortifago instanceof Mortifago);
            assertTrue(mortifago.estaSaludable());
            assertTrue(mortifago.getPuntosVida() > 0);
        }
    }
    
    // TEST 3: Verificar que la fábrica crea diferentes tipos de Magos
    @Test
    public void testCrearMagoVariedadDeTipos() {
        boolean tieneAuror = false;
        boolean tieneProfesor = false;
        boolean tieneEstudiante = false;
        
        // Probamos muchas veces para asegurar variedad
        for (int i = 0; i < 100; i++) {
            Mago mago = Reclutador.crearMago();
            
            if (mago instanceof Auror) tieneAuror = true;
            else if (mago instanceof Profesor) tieneProfesor = true;
            else if (mago instanceof Estudiante) tieneEstudiante = true;
            
            // Si ya vimos todos, podemos salir temprano
            if (tieneAuror && tieneProfesor && tieneEstudiante) {
                break;
            }
        }
        
        assertTrue(tieneAuror);
        assertTrue(tieneProfesor);
        assertTrue(tieneEstudiante);
    }
    
    // TEST 4: Verificar que la fábrica crea diferentes tipos de Mortifagos
    @Test
    public void testCrearMortifagoVariedadDeTipos() {
        boolean tieneComandante = false;
        boolean tieneSeguidor = false;
        
        for (int i = 0; i < 50; i++) {
            Mortifago mortifago = Reclutador.crearMortifago();
            
            if (mortifago instanceof Comandante) tieneComandante = true;
            else if (mortifago instanceof Seguidor) tieneSeguidor = true;
            
            if (tieneComandante && tieneSeguidor) {
                break;
            }
        }
        
        assertTrue(tieneComandante);
        assertTrue(tieneSeguidor);
    }
    
    // TEST 5: Verificar que los Magos creados tienen hechizos
    @Test
    public void testMagoCreadoTieneHechizos() {
        Mago mago = Reclutador.crearMago();
        
        // Un mago debe tener al menos 3 hechizos (ataque, defensa, curación)
        assertTrue(mago.hechizosDisponibles.size() >= 3);
        
        // Verificar que tiene los tipos correctos de hechizos
        boolean tieneAtaque = false;
        boolean tieneDefensa = false;
        boolean tieneCuracion = false;
        
        for (Hechizo h : mago.hechizosDisponibles) {
            if (h instanceof Expelliarmus) tieneAtaque = true;
            else if (h instanceof Protego) tieneDefensa = true;
            else if (h instanceof ExpectoPatronum) tieneCuracion = true;
        }
        
        assertTrue(tieneAtaque);
        assertTrue(tieneDefensa);
        assertTrue(tieneCuracion);
    }
    
    // TEST 6: Verificar que los Mortifagos creados tienen hechizos
    @Test
    public void testMortifagoCreadoTieneHechizos() {
        Mortifago mortifago = Reclutador.crearMortifago();
        
        // Un mortifago debe tener al menos 2 hechizos (oscuro, defensa)
        assertTrue(mortifago.hechizosDisponibles.size() >= 2);
        
        boolean tieneOscuro = false;
        boolean tieneDefensa = false;
        
        for (Hechizo h : mortifago.hechizosDisponibles) {
            if (h instanceof AvadaKedabra || h instanceof Confringo) {
                tieneOscuro = true;
            } else if (h instanceof Protego) {
                tieneDefensa = true;
            }
        }
        
        assertTrue(tieneOscuro);
        assertTrue(tieneDefensa);
    }
    
    // TEST 7: Verificar que todos los personajes tienen nombre
    @Test
    public void testTodosLosPersonajesTienenNombre() {
        Mago mago = Reclutador.crearMago();
        Mortifago mortifago = Reclutador.crearMortifago();
        
        assertNotNull(mago.getNombre());
        assertFalse(mago.getNombre().isEmpty());
        assertNotNull(mortifago.getNombre());
        assertFalse(mortifago.getNombre().isEmpty());
    }
    
    // TEST 8: Verificar que todos los personajes tienen nivel de magia positivo
    @Test
    public void testTodosLosPersonajesTienenNivelMagiaPositivo() {
        Mago mago = Reclutador.crearMago();
        Mortifago mortifago = Reclutador.crearMortifago();
        
        assertTrue(mago.getNivelMagia() > 0);
        assertTrue(mortifago.getNivelMagia() > 0);
    }

}
package testing;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fabricas.Reclutador;
import hechizos.AvadaKedabra;
import hechizos.Confringo;
import hechizos.ExpectoPatronum;
import hechizos.Expelliarmus;
import hechizos.Hechizo;
import hechizos.Protego;
import modelos.Mago;
import modelos.Mortifago;

class ReclutadorHechizosTest {

	// TEST 1: Un Mago NO debe tener hechizos oscuros
    @Test
    public void testMagoNoTieneHechizosOscuros() {
        for (int i = 0; i < 30; i++) {
            Mago mago = Reclutador.crearMago();
            
            for (Hechizo h : mago.hechizosDisponibles) {
                // Verificar que no sea oscuro
                assertFalse("Un mago no debe tener AvadaKedabra", h instanceof AvadaKedabra);
                assertFalse("Un mago no debe tener Confringo", h instanceof Confringo);
            }
        }
    }
    // TEST 2: Un Mortifago NO debe tener hechizos de curación
    @Test
    public void testMortifagoNoTieneHechizosCuracion() {
        for (int i = 0; i < 30; i++) {
            Mortifago mortifago = Reclutador.crearMortifago();
            
            for (Hechizo h : mortifago.hechizosDisponibles) {
                // Verificar que no sea de curación
                assertFalse("Un mortifago no debe tener ExpectoPatronum", h instanceof ExpectoPatronum);
            }
        }
    }
 // TEST 3: Un Mago DEBE tener hechizos de ataque, defensa y curación
    @Test
    public void testMagoTieneHechizosCorrectos() {
        for (int i = 0; i < 20; i++) {
            Mago mago = Reclutador.crearMago();
            
            boolean tieneAtaque = false;
            boolean tieneDefensa = false;
            boolean tieneCuracion = false;
            boolean tieneOscuro = false;
            
            for (Hechizo h : mago.hechizosDisponibles) {
                if (h instanceof Expelliarmus) tieneAtaque = true;
                else if (h instanceof Protego) tieneDefensa = true;
                else if (h instanceof ExpectoPatronum) tieneCuracion = true;
                else if (h instanceof AvadaKedabra || h instanceof Confringo) tieneOscuro = true;
            }
            
            assertTrue("El mago debe tener hechizo de ataque (Expelliarmus)", tieneAtaque);
            assertTrue("El mago debe tener hechizo de defensa (Protego)", tieneDefensa);
            assertTrue("El mago debe tener hechizo de curación (ExpectoPatronum)", tieneCuracion);
            assertFalse("El mago NO debe tener hechizos oscuros", tieneOscuro);
        }
    }
    // TEST 4: Un Mortifago DEBE tener hechizos oscuros y defensa, pero NO curación
    @Test
    public void testMortifagoTieneHechizosCorrectos() {
        for (int i = 0; i < 20; i++) {
            Mortifago mortifago = Reclutador.crearMortifago();
            
            boolean tieneOscuro = false;
            boolean tieneDefensa = false;
            boolean tieneCuracion = false;
            boolean tieneAtaque = false;
            
            for (Hechizo h : mortifago.hechizosDisponibles) {
                if (h instanceof AvadaKedabra || h instanceof Confringo) tieneOscuro = true;
                else if (h instanceof Protego) tieneDefensa = true;
                else if (h instanceof ExpectoPatronum) tieneCuracion = true;
                else if (h instanceof Expelliarmus) tieneAtaque = true;
            }
            
            assertTrue("El mortifago debe tener hechizo oscuro (AvadaKedabra o Confringo)", tieneOscuro);
            assertTrue("El mortifago debe tener hechizo de defensa (Protego)", tieneDefensa);
            assertFalse("El mortifago NO debe tener hechizo de curación (ExpectoPatronum)", tieneCuracion);
            assertFalse("El mortifago NO debe tener hechizo de ataque (Expelliarmus)", tieneAtaque);
        }
    }
}

package testing;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fabricas.FabricaHechizos;
import hechizos.AvadaKedabra;
import hechizos.Confringo;
import hechizos.ExpectoPatronum;
import hechizos.Expelliarmus;
import hechizos.Hechizo;
import hechizos.Protego;

class FabricaHechizosTest {

	// TEST 1: Crear hechizo de ataque
    @Test
    public void testCrearHechizoAtaque() {
        Hechizo hechizo = FabricaHechizos.crearHechizoPorTipo("ataque");
        
        assertNotNull(hechizo);
        assertTrue(hechizo instanceof Expelliarmus);
        assertEquals("Expelliarmus", hechizo.getNombre());
        assertEquals(10, hechizo.getCoste(), 0.001);
    }
 // TEST 2: Crear hechizo de defensa
    @Test
    public void testCrearHechizoDefensa() {
        Hechizo hechizo = FabricaHechizos.crearHechizoPorTipo("defensa");
        
        assertNotNull(hechizo);
        assertTrue(hechizo instanceof Protego);
        assertEquals("Protego", hechizo.getNombre());
        assertEquals(25, hechizo.getCoste(), 0.001);
    }
 // TEST 3: Crear hechizo de curación
    @Test
    public void testCrearHechizoCuracion() {
        Hechizo hechizo = FabricaHechizos.crearHechizoPorTipo("curacion");
        
        assertNotNull(hechizo);
        assertTrue(hechizo instanceof ExpectoPatronum);
        assertEquals("ExpectoPatronum", hechizo.getNombre());
        assertEquals(15, hechizo.getCoste(), 0.001);
    }
 // TEST 4: Crear hechizo oscuro - debe devolver Confringo o AvadaKedabra
    @Test
    public void testCrearHechizoOscuro() {
        Hechizo hechizo = FabricaHechizos.crearHechizoPorTipo("oscuro");
        
        assertNotNull(hechizo);
        // Debe ser Confringo o AvadaKedabra
        assertTrue(hechizo instanceof Confringo || hechizo instanceof AvadaKedabra);
    }
 // TEST 5: Verificar que el hechizo oscuro a veces es Confringo
    @Test
    public void testHechizoOscuroPuedeSerConfringo() {
        boolean encontradoConfringo = false;
        
        // Probamos varias veces porque es aleatorio
        for (int i = 0; i < 30; i++) {
            Hechizo hechizo = FabricaHechizos.crearHechizoPorTipo("oscuro");
            
            if (hechizo instanceof Confringo) {
                encontradoConfringo = true;
                assertEquals("Confringo", hechizo.getNombre());
                assertEquals(25, hechizo.getCoste(), 0.001);
                break;
            }
        }
        assertTrue("Debería crear Confringo al menos una vez", encontradoConfringo);
    }
    
    // TEST 6: Verificar que el hechizo oscuro a veces es AvadaKedabra
    @Test
    public void testHechizoOscuroPuedeSerAvadaKedabra() {
        boolean encontradoAvada = false;
        
        // Probamos varias veces porque es aleatorio
        for (int i = 0; i < 30; i++) {
            Hechizo hechizo = FabricaHechizos.crearHechizoPorTipo("oscuro");
            
            if (hechizo instanceof AvadaKedabra) {
                encontradoAvada = true;
                assertEquals("AvadaKedabra", hechizo.getNombre());
                assertEquals(75, hechizo.getCoste(), 0.001);
                break;
            }
        }
        
        assertTrue("Debería crear AvadaKedabra al menos una vez", encontradoAvada);
    }
    
}

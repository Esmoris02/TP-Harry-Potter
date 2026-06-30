package testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fabricas.Reclutador;
import modelos.Batallon;
import modelos.Mago;
import modelos.Mortifago;
import modelos.Personaje;


public class BatallonTest {
    
    private Batallon batallon;
    private Batallon enemigo;
    private Personaje mago;
    private Personaje mortifago;
    
    @Before
    public void setUp() {
        batallon = new Batallon();
        enemigo = new Batallon();
        mago = Reclutador.crearMago();
        mortifago = Reclutador.crearMortifago();
    }
    
    // TEST 1: Agregar personaje al batallón
    @Test
    public void testAgregarPersonaje() {
        batallon.agregarPersonaje(mago);
        assertTrue(batallon.tienePersonajesSaludables());
    }
    
    // TEST 2: Batallón vacío no tiene personajes saludables
    @Test
    public void testBatallonVacio() {
        assertFalse(batallon.tienePersonajesSaludables());
        assertNull(batallon.obtenerPersonajeSaludable());
        assertNull(batallon.obtenerPersonajeSaludableAleatorio());
    }
    
    // TEST 3: Obtener personaje saludable cuando hay varios
    @Test
    public void testObtenerPersonajeSaludable() {
        batallon.agregarPersonaje(mago);
        batallon.agregarPersonaje(mortifago);
        
        Personaje saludable = batallon.obtenerPersonajeSaludable();
        assertNotNull(saludable);
        assertTrue(saludable.estaSaludable());
    }
    
    // TEST 4: Obtener personaje saludable aleatorio
    @Test
    public void testObtenerPersonajeSaludableAleatorio() {
        for (int i = 0; i < 10; i++) {
            batallon.agregarPersonaje(Reclutador.crearMago());
        }
        
        Personaje aleatorio = batallon.obtenerPersonajeSaludableAleatorio();
        assertNotNull(aleatorio);
        assertTrue(aleatorio.estaSaludable());
    }
    
    // TEST 5: Un batallón ataca a otro
    @Test
    public void testBatallonAtaca() {
        batallon.agregarPersonaje(mago);
        enemigo.agregarPersonaje(mortifago);
        
        double vidaInicial = mortifago.getPuntosVida();
        batallon.atacar(enemigo);
        
        // El enemigo debería haber recibido daño (si el mago tiene hechizos)
        assertTrue(mortifago.getPuntosVida() <= vidaInicial);
    }
    
    // TEST 6: Batallón con personajes muertos
    @Test
    public void testBatallonConPersonajesMuertos() {
        Personaje personaje = Reclutador.crearMago();
        personaje.recibirDanio(1000); // Lo matamos
        batallon.agregarPersonaje(personaje);
        
        assertFalse(batallon.tienePersonajesSaludables());
        assertNull(batallon.obtenerPersonajeSaludable());
    }
    
    // TEST 7: Historial de hechizos se registra correctamente

}
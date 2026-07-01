package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fabricas.Reclutador;
import modelos.Batallon;
import modelos.Personaje;

class BatallonTest {

	private Batallon batallon = new Batallon();
    private Batallon enemigo = new Batallon();

    @Test
    public void unBatallonVacioNoTienePersonajesSaludables() {
        assertFalse(batallon.tienePersonajesSaludables());
    }

    @Test
    public void agregarPersonajeHaceQueElBatallonTengaPersonajesSaludables() {
        batallon.agregarPersonaje(Reclutador.crearMago());
        assertTrue(batallon.tienePersonajesSaludables());
    }

    @Test
    public void atacarABatallonVacioNoProduceErrores() {

        batallon.agregarPersonaje(Reclutador.crearMago());
        batallon.atacar(enemigo);
        assertTrue(true);
    }

    @Test
    public void unPersonajeMuertoNoCuentaComoSaludable() {

        Personaje p = Reclutador.crearMago();
        p.reducirVida(10000);
        batallon.agregarPersonaje(p);
        assertFalse(batallon.tienePersonajesSaludables());
    }

}

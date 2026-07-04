package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import modelos.Auror;

public class ProteccionTest {

    @Test
    public void unEscudoAbsorbeTodoElDanio() {

        Auror auror = new Auror();

        auror.aplicarProteccion(50);

        double vidaInicial = auror.obtenerPuntosVida();

        auror.reducirVida(20);

        // La vida no debe cambiar
        assertEquals(vidaInicial, auror.obtenerPuntosVida(), 0.01);

        // El escudo debe reducirse a 30
        assertEquals(30, auror.obtenerNivelProteccion(), 0.01);
    }

    @Test
    public void unEscudoSeRompeSiElDanioEsMayor() {

        Auror auror = new Auror();

        auror.aplicarProteccion(50);

        double vidaInicial = auror.obtenerPuntosVida();

        auror.reducirVida(80);

        // Debe perder únicamente el daño que excede el escudo
        assertEquals(vidaInicial - 30, auror.obtenerPuntosVida(), 0.01);

        // El escudo debe desaparecer
        assertEquals(0, auror.obtenerNivelProteccion(), 0.01);
    }

}
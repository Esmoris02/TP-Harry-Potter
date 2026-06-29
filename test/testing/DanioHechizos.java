package testing;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import hechizos.AvadaKedabra;
import hechizos.Confringo;
import hechizos.Expelliarmus;
import modelos.Comandante;
import modelos.Estudiante;
import modelos.Mago;
import modelos.Mortifago;
import modelos.Personaje;
import modelos.Profesor;
import modelos.Seguidor;
class DanioHechizos {

 // ============ TESTS CON AVADA KEDABRA ============
    
    @Test
    public void testAvadaKedabraDanioComandanteVsEstudiante() {
        // Creamos personajes
        Comandante comandante = new Comandante("Voldemort", 100, 100);
        Estudiante estudiante = new Estudiante("Harry", 100, 100);
        
        // Creamos objetivos (mismos para ambos)
        Personaje objetivo1 = new Mago("Objetivo1", 100, 100);
        Personaje objetivo2 = new Mago("Objetivo2", 100, 100);
        
        // Crear hechizo AvadaKedabra
        AvadaKedabra avada = new AvadaKedabra();
        
        // Comandante lanza AvadaKedabra
        double vidaInicial1 = objetivo1.getPuntosVida();
        avada.ejecutar(comandante, objetivo1);
        double danioComandante = vidaInicial1 - objetivo1.getPuntosVida();
        
        // Estudiante lanza AvadaKedabra (aunque no debería tenerlo)
        double vidaInicial2 = objetivo2.getPuntosVida();
        avada.ejecutar(estudiante, objetivo2);
        double danioEstudiante = vidaInicial2 - objetivo2.getPuntosVida();
        
        System.out.println("=== AvadaKedabra ===");
        System.out.println("Comandante (multiplicador ataque oscuro: 1.6): " + danioComandante);
        System.out.println("Estudiante (multiplicador ataque oscuro: 0.2): " + danioEstudiante);
        
        // El Comandante debe pegar mucho más que el Estudiante
        assertTrue("Comandante debería pegar más que Estudiante con AvadaKedabra", 
                   danioComandante > danioEstudiante);
    }
    @Test
    public void testAvadaKedabraDanioMortifagoVsMago() {
        Mortifago mortifago = new Mortifago("Mortifago", 100, 100);
        Mago mago = new Mago("Mago", 100, 100);
        
        Personaje objetivo1 = new Mago("Objetivo1", 100, 100);
        Personaje objetivo2 = new Mago("Objetivo2", 100, 100);
        
        AvadaKedabra avada = new AvadaKedabra();
        
        double vidaInicial1 = objetivo1.getPuntosVida();
        avada.ejecutar(mortifago, objetivo1);
        double danioMortifago = vidaInicial1 - objetivo1.getPuntosVida();
        
        double vidaInicial2 = objetivo2.getPuntosVida();
        avada.ejecutar(mago, objetivo2);
        double danioMago = vidaInicial2 - objetivo2.getPuntosVida();
        
        System.out.println("Mortifago (multiplicador: 1.8): " + danioMortifago);
        System.out.println("Mago (multiplicador: 0.5): " + danioMago);
        
        assertTrue("Mortifago debería pegar más que Mago con AvadaKedabra", 
                   danioMortifago > danioMago);
    }
    
    @Test
    public void testAvadaKedabraDanioComandanteVsSeguidor() {
        Comandante comandante = new Comandante("Comandante", 100, 100);
        Seguidor seguidor = new Seguidor("Seguidor", 100, 100);
        
        Personaje objetivo1 = new Mago("Objetivo1", 100, 300);
        Personaje objetivo2 = new Mago("Objetivo2", 100, 300);
        
        AvadaKedabra avada = new AvadaKedabra();
        
        double vidaInicial1 = objetivo1.getPuntosVida();
        avada.ejecutar(comandante, objetivo1);
        double danioComandante = vidaInicial1 - objetivo1.getPuntosVida();
        
        double vidaInicial2 = objetivo2.getPuntosVida();
        avada.ejecutar(seguidor, objetivo2);
        double danioSeguidor = vidaInicial2 - objetivo2.getPuntosVida();
        
        System.out.println("Comandante (multiplicador: 1.6): " + danioComandante);
        System.out.println("Seguidor (multiplicador: 0.8): " + danioSeguidor);
        
        assertTrue("Comandante debería pegar más que Seguidor con AvadaKedabra", 
                   danioComandante > danioSeguidor);
    }
    @Test
    public void testConfringoDanioComandanteVsEstudiante() {
        Comandante comandante = new Comandante("Voldemort", 100, 100);
        Estudiante estudiante = new Estudiante("Harry", 100, 100);
        
        Personaje objetivo1 = new Mago("Objetivo1", 100, 100);
        Personaje objetivo2 = new Mago("Objetivo2", 100, 100);
        
        Confringo confringo = new Confringo();
        
        double vidaInicial1 = objetivo1.getPuntosVida();
        confringo.ejecutar(comandante, objetivo1);
        double danioComandante = vidaInicial1 - objetivo1.getPuntosVida();
        
        double vidaInicial2 = objetivo2.getPuntosVida();
        confringo.ejecutar(estudiante, objetivo2);
        double danioEstudiante = vidaInicial2 - objetivo2.getPuntosVida();
        
        System.out.println("=== Confringo ===");
        System.out.println("Comandante (multiplicador ataque oscuro: 1.6): " + danioComandante);
        System.out.println("Estudiante (multiplicador ataque oscuro: 0.2): " + danioEstudiante);
        
        assertTrue("Comandante debería pegar más que Estudiante con Confringo", 
                   danioComandante > danioEstudiante);
    }
    @Test
    public void testConfringoDanioMortifagoVsMago() {
        Mortifago mortifago = new Mortifago("Mortifago", 100, 100);
        Mago mago = new Mago("Mago", 100, 100);
        
        Personaje objetivo1 = new Mago("Objetivo1", 100, 100);
        Personaje objetivo2 = new Mago("Objetivo2", 100, 100);
        
        Confringo confringo = new Confringo();
        
        double vidaInicial1 = objetivo1.getPuntosVida();
        confringo.ejecutar(mortifago, objetivo1);
        double danioMortifago = vidaInicial1 - objetivo1.getPuntosVida();
        
        double vidaInicial2 = objetivo2.getPuntosVida();
        confringo.ejecutar(mago, objetivo2);
        double danioMago = vidaInicial2 - objetivo2.getPuntosVida();
        
        System.out.println("Mortifago (multiplicador: 1.8): " + danioMortifago);
        System.out.println("Mago (multiplicador: 0.5): " + danioMago);
        
        assertTrue("Mortifago debería pegar más que Mago con Confringo", 
                   danioMortifago > danioMago);
    }
    
    // ============ TESTS CON EXPELLIARMUS ============
    
    @Test
    public void testExpelliarmusDanioComandanteVsEstudiante() {
        Comandante comandante = new Comandante("Voldemort", 100, 100);
        Estudiante estudiante = new Estudiante("Harry", 100, 100);
        
        Personaje objetivo1 = new Mago("Objetivo1", 100, 100);
        Personaje objetivo2 = new Mago("Objetivo2", 100, 100);
        
        Expelliarmus expelliarmus = new Expelliarmus();
        
        double vidaInicial1 = objetivo1.getPuntosVida();
        expelliarmus.ejecutar(comandante, objetivo1);
        double danioComandante = vidaInicial1 - objetivo1.getPuntosVida();
        
        double vidaInicial2 = objetivo2.getPuntosVida();
        expelliarmus.ejecutar(estudiante, objetivo2);
        double danioEstudiante = vidaInicial2 - objetivo2.getPuntosVida();
        
        System.out.println("=== Expelliarmus ===");
        System.out.println("Comandante (multiplicador ataque oscuro: 1.6): " + danioComandante);
        System.out.println("Estudiante (multiplicador ataque oscuro: 0.2): " + danioEstudiante);
        
        assertTrue("Comandante debería pegar más que Estudiante con Expelliarmus", 
                   danioComandante > danioEstudiante);
    }
    
    @Test
    public void testExpelliarmusDanioMortifagoVsMago() {
        Mortifago mortifago = new Mortifago("Mortifago", 100, 100);
        Mago mago = new Mago("Mago", 100, 100);
        
        Personaje objetivo1 = new Mago("Objetivo1", 100, 100);
        Personaje objetivo2 = new Mago("Objetivo2", 100, 100);
        
        Expelliarmus expelliarmus = new Expelliarmus();
        
        double vidaInicial1 = objetivo1.getPuntosVida();
        expelliarmus.ejecutar(mortifago, objetivo1);
        double danioMortifago = vidaInicial1 - objetivo1.getPuntosVida();
        
        double vidaInicial2 = objetivo2.getPuntosVida();
        expelliarmus.ejecutar(mago, objetivo2);
        double danioMago = vidaInicial2 - objetivo2.getPuntosVida();
        
        System.out.println("Mortifago (multiplicador: 1.8): " + danioMortifago);
        System.out.println("Mago (multiplicador: 0.5): " + danioMago);
        
        assertTrue("Mortifago debería pegar más que Mago con Expelliarmus", 
                   danioMortifago > danioMago);
    }
    
    // ============ TEST DE CURACIÓN ============
    
    @Test
    public void testProfesorCuraMasQueMortifago() {
        Profesor profesor = new Profesor("McGonagall", 100, 100);
        Mortifago mortifago = new Mortifago("Mortifago", 100, 100);
        
        // Creamos personajes heridos
        Profesor profesorHerido = new Profesor("Profesor Herido", 100, 50);
        Mortifago mortifagoHerido = new Mortifago("Mortifago Herido", 100, 50);
        
        hechizos.ExpectoPatronum expecto = new hechizos.ExpectoPatronum();
        
        double vidaInicialProfesor = profesorHerido.getPuntosVida();
        expecto.ejecutar(profesor, profesorHerido);
        double curacionProfesor = profesorHerido.getPuntosVida() - vidaInicialProfesor;
        
        double vidaInicialMortifago = mortifagoHerido.getPuntosVida();
        expecto.ejecutar(mortifago, mortifagoHerido);
        double curacionMortifago = mortifagoHerido.getPuntosVida() - vidaInicialMortifago;
        
        System.out.println("=== Curación ===");
        System.out.println("Profesor (multiplicador curación: 2.0): " + curacionProfesor);
        System.out.println("Mortifago (multiplicador curación: 0.4): " + curacionMortifago);
        
        assertTrue("Profesor debería curar más que Mortifago", 
                   curacionProfesor > curacionMortifago);
    }
    
    @Test
    public void testProfesorCuraMasQueEstudiante() {
        Profesor profesor = new Profesor("McGonagall", 100, 100);
        Estudiante estudiante = new Estudiante("Harry", 100, 100);
        
        Profesor profesorHerido = new Profesor("Profesor Herido", 100, 50);
        Estudiante estudianteHerido = new Estudiante("Estudiante Herido", 100, 50);
        
        hechizos.ExpectoPatronum expecto = new hechizos.ExpectoPatronum();
        
        double vidaInicialProfesor = profesorHerido.getPuntosVida();
        expecto.ejecutar(profesor, profesorHerido);
        double curacionProfesor = profesorHerido.getPuntosVida() - vidaInicialProfesor;
        
        double vidaInicialEstudiante = estudianteHerido.getPuntosVida();
        expecto.ejecutar(estudiante, estudianteHerido);
        double curacionEstudiante = estudianteHerido.getPuntosVida() - vidaInicialEstudiante;
        
        System.out.println("Profesor (multiplicador curación: 2.0): " + curacionProfesor);
        System.out.println("Estudiante (multiplicador curación: 0.8): " + curacionEstudiante);
        
        assertTrue("Profesor debería curar más que Estudiante", 
                   curacionProfesor > curacionEstudiante);
    }
}


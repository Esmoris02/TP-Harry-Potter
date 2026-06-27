package fabricas;

import java.util.Random;

import modelos.Auror;
import modelos.Comandante;
import modelos.Estudiante;
import modelos.Mago;
import modelos.Mortifago;
import modelos.Profesor;
import modelos.Seguidor;

public class Reclutador {
	// Instanciamos un Random para darle un poco de variedad a las estadísticas
    private static Random rand = new Random();

    // 1. Fábrica de Magos
    public static Mago crearMago() {
        int tipo = rand.nextInt(3); // Elige un número entre 0 y 2
        Mago nuevoMago;

        // Según el número aleatorio, instanciamos un tipo distinto
        if (tipo == 0) {
            nuevoMago = new Auror("Auror de Élite", 100, 150);
        } else if (tipo == 1) {
            nuevoMago = new Profesor("Profesor Experimentado", 80, 120);
        } else {
            nuevoMago = new Estudiante("Estudiante de Hogwarts", 50, 100);
        }

        // Le "enseñamos" hechizos básicos para que venga armado de fábrica
        //nuevoMago.aprenderHechizo(new Expelliarmus());
        //nuevoMago.aprenderHechizo(new ExpectoPatronum());
        //nuevoMago.aprenderHechizo(new Protego());
        
        nuevoMago.aprenderHechizo(FabricaHechizos.crearHechizoPorTipo("ataque"));
        nuevoMago.aprenderHechizo(FabricaHechizos.crearHechizoPorTipo("defensa"));
        nuevoMago.aprenderHechizo(FabricaHechizos.crearHechizoPorTipo("curacion"));

        return nuevoMago;
    }

    // 2. Fábrica de Mortífagos
    public static Mortifago crearMortifago() {
        int tipo = rand.nextInt(2); // Elige un número entre 0 y 1
        Mortifago nuevoMortifago;

        if (tipo == 0) {
            nuevoMortifago = new Comandante("Comandante Oscuro", 110, 160);
        } else {
            nuevoMortifago = new Seguidor("Seguidor Común", 70, 110);
        }

        // Le enseñamos hechizos agresivos
       // nuevoMortifago.aprenderHechizo(new AvadaKedabra());
        //nuevoMortifago.aprenderHechizo(new Confringo());
        //nuevoMortifago.aprenderHechizo(new Protego());
        nuevoMortifago.aprenderHechizo(FabricaHechizos.crearHechizoPorTipo("oscuro"));
        nuevoMortifago.aprenderHechizo(FabricaHechizos.crearHechizoPorTipo("defensa"));

        return nuevoMortifago;
    }

}

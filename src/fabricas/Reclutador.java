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
		Mago nuevoMago = null;
		// Según el número aleatorio, instanciamos un tipo distinto
		switch (tipo) {
		case 0:
			nuevoMago = new Auror();
			break;
		case 1:
			nuevoMago = new Profesor();
			break;
		case 2:
			nuevoMago = new Estudiante();
		}

		nuevoMago.aprenderHechizo(FabricaHechizos.crearHechizoPorTipo("ataque"));
		nuevoMago.aprenderHechizo(FabricaHechizos.crearHechizoPorTipo("defensa"));
		nuevoMago.aprenderHechizo(FabricaHechizos.crearHechizoPorTipo("curacion"));
		nuevoMago.aprenderHechizo(FabricaHechizos.crearHechizoPorTipo("oscuro"));
		return nuevoMago;
	}

	// 2. Fábrica de Mortífagos
	public static Mortifago crearMortifago() {
		int tipo = rand.nextInt(2); // Elige un número entre 0 y 1
		Mortifago nuevoMortifago = null;
		switch (tipo) {
		case 0:
			nuevoMortifago = new Comandante();
			break;
		case 1:
			nuevoMortifago = new Seguidor();
		}
		nuevoMortifago.aprenderHechizo(FabricaHechizos.crearHechizoPorTipo("ataque"));
		nuevoMortifago.aprenderHechizo(FabricaHechizos.crearHechizoPorTipo("oscuro"));
		nuevoMortifago.aprenderHechizo(FabricaHechizos.crearHechizoPorTipo("defensa"));
		nuevoMortifago.aprenderHechizo(FabricaHechizos.crearHechizoPorTipo("curacion"));
		return nuevoMortifago;
	}
}

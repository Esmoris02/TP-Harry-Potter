package fabricas;

import java.util.Random;

import hechizos.TipoHechizo;
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
	public static Mago crearMago(String nombre) {
		int tipo = rand.nextInt(3); // Elige un número entre 0 y 2
		Mago nuevoMago = null;
		// Según el número aleatorio, instanciamos un tipo distinto
		switch (tipo) {
		case 0:
			nuevoMago = new Auror(nombre);
			break;
		case 1:
			nuevoMago = new Profesor(nombre);
			break;
		case 2:
			nuevoMago = new Estudiante(nombre);
		}

		nuevoMago.aprenderHechizo(FabricaHechizos.crearHechizoPorTipo(TipoHechizo.ATAQUE));
		nuevoMago.aprenderHechizo(FabricaHechizos.crearHechizoPorTipo(TipoHechizo.DEFENSA));
		nuevoMago.aprenderHechizo(FabricaHechizos.crearHechizoPorTipo(TipoHechizo.CURACION));
		nuevoMago.aprenderHechizo(FabricaHechizos.crearHechizoPorTipo(TipoHechizo.OSCURO));
		nuevoMago.aprenderHechizo(FabricaHechizos.crearHechizoPorTipo(TipoHechizo.ESPECIAL));
		return nuevoMago;
	}

	// 2. Fábrica de Mortífagos
	public static Mortifago crearMortifago(String nombre) {
		int tipo = rand.nextInt(2); // Elige un número entre 0 y 1
		Mortifago nuevoMortifago = null;
		switch (tipo) {
		case 0:
			nuevoMortifago = new Comandante(nombre);
			break;
		case 1:
			nuevoMortifago = new Seguidor(nombre);
		}
		nuevoMortifago.aprenderHechizo(FabricaHechizos.crearHechizoPorTipo(TipoHechizo.ATAQUE));
		nuevoMortifago.aprenderHechizo(FabricaHechizos.crearHechizoPorTipo(TipoHechizo.DEFENSA));
		nuevoMortifago.aprenderHechizo(FabricaHechizos.crearHechizoPorTipo(TipoHechizo.CURACION));
		nuevoMortifago.aprenderHechizo(FabricaHechizos.crearHechizoPorTipo(TipoHechizo.OSCURO));
		nuevoMortifago.aprenderHechizo(FabricaHechizos.crearHechizoPorTipo(TipoHechizo.ESPECIAL));
		return nuevoMortifago;
	}
}

package batalla;

import java.util.List;
import java.util.Random;

import fabricas.Reclutador;
import modelos.Batallon;
import modelos.Personaje;

public class BatallaMagosVsMortifagos {
	public static void main(String[] args) {
		Batallon batallonMagos = new Batallon();
		Batallon batallonMortifagos = new Batallon();
		List<String> nombreMagos = List.of("Alaric Veyra", "Selene Damaris", "Thalion Merrow", "Isolde Fenwick",
				"Caelum Ardent");
		List<String> nombreMortifagos = List.of("Dorian Malrik", "Morgath Veylen", "Nyx Obsidian", "Kael Draven",
				"Seraphine Noctra");
		final int CANTIDAD_INTEGRANTES_X_BATALLON = 3;

		for (int i = 0; i < CANTIDAD_INTEGRANTES_X_BATALLON; i++) {
			if (i < nombreMagos.size()) {
				batallonMagos.agregarPersonaje(Reclutador.crearMago(nombreMagos.get(i)));
			} else {
				System.out.println("No se pueden crear más magos: lista de nombres agotada.");
				break;
			}
		}

		for (int i = 0; i < CANTIDAD_INTEGRANTES_X_BATALLON; i++) {
			if (i < nombreMortifagos.size()) {
				batallonMortifagos.agregarPersonaje(Reclutador.crearMortifago(nombreMortifagos.get(i)));
			} else {
				System.out.println("No se pueden crear más mortífagos: lista de nombres agotada.");
				break;
			}
		}

		Random rand = new Random();
		while (batallonMagos.tienePersonajesSaludables() && batallonMortifagos.tienePersonajesSaludables()) {
			System.out.println("============================================================");
			System.out.println("COMBATIENTES:");
			System.out.println("- MAGOS:");
			for (Personaje mago : batallonMagos.obtenerIntegrantes()) {
				System.out.println("   * " + mago.toString());
			}
			System.out.println("- MORTÍFAGOS:");
			for (Personaje mortifago : batallonMortifagos.obtenerIntegrantes()) {
				System.out.println("   * " + mortifago.toString());
			}
			System.out.println("------------------------------------------------------------");
			if (rand.nextBoolean()) {
				System.out.println("\n---- BATALLON DE MAGOS ----\n");
				batallonMagos.atacar(batallonMortifagos);
				if (batallonMortifagos.tienePersonajesSaludables()) {
					System.out.println("---- BATALLON DE MORTIFAGOS ----\n");
					batallonMortifagos.atacar(batallonMagos);
				}
			} else {
				System.out.println("---- BATALLON DE MORTIFAGOS ----\n");
				batallonMortifagos.atacar(batallonMagos);
				if (batallonMagos.tienePersonajesSaludables()) {
					System.out.println("\n---- BATALLON DE MAGOS ----\n");
					batallonMagos.atacar(batallonMortifagos);
				}
			}

		}

		if (batallonMagos.tienePersonajesSaludables()) {

			System.out.println("¡Los magos han ganado la batalla!");

		} else {

			System.out.println("¡Los mortífagos han ganado la batalla!");

		}

	}

}

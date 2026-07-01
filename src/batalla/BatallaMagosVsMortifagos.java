package batalla;

import java.util.Random;

import fabricas.Reclutador;
import modelos.Batallon;

public class BatallaMagosVsMortifagos {
	public static void main(String[] args) {
		Batallon batallonMagos = new Batallon();
		Batallon batallonMortifagos = new Batallon();

		System.out.println("\n--- BATALLON DE MAGOS COMPUESTO POR: ---\n");
		for (int i = 0; i < 3; i++) {
			batallonMagos.agregarPersonaje(Reclutador.crearMago());
		}
		
		System.out.println("\n--- BATALLON DE MORTIFAGOS COMPUESTO POR: ---\n");
		for (int i = 0; i < 3; i++) {
			batallonMortifagos.agregarPersonaje(Reclutador.crearMortifago());
		}

		Random rand = new Random();
		while (batallonMagos.tienePersonajesSaludables() && batallonMortifagos.tienePersonajesSaludables()) {
			if (rand.nextBoolean()) {
				System.out.println("\n---- BATALLON DE MAGOS ----\n");
				batallonMagos.atacar(batallonMortifagos);
				if (batallonMortifagos.tienePersonajesSaludables()) {
					batallonMortifagos.atacar(batallonMagos);
				}
			} else {
				System.out.println("---- BATALLON DE MORTIFAGOS ----");
				batallonMortifagos.atacar(batallonMagos);
				if (batallonMagos.tienePersonajesSaludables()) {
					batallonMagos.atacar(batallonMortifagos);
				}
			}

			System.out.println("\n----------------------------\n");
		}

		if (batallonMagos.tienePersonajesSaludables()) {

			System.out.println("¡Los magos han ganado la batalla!");

		} else {

			System.out.println("¡Los mortífagos han ganado la batalla!");

		}
	}

}

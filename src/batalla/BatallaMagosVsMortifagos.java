package batalla;

import java.util.Random;

import fabricas.Reclutador;
import modelos.Batallon;

public class BatallaMagosVsMortifagos {
	public static void main(String[] args) {
		Batallon batallonMagos = new Batallon();
		Batallon batallonMortifagos = new Batallon();

		for (int i = 0; i < 3; i++) {
			batallonMagos.agregarPersonaje(Reclutador.crearMago());
			batallonMortifagos.agregarPersonaje(Reclutador.crearMortifago());
		}

		Random rand = new Random();
		while (batallonMagos.tienePersonajesSaludables() && batallonMortifagos.tienePersonajesSaludables()) {
			if (rand.nextBoolean()) {
				System.out.println("---- BATALLON DE MAGOS ----");
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

			System.out.println("----------------------------");
		}

		if (batallonMagos.tienePersonajesSaludables()) {

			System.out.println("¡Los magos han ganado la batalla!");

		} else {

			System.out.println("¡Los mortífagos han ganado la batalla!");

		}
	}

}

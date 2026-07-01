package fabricas;

import java.util.Random;
import hechizos.HechizoBase;
import hechizos.PetrificusTotalus;
import hechizos.AvadaKedavra;
import hechizos.ExpectoPatronum;
import hechizos.Expelliarmus;
import hechizos.Protego;
import hechizos.Sectumsempra;
import hechizos.Stupefy;
import hechizos.VulneraSanetur;
import hechizos.Confringo;
import hechizos.Crucio;
import hechizos.Episkey;

public class FabricaHechizos {
	// Instanciamos un Random para variar entre los distintos tipos de hechizos
	private static Random rand = new Random();

	public static HechizoBase crearHechizoPorTipo(String tipo) {
		// Usamos switch para evaluar el tipo y devolver el objeto correcto
		switch (tipo.toLowerCase()) {
		case "ataque": {
			int type = rand.nextInt(2);
			if (type == 0)
				return new Confringo();
			return new Expelliarmus();
		}
		case "oscuro": {
			int type = rand.nextInt(3);
			if (type == 0)
				return new Crucio();
			if (type == 1)
				return new Sectumsempra();
			return new AvadaKedavra();
		}
		case "defensa": {
			return new Protego();
		}
		case "curacion": {
			int type = rand.nextInt(3);
			if (type == 0)
				return new VulneraSanetur();
			if (type == 1)
				return new Episkey();
			return new ExpectoPatronum();
		}
		case "especial": {
			int type = rand.nextInt(2);
			if (type == 0)
				return new Stupefy();
			return new PetrificusTotalus();
		}
		default:
			throw new IllegalArgumentException("Tipo de hechizo no reconocido: " + tipo);
		}
	}
}

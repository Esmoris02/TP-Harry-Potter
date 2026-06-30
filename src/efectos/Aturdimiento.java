package efectos;

import modelos.Personaje;

public class Aturdimiento implements Efecto {

	@Override
	public void aplicar(Personaje objetivo) {
		objetivo.aplicarAturdimiento();
	}

	@Override
	public boolean haExpirado() {
		return true;
	}

}

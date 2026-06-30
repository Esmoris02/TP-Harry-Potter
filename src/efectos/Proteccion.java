package efectos;

import modelos.Personaje;

public class Proteccion implements Efecto{
	private double resistencia;

	public Proteccion(double resistencia) {
		this.resistencia = resistencia;
	}

	@Override
	public void aplicar(Personaje objetivo) {
		objetivo.aplicarProteccion(resistencia);
	}

	@Override
	public boolean haExpirado() {
		return true;
	}
	
}

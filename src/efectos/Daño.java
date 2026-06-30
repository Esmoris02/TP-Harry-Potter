package efectos;

import modelos.Personaje;

public class Daño implements Efecto {
	private double cantidad;

	public Daño(double cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public void aplicar(Personaje objetivo) {
		objetivo.reducirVida(cantidad);
	}

	@Override
	public boolean haExpirado() {
		return true;
	}

}

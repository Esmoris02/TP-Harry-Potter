package efectos;

import modelos.Personaje;

public class Curacion implements Efecto{
	private double cantidad;

	public Curacion(double cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public void aplicar(Personaje objetivo) {
		objetivo.aumentarVida(cantidad);
	}

	@Override
	public boolean haExpirado() {
		return true;
	}

}

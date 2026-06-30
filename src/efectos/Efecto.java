package efectos;

import modelos.Personaje;

public interface Efecto {
	public void aplicar(Personaje objetivo);
	public boolean haExpirado();
}

package efectos;

import modelos.Personaje;

public class Daño implements Efecto{
	double cantidad;
	
	
	
	@Override
	public void aplicar(Personaje p) {
		aplicarDaño(p, 5);
	}
	
	public void aplicarDaño(Personaje p, double daño) {
		
	}

}

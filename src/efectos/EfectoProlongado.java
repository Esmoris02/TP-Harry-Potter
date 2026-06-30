package efectos;

import modelos.Personaje;

public class EfectoProlongado extends EfectoDecorador{
	private int turnosRestantes;
	private boolean efectoBaseAplicado;
	private String nombreEfectoAdicional;

	public EfectoProlongado(Efecto efectoBase, Efecto efectoAdicional, int duracion, String nombreEfectoAdicional) {
		super(efectoBase, efectoAdicional);
		this.turnosRestantes = duracion; // duración variable
		this.nombreEfectoAdicional = nombreEfectoAdicional;
		this.efectoBaseAplicado = false;
	}

	@Override
	public void aplicar(Personaje objetivo) {
		// aplicar el efecto primordial solo una vez
		if (!efectoBaseAplicado) {
			efectoBase.aplicar(objetivo);
			efectoBaseAplicado = true;
			return; 
		}

		// aplicar efecto prolongado mientras dure en el siguiente turno
		if (turnosRestantes > 0) {
			System.out.println(objetivo.obtenerNombre() + " experimenta " + nombreEfectoAdicional);
			efectoAdicional.aplicar(objetivo);
			turnosRestantes--;
		}
	}

	@Override
	public boolean haExpirado() {
		return 0 == turnosRestantes;
	}
}

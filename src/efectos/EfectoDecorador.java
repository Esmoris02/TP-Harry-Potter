package efectos;

import modelos.Personaje;

public abstract class EfectoDecorador implements Efecto {
	protected Efecto efecto;
	
    public EfectoDecorador(Efecto efecto) {
        this.efecto = efecto;
    }

    public abstract void aplicar(Personaje p);

}

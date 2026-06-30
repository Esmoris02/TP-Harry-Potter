package efectos;

import modelos.Personaje;

public abstract class EfectoDecorador implements Efecto {
	protected Efecto efectoBase;
	protected Efecto efectoAdicional;

    public EfectoDecorador(Efecto efectoBase, Efecto efectoAdicional) {
        this.efectoBase = efectoBase;
        this.efectoAdicional = efectoAdicional;
    }

    abstract public void aplicar(Personaje objetivo);
    abstract public boolean haExpirado();

}

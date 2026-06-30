package modelos;

import hechizos.Confringo;
import hechizos.Episkey;
import hechizos.ExpectoPatronum;
import hechizos.Expelliarmus;
import hechizos.PetrificusTotalus;
import hechizos.Protego;
import hechizos.Stupefy;

public class Profesor extends Mago{
	private static final int TASA_RECUPERACION_MAGIA = 25;
	private static final double MULTIPLICADOR_CURACION = 2.0;
	private static final double MULTIPLICADOR_HECHIZO_OSCURO = 0.5;
	private static final int MAX_PUNTOS_VIDA = 120;
	private static final int MAX_NIVEL_MAGIA = 80;

	public Profesor() {
        super("Profesor Experimentado", MAX_NIVEL_MAGIA, MAX_PUNTOS_VIDA);
        this.maximoNivelMagia = MAX_NIVEL_MAGIA;
        this.maximoPuntosVida = MAX_PUNTOS_VIDA;
        this.aprenderHechizo(new Expelliarmus());
		this.aprenderHechizo(new Protego());
		this.aprenderHechizo(new Stupefy());
        this.aprenderHechizo(new Confringo());
        this.aprenderHechizo(new Episkey());
        this.aprenderHechizo(new PetrificusTotalus());
        this.aprenderHechizo(new ExpectoPatronum());
    }

    // El Profesor es un maestro en magia, así que tiene curacion mejorada
    @Override
    public double obtenerMultiplicadorCuracion() {
        return MULTIPLICADOR_CURACION; 
    }
    
    @Override
    public double obtenerMultiplicadorHechizoOscuro() {
        return MULTIPLICADOR_HECHIZO_OSCURO; 
    }
    
    // Recuperacion de nivel de magia estándar
    @Override
    public double obtenerTasaRecuperacionMagia() {
		return TASA_RECUPERACION_MAGIA;
    }

}

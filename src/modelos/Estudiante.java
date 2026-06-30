package modelos;

import hechizos.Confringo;
import hechizos.ExpectoPatronum;
import hechizos.Expelliarmus;
import hechizos.Protego;
import hechizos.Stupefy;

public class Estudiante extends Mago{
	private static final double MULTIPLICADOR_HECHIZO_OSCURO = 0.2;
	private static final double MULTIPLICADOR_DEFENSA = 0.7;
	private static final double MULTIPLICADOR_CURACION = 0.8;
	private static final int MAX_PUNTOS_VIDA = 100;
	private static final int MAX_NIVEL_MAGIA = 50;

	public Estudiante() {
        super("Estudiante de Hogwarts", MAX_NIVEL_MAGIA, MAX_PUNTOS_VIDA);
        this.maximoNivelMagia = MAX_NIVEL_MAGIA;
        this.maximoPuntosVida = MAX_PUNTOS_VIDA;
        this.aprenderHechizo(new Stupefy());
        this.aprenderHechizo(new Expelliarmus());
        this.aprenderHechizo(new Protego());
        this.aprenderHechizo(new Confringo());
        this.aprenderHechizo(new ExpectoPatronum());
    }

    // El estudiante todavía está aprendiendo, curación es mucho menor que la de un mago nermal
    @Override
    public double obtenerMultiplicadorCuracion() {
        return MULTIPLICADOR_CURACION; 
    }

    // Escudos mágicos débiles
    @Override
    public double obtenerMultiplicadorDefensa() {
        return MULTIPLICADOR_DEFENSA; 
    }

    //Si por alguna razón intenta usar magia oscura, el efecto es casi nulo
    @Override
    public double obtenerMultiplicadorHechizoOscuro() {
        return MULTIPLICADOR_HECHIZO_OSCURO; 
    }

}

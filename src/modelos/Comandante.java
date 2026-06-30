package modelos;

import hechizos.AvadaKedavra;
import hechizos.Crucio;
import hechizos.Protego;
import hechizos.Sectumsempra;
import hechizos.Stupefy;
import hechizos.VulneraSanetur;

public class Comandante extends Mortifago{
	private static final int TASA_RECUPERACION_MAGIA = 30;
	private static final double MULTIPLICADOR_DEFENSA = 1.4;
	private static final double MULTIPLICADOR_CURACION = 0.5;
	private static final double MULTIPLICADOR_HECHIZO_OSCURO = 1.6;
	private static final int MAX_PUNTOS_VIDA = 160;
	private static final int MAX_NIVEL_MAGIA = 110;

	public Comandante() {
		//Nombre, puntos de magia, puntos de vida
        super("Comandante Oscuro", MAX_NIVEL_MAGIA, MAX_PUNTOS_VIDA);
        this.maximoNivelMagia = MAX_NIVEL_MAGIA;
        this.maximoPuntosVida = MAX_PUNTOS_VIDA;
        this.aprenderHechizo(new Sectumsempra());
        this.aprenderHechizo(new VulneraSanetur());
        this.aprenderHechizo(new Crucio());
        this.aprenderHechizo(new AvadaKedavra());
        this.aprenderHechizo(new Protego());
        this.aprenderHechizo(new Stupefy());
        
    }

    // Bonificacion por uso de magia oscura
    @Override
    public double obtenerMultiplicadorHechizoOscuro() {
        return MULTIPLICADOR_HECHIZO_OSCURO; 
    }

    // Penalizacion por magia de curación
    @Override
    public double obtenerMultiplicadorCuracion() {
        return MULTIPLICADOR_CURACION; 
    }

    // Defensa estandar mejorada
    @Override
    public double obtenerMultiplicadorDefensa() {
        return MULTIPLICADOR_DEFENSA;
    }
    
    // Recuperacion de nivel de magia estándar
    @Override
    public double obtenerTasaRecuperacionMagia() {
		return TASA_RECUPERACION_MAGIA;
    }
    
}

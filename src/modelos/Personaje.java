package modelos;

import java.util.List;
import java.util.Random;
import java.util.LinkedList;
import java.util.Set;
import hechizos.Hechizo;

public abstract class Personaje {
	public String nombre;
    public double nivelMagia;
    public double puntosVida;
    public boolean protegido;
    //futura implementación de hechizos 
    public List<Hechizo> hechizosDisponibles = new LinkedList<>();  
    
    public Personaje(String nombre, double nivelMagia, double puntosVida) {
        this.nombre = nombre;
        this.nivelMagia = nivelMagia;
        this.puntosVida = puntosVida;
        //futura implementación de hechizos 
        //this.hechizosDisponibles = new ArrayList<>();
    }
    
    public String getNombre() {
    	return nombre;
    }
    
    public void recibirDanio(double cantidad) {
    	if(this.protegido) {
    		System.out.println("Ataque bloqueado");
    		this.protegido = false;//Se rompe el escudo
    		return;
    	}
        this.puntosVida -= cantidad;
        if (this.puntosVida < 0) {
            this.puntosVida = 0; // Evitamos que la vida quede en números negativos
        }
    }
    public void recibirCuracion(double cantidad) {
        this.puntosVida += cantidad;
    }

    public boolean estaSaludable() {
        return this.puntosVida > 0; 
    }

    public void aprenderHechizo(Hechizo hechizo) {
        this.hechizosDisponibles.add(hechizo);
    }
    
    public Hechizo elegirHechizo(Set<Hechizo> hechizosUsadosEnTurno) {
    	List<Hechizo> hechizosDisponiblesParaUsar = new LinkedList<>();
    	Random rand = new Random();
    	int indice;
    	for(Hechizo h: hechizosDisponibles) {
    		if(!hechizosUsadosEnTurno.contains(h)) {
    			hechizosDisponiblesParaUsar.add(h);
    		}
    	}
    	if(hechizosDisponiblesParaUsar.isEmpty()) {
    		return null;
    	}
    	indice = rand.nextInt(hechizosDisponiblesParaUsar.size());
    	return hechizosDisponiblesParaUsar.get(indice);
    }
    
    /*public void lanzarHechizo(Hechizo nombreHechizo, Personaje objetivo) {
    	for(Hechizo h : hechizosDisponibles) {
    		if(h.getClass().getSimpleName().equals(nombreHechizo)) {//Devuelve el objeto real dentro de la lista y compara con el nombre de hechizo solicitado.
    			h.ejecutar(this, objetivo);							//Si encuentra ejecuta
    			return;
    		}
    		throw new IllegalArgumentException("No conoce el hechizo");
    	}
    }*/
    
    public abstract double obtenerMultiplicadorAtaqueOscuro();
    public abstract double obtenerMultiplicadorCuracion();
    public abstract double obtenerMultiplicadorDefensa();

}

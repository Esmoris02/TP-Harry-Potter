package modelos;

public abstract class Personaje {
	public  String nombre;
    public double nivelMagia;
    public double puntosVida;
    //futura implementación de hechizos 
    //public List<Hechizo> hechizosDisponibles;  
    
    public Personaje(String nombre, double nivelMagia, double puntosVida) {
        this.nombre = nombre;
        this.nivelMagia = nivelMagia;
        this.puntosVida = puntosVida;
        //futura implementación de hechizos 
        //this.hechizosDisponibles = new ArrayList<>();
    }
    
    public void recibirDanio(double cantidad) {
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

    /*public void aprenderHechizo(Hechizo hechizo) {
        this.hechizosDisponibles.add(hechizo);
    }*/

    
    public abstract double obtenerMultiplicadorAtaqueOscuro();
    public abstract double obtenerMultiplicadorCuracion();
    public abstract double obtenerMultiplicadorDefensa();

}

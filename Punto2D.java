package pruebas.instance.model;

public class Punto2D {
	protected int x;
	protected int y;
	
	public Punto2D(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public double calcularDistancia() {
		//return Math.sqrt(x*x+y*y); //esto es para hacer una ra�z cuadrada, lo de abajo tambi�n
		
		return Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
	}
	
	
}

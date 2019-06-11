package Exercicio01;

public abstract class Quadrilatero extends Poligono {


	
	 public Quadrilatero(String nome,double base, double altura) {
		  super(nome, base,altura);
		 
	  }

	   public abstract double area();
}

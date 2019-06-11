package Exercicio01;

public class Circulo extends Figura {
	private double raio;
	
	
	  public Circulo(String nome,double raio) {
		  super(nome);
		  this.raio=raio;
		 
	  }
	  
	  public double getRaio() {
		return raio;
	}
	  public void setRaio(double raio) {
		this.raio = raio;
	}
	  
	 
	@Override
	public double area() {
	
		return (raio*raio)*3.14;
	}
	  
	 
}



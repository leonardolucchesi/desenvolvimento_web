package Exercicio01;

public abstract class Poligono extends Figura {
private double base;
private double altura;
    
    public Poligono(String nome,double base, double altura) {
    	super(nome);
   	 this.base=base;
   	 this.altura=altura;
    }
    public double getBase() {
		return base;
	}
    public double getAltura() {
		return altura;
	}
    public void setAltura(double altura) {
		this.altura = altura;
	}
    public void setBase(double base) {
		this.base = base;
	}
   
    public abstract double area();

}

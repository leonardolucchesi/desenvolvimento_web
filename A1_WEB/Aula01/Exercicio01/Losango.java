package Exercicio01;

public class Losango extends Quadrilatero {

	public Losango(String nome, double base, double altura) {
		super(nome, base, altura);
		
	}

	@Override
	public double area() {
		
		return getBase()*getAltura();
	}

}

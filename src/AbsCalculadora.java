
public abstract class AbsCalculadora implements IOperacao {

	protected double a;
	protected double b;

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public abstract double calcular(double a, double b);

}

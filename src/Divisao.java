
public class Divisao extends AbsCalculadora {

	@Override
	public double calcular(double a, double b) {
		
		if(b == 0.0)
			throw new DivisaoPorZeroException("Não é permitido a divisão por zero!!!");
		return a / b;
	}

}

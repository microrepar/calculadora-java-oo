import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Calculadora extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblValor1;
	private JLabel lblValor2;
	private JTextField txtValor1;
	private JTextField txtValor2;
	private JButton btnAdicao;
	private JButton btnSubtracao;
	private JButton btnDivisao;
	private JButton btnMultiplicacao;
	private Map<String, AbsCalculadora> operacoes;
	private double resutaldo;
	private JLabel lblResultado;

	public Calculadora() {
		setSize(500, 500);
		setTitle("Calculadora");

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);

		init();
		setVisible(true);

		operacoes = new HashMap<>();
		operacoes.put("+", new Soma());
		operacoes.put("-", new Subtracao());
		operacoes.put("/", new Divisao());
		operacoes.put("*", new Multiplicacao());

	}

	private void init() {
		lblValor1 = new JLabel();
		lblValor1.setText("Valor 1");
		lblValor1.setBounds(20, 20, getWidth() / 2 - 40, 35);
		add(lblValor1);

		lblValor2 = new JLabel();
		lblValor2.setText("Valor 2");
		lblValor2.setBounds(lblValor1.getWidth() + 40, 20, getWidth() / 2, 35);
		add(lblValor2);

		txtValor1 = new JTextField();
		txtValor1.setBounds(20, lblValor1.getY() + lblValor1.getHeight() + 5, lblValor1.getWidth(), 35);
		add(txtValor1);

		txtValor2 = new JTextField();
		txtValor2.setBounds(txtValor1.getX() + txtValor1.getWidth() + 20, lblValor2.getY() + lblValor2.getHeight() + 5,
				txtValor1.getWidth(), 35);
		add(txtValor2);

		btnAdicao = new JButton();
		btnAdicao.setText("+");
		btnAdicao.setBounds(25, getWidth() - getWidth() / 2, 50, 50);
		add(btnAdicao);
		btnAdicao.addActionListener(this);

		btnSubtracao = new JButton();
		btnSubtracao.setText("-");
		btnSubtracao.setBounds((int) (getWidth() * 0.25) + 20, getWidth() / 2, 50, 50);
		add(btnSubtracao);
		btnSubtracao.addActionListener(this);

		btnDivisao = new JButton();
		btnDivisao.setText("/");
		btnDivisao.setBounds((int) (getWidth() * 0.5) + 20, getWidth() / 2, 50, 50);
		add(btnDivisao);
		btnDivisao.addActionListener(this);

		btnMultiplicacao = new JButton();
		btnMultiplicacao.setText("*");
		btnMultiplicacao.setBounds((int) (getWidth() * 0.75) + 20, getWidth() / 2, 50, 50);
		add(btnMultiplicacao);
		btnMultiplicacao.addActionListener(this);

		lblResultado = new JLabel();
		lblResultado.setBounds(20, (int) (getWidth() * 0.25) - 10, getWidth() - 20, 35);
		lblResultado.setText("Resultado:");
		add(lblResultado);

	}

	@Override
	public void actionPerformed(ActionEvent args) {

		if (args.getSource().equals(btnAdicao)) {
			setInterface(operacoes.get(btnAdicao.getText()));
		}
		if (args.getSource().equals(btnSubtracao)) {
			setInterface(operacoes.get(btnSubtracao.getText()));
		}
		if (args.getSource().equals(btnDivisao)) {
			setInterface(operacoes.get(btnDivisao.getText()));
		}
		if (args.getSource().equals(btnMultiplicacao)) {
			setInterface(operacoes.get(btnMultiplicacao.getText()));
		}
	}

	private void setInterface(AbsCalculadora operacao) {
		if (txtValor1.getText().trim().length() == 0)
			txtValor1.setText("0");
		if (txtValor2.getText().trim().length() == 0)
			txtValor2.setText("0");

		try {
			operacao.setA(Double.parseDouble(txtValor1.getText()));
			operacao.setB(Double.parseDouble(txtValor2.getText()));
			resutaldo = operacao.calcular(Double.parseDouble(txtValor1.getText()),
					Double.parseDouble(txtValor2.getText()));
			lblResultado.setText("Resultado: " + String.valueOf(resutaldo));
		} catch (NumberFormatException e) {
			lblResultado.setText("Resultado: " + "Por favor insira apenas digitos!");
		} catch (DivisaoPorZeroException e) {
			lblResultado.setText("Resultado: " + e.getMessage());
		}
	}

}

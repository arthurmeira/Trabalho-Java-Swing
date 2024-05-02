import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Menu extends JFrame {
    private JLabel lblTitle;
    private JLabel labelA, labelB, labelResultado;
    private JTextField campoA, campoB, campoResultado;

    double valor = 10.56789;

    DecimalFormat df = new DecimalFormat("#.##");

    private JButton[] buttons = new JButton[9];
    private String[] buttonLabels = {
            "Desconto em %", "Amostragem", "Deconto pós quitação", "Valor original", "Potência",
            "Raiz Quadrada", "Raiz Cúbica", "Seno", "Cosseno"
    };

    public Menu() {
        setSize(800, 600);
        setTitle("CÁLCULOS MATEMÁTICOS");
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        componentes();
        setVisible(true);
    }

    private void componentes() {
        // Criando o título
        lblTitle = new JLabel("Escolha uma operação");
        lblTitle.setBounds(100, 30, 300, 25);
        lblTitle.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        getContentPane().add(lblTitle);

        // Criando os botões
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].setBounds(100, 100 + i * 40, 200, 25);
            final int buttonIndex = i;
            buttons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    realizarCalculo(buttonIndex);
                }
            });
            getContentPane().add(buttons[i]);
        }

        // Adicionando campos de texto para entrada e saída de dados
        labelA = new JLabel("Valor de A: ");
        campoA = new JTextField(10);

        labelB = new JLabel("Valor de B: ");
        campoB = new JTextField(10);

        labelResultado = new JLabel("Resultado: ");
        campoResultado = new JTextField(10);

        labelA.setBounds(400, 100, 300, 25);
        campoA.setBounds(530, 100, 100, 25);

        labelB.setBounds(400, 140, 300, 25);
        campoB.setBounds(530, 140, 100, 25);

        labelResultado.setBounds(400, 180, 300, 25);
        campoResultado.setBounds(530, 180, 100, 25);

        getContentPane().add(labelA);
        getContentPane().add(labelB);
        getContentPane().add(labelResultado);
        getContentPane().add(campoA);
        getContentPane().add(campoB);
        getContentPane().add(campoResultado);
    }

    private void realizarCalculo(int buttonIndex) {
        double a = Double.parseDouble(campoA.getText());
        double b = Double.parseDouble(campoB.getText());
        double resultado = 0;

        switch (buttonIndex) {
            case 0: //Aplicar desconto %
                resultado = a - (a * (b / 100));
                break;
            case 1: //Incrementar % a um valor
                resultado = ((a - b) / a) * 100;
                break;
            case 2: //Amostragem - Quanto X% representa de Y
                resultado = (a * b) / 100;
                break;
            case 3: //Amostragem 2 - Quanto X representa de Y
                resultado = (a * 100 / (100 - b));
                break;
            case 4: //Valor era A e paguei B, qual % de desconto?
                resultado = Math.pow(a, b);
                break;
            case 5: //Variação delta % - diferença % entre valores
                resultado = Math.sqrt(a);
                break;
            case 6: //Valor original?
                resultado = Math.cbrt(a);
                break;
            case 7: //Regra de três
                resultado = Math.sin(a);
                break;
            case 8: //Gerador senha
                resultado = Math.cos(a);
                break;
        }

        campoResultado.setText(String.valueOf(resultado));

        String result = df.format(resultado); // Formata o resultado para duas casas decimais
        campoResultado.setText(result);
    }

    public static void main(String[] args) {
        new Menu();
    }
}

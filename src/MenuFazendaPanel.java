import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFazendaPanel extends JPanel {

    public MenuFazendaPanel(GUI gui, Jogador jogador) {
        setLayout(new GridLayout(4, 1));

        JLabel label = new JLabel("Bem-vindo, " + jogador.getNome());
        add(label);

        JButton novaFazendaButton = new JButton("Nova Fazenda");
        novaFazendaButton.addActionListener(e -> {
            String nomeFazenda = JOptionPane.showInputDialog("Digite o nome da nova fazenda:");
            jogador.criarEAdicionarFazenda(nomeFazenda);
            JOptionPane.showMessageDialog(null, "Fazenda criada com sucesso!");
        });
        add(novaFazendaButton);

        JButton entrarFazendaButton = new JButton("Entrar na Fazenda");
        entrarFazendaButton.addActionListener(e -> {
            String nomeFazenda = JOptionPane.showInputDialog("Digite o nome da fazenda para entrar:");
            Fazenda fazenda = jogador.getFazendaByName(nomeFazenda);
            if (fazenda != null) {
                gui.abrirMenuInteragirFazenda(fazenda);
            } else {
                JOptionPane.showMessageDialog(null, "Fazenda não encontrada.");
            }
        });
        add(entrarFazendaButton);

        JButton sairButton = new JButton("Sair");
        sairButton.addActionListener(e -> System.exit(0));
        add(sairButton);
    }
}

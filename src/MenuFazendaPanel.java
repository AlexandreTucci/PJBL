import javax.swing.*;
import java.awt.*;

public class MenuFazendaPanel extends JPanel {

    public MenuFazendaPanel(GUI gui, Jogador jogador) {
        setLayout(new GridLayout(5, 1));

        JLabel label = new JLabel("Bem-vindo, " + jogador.getNome());
        add(label);

        JButton salvarButton = new JButton("Salvar Jogo");
        salvarButton.addActionListener(e -> {
            if (jogador != null) {
                Persistencia.salvarJogo(jogador, "jogoSalvo.dat");  // Salva o jogo no arquivo "jogoSalvo.dat"
                System.out.println("Jogo salvo com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum jogo em andamento para salvar.");
            }
        });
        add(salvarButton);


        JButton novaFazendaButton = new JButton("Nova Fazenda");
        novaFazendaButton.addActionListener(e -> {
            String nomeFazenda = JOptionPane.showInputDialog("Digite o nome da nova fazenda:");
            if (nomeFazenda == null) {
                // Operação cancelada pelo usuário
                return;
            }
            if (nomeFazenda.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "O nome da fazenda não pode ser vazio.");
                return;
            }
            jogador.criarEAdicionarFazenda(nomeFazenda);
            JOptionPane.showMessageDialog(null, "Fazenda " + nomeFazenda + " criada com sucesso!");
        });
        add(novaFazendaButton);

        JButton entrarFazendaButton = new JButton("Entrar na Fazenda");
        entrarFazendaButton.addActionListener(e -> {
            String nomeFazenda = JOptionPane.showInputDialog("Digite o nome da fazenda para entrar:");
            if (nomeFazenda == null) {
                // Operação cancelada pelo usuário
                return;
            }
            if (nomeFazenda.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "O nome da fazenda não pode ser vazio.");
                return;
            }

            Fazenda fazenda = jogador.getFazendaByName(nomeFazenda);
            if (fazenda != null) {
                gui.abrirMenuInteragirFazenda(fazenda);
            } else {
                JOptionPane.showMessageDialog(null, "Fazenda não encontrada.");
            }
        });
        add(entrarFazendaButton);

        JButton listarFazendasButton = new JButton("Listar Fazendas");
        listarFazendasButton.addActionListener(e -> {
            StringBuilder fazendasList = new StringBuilder("Fazendas:\n");
            for (Fazenda fazenda : jogador.getFazendas()) {
                fazendasList.append(fazenda.getNome()).append("\n");
            }
            JOptionPane.showMessageDialog(null, fazendasList.toString());
        });
        add(listarFazendasButton);

        JButton voltarMenuInicialButton = new JButton("Voltar para menu incial");
        voltarMenuInicialButton.addActionListener(e -> gui.voltarParaMenuInicial());
        add(voltarMenuInicialButton);

        JButton sairButton = new JButton("Sair");
        sairButton.addActionListener(e -> System.exit(0));
        add(sairButton);
    }
}

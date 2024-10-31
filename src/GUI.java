import javax.swing.*;
//import java.awt.*;

public class GUI extends JFrame {
    private Jogador jogador;

    public GUI() {
        setTitle("Jogo de Fazenda");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }

    private void initUI() {
        // Inicia o menu inicial
        setContentPane(new MenuInicialPanel(this));
    }

    public void iniciarJogo(Jogador jogador) {
        this.jogador = jogador;
        setContentPane(new MenuFazendaPanel(this, jogador));
        revalidate();
    }

    public void abrirMenuInteragirFazenda(Fazenda fazenda) {
        setContentPane(new InteragirComFazendaPanel(this, fazenda));
        revalidate();
    }

    public void voltarParaMenuFazenda() {
        setContentPane(new MenuFazendaPanel(this, jogador));
        revalidate();
    }
}

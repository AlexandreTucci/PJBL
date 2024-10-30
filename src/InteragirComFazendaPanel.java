import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class InteragirComFazendaPanel extends JPanel {

    public InteragirComFazendaPanel(GUI gui, Fazenda fazenda) {
        setLayout(new GridLayout(5, 1));

        JLabel label = new JLabel("Interações com a fazenda " + fazenda.getNome());
        add(label);

        JButton adicionarAnimalButton = new JButton("Adicionar Animal");
        adicionarAnimalButton.addActionListener(e -> {
            String tipoAnimal = JOptionPane.showInputDialog("Digite o tipo do animal:");
            String nomeAnimal = JOptionPane.showInputDialog("Digite o nome do animal:");
            int idadeAnimal = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do animal:"));
            fazenda.adicionarAnimal(tipoAnimal, nomeAnimal, idadeAnimal);
            JOptionPane.showMessageDialog(null, "Animal adicionado com sucesso!");
        });
        add(adicionarAnimalButton);

        JButton adicionarPlantaButton = new JButton("Adicionar Planta");
        adicionarPlantaButton.addActionListener(e -> {
            String tipoPlanta = JOptionPane.showInputDialog("Digite o tipo da planta:");
            String nomePlanta = JOptionPane.showInputDialog("Digite o nome da planta:");
            int idadePlanta = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade da planta:"));
            fazenda.adicionarPlanta(tipoPlanta, nomePlanta, idadePlanta);
            JOptionPane.showMessageDialog(null, "Planta adicionada com sucesso!");
        });
        add(adicionarPlantaButton);

        JButton voltarButton = new JButton("Voltar ao Menu da Fazenda");
        voltarButton.addActionListener(e -> gui.voltarParaMenuFazenda());
        add(voltarButton);
    }
}

import javax.swing.*;
import java.awt.*;
//import java.awt.event.ActionEvent;

public class InteragirComFazendaPanel extends JPanel {

    public InteragirComFazendaPanel(GUI gui, Fazenda fazenda) {
        setLayout(new GridLayout(5, 1));

        JLabel label = new JLabel("Interações com a fazenda " + fazenda.getNome());
        add(label);

        JButton adicionarAnimalButton = new JButton("Adicionar Animal");
        adicionarAnimalButton.addActionListener(e -> {
            String tipoAnimal = JOptionPane.showInputDialog("Digite o tipo do animal (Vaca, Porco ou Galinha):");
            // Se o usuário clicar em "Cancelar", nomeFazenda será null. Apenas fecha o diálogo
            if (tipoAnimal == null) {
                return;
            }
            // Verificação de tipo de animal vazio ou não permitido
            tipoAnimal = tipoAnimal.trim();
            if (tipoAnimal.isEmpty() || 
            (!tipoAnimal.equalsIgnoreCase("Vaca") && 
                !tipoAnimal.equalsIgnoreCase("Porco") && 
                !tipoAnimal.equalsIgnoreCase("Galinha"))) {
                JOptionPane.showMessageDialog(null, "Tipo de animal inválido. Escolha entre Vaca, Porco ou Galinha.");
                return;
            }

            int idadeAnimal = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do(a) "+tipoAnimal+":"));
            fazenda.adicionarAnimal(tipoAnimal, null, idadeAnimal);
            JOptionPane.showMessageDialog(null, tipoAnimal+" adicionado com sucesso!");
        });
        add(adicionarAnimalButton);

        JButton adicionarPlantaButton = new JButton("Adicionar Planta");
        adicionarPlantaButton.addActionListener(e -> {
            String tipoPlanta = JOptionPane.showInputDialog("Digite o tipo da planta (Milho, Soja ou Trigo):");
            // Se o usuário clicar em "Cancelar", nomeFazenda será null. Apenas fecha o diálogo
            if (tipoPlanta == null) {
                return;
            }
            // Verificação de tipo de animal vazio ou não permitido
            tipoPlanta = tipoPlanta.trim();
            if (tipoPlanta.isEmpty() || 
<<<<<<< Updated upstream
            (!tipoPlanta.equalsIgnoreCase("Milho") && 
=======
                (!tipoPlanta.equalsIgnoreCase("Milho") && 
>>>>>>> Stashed changes
                !tipoPlanta.equalsIgnoreCase("Soja") && 
                !tipoPlanta.equalsIgnoreCase("Trigo"))) {
                JOptionPane.showMessageDialog(null, "Tipo de planta inválido. Escolha entre Milho, Soja ou Trigo.");
                return;
            }

<<<<<<< Updated upstream
            int idadePlanta = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade da planta "+tipoPlanta+":"));
            fazenda.adicionarPlanta(tipoPlanta, null, idadePlanta);
            JOptionPane.showMessageDialog(null, tipoPlanta+" adicionada com sucesso!");
=======
            int idadePlanta = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade da planta:"));
            fazenda.adicionarPlanta(tipoPlanta, null, idadePlanta);
            JOptionPane.showMessageDialog(null, "Planta adicionada com sucesso!");
>>>>>>> Stashed changes
        });
        add(adicionarPlantaButton);

        JButton voltarButton = new JButton("Voltar ao Menu da Fazenda");
        voltarButton.addActionListener(e -> gui.voltarParaMenuFazenda());
        add(voltarButton);
    }
}

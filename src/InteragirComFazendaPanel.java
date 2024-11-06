import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InteragirComFazendaPanel extends JPanel {

    public InteragirComFazendaPanel(GUI gui, Fazenda fazenda) {
        setLayout(new GridLayout(8, 1));

        JLabel label = new JLabel("Interações com a fazenda " + fazenda.getNome());
        add(label);

        // Botão para adicionar animal
        JButton adicionarAnimalButton = new JButton("Adicionar Animal");
        adicionarAnimalButton.addActionListener(e -> {
            String tipoAnimal = JOptionPane.showInputDialog("Digite o tipo do animal (Vaca, Galinha, Porco):");
            String nomeAnimal = JOptionPane.showInputDialog("Digite o nome do animal:");
            int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do animal:"));
            fazenda.adicionarAnimal(tipoAnimal, nomeAnimal, idade);
            mostrarMensagem("Animal adicionado", "O animal " + nomeAnimal + " foi adicionado com sucesso!");
        });
        add(adicionarAnimalButton);

        // Botão para remover animal
        JButton removerAnimalButton = new JButton("Remover Animal");
        removerAnimalButton.addActionListener(e -> {
            String tipoAnimal = JOptionPane.showInputDialog("Digite o tipo do animal que deseja remover (Vaca, Galinha, Porco):");
            fazenda.removerAnimal(tipoAnimal);
            mostrarMensagem("Animal removido", "O animal do tipo " + tipoAnimal + " foi removido com sucesso.");
        });
        add(removerAnimalButton);

        // Botão para adicionar planta
        JButton adicionarPlantaButton = new JButton("Adicionar Planta");
        adicionarPlantaButton.addActionListener(e -> {
            String tipoPlanta = JOptionPane.showInputDialog("Digite o tipo da planta (Milho, Soja, Trigo):");
            String nomePlanta = JOptionPane.showInputDialog("Digite o nome da planta:");
            int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade da planta:"));
            fazenda.adicionarPlanta(tipoPlanta, nomePlanta, idade);
            mostrarMensagem("Planta adicionada", "A planta " + nomePlanta + " foi adicionada com sucesso!");
        });
        add(adicionarPlantaButton);

        // Botão para listar animais
        JButton listarAnimaisButton = new JButton("Listar Animais");
        listarAnimaisButton.addActionListener(e -> {
            StringBuilder animaisList = new StringBuilder("Animais na fazenda:\n");
            for (Animal animal : fazenda.getAnimais()) {
                animaisList.append(animal.getTipo()).append(" ").append(animal.getNome())
                    .append(" (Idade: ").append(animal.getIdade()).append(" anos)\n");
            }
            mostrarMensagem("Lista de Animais", animaisList.toString());
        });
        add(listarAnimaisButton);

        // Botão para listar plantas
        JButton listarPlantasButton = new JButton("Listar Plantas");
        listarPlantasButton.addActionListener(e -> {
            StringBuilder plantasList = new StringBuilder("Plantas na fazenda:\n");
            for (Planta planta : fazenda.getPlantas()) {
                plantasList.append(planta.getTipo()).append(" ").append(planta.getNome())
                    .append(" (Idade: ").append(planta.getIdade()).append(" anos)\n");
            }
            mostrarMensagem("Lista de Plantas", plantasList.toString());
        });
        add(listarPlantasButton);

        // Botão para exibir informações detalhadas da fazenda
        JButton infoFazendaButton = new JButton("Informações da Fazenda");
        infoFazendaButton.addActionListener(e -> {
            String info = "Número de Animais: " + fazenda.getAnimais().length + "\n" +
                          "Número de Plantas: " + fazenda.getPlantas().length;
            mostrarMensagem("Informações da Fazenda", info);
        });
        add(infoFazendaButton);

        // Botão para retornar ao menu principal da fazenda
        JButton voltarButton = new JButton("Voltar ao Menu da Fazenda");
        voltarButton.addActionListener(e -> gui.voltarParaMenuFazenda());
        add(voltarButton);
    }

    // Método para mostrar uma nova janela com a mensagem
    private void mostrarMensagem(String titulo, String mensagem) {
        JDialog dialog = new JDialog();
        dialog.setTitle(titulo);
        dialog.setSize(300, 200);
        dialog.setLocationRelativeTo(null);
        
        JTextArea textArea = new JTextArea(mensagem);
        textArea.setEditable(false);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        dialog.add(new JScrollPane(textArea));
        
        JButton fecharButton = new JButton("Fechar");
        fecharButton.addActionListener(e -> dialog.dispose());
        
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        panel.add(fecharButton, BorderLayout.SOUTH);

        dialog.add(panel);
        dialog.setVisible(true);
    }
}

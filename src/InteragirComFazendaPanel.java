import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class InteragirComFazendaPanel extends JPanel {

    public InteragirComFazendaPanel(GUI gui, Fazenda fazenda) {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Interações com a fazenda " + fazenda.getNome(), SwingConstants.CENTER);
        add(label, BorderLayout.NORTH);

        // Painel principal com duas colunas
        JPanel colunasPanel = new JPanel(new GridLayout(1, 2, 10, 10));

        // Coluna da esquerda
        JPanel colunaEsquerda = new JPanel(new GridLayout(4, 1, 5, 5));
        JButton adicionarAnimalButton = new JButton("Adicionar Animal");
        adicionarAnimalButton.addActionListener(e -> adicionarAnimal(fazenda));
        colunaEsquerda.add(adicionarAnimalButton);

        JButton removerAnimalButton = new JButton("Remover Animal");
        removerAnimalButton.addActionListener(e -> removerAnimal(fazenda));
        colunaEsquerda.add(removerAnimalButton);

        JButton listarAnimaisButton = new JButton("Listar Animais");
        listarAnimaisButton.addActionListener(e -> listarAnimais(fazenda));
        colunaEsquerda.add(listarAnimaisButton);

        JButton infoFazendaButton = new JButton("Informações da Fazenda");
        infoFazendaButton.addActionListener(e -> infoFazenda(fazenda));
        colunaEsquerda.add(infoFazendaButton);

        // Coluna da direita
        JPanel colunaDireita = new JPanel(new GridLayout(4, 1, 5, 5));
        JButton adicionarPlantaButton = new JButton("Adicionar Planta");
        adicionarPlantaButton.addActionListener(e -> adicionarPlanta(fazenda));
        colunaDireita.add(adicionarPlantaButton);

        JButton colherPlantaButton = new JButton("Colher Planta");
        colherPlantaButton.addActionListener(e -> colherPlanta(fazenda));
        colunaDireita.add(colherPlantaButton);

        JButton listarPlantasButton = new JButton("Listar Plantas");
        listarPlantasButton.addActionListener(e -> listarPlantas(fazenda));
        colunaDireita.add(listarPlantasButton);

        JButton voltarButton = new JButton("Voltar ao Menu da Fazenda");
        voltarButton.addActionListener(e -> gui.voltarParaMenuFazenda());
        colunaDireita.add(voltarButton);

        colunasPanel.add(colunaEsquerda);
        colunasPanel.add(colunaDireita);

        add(colunasPanel, BorderLayout.CENTER);
    }

    private void adicionarAnimal(Fazenda fazenda) {
        String tipoAnimal = JOptionPane.showInputDialog("Digite o tipo do animal (Vaca, Galinha, Porco):");
        if (tipoAnimal == null || tipoAnimal.trim().isEmpty()) return;

        String nomeAnimal = JOptionPane.showInputDialog("Digite o nome do animal:");
        if (nomeAnimal == null || nomeAnimal.trim().isEmpty()) return;

        String idadeStr = JOptionPane.showInputDialog("Digite a idade do animal:");
        if (idadeStr == null || idadeStr.trim().isEmpty()) return;
        
        try {
            int idade = Integer.parseInt(idadeStr);
            fazenda.adicionarAnimal(tipoAnimal, nomeAnimal, idade);
            mostrarMensagem("Animal adicionado", "O animal " + nomeAnimal + " foi adicionado com sucesso!");
        } catch (NumberFormatException e) {
            mostrarMensagem("Erro", "Idade inválida. Por favor, insira um número.");
        }
    }

    private void removerAnimal(Fazenda fazenda) {
        String tipoAnimal = JOptionPane.showInputDialog("Digite o tipo do animal que deseja remover (Vaca, Galinha, Porco):");
        if (tipoAnimal == null || tipoAnimal.trim().isEmpty()) return;

        fazenda.removerAnimal(tipoAnimal);
        mostrarMensagem("Animal removido", "O animal do tipo " + tipoAnimal + " foi removido com sucesso.");
    }

    private void listarAnimais(Fazenda fazenda) {
        StringBuilder animaisList = new StringBuilder("Animais na fazenda:\n");
        for (Animal animal : fazenda.getAnimais()) {
            animaisList.append(animal.getTipo()).append(" ").append(animal.getNome())
                .append(" (Idade: ").append(animal.getIdade()).append(" anos)\n");
        }
        mostrarMensagem("Lista de Animais", animaisList.toString());
    }

    private void infoFazenda(Fazenda fazenda) {
        String info = "Número de Animais: " + fazenda.getAnimais().size() + "\n" +
                      "Número de Plantas: " + fazenda.getPlantas().size();
        mostrarMensagem("Informações da Fazenda", info);
    }

    private void adicionarPlanta(Fazenda fazenda) {
        String tipoPlanta = JOptionPane.showInputDialog("Digite o tipo da planta (Milho, Soja, Trigo):");
        if (tipoPlanta == null || tipoPlanta.trim().isEmpty()) return;

        String nomePlanta = JOptionPane.showInputDialog("Digite o nome da planta:");
        if (nomePlanta == null || nomePlanta.trim().isEmpty()) return;

        String idadeStr = JOptionPane.showInputDialog("Digite a idade da planta:");
        if (idadeStr == null || idadeStr.trim().isEmpty()) return;
        
        try {
            int idade = Integer.parseInt(idadeStr);
            fazenda.adicionarPlanta(tipoPlanta, nomePlanta, idade);
            mostrarMensagem("Planta adicionada", "A planta " + nomePlanta + " foi adicionada com sucesso!");
        } catch (NumberFormatException e) {
            mostrarMensagem("Erro", "Idade inválida. Por favor, insira um número.");
        }
    }

    private void colherPlanta(Fazenda fazenda) {
        String tipoPlanta = JOptionPane.showInputDialog("Digite o tipo da planta que deseja colher (Milho, Soja, Trigo):");
        if (tipoPlanta == null || tipoPlanta.trim().isEmpty()) return;

        fazenda.colherPlanta(tipoPlanta);
        mostrarMensagem("Planta colhida", "A planta do tipo " + tipoPlanta + " foi colhida com sucesso.");
    }

    private void listarPlantas(Fazenda fazenda) {
        StringBuilder plantasList = new StringBuilder("Plantas na fazenda:\n");
        for (Planta planta : fazenda.getPlantas()) {
            plantasList.append(planta.getTipo()).append(" ").append(planta.getNome())
                .append(" (Idade: ").append(planta.getIdade()).append(" anos)\n");
        }
        mostrarMensagem("Lista de Plantas", plantasList.toString());
    }

    private void mostrarMensagem(String titulo, String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
}

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

        // Coluna da esquerda (Animais)
        JPanel colunaEsquerda = new JPanel(new GridLayout(6, 1, 5, 5));  // Alterado para 6 linhas para incluir novos botões
        JButton adicionarAnimalButton = new JButton("Adicionar Animal");
        adicionarAnimalButton.addActionListener(e -> adicionarAnimal(fazenda));
        colunaEsquerda.add(adicionarAnimalButton);

        JButton removerAnimalButton = new JButton("Remover Animal");
        removerAnimalButton.addActionListener(e -> removerAnimal(fazenda));
        colunaEsquerda.add(removerAnimalButton);

        JButton listarAnimaisButton = new JButton("Listar Animais");
        listarAnimaisButton.addActionListener(e -> listarAnimais(fazenda));
        colunaEsquerda.add(listarAnimaisButton);

        JButton alimentarAnimalButton = new JButton("Alimentar Animal");  // Novo botão para alimentar animal
        alimentarAnimalButton.addActionListener(e -> alimentarAnimal(fazenda));
        colunaEsquerda.add(alimentarAnimalButton);

        JButton procriarAnimalButton = new JButton("Procriar Animal");  // Novo botão para procriar animal
        procriarAnimalButton.addActionListener(e -> procriarAnimal(fazenda));
        colunaEsquerda.add(procriarAnimalButton);

        JButton infoFazendaButton = new JButton("Informações da Fazenda");
        infoFazendaButton.addActionListener(e -> infoFazenda(fazenda));
        colunaEsquerda.add(infoFazendaButton);

        // Coluna da direita (Plantas)
        JPanel colunaDireita = new JPanel(new GridLayout(6, 1, 5, 5));  // Alterado para 6 linhas para incluir novos botões
        JButton adicionarPlantaButton = new JButton("Adicionar Planta");
        adicionarPlantaButton.addActionListener(e -> adicionarPlanta(fazenda));
        colunaDireita.add(adicionarPlantaButton);

        JButton colherPlantaButton = new JButton("Colher Planta");
        colherPlantaButton.addActionListener(e -> colherPlanta(fazenda));
        colunaDireita.add(colherPlantaButton);

        JButton listarPlantasButton = new JButton("Listar Plantas");
        listarPlantasButton.addActionListener(e -> listarPlantas(fazenda));
        colunaDireita.add(listarPlantasButton);

        JButton regarPlantaButton = new JButton("Regar Planta");  // Novo botão para regar planta
        regarPlantaButton.addActionListener(e -> regarPlanta(fazenda));
        colunaDireita.add(regarPlantaButton);

        JButton voltarButton = new JButton("Voltar ao Menu da Fazenda");
        voltarButton.addActionListener(e -> gui.voltarParaMenuFazenda());
        colunaDireita.add(voltarButton);

        colunasPanel.add(colunaEsquerda);
        colunasPanel.add(colunaDireita);

        add(colunasPanel, BorderLayout.CENTER);
    }

    // Método para adicionar um novo animal na fazenda
    private void adicionarAnimal(Fazenda fazenda) {
        String tipoAnimal = JOptionPane.showInputDialog("Digite o tipo do animal (Vaca, Galinha, Porco):");
        if (tipoAnimal == null || tipoAnimal.trim().isEmpty()) return;

        // Verificação de tipo válido
        if (!tipoAnimal.equalsIgnoreCase("Vaca") && !tipoAnimal.equalsIgnoreCase("Galinha") && !tipoAnimal.equalsIgnoreCase("Porco")) {
            mostrarMensagem("Erro", "Tipo de animal inválido. Apenas Vaca, Galinha ou Porco são permitidos.");
            return;
        }

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

    // Método para remover um animal da fazenda
    private void removerAnimal(Fazenda fazenda) {
        String tipoAnimal = JOptionPane.showInputDialog("Digite o tipo do animal que deseja remover (Vaca, Galinha, Porco):");
        if (tipoAnimal == null || tipoAnimal.trim().isEmpty()) return;

        Animal animal = fazenda.getAnimalByTipo(tipoAnimal);
        if (animal == null) {
            mostrarMensagem("Erro", "Não existe nenhum animal do tipo " + tipoAnimal + " na fazenda.");
            return;
        }

        fazenda.removerAnimal(tipoAnimal);
        mostrarMensagem("Animal removido", "O animal do tipo " + tipoAnimal + " foi removido com sucesso.");
    }

    // Método para listar os animais na fazenda
    private void listarAnimais(Fazenda fazenda) {
        StringBuilder animaisList = new StringBuilder("Animais na fazenda:\n");
        for (Animal animal : fazenda.getAnimais()) {
            animaisList.append(animal.getTipo()).append(" ").append(animal.getNome())
                .append(" (Idade: ").append(animal.getIdade()).append(" anos)\n");
        }
        mostrarMensagem("Lista de Animais", animaisList.toString());
    }

    // Método para alimentar um animal específico na fazenda
    private void alimentarAnimal(Fazenda fazenda) {
        String nomeAnimal = JOptionPane.showInputDialog("Digite o nome do animal para alimentar:");
        Animal animal = fazenda.getAnimalByName(nomeAnimal);
        if (animal != null) {
            animal.alimentar(fazenda);
            mostrarMensagem("Animal alimentado", nomeAnimal + " foi alimentado com sucesso!");
        } else {
            mostrarMensagem("Erro", "Animal não encontrado.");
        }
    }

    // Método para procriar um animal específico na fazenda
    private void procriarAnimal(Fazenda fazenda) {
        String nomeAnimal = JOptionPane.showInputDialog("Digite o nome do animal para procriar:");
        Animal animal = fazenda.getAnimalByName(nomeAnimal);
        if (animal != null) {
            animal.procriar(fazenda);
            mostrarMensagem("Procriação", nomeAnimal + " procriou com sucesso!");
        } else {
            mostrarMensagem("Erro", "Animal não encontrado.");
        }
    }

    // Método para exibir informações gerais da fazenda
    private void infoFazenda(Fazenda fazenda) {
        String info = "Número de Animais: " + fazenda.getAnimais().size() + "\n" +
                      "Número de Plantas: " + fazenda.getPlantas().size();
        mostrarMensagem("Informações da Fazenda", info);
    }

    // Método para adicionar uma nova planta na fazenda
    private void adicionarPlanta(Fazenda fazenda) {
        String tipoPlanta = JOptionPane.showInputDialog("Digite o tipo da planta (Milho, Soja, Trigo):");
        if (tipoPlanta == null || tipoPlanta.trim().isEmpty()) return;

        // Verificação de tipo válido
        if (!tipoPlanta.equalsIgnoreCase("Milho") && !tipoPlanta.equalsIgnoreCase("Soja") && !tipoPlanta.equalsIgnoreCase("Trigo")) {
            mostrarMensagem("Erro", "Tipo de planta inválido. Apenas Milho, Soja ou Trigo são permitidos.");
            return;
        }

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

    // Método para colher uma planta específica na fazenda
    private void colherPlanta(Fazenda fazenda) {
        String tipoPlanta = JOptionPane.showInputDialog("Digite o tipo da planta que deseja colher (Milho, Soja, Trigo):");
        if (tipoPlanta == null || tipoPlanta.trim().isEmpty()) return;

        // Verificação de existência da planta
        Planta planta = fazenda.getPlantaByTipo(tipoPlanta);
        if (planta == null) {
            mostrarMensagem("Erro", "Não existe nenhuma planta do tipo " + tipoPlanta + " na fazenda.");
            return;
        }

        fazenda.colherPlanta(tipoPlanta);
        mostrarMensagem("Planta colhida", "A planta do tipo " + tipoPlanta + " foi colhida com sucesso.");
    }

    // Método para listar as plantas na fazenda
    private void listarPlantas(Fazenda fazenda) {
        StringBuilder plantasList = new StringBuilder("Plantas na fazenda:\n");
        for (Planta planta : fazenda.getPlantas()) {
            plantasList.append(planta.getTipo()).append(" ").append(planta.getNome())
                .append(" (Idade: ").append(planta.getIdade()).append(" anos)\n");
        }
        mostrarMensagem("Lista de Plantas", plantasList.toString());
    }

    // Método para regar uma planta específica na fazenda
    private void regarPlanta(Fazenda fazenda) {
        String nomePlanta = JOptionPane.showInputDialog("Digite o nome da planta para regar:");
        Planta planta = fazenda.getPlantaByName(nomePlanta);
        if (planta != null) {
            planta.regar();
            mostrarMensagem("Planta regada", nomePlanta + " foi regada com sucesso!");
        } else {
            mostrarMensagem("Erro", "Planta não encontrada.");
        }
    }

    // Método auxiliar para exibir uma mensagem de diálogo
    private void mostrarMensagem(String titulo, String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
}

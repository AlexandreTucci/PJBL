import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InteragirComFazendaPanel extends JPanel {
    public InteragirComFazendaPanel(GUI gui, Fazenda fazenda) {
        setLayout(new BorderLayout());
        setBackground(new Color(240, 230, 140)); // Fundo amarelo do painel

        JLabel label = new JLabel("Interações com a fazenda " + fazenda.getNome(), SwingConstants.CENTER);
        add(label, BorderLayout.NORTH);

        // Painel principal com duas colunas
        JPanel colunasPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        colunasPanel.setBackground(new Color(240, 230, 140));

        // Coluna da esquerda (Animais)
        JPanel colunaEsquerda = new JPanel(new GridLayout(6, 1, 5, 5));
        colunaEsquerda.setBackground(new Color(240, 230, 140));
        
        // Configurações de estilo para os botões
        JButton adicionarAnimalButton = criarBotaoVerde("Adicionar Animal", e -> adicionarAnimal(fazenda));
        colunaEsquerda.add(adicionarAnimalButton);

        JButton removerAnimalButton = criarBotaoVerde("Remover Animal", e -> removerAnimal(fazenda));
        colunaEsquerda.add(removerAnimalButton);

        JButton listarAnimaisButton = criarBotaoVerde("Listar Animais", e -> listarAnimais(fazenda));
        colunaEsquerda.add(listarAnimaisButton);

        JButton alimentarAnimalButton = criarBotaoVerde("Alimentar Animal", e -> alimentarAnimal(fazenda));
        colunaEsquerda.add(alimentarAnimalButton);

        JButton procriarAnimalButton = criarBotaoVerde("Procriar Animal", e -> procriarAnimal(fazenda));
        colunaEsquerda.add(procriarAnimalButton);

        JButton infoFazendaButton = criarBotaoVerde("Informações da Fazenda", e -> infoFazenda(fazenda));
        colunaEsquerda.add(infoFazendaButton);

        // Coluna da direita (Plantas)
        JPanel colunaDireita = new JPanel(new GridLayout(6, 1, 5, 5));
        colunaDireita.setBackground(new Color(240, 230, 140));

        JButton adicionarPlantaButton = criarBotaoVerde("Adicionar Planta", e -> adicionarPlanta(fazenda));
        colunaDireita.add(adicionarPlantaButton);

        JButton colherPlantaButton = criarBotaoVerde("Colher Planta", e -> colherPlanta(fazenda));
        colunaDireita.add(colherPlantaButton);

        JButton listarPlantasButton = criarBotaoVerde("Listar Plantas", e -> listarPlantas(fazenda));
        colunaDireita.add(listarPlantasButton);

        JButton regarPlantaButton = criarBotaoVerde("Regar Planta", e -> regarPlanta(fazenda));
        colunaDireita.add(regarPlantaButton);

        JButton voltarButton = criarBotaoVerde("Voltar ao Menu da Fazenda", e -> gui.voltarParaMenuFazenda());
        colunaDireita.add(voltarButton);

        colunasPanel.add(colunaEsquerda);
        colunasPanel.add(colunaDireita);

        add(colunasPanel, BorderLayout.CENTER);
    }

    private JButton criarBotaoVerde(String texto, ActionListener acao) {
        JButton botao = new JButton(texto);
        botao.setBackground(new Color(50, 205, 50));
        botao.setForeground(Color.BLACK); // Texto branco
        botao.setFocusPainted(false);
        botao.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2, true)); // Borda arredondada
        botao.setOpaque(true);
        botao.setBorderPainted(false);
        botao.setFont(new Font("Arial", Font.BOLD, 14));
        botao.addActionListener(acao);
        return botao;
    }
    private void adicionarAnimal(Fazenda fazenda){
        String tipoAnimal = JOptionPane.showInputDialog("Digite o tipo do animal (Vaca, Galinha, Porco):");
        if (tipoAnimal == null || tipoAnimal.trim().isEmpty()) return;

        if (!tipoAnimal.equalsIgnoreCase("Vaca") && !tipoAnimal.equalsIgnoreCase("Galinha") && !tipoAnimal.equalsIgnoreCase("Porco")) {
            mostrarMensagem("Erro", "Tipo de animal inválido. Apenas Vaca, Galinha ou Porco são permitidos.");
            return;
        }

        String idadeStr = JOptionPane.showInputDialog("Digite a idade do animal:");
        if (idadeStr == null || idadeStr.trim().isEmpty()) return;

        try {
            int idade = Integer.parseInt(idadeStr);

            // Verificação de idade válida
            if (idade < 0 || idade > 100) { // Exemplo de faixa válida de 0 a 100 anos
                throw new IdadeInvalidaException(idade);
            }

            fazenda.adicionarAnimal(tipoAnimal, idade);
            mostrarMensagem("Animal adicionado", "O animal do tipo " + tipoAnimal + " foi adicionado com sucesso!");
        } catch (NumberFormatException e) {
            mostrarMensagem("Erro", "Idade inválida. Por favor, insira um número.");
        } catch (IdadeInvalidaException e) {
            mostrarMensagem("Erro", e.toString());
        }
    }

    private void removerAnimal(Fazenda fazenda) {
        String tipoAnimal = JOptionPane.showInputDialog("Digite o tipo do animal que deseja remover (Vaca, Galinha, Porco):");
        if (tipoAnimal == null || tipoAnimal.trim().isEmpty()) return;
        ArrayList<Animal> animais = fazenda.getAnimaisByTipo(tipoAnimal);
        if (animais != null && !animais.isEmpty()) {
            for (Animal animal : animais) {
                animal.abater(fazenda);
            }
            mostrarMensagem("Animal removido", "O animal do tipo " + tipoAnimal + " foi removido com sucesso.");
        } else {
            mostrarMensagem("Erro", "Animal do tipo " + tipoAnimal + " não encontrada.");
        }
    }

    private void listarAnimais(Fazenda fazenda) {
        StringBuilder animaisList = new StringBuilder("Animais na fazenda:\n");
        for (Animal animal : fazenda.getAnimais()) {
            animaisList.append(animal.getTipo()).append(" (Idade: ").append(animal.getIdade()).append(" anos)\n");
        }
        mostrarMensagem("Lista de Animais", animaisList.toString());
    }

    // Método para alimentar um animal específico na fazenda por tipo
    private void alimentarAnimal(Fazenda fazenda) {
        String tipoAnimal = JOptionPane.showInputDialog("Digite o tipo do animal para alimentar (Vaca, Galinha, Porco):");
        if (tipoAnimal == null || tipoAnimal.trim().isEmpty()) return;

        ArrayList<Animal> animais = fazenda.getAnimaisByTipo(tipoAnimal);
        if (animais != null && !animais.isEmpty()) {
            for (Animal animal : animais) {
                animal.alimentar(); // Chama o método alimentar na instância específica do animal
            }
            mostrarMensagem("Animal alimentado", tipoAnimal + " foi alimentado com sucesso!");
        } else {
            mostrarMensagem("Erro", "Animal do tipo " + tipoAnimal + " não encontrado.");
        }
    }

    // Método para procriar um animal específico na fazenda por tipo
    private void procriarAnimal(Fazenda fazenda) {
        String tipoAnimal = JOptionPane.showInputDialog("Digite o tipo do animal para procriar (Vaca, Galinha, Porco):");
        if (tipoAnimal == null || tipoAnimal.trim().isEmpty()) return;

        ArrayList<Animal> animais = fazenda.getAnimaisByTipo(tipoAnimal);
        if (animais != null && !animais.isEmpty()) {
            for (Animal animal : animais) {
                animal.procriar(fazenda); // Chama o método alimentar na instância específica do animal
            }
            mostrarMensagem("Procriação", "Um novo " + tipoAnimal + " foi procriado com sucesso!");
        } else {
            mostrarMensagem("Erro", "Animal do tipo " + tipoAnimal + " não encontrado.");
        }
    }

    private void infoFazenda(Fazenda fazenda) {
        String info =   "Fazenda: " + fazenda.getNome() + "\n" +
                        "Dono: " + fazenda.getNomeDono() + "\n" +
                        "Número de Animais: " + fazenda.getAnimais().size() + "\n" +
                        "Número de Plantas: " + fazenda.getPlantas().size();
        mostrarMensagem("Informações da Fazenda", info);
    }

    private void adicionarPlanta(Fazenda fazenda) {
        String tipoPlanta = JOptionPane.showInputDialog("Digite o tipo da planta (Milho, Soja, Trigo):");
        if (tipoPlanta == null || tipoPlanta.trim().isEmpty()) return;

        if (!tipoPlanta.equalsIgnoreCase("Milho") && !tipoPlanta.equalsIgnoreCase("Soja") && !tipoPlanta.equalsIgnoreCase("Trigo")) {
            mostrarMensagem("Erro", "Tipo de planta inválido. Apenas Milho, Soja ou Trigo são permitidos.");
            return;
        }

        String idadeStr = JOptionPane.showInputDialog("Digite a idade da planta:");
        if (idadeStr == null || idadeStr.trim().isEmpty()) return;

        try {
            int idade = Integer.parseInt(idadeStr);
            fazenda.adicionarPlanta(tipoPlanta, idade);
            mostrarMensagem("Planta adicionada", "A planta do tipo " + tipoPlanta + " foi adicionada com sucesso!");
        } catch (NumberFormatException e) {
            mostrarMensagem("Erro", "Idade inválida. Por favor, insira um número.");
        }
    }

    private void colherPlanta(Fazenda fazenda) {
        String tipoPlanta = JOptionPane.showInputDialog("Digite o tipo da planta que deseja colher (Milho, Soja, Trigo):");
        if (tipoPlanta == null || tipoPlanta.trim().isEmpty()) return;
        ArrayList<Planta> plantas = fazenda.getPlantaByTipo(tipoPlanta);
        if (plantas != null && !plantas.isEmpty()) {
            for (Planta planta : plantas) {
                planta.colher(fazenda); // Chama o método alimentar na instância específica do animal }
            }
        mostrarMensagem("Planta colhida", "A planta do tipo " + tipoPlanta + " foi colhida com sucesso.");
        }else {
            mostrarMensagem("Erro", "Planta do tipo " + tipoPlanta + " não encontrada.");
        }
    }

    private void listarPlantas(Fazenda fazenda) {
        StringBuilder plantasList = new StringBuilder("Plantas na fazenda:\n");
        for (Planta planta : fazenda.getPlantas()) {
            plantasList.append(planta.getTipo()).append(" (Idade: ").append(planta.getIdade()).append(" anos)\n");
        }
        mostrarMensagem("Lista de Plantas", plantasList.toString());
    }

    private void regarPlanta(Fazenda fazenda) {
        String tipoPlanta = JOptionPane.showInputDialog("Digite o tipo da planta para regar (Milho, Soja, Trigo):");
        if (tipoPlanta == null || tipoPlanta.trim().isEmpty()) return;

        ArrayList<Planta> plantas = fazenda.getPlantaByTipo(tipoPlanta);
        if (plantas != null && !plantas.isEmpty()) {
            for (Planta planta : plantas) {
                planta.regar(); // Chama o método alimentar na instância específica do animal }
            }
            mostrarMensagem("Planta regada", tipoPlanta + " foi regada com sucesso!");
        } else {
            mostrarMensagem("Erro", "Planta do tipo " + tipoPlanta + " não encontrada.");
        }
    }

    private void mostrarMensagem(String titulo, String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
}

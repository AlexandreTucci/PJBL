import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Cria e executa a interface gráfica na thread de eventos do Swing para garantir que seja thread-safe
        SwingUtilities.invokeLater(() -> {
            GUI gui = new GUI(); // Cria a janela principal do jogo
            gui.setVisible(true); // Define a janela como visível
        });

        Scanner teclado = new Scanner(System.in);
        Jogador jogador = null;

        while (true) {
            if (jogador == null) {
                jogador = menuInicial(teclado); // Processa o menu inicial
            }
        }
    }

    public static Jogador menuInicial(Scanner teclado) {
        int option;
        Jogador jogador = null;

        do {
            System.out.println("(1) Novo Jogo");
            System.out.println("(2) Sair");
            System.out.print("Escolha uma opção: ");
            option = teclado.nextInt();

            switch (option) {
                case 1:
                    jogador = criacaoDoPersonagem(teclado);
                    menuFazenda(jogador, teclado); // Chama o menu da fazenda
                    break;
                case 2:
                    sairDoJogo();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (option != 1);

        return jogador;
    }

    public static void menuFazenda(Jogador jogador, Scanner teclado) {
        while (true) { // Loop contínuo
            System.out.println("(1) Nova Fazenda");
            System.out.println("(2) Entrar Fazenda");
            System.out.println("(3) Sair");
            System.out.print("Escolha uma opção: ");
            int option = teclado.nextInt();

            switch (option) {
                case 1:
                    criacaoDaFazenda(jogador, teclado);
                    break;
                case 2:
                    entrarNaFazenda(jogador, teclado);
                    break;
                case 3:
                    sairDoJogo();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    public static void entrarNaFazenda(Jogador jogador, Scanner teclado) {
        System.out.print("Nome da fazenda para entrar: ");
        String nomeFazenda = teclado.next();
        Fazenda fazenda = jogador.getFazendaByName(nomeFazenda);
        if (fazenda != null) {
            menuInteragirComFazenda(fazenda, jogador, teclado);
        } else {
            System.out.println("Fazenda não encontrada.");
        }
    }

    public static void menuInteragirComFazenda(Fazenda fazenda, Jogador jogador, Scanner teclado) {
        int option;

        do {
            System.out.println("\nOpções para " + fazenda.getNome() + ":");
            System.out.println("(1) Mostrar informações da fazenda");
            System.out.println("(2) Adicionar animal");
            System.out.println("(3) Adicionar planta");
            System.out.println("(4) Interagir com animal");
            System.out.println("(5) Interagir com planta");
            System.out.println("(6) Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            option = teclado.nextInt();

            switch (option) {
                case 1:
                    fazenda.InfoFazenda();
                    break;
                case 2:
                    adicionarAnimal(fazenda, teclado);
                    break;
                case 3:
                    adicionarPlanta(fazenda, teclado);
                    break;
                case 4:
                    interagirComAnimal(fazenda, teclado);
                    break;
                case 5:
                    interagirComPlanta(fazenda, teclado);
                    break;
                case 6:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (option != 6); // Sai do loop e volta ao menu principal ao escolher a opção 6
    }

    public static Jogador criacaoDoPersonagem(Scanner teclado) {
        System.out.print("Digite o nome do jogador: ");
        String nomeDoJogador = teclado.next();
        Jogador jogador = new Jogador(nomeDoJogador);
        System.out.println("Personagem criado com sucesso.");
        return jogador;
    }

    public static void criacaoDaFazenda(Jogador jogador, Scanner teclado) {
        System.out.print("Digite o nome da nova fazenda: ");
        String nomeDaFazenda = teclado.next();
        jogador.criarEAdicionarFazenda(nomeDaFazenda);
        System.out.println("Fazenda criada com sucesso.");
    }

    public static void adicionarAnimal(Fazenda fazenda, Scanner teclado) {
        System.out.print("Digite o tipo do animal: ");
        String tipoAnimal = teclado.next();
        // System.out.print("Digite o nome do animal: ");
        // String nomeAnimal = teclado.next();
        System.out.print("Digite a idade do animal: ");
        int idadeAnimal = teclado.nextInt();
        fazenda.adicionarAnimal(tipoAnimal, /*nomeAnimal,*/ idadeAnimal);
        System.out.println("Animal adicionado com sucesso.");
    }

    public static void adicionarPlanta(Fazenda fazenda, Scanner teclado) {
        System.out.print("Digite o tipo da planta: ");
        String tipoPlanta = teclado.next();
        // System.out.print("Digite o nome da planta: ");
        // String nomePlanta = teclado.next();
        System.out.print("Digite a idade da planta: ");
        int idadePlanta = teclado.nextInt();
        fazenda.adicionarPlanta(tipoPlanta, /*nomePlanta,*/ idadePlanta);
        System.out.println("Planta adicionada com sucesso.");
    }

    // public static void interagirComAnimal(Fazenda fazenda, Scanner teclado) {
    //     System.out.print("Digite o nome do animal para interagir: ");
    //     String nomeAnimal = teclado.next();
    //     Animal animal = fazenda.getAnimalByName(nomeAnimal);

    //     if (animal != null) {
    //         menuInteracaoAnimal(animal,fazenda, teclado); // Chama o submenu de interação com o animal
    //     } else {
    //         System.out.println("Animal não encontrado.");
    //     }
    // }
    // public static void interagirComPlanta(Fazenda fazenda, Scanner teclado) {
    //     System.out.print("Digite o nome da planta para interagir: ");
    //     String nomePlanta = teclado.next();
    //     Planta planta = fazenda.getPlantaByName(nomePlanta);
    //     if (planta != null) {
    //         menuInteracaoPlanta(planta,fazenda, teclado);
    //     } else {
    //         System.out.println("Planta não encontrada.");
    //     }
    // }

    public static void interagirComAnimal(Fazenda fazenda, Scanner teclado) {
        System.out.print("Digite o tipo do animal para interagir: ");
        String tipoAnimal = teclado.next();

        ArrayList<Animal> animaisTipo = fazenda.getAnimaisByTipo(tipoAnimal);

        if (animaisTipo.size() > 0) {
            Animal animal = animaisTipo.get(0); // Interage com o primeiro animal do tipo
            menuInteracaoAnimal(animal, fazenda, teclado); // Chama o submenu de interação com o animal
        } else {
            System.out.println("Nenhum animal desse tipo encontrado.");
        }
    }

    public static void interagirComPlanta(Fazenda fazenda, Scanner teclado) {
        System.out.print("Digite o nome da planta para interagir: ");
        String tipoPlanta = teclado.next();

        ArrayList<Planta> plantasTipo = fazenda.getPlantaByTipo(tipoPlanta);

        if (plantasTipo.size() > 0) {
            Planta planta = plantasTipo.get(0); // Interage com o primeiro animal do tipo
            menuInteracaoPlanta(planta, fazenda, teclado); // Chama o submenu de interação com o animal
        } else {
            System.out.println("Nenhum animal desse tipo encontrado.");
        }
    }

    public static void menuInteracaoAnimal(Animal animal,Fazenda fazenda, Scanner teclado) {
        int option;

        do {
            System.out.println("\nInteragindo com o animal: " /*+ animal.getNome()*/ + " (Tipo: " + animal.getTipo() + ", Idade: " + animal.getIdade() + ")");
            System.out.println("(1) Alimentar o animal");
            System.out.println("(2) Procriar o animal");
            System.out.println("(3) Mostrar informações do animal");
            System.out.println("(4) Abater o animal");
            System.out.println("(5) Voltar ao menu da fazenda");
            System.out.print("Escolha uma opção: ");
            option = teclado.nextInt();

            switch (option) {
                case 1:
                    animal.alimentar(/*fazenda*/); // Chama o método para alimentar o animal
                    break;
                case 2:
                    animal.procriar(fazenda); // Chama o método para procriar o animal
                    break;
                case 3:
                    mostrarInfoAnimal(animal); // Mostra informações do animal
                    break;
                case 4:
                    animal.abater(/*fazenda*/); // Chama o método para abater o animal
                    break;
                case 5:
                    System.out.println("Voltando ao menu da fazenda...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (option != 5); // Sai do loop e volta ao menu da fazenda ao escolher a opção 5
    }
    public static void menuInteracaoPlanta(Planta planta,Fazenda fazenda, Scanner teclado) {
        int option;

        do {
            System.out.println("\nInteragindo com o planta: "/*  + planta.getNome() */+ " (Tipo: " + planta.getTipo() + ", Idade: " + planta.getIdade() + ")");
            System.out.println("(1) Plantar a planta");
            System.out.println("(2) Regar a planta");
            System.out.println("(3) Mostrar informações da planta");
            System.out.println("(4) Colher a planta");
            System.out.println("(5) Voltar ao menu da planta");
            System.out.print("Escolha uma opção: ");
            option = teclado.nextInt();

            switch (option) {
                case 1:
                    planta.plantar(); // Chama o método para alimentar o animal
                    break;
                case 2:
                    planta.regar(); // Chama o método para procriar o animal
                    break;
                case 3:
                    mostrarInfoPlanta(planta); // Mostra informações do animal
                    break;
                case 4:
                    planta.colher(fazenda); // Chama o método para abater o animal
                    break;
                case 5:
                    System.out.println("Voltando ao menu da fazenda...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (option != 5); // Sai do loop e volta ao menu da fazenda ao escolher a opção 5
    }

    public static void mostrarInfoAnimal(Animal animal) {
        // Mostra as informações do animal
        System.out.println("Informações do animal:");
        // System.out.println("Nome: " + animal.getNome());
        System.out.println("Tipo: " + animal.getTipo());
        System.out.println("Idade: " + animal.getIdade());
        // Adicione mais informações se necessário
    }
    public static void mostrarInfoPlanta(Planta planta) {
        // Mostra as informações do animal
        System.out.println("Informações do planta:");
        // System.out.println("Nome: " + planta.getNome());
        System.out.println("Tipo: " + planta.getTipo());
        System.out.println("Idade: " + planta.getIdade());
        // Adicione mais informações se necessário
    }


    public static void sairDoJogo() {
        System.out.println("Saindo do jogo...");
        System.exit(0);
    }
}

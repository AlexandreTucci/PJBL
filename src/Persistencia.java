import java.io.*;

public class Persistencia {

    public static void salvarJogo(Jogador jogador, String nomeArquivo) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            out.writeObject(jogador);
            System.out.println("Jogo salvo com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o jogo: " + e.getMessage());
        }
    }

    // Novo método para salvar em .txt legível
    public static void salvarJogoComoTexto(Jogador jogador, String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write(jogador.toString());
            System.out.println("Jogo salvo como texto em " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar o jogo como texto: " + e.getMessage());
        }
    }

    public static Jogador carregarJogo(String nomeArquivo) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            return (Jogador) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar o jogo: " + e.getMessage());
            return null;
        }
    }
}

import java.util.ArrayList;
import java.io.*;

public class Jogador implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private ArrayList<Fazenda> fazendas;

    public Jogador(String nome) {
        this.nome = nome;
        this.fazendas = new ArrayList<>();
    }

    public void criarEAdicionarFazenda(String nomeFazenda) {
        Fazenda fazenda = new Fazenda(nomeFazenda, this);
        this.fazendas.add(fazenda);
    }

    public void comprarComida(){}
    public void comprarAnimal(){}

    public String getNome() {
        return nome;
    }

    public ArrayList<Fazenda> getFazendas() {
        return fazendas;
    }

    public Fazenda getFazendaByName(String nomeFazenda) {
        for (Fazenda fazenda : fazendas) {
            if (fazenda.getNome().equalsIgnoreCase(nomeFazenda)) {
                return fazenda;
            }
        }
        return null; // Retorna null se a fazenda não for encontrada
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Jogador: ").append(nome).append("\n");
        sb.append("Fazendas:\n");
        for (Fazenda fazenda : fazendas) {
            sb.append(" - ").append(fazenda.getNome()).append("\n");
        }
        return sb.toString();
    }
}

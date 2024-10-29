import java.util.ArrayList;

public class Jogador {
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
}
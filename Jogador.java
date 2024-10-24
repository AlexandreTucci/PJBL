public class Jogador{
    private String nome;
    private ArrayList<Fazenda> fazendas = new ArrayList<>();

    public Jogador(String nome) {
        this.nome = nome;
        this.fazendas.add(new Fazenda()); 
    }

    public void adicionarFazenda(Fazenda fazenda) {
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
}
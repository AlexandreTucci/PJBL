import java.util.ArrayList;

class Fazenda {
    private String nome;
    private Jogador dono;
    private ArrayList<Animal> animais;
    private ArrayList<Planta> plantas;

    public Fazenda(String nome, Jogador dono) { 
        this.nome = nome;
        this.dono = dono; 
        this.animais = new ArrayList<>();
        this.plantas = new ArrayList<>();
    }
    public String getNome() {
        return nome;
    }

    public Jogador getDono() { 
        return dono;
    }

    public void InfoFazenda() {
        System.out.println("Fazenda: " + nome);
        System.out.println("Dono: " + dono.getNome());
        System.out.println("Número de Animais: " + animais.size());
        System.out.println("Número de Plantas: " + plantas.size());
    }
}
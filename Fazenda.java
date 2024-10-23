import java.util.ArrayList;

public class Fazenda {
    private String nome;
    private ArrayList<SerVivo> seresVivos;

    public Fazenda(String nome) {
        this.nome = nome;
        this.seresVivos = new ArrayList<>();
    }

    public void adicionarSerVivo(SerVivo ser) {
        seresVivos.add(ser);
    }

    public ArrayList<SerVivo> getSeresVivos() {
        return seresVivos;
    }

    public void mostrarStatus() {
        System.out.println("Status da Fazenda " + nome + ":");
        for (SerVivo ser : seresVivos) {
            System.out.println("Nome: " + ser.getNome() + ", Idade: " + ser.getIdade() + ", Saúde: " + ser.getSaude());
            ser.crescer();
        }
    }
}

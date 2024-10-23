public class Jogador {
    private String nome;
    private Fazenda fazenda;

    public Jogador(String nome) {
        this.nome = nome;
        this.fazenda = new Fazenda("Minha Fazenda");
    }

    public void plantar(String nomePlanta) {
        Planta planta = new Planta(nomePlanta, 0);
        fazenda.adicionarSerVivo(planta);
        System.out.println(nome + " plantou " + nomePlanta + " na fazenda.");
    }

    public void alimentarAnimal(String nomeAnimal) {
        for (SerVivo ser : fazenda.getSeresVivos()) {
            if (ser instanceof Animal && ser.getNome().equals(nomeAnimal)) {
                ((Animal) ser).setSaude(ser.getSaude() + 10);
                System.out.println(nome + " alimentou " + nomeAnimal + ".");
            }
        }
    }

    public void mostrarStatusFazenda() {
        fazenda.mostrarStatus();
    }
}

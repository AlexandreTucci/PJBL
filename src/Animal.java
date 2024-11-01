abstract class Animal extends SerVivo {
    private String tipo;

    public Animal(String nome, int idade, String tipo) {
        super(nome, idade);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public void crescer() {}
    public void morrer() {}

    public void procriar(Fazenda fazenda) {
        fazenda.adicionarAnimal(this.tipo, this.tipo, 0); 
        System.out.println(getNome() + " foi procriado");
    }
    public void alimentar(Fazenda fazenda) {
        System.out.println(getNome() + " foi alimentada");
    }
    public void abater(Fazenda fazenda) {
        fazenda.removerAnimal(tipo);
        System.out.println(getNome() + " foi abatido");
    }
}
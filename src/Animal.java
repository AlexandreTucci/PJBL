abstract class Animal extends SerVivo {
    private String tipo;

    public Animal( int idade, String tipo) {
        super(idade);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public void crescer() {}
    public void morrer() {}

    public void procriar(Fazenda fazenda) {
        fazenda.adicionarAnimal(this.tipo, 0);
        System.out.println(getTipo() + " foi procriado");
    }
    public void alimentar() {
        System.out.println(getTipo() + " foi alimentada");
    }
    public void abater() {
        System.out.println(getTipo() + " foi abatido");
    }
}
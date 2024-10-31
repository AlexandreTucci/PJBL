class Porco extends Animal {
    public Porco( int idade) {
        super(idade, "Porco"); // Passa o tipo "Porco" diretamente
    }

    @Override
    public void crescer() {}
    public void morrer() {}

    public void procriar() {
        System.out.println(getTipo() + " foi procriado");
    }
    public void alimentar() {
        System.out.println(getTipo() + " foi alimentada");
    }
    public void abater() {
        System.out.println(getTipo() + " foi abatido");
    }
}

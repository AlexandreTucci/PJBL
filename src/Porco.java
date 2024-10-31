class Porco extends Animal {
    public Porco( int idade) {
        super(idade, "Porco"); // Passa o tipo "Porco" diretamente
    }

    @Override
    public void crescer() {}
    public void morrer() {}

    public void procriar() {
        System.out.println(getNome() + " foi procriado");
    }
    public void alimentar() {
        System.out.println(getNome() + " foi alimentada");
    }
    public void abater() {
        System.out.println(getNome() + " foi abatido");
    }
}

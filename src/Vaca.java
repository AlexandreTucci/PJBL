class Vaca extends Animal {
    public Vaca(int idade) {
        super(idade, "Vaca"); // Passa o tipo "Vaca" diretamente
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

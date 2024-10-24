class Galinha extends Animal {
    public Galinha(String nome, int idade) {
        super(nome, idade, "Galinha"); // Passa o tipo "Vaca" diretamente
    }

    @Override
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
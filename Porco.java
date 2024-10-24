class Porco extends Animal {
    public Porco(String nome, int idade) {
        super(nome, idade, "Porco"); // Passa o tipo "Vaca" diretamente
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
class Vaca extends Animal {
    public Vaca(String nome, int idade) {
        super(nome, idade, "Vaca"); // Passa o tipo "Vaca" diretamente
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

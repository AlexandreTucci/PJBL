class Porco extends Animal {
    public Porco(String nome, int idade) {
        super(nome, idade, "Porco"); // Passa o tipo "Vaca" diretamente
    }

    @Override
    public void abater() {
        System.out.println(getNome() + " foi abatido");
    }
}

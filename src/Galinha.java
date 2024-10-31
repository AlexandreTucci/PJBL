class Galinha extends Animal {
    public Galinha(int idade) {
        super(idade, "Galinha"); // Passa o tipo "Vaca" diretamente
    }

    @Override
    public void crescer() {}
    public void morrer() {}

    public void procriar(Fazenda fazenda) {
        fazenda.adicionarAnimal("galinha", 0); 
        System.out.println(getNome() + " foi procriado");
    }
    public void alimentar() {
        System.out.println(getNome() + " foi alimentada");
    }
    public void abater() {
        System.out.println(getNome() + " foi abatido");
    }
    
}



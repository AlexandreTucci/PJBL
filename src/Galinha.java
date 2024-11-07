class Galinha extends Animal {
    public Galinha(/*String nome,*/ int idade) {
        super(/*nome,*/ idade, "Galinha"); // Passa o tipo "Galinha" diretamente
    }

    @Override
    public void crescer() {}
    public void morrer() {}

    public void procriar(Fazenda fazenda) {
        fazenda.adicionarAnimal("galinha", /* "Galinha",*/ 0); 
        System.out.println(getTipo() + " foi procriado");
    }
    public void alimentar() {
        System.out.println(getTipo() + " foi alimentada");
    }
    public void abater() {
        System.out.println(getTipo() + " foi abatido");
    }
    
}



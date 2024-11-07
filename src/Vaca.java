class Vaca extends Animal {
    public Vaca(/*String nome,*/ int idade) {
        super(/*nome,*/ idade, "Vaca"); // Passa o tipo "Vaca" diretamente
    }

    @Override
    public void crescer() {}
    public void morrer() {}

    public void procriar(Fazenda fazenda) {
        fazenda.adicionarAnimal("vaca", /* "Vaca",*/ 0); 
        System.out.println(getTipo() + " foi procriado");
    }

    public void alimentar() {
        System.out.println(getTipo() + " foi alimentada");
    }

    public void abater() {
        System.out.println(getTipo() + " foi abatido");
    }
}

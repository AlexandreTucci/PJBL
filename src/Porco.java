import java.io.Serializable;

class Porco extends Animal implements Serializable {
    private static final long serialVersionUID = 1L;
    public Porco(/*String nome,*/ int idade) {
        super(/*nome,*/ idade, "Porco"); // Passa o tipo "Porco" diretamente
    }

    @Override
    public void procriar(Fazenda fazenda) {
        fazenda.adicionarAnimal("porco", 0);
        System.out.println(getTipo() + " foi procriado");
    }
    @Override
    public void alimentar() {
        System.out.println(getTipo() + " foi alimentada");
    }
    @Override
    public void abater(Fazenda fazenda) {
        fazenda.removerAnimal("porco");
        System.out.println(getTipo() + " foi abatido");
    }
}

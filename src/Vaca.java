import java.io.Serializable;

class Vaca extends Animal implements Serializable {
    private static final long serialVersionUID = 1L;
    public Vaca(/*String nome,*/ int idade) {
        super(/*nome,*/ idade, "Vaca"); // Passa o tipo "Vaca" diretamente
    }

    @Override
    public void procriar(Fazenda fazenda) {
        fazenda.adicionarAnimal("vaca", 0);
        System.out.println(getTipo() + " foi procriado");
    }

    @Override
    public void alimentar() {
        System.out.println(getTipo() + " foi alimentada");
    }

    @Override
    public void abater(Fazenda fazenda) {
        fazenda.removerAnimal("vaca");
        System.out.println(getTipo() + " foi abatido");
    }
}

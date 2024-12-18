import java.io.Serializable;

class Galinha extends Animal implements Serializable {
    private static final long serialVersionUID = 1L;
    public Galinha(/*String nome,*/ int idade) {
        super(/*nome,*/ idade, "Galinha"); // Passa o tipo "Galinha" diretamente
    }


    public void procriar(Fazenda fazenda) {
        fazenda.adicionarAnimal("galinha", /* "Galinha",*/ 0); 
        System.out.println(getTipo() + " foi procriado");
    }
    public void alimentar() {
        System.out.println(getTipo() + " foi alimentada");
    }
    public void abater(Fazenda fazenda) {
        fazenda.removerAnimal("galinha");
        System.out.println(getTipo() + " foi abatido");
    }
}



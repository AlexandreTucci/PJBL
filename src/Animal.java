import java.io.Serializable;

//Animal.java
abstract class Animal extends SerVivo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String tipo;

    public Animal( int idade, String tipo) {
        super(idade);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
    public abstract void procriar(Fazenda fazenda);
    public abstract void alimentar();
    public abstract void abater(Fazenda fazenda);
}
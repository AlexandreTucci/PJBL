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
    public void procriar(Fazenda fazenda) {}
    public void alimentar() {}
    public void abater(Fazenda fazenda) {}
}
import java.io.Serializable;

abstract class Planta extends SerVivo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String tipo;
    public Planta(int idade, String tipo) {
        super(idade);
        this.tipo = tipo;
    }
    public String getTipo() {
        return tipo;
    }

    public abstract void regar();
    public abstract void colher(Fazenda fazenda);
}
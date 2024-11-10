import java.io.Serializable;

public abstract class SerVivo implements Serializable {
    private static final long serialVersionUID = 1L;
    private int idade;

    public SerVivo(int idade) {
        this.idade = idade;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

}

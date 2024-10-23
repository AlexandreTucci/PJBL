public class Animal extends SerVivo {
    private String tipo;

    public Animal(String nome, int idade, String tipo) {
        super(nome, idade);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public void crescer() {
        System.out.println(getNome() + " está crescendo!");
    }
}

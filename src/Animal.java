//Animal.java
abstract class Animal extends SerVivo {
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
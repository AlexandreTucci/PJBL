abstract class Planta extends SerVivo {
    private String tipo;
    public Planta(int idade, String tipo) {
        super(idade);
        this.tipo = tipo;
    }
    public String getTipo() {
        return tipo;
    }

    public void regar() {}
    public void colher(Fazenda fazenda) {
        System.out.println(getTipo() + " foi colhido(a)");}
}
abstract class Planta extends SerVivo {
    private String tipo;

    public Planta(String nome, int idade, String tipo) {
        super(nome, idade);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public void crescer() {}
    public void morrer() {}

    public void plantar() {System.out.println(getNome() + " foi plantada");}
    public void regar() {System.out.println(getNome() + " foi regada");}
    public void colher(Fazenda fazenda) {
        fazenda.colherPlanta(tipo);
        System.out.println(getNome() + " foi colhido(a)");}

}

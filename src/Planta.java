abstract class Planta extends SerVivo {
    private String tipo;

    public Planta(int idade, String tipo) {
        super(idade);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public void crescer() {}
    public void morrer() {}

    public void plantar() {System.out.println(getTipo() + " foi plantada");}
    public void regar() {System.out.println(getTipo() + " foi regada");}
    public void colher() {System.out.println(getTipo() + " foi colhida");}

}

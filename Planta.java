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
    public void crescer() {
        System.out.println(getNome() + " está crescendo!");
    }

    public void plantar() {
        System.out.println(getNome() + " foi plantada");
    }

    public void alimentar() {
        System.out.println(getNome() + " foi alimentada");
    }

    public void colher() {
        System.out.println(getNome() + " foi colhida");
    }

}

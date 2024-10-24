abstract class Animal extends SerVivo {
    private String tipo;

    public Animal(String nome, int idade, String tipo) {
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

    public void procriar() {
        System.out.println(getNome() + " foi procriado");
    }

    public void alimentar() {
        System.out.println(getNome() + " foi alimentada");
    }

    public void abater() {
        System.out.println(getNome() + " foi abatido");
    }

}
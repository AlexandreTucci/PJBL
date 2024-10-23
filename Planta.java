public class Planta extends SerVivo {
    public Planta(String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public void crescer() {
        System.out.println(getNome() + " está crescendo!");
    }
}

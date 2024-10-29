class Trigo extends Planta{
    public Trigo(String nome, int idade) {
        super(nome, idade, "Trigo");
    }

    @Override
    public void crescer() {System.out.println(getNome() + " está crescendo!");}
    public void morrer() {System.out.println(getNome() + " morreu!");}

    public void plantar() {System.out.println(getNome() + " foi plantada");}
    public void regar() {System.out.println(getNome() + " foi alimentada");}
    public void colher() {System.out.println(getNome() + " foi colhida");}
}

class Milho extends Planta{
    public Milho(/*String nome,*/ int idade) {
        super(/*nome,*/ idade, "Milho");
    }

    @Override
    public void crescer() {System.out.println(getTipo() + " está crescendo!");}
    public void morrer() {System.out.println(getTipo() + " morreu!");}

    public void plantar() {System.out.println(getTipo() + " foi plantada");}
    public void regar() {System.out.println(getTipo() + " foi alimentada");}
    public void colher() {System.out.println(getTipo() + " foi colhida");}
}
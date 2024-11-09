class Soja extends Planta{
    public Soja(int idade) {
        super(idade, "Soja");
    }


    @Override
    public void regar() {System.out.println(getTipo() + " foi alimentada");}
    @Override
    public void colher(Fazenda fazenda) {
        fazenda.colherPlanta("soja");
        System.out.println(getTipo() + " foi colhida");}
}

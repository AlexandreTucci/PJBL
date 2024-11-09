class Trigo extends Planta{
    public Trigo(int idade) {
        super( idade, "Trigo");
    }


    @Override
    public void regar() {System.out.println(getTipo() + " foi alimentada");}
    @Override
    public void colher(Fazenda fazenda) {
        fazenda.colherPlanta("trigo");
        System.out.println(getTipo() + " foi colhida");}
}

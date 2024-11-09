class Milho extends Planta{
    public Milho(int idade) {
        super( idade, "Milho");
    }


    @Override
    public void regar() {System.out.println(getTipo() + " foi alimentada");}
    @Override
    public void colher(Fazenda fazenda) {
        fazenda.colherPlanta("milho");
        System.out.println(getTipo() + " foi colhida");}
}
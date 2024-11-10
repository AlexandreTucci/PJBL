import java.io.Serializable;

class Milho extends Planta implements Serializable {
    private static final long serialVersionUID = 1L;
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
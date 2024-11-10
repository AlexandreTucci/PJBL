import java.io.Serializable;

class Trigo extends Planta implements Serializable {
    private static final long serialVersionUID = 1L;
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

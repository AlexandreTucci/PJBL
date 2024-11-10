import java.io.Serializable;

class Soja extends Planta implements Serializable {
    private static final long serialVersionUID = 1L;
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

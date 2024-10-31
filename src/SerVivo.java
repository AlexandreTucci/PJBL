public abstract class SerVivo {
//    private String nome;
    private int idade;
    //private int saude;

    public SerVivo(int idade) {
//        this.nome = nome;
        this.idade = idade;
        //this.saude = 100;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    /*public int getSaude() {
        return saude;
    }*/

    /*public void setSaude(int saude) {
        this.saude = saude;
    }*/

    public abstract void crescer();
    public abstract void morrer();

}

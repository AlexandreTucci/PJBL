class Galinha extends Animal {
    public Galinha(String nome, int idade) {
        super(nome, idade, "Vaca"); // Passa o tipo "Vaca" diretamente
    }

    @Override
    public void morrer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'morrer'");
    }
}

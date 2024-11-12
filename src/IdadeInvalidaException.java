public class IdadeInvalidaException extends Exception{
    protected int idade;
    public IdadeInvalidaException(int idade){
        super();
        this.idade = idade;
    }

    public String toString() {
        return "Idade:" + idade + " não é um numero válido, digite um numero entre 0 e 100";
    }

}

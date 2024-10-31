import java.util.ArrayList;

class Fazenda {
    private String nome;
    private Jogador dono;
    private ArrayList<Animal> animais;
    private ArrayList<Planta> plantas;

    public Fazenda(String nome, Jogador dono) { 
        
        this.nome = nome;
        this.dono = dono; 
        this.animais = new ArrayList<>();
        this.plantas = new ArrayList<>();
    }

    public void adicionarAnimal(String tipoAnimal, int idade) {
        Animal animal = null;

        switch (tipoAnimal.toLowerCase()) {
            case "vaca":
                animal = new Vaca(idade);
                break;
            case "galinha":
                animal = new Galinha(idade);
                break;
            case "porco":
                animal = new Porco(idade);
                break;
            default:
                System.out.println("Tipo de animal inválido: " + tipoAnimal);
                return; // Sai do método se o tipo for inválido
        }

        if (animal != null) {
            animais.add(animal);
            System.out.println(animal.getTipo() + " foi adicionado à fazenda " + this.getNome());
        }
    }
    public void adicionarPlanta(String tipoPlanta, int idade) {
        Planta planta = null;

        switch (tipoPlanta.toLowerCase()) {
            case "milho":
                planta = new Milho(idade);
                break;
            case "trigo":
                planta = new Trigo(idade);
                break;
            case "soja":
                planta = new Soja(idade);
                break;
            default:
                System.out.println("Tipo de planta inválido: " + tipoPlanta);
                return; // Sai do método se o tipo for inválido
        }
        if (planta != null) {
            plantas.add(planta);
            System.out.println(planta.getTipo() + " " + " foi adicionado à fazenda " + this.getNome());
        }
    }
    public String getNome(){
        return nome;
    }

    public void InfoFazenda() {
        System.out.println(" ");
        System.out.println("Número de galinhas = " + this.contar(this.animais, "galinha"));
        System.out.println("Número de vacas = " + this.contar(this.animais, "vaca"));
        System.out.println("Número de porcos  = " + this.contar(this.animais, "porco"));
        System.out.println("Fazenda: " + nome);
        System.out.println("Dono: " + dono.getNome());


        System.out.println("Número de Animais: " + animais.size());
        System.out.println("Lista de Animais: ");
        for (Animal animal : animais) {
            System.out.println( animal.getTipo() + " " + "(idade:" + animal.getIdade() + ")" ); // Chama o método toString() de cada animal
        }

        System.out.println("Número de Plantas: " + plantas.size());
        System.out.println("Lista de Plantas: ");
        for (Planta planta : plantas) {
            System.out.println( planta.getTipo() + " " + "(idade:" + planta.getIdade() + ")" ); // Chama o método toString() de cada animal
        }
    }

    public static int contar(ArrayList<Animal> animais, String tipoAnimal) {
        int contador = 0;
        for (Animal animal : animais) {
            if (animal.getTipo().equalsIgnoreCase(tipoAnimal)) { 
                contador++;
            }
        }
        return contador;
    }


}
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

    public void adicionarAnimal(String tipoAnimal, String nomeAnimal, int idade) {
        Animal animal = null;

        switch (tipoAnimal.toLowerCase()) {
            case "vaca":
                animal = new Vaca(nomeAnimal, idade);
                break;
            case "galinha":
                animal = new Galinha(nomeAnimal, idade);
                break;
            case "porco":
                animal = new Porco(nomeAnimal, idade);
                break;
            default:
                System.out.println("Tipo de animal inválido: " + tipoAnimal);
                return; // Sai do método se o tipo for inválido
        }

        if (animal != null) {
            animais.add(animal);
            System.out.println(animal.getTipo() + " " + animal.getNome() + " foi adicionado à fazenda " + this.getNome());
        }
    }
    public void adicionarPlanta(String tipoPlanta, String nomePlanta, int idade) {
        Planta planta = null;

        switch (tipoPlanta.toLowerCase()) {
            case "milho":
                planta = new Milho(nomePlanta, idade);
                break;
            case "trigo":
                planta = new Trigo(nomePlanta, idade);
                break;
            case "soja":
                planta = new Soja(nomePlanta, idade);
                break;
            default:
                System.out.println("Tipo de planta inválido: " + tipoPlanta);
                return; // Sai do método se o tipo for inválido
        }
        if (planta != null) {
            plantas.add(planta);
            System.out.println(planta.getTipo() + " " + planta.getNome() + " foi adicionado à fazenda " + this.getNome());
        }
    }

    public String getNome(){
        return nome;
    }
    public Animal getAnimalByName(String nomeAnimal) {
        for (Animal animal : animais) {
            if (animal.getNome().equalsIgnoreCase(nomeAnimal)) {
                return animal; // Retorna o animal se o nome coincidir
            }
        }
        return null; // Retorna null se o animal não for encontrado
    }

    // Método para buscar uma planta pelo nome
    public Planta getPlantaByName(String nomePlanta) {
        for (Planta planta : plantas) {
            if (planta.getNome().equalsIgnoreCase(nomePlanta)) {
                return planta; // Retorna a planta se o nome coincidir
            }
        }
        return null; // Retorna null se a planta não for encontrada
    }
    public void InfoFazenda() {
        System.out.println(" ");
        System.out.println("Número de galinhas = " + this.contarGalinhas(this.animais));
        System.out.println("Fazenda: " + nome);
        System.out.println("Dono: " + dono.getNome());


        System.out.println("Número de Animais: " + animais.size());
        System.out.println("Lista de Animais: ");
        for (Animal animal : animais) {
            System.out.println( animal.getTipo() + " " + animal.getNome() + "(idade:" + animal.getIdade() + ")" ); // Chama o método toString() de cada animal
        }

        System.out.println("Número de Plantas: " + plantas.size());
        System.out.println("Lista de Plantas: ");
        for (Planta planta : plantas) {
            System.out.println( planta.getTipo() + " " + planta.getNome() + "(idade:" + planta.getIdade() + ")" ); // Chama o método toString() de cada animal
        }
    }

    public static int contarGalinhas(ArrayList<Animal> animais) {
        int contador = 0;
        for (Animal animal : animais) {
            if (animal.getTipo().equalsIgnoreCase("galinha")) { // Verifica se é "galinha"
                contador++;
            }
        }
        return contador;
    }
}
import java.util.ArrayList;
import java.util.Iterator;

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

    public void removerAnimal(String tipoAnimal) {
        tipoAnimal = tipoAnimal.toLowerCase(); 
        for (int i = 0; i < animais.size(); i++) {
            if (animais.get(i).getTipo().equalsIgnoreCase(tipoAnimal)) {
                animais.remove(i); 
                break; 
            }
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

    public void colherPlanta(String tipoPlanta) {
        tipoPlanta = tipoPlanta.toLowerCase(); 
        for (int i = 0; i < plantas.size(); i++) {
            if (plantas.get(i).getTipo().equalsIgnoreCase(tipoPlanta)) {
                plantas.remove(i); 
                break; 
            }
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
        System.out.println("Número de galinhas = " + this.contar(this.animais, "galinha"));
        System.out.println("Número de vacas = " + this.contar(this.animais, "vaca"));
        System.out.println("Número de porcos  = " + this.contar(this.animais, "porco"));
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

    public static int contar(ArrayList<Animal> animais, String tipoAnimal) {
        int contador = 0;
        for (Animal animal : animais) {
            if (animal.getTipo().equalsIgnoreCase(tipoAnimal)) { 
                contador++;
            }
        }
        return contador;
    }

    // Adicionando métodos para obter listas de animais e plantas
    public ArrayList<Animal> getAnimais() {
        return animais;
    }

    public ArrayList<Planta> getPlantas() {
        return plantas;
    }

    // Método para buscar um animal pelo tipo
    public Animal getAnimalByTipo(String tipoAnimal) {
        tipoAnimal = tipoAnimal.toLowerCase(); // Normaliza a busca para maiúsculas/minúsculas
        for (Animal animal : animais) {
            if (animal.getTipo().equalsIgnoreCase(tipoAnimal)) {
                return animal; // Retorna o primeiro animal encontrado com o tipo correspondente
            }
        }
        return null; // Retorna null se o animal não for encontrado
    }

    // Método para buscar uma planta pelo tipo
    public Planta getPlantaByTipo(String tipoPlanta) {
        tipoPlanta = tipoPlanta.toLowerCase(); // Normaliza a busca para maiúsculas/minúsculas
        for (Planta planta : plantas) {
            if (planta.getTipo().equalsIgnoreCase(tipoPlanta)) {
                return planta; // Retorna a primeira planta encontrada com o tipo correspondente
            }
        }
        return null; // Retorna null se a planta não for encontrada
    }
}

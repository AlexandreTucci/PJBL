import java.util.ArrayList;
import java.io.*;
public class Fazenda implements Serializable {
    private static final long serialVersionUID = 1L;
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

    public void adicionarAnimal(String tipoAnimal, /*String nomeAnimal,*/ int idade){
        Animal animal = null;

        switch (tipoAnimal.toLowerCase()) {
            case "vaca":
                animal = new Vaca(/*nomeAnimal,*/ idade);
                break;
            case "galinha":
                animal = new Galinha(/*nomeAnimal,*/ idade);
                break;
            case "porco":
                animal = new Porco(/*nomeAnimal,*/ idade);
                break;
            default:
                System.out.println("Tipo de animal inválido: " + tipoAnimal);
                return; // Sai do método se o tipo for inválido
        }

        if (animal != null) {
            animais.add(animal);
            System.out.println(animal.getTipo() + " "/*  + animal.getNome()*/ + " foi adicionado à fazenda " + this.getNome());
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

    public void adicionarPlanta(String tipoPlanta, /*String nomePlanta,*/ int idade) {
        Planta planta = null;

        switch (tipoPlanta.toLowerCase()) {
            case "milho":
                planta = new Milho(/*nomePlanta,*/ idade);
                break;
            case "trigo":
                planta = new Trigo(/*nomePlanta,*/ idade);
                break;
            case "soja":
                planta = new Soja(/*nomePlanta,*/ idade);
                break;
            default:
                System.out.println("Tipo de planta inválido: " + tipoPlanta);
                return; // Sai do método se o tipo for inválido
        }
        if (planta != null) {
            plantas.add(planta);
            System.out.println(planta.getTipo() + " "/*  + planta.getNome() */+ " foi adicionado à fazenda " + this.getNome());
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
    public String getNomeDono(){ return dono.getNome();}
    public ArrayList<Animal> getAnimais() {
        return animais;
    }
    public ArrayList<Planta> getPlantas() {
        return plantas;
    }

    public ArrayList<Animal> getAnimaisByTipo(String tipoAnimal) {
        ArrayList<Animal> animaisTipo = new ArrayList<>();
        for (Animal animal : animais) {
            if (animal.getTipo().equalsIgnoreCase(tipoAnimal)) {
                animaisTipo.add(animal);
            }
        }
        return animaisTipo;
    }
    public ArrayList<Planta> getPlantaByTipo(String tipoPlanta) {
        ArrayList<Planta> plantasTipo = new ArrayList<>();
        for (Planta planta : plantas) {
            if (planta.getTipo().equalsIgnoreCase(tipoPlanta)) {
                plantasTipo.add(planta);
            }
        }
        return plantasTipo;
    }
}
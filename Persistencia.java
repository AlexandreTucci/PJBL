import java.io.*;
import java.util.ArrayList;

public class Persistencia {
    public static void salvarDados(String filename, Fazenda fazenda) throws IOException {
        FileOutputStream fos = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(fazenda);
        oos.close();
    }

    public static Fazenda carregarDados(String filename) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Fazenda fazenda = (Fazenda) ois.readObject();
        ois.close();
        return fazenda;
    }
}

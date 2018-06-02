import java.io.*;

public class PersistenciaUsuari {

    /**
     * en el File file el contenido de Usuari u serializado
     * @param u Usuari que será guardado en el File file
     * @param file File que contendrá el valor de Usuari u serializado
     */
    public void guardar_U(Usuari u, File file) {
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(u);
            oos.close();
        }
        catch (IOException e) {}
    }

    /**
     * Devuelve el Usuari guardado guardado en el File file, si este existe
     * @param file File el cual contiene el Usuari serializado
     * @return devuelve el Usuari guardado en el File file
     */
    public Usuari cargar_U(File file) {
        ObjectInputStream ois;
        Usuari u = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            u = (Usuari) ois.readObject();
            ois.close();
            return u;
        } catch (FileNotFoundException e) {
            Usuari err = null;
            return err;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return u;
    }
}

package Graficacion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Fuente {

    //Se toma el nombre de la figura a dibujar
    private String nombre;
    //Scanner toma la entrada
    private Scanner in = null;

    //Metodo para abrir el archivo
    public Fuente(String nombre) {
        this.nombre = nombre;
        try {
            in = new Scanner(new File(nombre));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Fuente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Metodo que toma los caracteres del archivo
    private String[] arrayListToArray(ArrayList<String> entrada) {
        String salida[] = new String[entrada.size()];
        Iterator iter = entrada.iterator();
        String s;
        int j = 0;
        while (iter.hasNext()) {
            s = (String) iter.next();
            salida[j] = s;
            j++;
        }

        return salida;
    }
    
    //Metodo que separa los caracteres para que la lectura de las instrucciones
    //Sea optima
    public String[][] leerSeparar() {

        ArrayList<String> l = new ArrayList();

        String s;
        while (in.hasNextLine()) {
            s = in.nextLine();
            l.add(s);
        }

        Iterator iter = l.iterator();
        s = (String) iter.next();
        String[] temp = s.split(",");
        int numeroCampos = temp.length;

        String[][] temp1 = new String[l.size()][numeroCampos];
        int j = 0;
        iter = l.iterator();
        while (iter.hasNext()) {
            s = (String) iter.next();
            temp = s.split(",");
            for (int i = 0; i < temp.length; i++) {
                temp1[j][i] = temp[i];
            }
            j++;
        }
        return temp1;
    }

    public double[][] stringADouble(String[][] entrada) {
        double temp[][] = new double[entrada.length][entrada[0].length];
        for (int i = 0; i < entrada.length; i++) {
            for (int j = 0; j < entrada[0].length; j++) {
                temp[i][j] = Double.parseDouble(entrada[i][j]);

            }
        }

        return temp;
    }

}

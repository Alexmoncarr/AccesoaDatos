package fichero1;

import java.io.*;
import java.util.Scanner;

public class LeerEscribirArchivo {

    public static void main(String[] args) {
       leer();
       //escribir();
    }

    public static void leer(){
            File archivo = null;
            FileReader fr = null;
            BufferedReader br = null;

            try {
                archivo = new File ("C:\\Users\\aleja\\OneDrive\\Escritorio\\Archivo.txt");
                br = new BufferedReader(fr);

                String linea;
                while((linea=br.readLine())!=null)
                    System.out.println(linea);
            }
            catch(Exception e){
                e.printStackTrace();
            }finally{
                try{
                    if( null != fr ){
                        fr.close();
                    }
                }catch (Exception e2){
                    e2.printStackTrace();
                }
            }

    }

    public static void escribir() {
        try {
            File fichero = new File("C:\\Users\\aleja\\OneDrive\\Escritorio\\Archivo.txt");
            FileWriter escritura = new FileWriter(fichero, true);
            Scanner sc = new Scanner(System.in);

            System.out.println("Escribe lo que quieras guardar en el fichero. Introduce un * para finalizar.");

            while (true) {
                String text = sc.nextLine();

                if (text.equals("*")) {
                    break;
                }
                escritura.write(text + "\n");
            }
            escritura.close();
            sc.close();

            System.out.println("Se ha guardado correctamente en el fichero.");

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}

package ExpresionesRegulares;

import java.io.*;

public class MetodesPropisString {
    public static void main(String[] args) throws IOException {

        String archivo = "santako.txt";
        BufferedReader br = new BufferedReader(new FileReader(archivo));

        String linea = "";

        while ((linea = br.readLine()) != null) {
            int noelcontador = contarOcurrencias(linea, "<]:-DOo");
            int renocontador = contarOcurrencias(linea, ">:o)");
            int folletcontador = contarOcurrencias(linea, "<]:-D");

            StringBuilder salida = new StringBuilder();
            if (noelcontador > 0) {
                salida.append("Pare Noel (").append(noelcontador).append(") ");
            }
            if (renocontador > 0) {
                salida.append("Ren (").append(renocontador).append(") ");
            }
            if (folletcontador > 0 && noelcontador == 0 && renocontador == 0) {
                salida.append("Follet (").append(folletcontador).append(") ");
            }

            System.out.println(salida.toString().trim());
        }
    }

    public static int contarOcurrencias(String linea, String patron) {
        int contador = 0;
        int indice = 0;

        while ((indice = linea.indexOf(patron, indice)) != -1) {
            contador++;
            indice++;
        }

        return contador;
    }
}
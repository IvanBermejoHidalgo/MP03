package ExpresionesRegulares;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionsRegulars {
    public static void main(String[] args) {
        try {
            String archivo = "/home/ivan/Descargas/santako.txt";
            BufferedReader br = new BufferedReader(new FileReader(archivo));

            String linea = "";
            String noel = "\\*<]:-DOo";
            String reno = ">:o\\)";
            String follet = "<]:-D$";

            while ((linea = br.readLine()) != null) {
                int noelcontador = Contador(linea, noel);
                int renocontador = Contador(linea, reno);
                int folletcontador = Contador(linea, follet);

                StringBuilder salida = new StringBuilder();
                if (noelcontador > 0) {
                    salida.append("Pare Noel (").append(noelcontador).append(") ");
                }
                if (renocontador > 0) {
                    salida.append("Ren (").append(renocontador).append(") ");
                }
                if (folletcontador > 0) {
                    salida.append("Follet (").append(folletcontador).append(") ");
                }
                System.out.println(salida.toString().trim());
            }

            br.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static int Contador(String input, String pattern) {
        Pattern pattern1 = Pattern.compile(pattern);
        Matcher matcher = pattern1.matcher(input);
        int contador = 0;
        while (matcher.find()) {
            contador++;
        }
        return contador;
    }
}
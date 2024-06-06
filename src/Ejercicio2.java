import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<Integer> listaEdades = new ArrayList<>();
        int edad;
        double sumaEdad = 0;
        int contador = -1;
        int bajoMedia = -1;
        int sobreMedia = 0;

        do {
            System.out.println("Introduce una edad (negativo para salir):");
            edad = s.nextInt();
            sumaEdad += edad;
            contador++;
            listaEdades.add(edad);
            s.nextLine();
        }
        while(edad >= 0);
        double media = sumaEdad / contador;

        List<Integer> CopiaLista = List.copyOf(listaEdades);
        Iterator<Integer> iterador = listaEdades.iterator();
        Iterator<Integer> iterador2 = CopiaLista.iterator();

        while (iterador.hasNext()){
            if(iterador.next() < media){
                bajoMedia++;
            }
        }

        while (iterador2.hasNext()){
            if(iterador2.next() > media){
                sobreMedia++;
            }
        }

        System.out.println("La edad media es: " +  media);
        System.out.println("Hay " +  bajoMedia + " personas por debajo de la media");
        System.out.println("Hay " +  sobreMedia + " personas por encima de la media");
    }
}

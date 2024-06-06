import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<String> almacen = new ArrayList<>();
        Set<String> almacenSinRepetir = new HashSet<>();
        int cantidad;
        int contador = 0;
        do {
            System.out.println("Introduce cantidad de productos para añadir: (0 para salir).");
            cantidad = s.nextInt();
            s.nextLine();
            if (cantidad != 0) {
                almacen.clear();
                for (int i = 0; i < cantidad; i++) {
                    System.out.println("Introduce producto " + (i + 1) + ":");
                    String producto = s.nextLine();
                    contador++;
                    System.out.println("Te quedan " + (cantidad - contador) + " productos.");
                    producto = producto.toLowerCase();
                    almacen.add(producto);
                }

                almacenSinRepetir.clear();
                almacenSinRepetir.addAll(almacen);

                System.out.println("Productos distintos: " + almacenSinRepetir.size());
            }
        } while (cantidad != 0);
        s.close();
    }
}

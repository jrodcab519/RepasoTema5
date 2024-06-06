package Ejercicio3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Ejercicio3 {
    static LinkedHashMap<String, LocalDate> almacen = new LinkedHashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un código de producto y una fecha: (Ejemplo: AB-123 5 06 2024) (FIN: mostrar listado y salir).");
        String producto = sc.nextLine();
        while (!producto.equals("FIN")) {
            insertarProducto(producto);
            producto = sc.nextLine();
        }
        System.out.println("LISTADO DEL ALMACÉN");
        for (String s : almacen.keySet()) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            System.out.println(s + " -> " + almacen.get(s).format(dtf));
        }
    }

    private static void insertarProducto(String producto) {
        String[] split = producto.split(" ");
        Producto p = new Producto(split[0]);
        int dia = Integer.parseInt(split[1]);
        int mes = Integer.parseInt(split[2]);
        int anyo = Integer.parseInt(split[3]);
        LocalDate fecha = LocalDate.of(anyo, mes, dia);
        if (almacen.containsKey(p.getCodigo())) {
            if (almacen.get(p.getCodigo()).isAfter(fecha)) {
                almacen.replace(p.getCodigo(), fecha);
                System.out.println("Producto existente. Actualizado");
            } else {
                System.out.println("Producto existente. No se actualiza");
            }
        } else {
            almacen.put(p.getCodigo(),fecha);
            System.out.println("Nuevo producto. Registrado");
        }
    }
}

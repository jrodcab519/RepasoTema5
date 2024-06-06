package Ejercicio3;

public class Producto {
    private String codigo;

    public Producto(String codigo) {
        setCodigo(codigo);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if(!(codigo.charAt(0) >= 'A' && codigo.charAt(0) <= 'Z')){
            throw new IllegalArgumentException("Codigo invalido");
        } else if (!(codigo.charAt(1) >= 'A' && codigo.charAt(1) <= 'Z' || codigo.charAt(1) == '-')) {
            throw new IllegalArgumentException("Codigo invalido");
        }
        String[] split = codigo.split("-");
        if (split[1].length() < 2 || split[1].length() > 3) {
            throw new IllegalArgumentException("Codigo no valido");
        }
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return String.valueOf(this.codigo);
    }
}

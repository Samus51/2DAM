package utils;

import java.util.Date;

public class Cliente {
    private String nombre;
    private String apellidos;
    private java.util.Date fechaNacimiento;
    private String provincia;

    public Cliente(String nombre, String apellidos, java.util.Date fechaNacimiento, String provincia) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.provincia = provincia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getProvincia() {
        return provincia;
    }

    // Sobrescribir equals y hashCode para comparación
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Cliente)) return false;
        Cliente other = (Cliente) obj;
        return nombre.equalsIgnoreCase(other.nombre) && apellidos.equalsIgnoreCase(other.apellidos);
    }

    @Override
    public int hashCode() {
        return (nombre + " " + apellidos).toLowerCase().hashCode();
    }

    @Override
    public String toString() {
        return nombre + " " + apellidos + ", " +
               new java.text.SimpleDateFormat("dd/MM/yyyy").format(fechaNacimiento) + ", " +
               provincia;
    }
}

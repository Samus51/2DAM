package uiux.models;

public class Reserva {
    private Usuario usuario;
    private Clases claseReservada;

    public Reserva(Usuario usuario, Clases claseReservada) {
        this.usuario = usuario;
        this.claseReservada = claseReservada;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Clases getClaseReservada() {
        return claseReservada;
    }
    @Override
    public String toString() {
        return "Reserva{" +
                "usuario=" + usuario +
                ", claseReservada=" + claseReservada +
                '}';
    }

}

package eldon.lafundacion.eldonapp.bean;

/**
 * Created by Mateo on 20/07/2016.
 */
public class Servicio {
    private int idServicio;
    private String servicio;

    public Servicio() {
    }

    public Servicio(String servicio) {
        this.servicio = servicio;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }
}

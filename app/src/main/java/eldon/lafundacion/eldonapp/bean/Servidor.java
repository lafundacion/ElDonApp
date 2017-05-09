package eldon.lafundacion.eldonapp.bean;

import java.io.Serializable;

/**
 * Created by Mateo on 20/07/2016.
 */
public class Servidor implements Serializable {
    private int idServidor;
    private int Valoracion;
    private String Nombre;
    private String Edad;
    private String Telefono;
    private String Distancia;
    private String Actividad;
    private String datoAdicional;
    private String Experiencia;
    private int idServicio;

    public Servidor() {
    }

    public int getIdServidor() {
        return idServidor;
    }

    public void setIdServidor(int idServidor) {
        this.idServidor = idServidor;
    }

    public int getValoracion() {
        return Valoracion;
    }

    public void setValoracion(int valoracion) {
        Valoracion = valoracion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getEdad() {
        return Edad;
    }

    public void setEdad(String edad) {
        Edad = edad;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getDistancia() {
        return Distancia;
    }

    public void setDistancia(String distancia) {
        Distancia = distancia;
    }

    public String getActividad() {
        return Actividad;
    }

    public void setActividad(String actividad) {
        Actividad = actividad;
    }

    public String getDatoAdicional() {
        return datoAdicional;
    }

    public void setDatoAdicional(String datoAdicional) {
        this.datoAdicional = datoAdicional;
    }

    public String getExperiencia() {
        return Experiencia;
    }

    public void setExperiencia(String experiencia) {
        Experiencia = experiencia;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }
}

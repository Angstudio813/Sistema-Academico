package ProyectoEstudiaYa.webapp.dto;

public class MisCursosDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private String nivel;
    private Integer grado;
    private String colorHex;
    private String icono;
    private Integer totalTemas;

    public MisCursosDTO() {
    }

    public MisCursosDTO(Long id, String nombre, String descripcion, String nivel, Integer grado,
            String colorHex, String icono, Integer totalTemas) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.nivel = nivel;
        this.grado = grado;
        this.colorHex = colorHex;
        this.icono = icono;
        this.totalTemas = totalTemas;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNivel() {
        return nivel;
    }

    public Integer getGrado() {
        return grado;
    }

    public String getColorHex() {
        return colorHex;
    }

    public String getIcono() {
        return icono;
    }

    public Integer getTotalTemas() {
        return totalTemas;
    }
}

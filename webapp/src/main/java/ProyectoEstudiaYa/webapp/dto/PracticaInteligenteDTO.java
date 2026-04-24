package ProyectoEstudiaYa.webapp.dto;

public class PracticaInteligenteDTO {

    private Long id;
    private String pregunta;
    private String opcionA;
    private String opcionB;
    private String opcionC;
    private String opcionD;
    private String dificultad;
    private Boolean generadoPorIA;
    private Long temaId;
    private String temaNombre;
    private String cursoNombre;

    public PracticaInteligenteDTO() {
    }

    public PracticaInteligenteDTO(Long id, String pregunta, String opcionA, String opcionB,
            String opcionC, String opcionD, String dificultad, Boolean generadoPorIA,
            Long temaId, String temaNombre, String cursoNombre) {
        this.id = id;
        this.pregunta = pregunta;
        this.opcionA = opcionA;
        this.opcionB = opcionB;
        this.opcionC = opcionC;
        this.opcionD = opcionD;
        this.dificultad = dificultad;
        this.generadoPorIA = generadoPorIA;
        this.temaId = temaId;
        this.temaNombre = temaNombre;
        this.cursoNombre = cursoNombre;
    }

    public Long getId() {
        return id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public String getOpcionA() {
        return opcionA;
    }

    public String getOpcionB() {
        return opcionB;
    }

    public String getOpcionC() {
        return opcionC;
    }

    public String getOpcionD() {
        return opcionD;
    }

    public String getDificultad() {
        return dificultad;
    }

    public Boolean getGeneradoPorIA() {
        return generadoPorIA;
    }

    public Long getTemaId() {
        return temaId;
    }

    public String getTemaNombre() {
        return temaNombre;
    }

    public String getCursoNombre() {
        return cursoNombre;
    }
}

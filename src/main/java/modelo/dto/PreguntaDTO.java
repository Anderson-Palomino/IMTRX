package modelo.dto;

public class PreguntaDTO {
    private int id;
    private String pregunta;
    private String respuesta;
    private int categoria;

    public PreguntaDTO() {
    }

    public PreguntaDTO(int id,int categoria, String pregunta, String respuesta) {
        this.id = id;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
  
    @Override
    public String toString(){
        return getPregunta();
    }
}

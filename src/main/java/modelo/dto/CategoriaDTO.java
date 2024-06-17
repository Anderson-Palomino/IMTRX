package modelo.dto;

public class CategoriaDTO {
    private int IdCategoria;
    private String nombre;

    public CategoriaDTO() {
    }

    public CategoriaDTO(int IdCategoria, String nombre) {
        this.IdCategoria = IdCategoria;
        this.nombre = nombre;
    }

    public int getIdCategoria() {
        return IdCategoria;
    }

    public void setIdCategoria(int IdCategoria) {
        this.IdCategoria = IdCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override public String toString(){
        return getNombre();
    }
}

package modelo.dto;
public class ReclamacionDTO {
    private int id;
    private String fecha;
    private String primerNombre;
    private String segundoNombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String domicilio;
    private String departamento;
    private String provincia;
    private String distrito;
    private String dni;
    private String telefono;
    private String correo;
    private boolean menor;
    private String tipoBienContratado;
    private double montoReclamo;
    private String tipoReclamo;
    private String descripcion;
    private String imagenReclamante;
    private String pedidoConsumidor;
    private boolean respuestaDireccion;

    // Constructor, getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean isMenor() {
        return menor;
    }

    public void setMenor(boolean menor) {
        this.menor = menor;
    }

    public String getTipoBienContratado() {
        return tipoBienContratado;
    }

    public void setTipoBienContratado(String tipoBienContratado) {
        this.tipoBienContratado = tipoBienContratado;
    }

    public double getMontoReclamo() {
        return montoReclamo;
    }

    public void setMontoReclamo(double montoReclamo) {
        this.montoReclamo = montoReclamo;
    }

    public String getTipoReclamo() {
        return tipoReclamo;
    }

    public void setTipoReclamo(String tipoReclamo) {
        this.tipoReclamo = tipoReclamo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagenReclamante() {
        return imagenReclamante;
    }

    public void setImagenReclamante(String imagenReclamante) {
        this.imagenReclamante = imagenReclamante;
    }

    public String getPedidoConsumidor() {
        return pedidoConsumidor;
    }

    public void setPedidoConsumidor(String pedidoConsumidor) {
        this.pedidoConsumidor = pedidoConsumidor;
    }

    public boolean isRespuestaDireccion() {
        return respuestaDireccion;
    }

    public void setRespuestaDireccion(boolean respuestaDireccion) {
        this.respuestaDireccion = respuestaDireccion;
    }
    
}

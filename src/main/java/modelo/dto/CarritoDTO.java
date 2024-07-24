package modelo.dto;

/**
 *
 * @author ander
 */
public class CarritoDTO {
    private int item;
    private int idProducto;
    private String nombre;
    private String imagen;
    private double preciocompra;
    private int cantidad;
    private double subTotal;

    public CarritoDTO() {
    }

    public CarritoDTO(int item, int idProducto, String nombre, String imagen, double preciocompra, int cantidad, double subTotal) {
        this.item = item;
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.imagen = imagen;
        this.preciocompra = preciocompra;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
    }
    
    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public double getPreciocompra() {
        return preciocompra;
    }

    public void setPreciocompra(double preciocompra) {
        this.preciocompra = preciocompra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
    
    
}

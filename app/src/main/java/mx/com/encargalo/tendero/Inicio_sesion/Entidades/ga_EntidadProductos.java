package mx.com.encargalo.tendero.Inicio_sesion.Entidades;

public class ga_EntidadProductos {
    private int idProducto ;
    private String prodImagen;
    private String prodDescripcion;
    private float proPrecioCosto;
    private float proPrecioVenta;
    private String proUndidadMedida;
    private int idCategoriaProducto;
    private int idProveedor;

    public ga_EntidadProductos() {
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getProdImagen() {
        return prodImagen;
    }

    public void setProdImagen(String prodImagen) {
        this.prodImagen = prodImagen;
    }

    public String getProdDescripcion() {
        return prodDescripcion;
    }

    public void setProdDescripcion(String prodDescripcion) {
        this.prodDescripcion = prodDescripcion;
    }

    public float getProPrecioCosto() {
        return proPrecioCosto;
    }

    public void setProPrecioCosto(float proPrecioCosto) {
        this.proPrecioCosto = proPrecioCosto;
    }

    public float getProPrecioVenta() {
        return proPrecioVenta;
    }

    public void setProPrecioVenta(float proPrecioVenta) {
        this.proPrecioVenta = proPrecioVenta;
    }

    public String getProUndidadMedida() {
        return proUndidadMedida;
    }

    public void setProUndidadMedida(String proUndidadMedida) {
        this.proUndidadMedida = proUndidadMedida;
    }

    public int getIdCategoriaProducto() {
        return idCategoriaProducto;
    }

    public void setIdCategoriaProducto(int idCategoriaProducto) {
        this.idCategoriaProducto = idCategoriaProducto;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    @Override
    public String toString() {
        return "ga_EntidadProductos{" +
                "idProducto=" + idProducto +
                ", prodImagen='" + prodImagen + '\'' +
                ", prodDescripcion='" + prodDescripcion + '\'' +
                ", proPrecioCosto=" + proPrecioCosto +
                ", proPrecioVenta=" + proPrecioVenta +
                ", proUndidadMedida='" + proUndidadMedida + '\'' +
                ", idCategoriaProducto=" + idCategoriaProducto +
                ", idProveedor=" + idProveedor +
                '}';
    }
}

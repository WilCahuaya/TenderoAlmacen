package mx.com.encargalo.tendero.Inicio_sesion.Entidades;

public class ga_EntidadListadoProductoTienda {
    private int idListadoProductoTienda;
    private float lptStock;
    private float 	lptStockMinimo;
    private float lptPrecioCompra;
    private float lptPrecioVenta;
    private String lpEstado;
    private int idProducto ;
    private int idTienda;

    public ga_EntidadListadoProductoTienda() {
    }

    public ga_EntidadListadoProductoTienda(int idListadoProductoTienda, float lptStock, float lptStockMinimo, float lptPrecioCompra, float lptPrecioVenta, String lpEstado, int idProducto, int idTienda) {
        this.idListadoProductoTienda = idListadoProductoTienda;
        this.lptStock = lptStock;
        this.lptStockMinimo = lptStockMinimo;
        this.lptPrecioCompra = lptPrecioCompra;
        this.lptPrecioVenta = lptPrecioVenta;
        this.lpEstado = lpEstado;
        this.idProducto = idProducto;
        this.idTienda = idTienda;
    }

    public int getIdListadoProductoTienda() {
        return idListadoProductoTienda;
    }

    public void setIdListadoProductoTienda(int idListadoProductoTienda) {
        this.idListadoProductoTienda = idListadoProductoTienda;
    }

    public float getLptStock() {
        return lptStock;
    }

    public void setLptStock(float lptStock) {
        this.lptStock = lptStock;
    }

    public float getLptStockMinimo() {
        return lptStockMinimo;
    }

    public void setLptStockMinimo(float lptStockMinimo) {
        this.lptStockMinimo = lptStockMinimo;
    }

    public float getLptPrecioCompra() {
        return lptPrecioCompra;
    }

    public void setLptPrecioCompra(float lptPrecioCompra) {
        this.lptPrecioCompra = lptPrecioCompra;
    }

    public float getLptPrecioVenta() {
        return lptPrecioVenta;
    }

    public void setLptPrecioVenta(float lptPrecioVenta) {
        this.lptPrecioVenta = lptPrecioVenta;
    }

    public String getLpEstado() {
        return lpEstado;
    }

    public void setLpEstado(String lpEstado) {
        this.lpEstado = lpEstado;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }

    @Override
    public String toString() {
        return "ga_EntidadListadoProductoTienda{" +
                "idListadoProductoTienda=" + idListadoProductoTienda +
                ", lptStock=" + lptStock +
                ", lptStockMinimo=" + lptStockMinimo +
                ", lptPrecioCompra=" + lptPrecioCompra +
                ", lptPrecioVenta=" + lptPrecioVenta +
                ", lpEstado='" + lpEstado + '\'' +
                ", idProducto=" + idProducto +
                ", idTienda=" + idTienda +
                '}';
    }
}

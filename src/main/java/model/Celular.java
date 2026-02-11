package model;

public class Celular {

    private int id;
    private int idMarca;
    private String modelo;
    private String sistemaOperativo;
    private CategoriaGama gama;
    private double precio;
    private int stock;

    public Celular() {
    }

    public Celular(int idMarca, String modelo, String sistemaOperativo,
                    CategoriaGama gama, double precio, int stock) {
        this.idMarca = idMarca;
        this.modelo = modelo;
        this.sistemaOperativo = sistemaOperativo;
        this.gama = gama;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public CategoriaGama getGama() {
        return gama;
    }

    public void setGama(CategoriaGama gama) {
        this.gama = gama;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return "Celular{" + "id=" + id + ", idMarca=" + idMarca + ", modelo=" + modelo + ", sistemaOperativo=" + sistemaOperativo + ", gama=" + gama + ", precio=" + precio + ", stock=" + stock + '}';
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}

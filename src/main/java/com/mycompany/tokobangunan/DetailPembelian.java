/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tokobangunan;

/**
 *
 * @author User
 */
public class DetailPembelian {
    private String no_pembelian;
    private Produk produk;
    private double harga_beli;
    private double kuantitas;
    
    public DetailPembelian(String no_pembelian, Produk produk, Double harga_beli, Double kuantitas){
        this.no_pembelian = no_pembelian;
        this.produk = produk;
        this.harga_beli = harga_beli;
        this.kuantitas = kuantitas;
    }
    
    public String getNoPembelian(){
        return no_pembelian;
    }
    
    public Produk getProduk(){
        return produk;
    }
    
    public Double getHargaBeli(){
        return harga_beli;
    }
    
    public Double getKuantitas(){
        return kuantitas;
    }
    
    public void setProduk(Produk produk){
        this.produk = produk;
    }
    
    public void setHargaBeli(Double harga_beli){
        this.harga_beli = harga_beli;
    }
    
    public void setKuantitas(Double kuantitas){
        this.kuantitas = kuantitas;
    }
    
    public double getTotalHarga(){
        return harga_beli * kuantitas;
    }
    
    public String tampilkanDetail(){
        return this.produk.getNamaProduk() +
                ", dengan jumlah " +
                this.kuantitas +
                " seharga " +
                Double.toString(this.harga_beli);
    }
}

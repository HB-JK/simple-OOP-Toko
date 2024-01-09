/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tokobangunan;

/**
 *
 * @author User
 */
public class DetailPenjualan {
    private String no_penjualan;
    private Produk produk;
    private double harga_jual;
    private double kuantitas;
    
    public DetailPenjualan(String no_penjualan, Produk produk, Double harga_jual, Double kuantitas){
        this.no_penjualan = no_penjualan;
        this.produk = produk;
        this.harga_jual = harga_jual;
        this.kuantitas = kuantitas;
    }
    
    public String getNoPenjualan(){
        return no_penjualan;
    }
    
    public Produk getProduk(){
        return produk;
    }
    
    public Double getHargaJual(){
        return harga_jual;
    }
    
    public Double getKuantitas(){
        return kuantitas;
    }
    
    public void setProduk(Produk produk){
        this.produk = produk;
    }
    
    public void setHargaBeli(Double harga_jual){
        this.harga_jual = harga_jual;
    }
    
    public void setKuantitas(Double kuantitas){
        this.kuantitas = kuantitas;
    }
    
    public double getTotalHarga(){
        return harga_jual * kuantitas;
    }
    
    public String tampilkanDetail(){
        return this.produk.getNamaProduk() +
                ", dengan jumlah " +
                this.kuantitas +
                " seharga " +
                Double.toString(this.harga_jual);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tokobangunan;

import java.util.UUID;

/**
 *
 * @author User
 */
public class Produk {
    private UUID kode_produk;
    private String nama_produk;
    private String kategori;
    private double stok_produk;
    private double harga_jual;
    
    public Produk(String nama_produk, String kategori, double stok_produk, double harga_jual){
        this.kode_produk = UUID.randomUUID();
        this.nama_produk = nama_produk;
        this.kategori = kategori;
        this.stok_produk = stok_produk;
        this.harga_jual = harga_jual;
    }
    
    public UUID getKodeProduk(){
        return this.kode_produk;
    }
    
    public String getNamaProduk(){
        return this.nama_produk;
    }
    
    public String getKategori(){
        return this.kategori;
    }
    
    public Double getHargaJual(){
        return this.harga_jual;
    }
    
    public Double getStokProduk(){
        return this.stok_produk;
    }
    
    public void setNamaProduk(String nama_produk){
        this.nama_produk = nama_produk;
    }
    
    public void setKategori(String kategori){
        this.kategori = kategori;
    }
    
    public void setStokProduk(double stok_produk){
        this.stok_produk = stok_produk;
    }
    
    public void setHargaJual(double harga_jual){
        this.harga_jual = harga_jual;
    }
    
    public String tampilkanDetail(){
        return this.nama_produk +
                ", dengan harga " +
                Double.toString(this.harga_jual) +
                " memiliki sisa stok " +
                this.stok_produk;
    }
}

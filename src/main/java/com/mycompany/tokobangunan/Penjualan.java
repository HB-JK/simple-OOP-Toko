/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tokobangunan;

import java.util.Date;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;
import java.util.Random;

/**
 *
 * @author User
 */
public class Penjualan {
    private int id_penjualan;
    private String no_penjualan;
    private String nama_customer;
    private String alamat_customer;
    private String metode_pembayaran;
    private DetailPenjualan[] list_produk = new DetailPenjualan[]{};
    
    public Penjualan(String nama_customer, String alamat_customer){
        this.id_penjualan = new Random().nextInt();
        this.no_penjualan = this.generateNoPenjualan();
        this.nama_customer = nama_customer;
        this.alamat_customer = alamat_customer;
    }
    
    private String generateNoPenjualan(){
        DateTimeFormatter year = DateTimeFormatter.ofPattern("yyyy");
        return "PJ-" + year.format(LocalDateTime.now()) + "-1";
    }
    
    public int getIdPenjualan(){
        return id_penjualan;
    }
    
    public String getNoPenjualan(){
        return no_penjualan;
    }
    
    public String getNamaCustomer(){
        return nama_customer;
    }
    
    public String getAlamatCustomer(){
        return alamat_customer;
    }
    
    public String getMetodePembayaran(){
        return metode_pembayaran;
    }
    
    public void setNamaCustomer(String nama_customer){
        this.nama_customer = nama_customer;
    }
    
    public void setAlamatCustomer(String alamat_customer){
        this.alamat_customer = alamat_customer;
    }
    
    public void setMetodePembayaran(String metode_pembayaran){
        this.metode_pembayaran = metode_pembayaran;
    }
    
    public void tambahProdukJual(DetailPenjualan detail){
        this.list_produk[list_produk.length] = detail; //new DetailPenjualan();
    }
    
    public void tampilkanListProdukJual(){
        for(DetailPenjualan detail: list_produk){
            System.out.println(detail.tampilkanDetail());
        }
    }
    
    public Double getTotalPenjualan(){
        double grandTotal = 0;
        
        for(DetailPenjualan detail: list_produk){
            grandTotal += detail.getTotalHarga();
        }
        
        return grandTotal;
    }
}

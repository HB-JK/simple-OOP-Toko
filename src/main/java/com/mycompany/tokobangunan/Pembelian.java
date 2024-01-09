/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tokobangunan;
import java.util.Random;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;

/**
 *
 * @author User
 */
public class Pembelian {
    private int id_pembelian;
    private String no_pembelian;
    private Admin admin;
    private String supplier;
    private DetailPembelian[] list_produk = new DetailPembelian[]{};
    
    public Pembelian(Admin admin, String supplier){
        this.id_pembelian = new Random().nextInt();
        this.no_pembelian = this.generateNoPembelian();
        this.admin = admin;
        this.supplier = supplier;
    }
    
    private String generateNoPembelian(){
        DateTimeFormatter year = DateTimeFormatter.ofPattern("yyyy");
        return "PB-" + year.format(LocalDateTime.now()) + "-1";
    }
    
    public int getIdPembelian(){
        return id_pembelian;
    }
    
    public String getSupplier(){
        return this.supplier;
    }
    
    public void setSupplier(String supplier){
        this.supplier = supplier;
    }
    
    public void tambahProdukBeli(DetailPembelian detail){
        this.list_produk[list_produk.length] = detail;
    }
    
    public void tampilkanListProdukBeli(){
        for(DetailPembelian detail: list_produk){
            System.out.println(detail.tampilkanDetail());
        }
    }
    
    public Double getTotalPembelian(){
        double grandTotal = 0;
        
        for(DetailPembelian detail: list_produk){
            grandTotal += detail.getTotalHarga();
        }
        
        return grandTotal;
    }
}
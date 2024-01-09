package com.mycompany.tokobangunan;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class Admin {
    private String id_admin;
    private String username;
    private HashMap<String,String> user = new HashMap<String, String>();
    private List<Map<String , String>> list_user = new ArrayList<Map<String,String>>();
    private HashMap<Integer, Produk> list_produk = new HashMap<Integer, Produk>();
    
    public Admin(){
        this.user.put("id_admin", "1");
        this.user.put("username", "admin");
        this.user.put("password", "admin");
        
        this.list_user.add(this.list_user.size(), this.user);
    }
    
    public String getIdAdmin(){
        return this.id_admin;
    }
    
    public boolean login(String username, String password){
        try{
            for(Map<String, String> map: list_user){
                if(map.get("username").equals(username) && map.get("password").equals(password)){
                    this.id_admin = map.get("id_admin");
                    this.username = username;
                    return true;
                }
            }
            
            return false;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public int getTotalProduk(){
        return this.list_produk.size();
    }
    
    public void tambahProduk(Produk produk){
        this.list_produk.put(list_produk.size(), produk);
    }
    
    public void editProduk(int itemIndex, Produk produk){
        Produk edit_item = this.getProduk(itemIndex);
        edit_item.setNamaProduk((produk.getNamaProduk().isEmpty()) ? edit_item.getNamaProduk() : produk.getNamaProduk());
        edit_item.setKategori((produk.getKategori().isEmpty()) ? edit_item.getKategori() : produk.getKategori());
        edit_item.setStokProduk((produk.getStokProduk()== null) ? edit_item.getStokProduk() : produk.getStokProduk());
        edit_item.setHargaJual((produk.getHargaJual() == null) ? edit_item.getHargaJual() : produk.getHargaJual());
        
        this.list_produk.replace(itemIndex, edit_item);
    }
    
    public void hapusProduk(int itemIndex){
        this.list_produk.remove(itemIndex - 1);
        this.tampilkanSemuaProduk();
    }
    
    public Produk getProduk(int key){
        return list_produk.get(key - 1);
    }
    
    public void updateStokProduk(int itemIndex, double jumlahBarang, String tipeStok){
        Produk produk = this.getProduk(itemIndex);
        if(tipeStok == "keluar"){
            produk.setStokProduk(produk.getStokProduk() - jumlahBarang);
        }else{
            produk.setStokProduk(produk.getStokProduk() + jumlahBarang);
        }
        
        this.list_produk.replace(itemIndex, produk);
    }
    
    public void tampilkanSemuaProduk(){
        System.out.println("========== List Produk ============");
        for(Map.Entry<Integer, Produk> entry: list_produk.entrySet()){
            Produk produk = entry.getValue();
            System.out.println((entry.getKey() + 1) + ". " + produk.tampilkanDetail());
        }
    }
}

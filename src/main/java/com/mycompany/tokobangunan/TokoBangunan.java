/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tokobangunan;
import java.util.Scanner;
/**
 *
 * @author User
 */
public class TokoBangunan {
    private boolean is_login = false;
    private Scanner inputUser = new Scanner(System.in);
    
    public static void main(String[] args) {
        new TokoBangunan().boot();
    }
    
    public void boot(){
        Admin admin = new Admin();
        
        //User need to input the correct one, if not the user cannot continue to the next step
        while(!this.is_login){
            System.out.println("Masukkan username: ");
            String username = inputUser.nextLine();
            System.out.println("Masukkan password: ");
            String password = inputUser.nextLine();
            
            if(admin.login(username, password)){
                System.out.println("Berhasil login, Apa yang ingin dilakukan\n");
                this.is_login = true;
                this.mainAction(admin);
            }else{
                System.out.println("Username atau password yang dimasukkan itu salah. Silahkan di input lagi\n");
            }
        }
    }
    
    public void mainAction(Admin admin){
        boolean is_done = false;
        
        //The system will keep showing until the user logout or terminate program.
        while(!is_done){
            System.out.println("==========================================================");
            System.out.println("============ Apa yang ingin anda lakukan?   ==============");
            System.out.println("============ 1. Manajemen produk            ==============");
            System.out.println("============ 2. Membeli produk              ==============");
            System.out.println("============ 3. Menjual produk              ==============");
            System.out.println("============ 4. Logout                      ==============");
            System.out.println("==========================================================");
            
            System.out.println("Masukkan sesuai angka dengan opsi yang ingin dilakukan!!");
            int feature_choice = inputUser.nextInt();
            
            switch(feature_choice){
                case 1:
                    this.manajemenProduk(admin);
                    break;
                case 2:
                    System.out.println("Anda memilih untuk membeli produk\n");
                    break;
                case 3:
                    System.out.println("Anda memilih untuk menjual produk\n");
                    break;
                case 4:
                    System.out.println("Anda sudah logout\n");
                    is_done = true;
                    break;
                default:
                    System.out.println("Silahkan pilih opsi yang ada diatas ya\n");
                    break;
            }
        }
    }
    
    public void manajemenProduk(Admin admin){
        boolean is_done = false;
        
        while(!is_done){
            //Deskripsi dari fitur manajemen produk
            System.out.println("\n==========================================================");
            System.out.println("============ Apa yang ingin anda lakukan?   ==============");
            System.out.println("============ 1. Lihat list produk           ==============");
            System.out.println("============ 2. Tambah produk               ==============");
            System.out.println("============ 3. Edit produk                 ==============");
            System.out.println("============ 4. Hapus produk                ==============");
            System.out.println("============ 5. Kembali ke menu sebelumnya  ==============");
            System.out.println("==========================================================");
            
            System.out.println("Masukkan sesuai angka dengan opsi yang ingin dilakukan!!");
            int feature_choice = inputUser.nextInt();
            
            switch(feature_choice){
                case 1: // case 1 untuk menampilkan semua produk yang sudah ditambahkan.
                    admin.tampilkanSemuaProduk(); // new Admin().tampilkanSemuaProduk();
                    break;
                case 2: // case 2 untuk menambahkan produk
                    admin.tambahProduk(this.defineProduk());
                    System.out.println("Berhasil menambahkan produk bernama " + admin.getProduk(admin.getTotalProduk()).getNamaProduk());
                    break;
                case 3: // case 3 untuk aksi edit pada produk yang dipilih
                    if(admin.getTotalProduk() < 1){
                        System.out.println("Produk anda kosong, silahkan tambahkan produk terlebih dahulu");
                        break;
                    }
                    admin.tampilkanSemuaProduk();
                    
                    System.out.println("Silahkan pilih produk yang mau di edit sesuai dengan opsi diatas");
                    int itemIndex = this.inputUser.nextInt();
                    
                    admin.editProduk(itemIndex, this.defineProduk());
                    System.out.println("Berhasil edit produk bernama " + admin.getProduk(admin.getTotalProduk()).getNamaProduk());
                    break;
                case 4:
                    if(admin.getTotalProduk() < 1){
                        System.out.println("Produk anda kosong, silahkan tambahkan produk terlebih dahulu");
                        break;
                    }
                    admin.tampilkanSemuaProduk();
                    
                    System.out.println("Silahkan pilih produk yang mau di hapus sesuai dengan opsi diatas");
                    int itemIndexHapus = this.inputUser.nextInt();
                    
                    admin.hapusProduk(itemIndexHapus);
                    System.out.println("Berhasil menghapus produk");
                    break;
                case 5:
                    is_done = true;
                    break;
                default:
                    System.out.println("Silahkan pilih sesuai dengan opsi diatas");
            }
        }
    }
    
    public Produk defineProduk(){
        System.out.println("Masukkan nama produk");
        String nama_produk = inputUser.next();

        System.out.println("Masukkan kategori produk");
        String kategori = inputUser.next();

        System.out.println("Masukkan jumlah stok awal produk");
        double stok_produk = inputUser.nextFloat();

        System.out.println("Masukkan harga jual produk");
        double harga_jual = inputUser.nextFloat();
        
        return new Produk(nama_produk, kategori, stok_produk, harga_jual);
    }
}

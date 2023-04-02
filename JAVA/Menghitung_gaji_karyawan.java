
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;
public class Menghitung_gaji_karyawan {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

            String nama,pesan,jabatan;
            int jum, gol, status,gapok,anak;
            double pajakgapok,gajibersih,tun_anak,tun_keluarga;

            System.out.println("PROGRAM MENGHITUNG GAJI KARYAWAN");
            System.out.println("-------------------------------------------------");

            System.out.print("Masukan Nama : ");
            nama=input.next();
            System.out.println("Masukan Golongan : ");
            System.out.println("1.Direktur");
            System.out.println("2.Manager");
            System.out.println("3.Kabag");
            System.out.println("4.lainya");
            gol=input.nextInt();
            System.out.println("status :");
            System.out.println("1.Menikah ");
            System.out.println("2.Janda/Duda ");
            System.out.println("3.Belum menikah");
            status = input.nextInt();
          
            tun_keluarga=0;
            tun_anak=0;
            jabatan = "";
            switch(gol){
                case 1 : 
                        gapok=5000000;
                       jabatan="Direktur";
                        break;
                case 2 :
                        gapok=4000000;
                        jabatan="Manager";
                        break;
                case 3 :
                        gapok=3000000;
                       jabatan="Kabag";
                        break;
                case 4 :
                        gapok=2000000;
                        jabatan="lainya";
                        break;
                default :
                        gapok=0;
                        jabatan="";
            }
            pesan="";
            switch(status){
            case 1:pesan="menikah";
                  tun_keluarga=450000;
                break;
            case 2:pesan="Duda/Janda";
                tun_keluarga=450000;
                break;
            case 3:pesan="belum menikah";
                tun_keluarga=0;
                tun_anak=0;
                break;
                  

            }
            anak=0;
         if(status != 3){
            System.out.println("Jumlah anak :");
            anak = input.nextInt();
         }

         if((anak !=0)&&(anak > 1)){
            tun_anak = 200000*2;
         }else if((anak !=0)&&(anak == 1)){
            tun_anak = 200000;
         }else{
            tun_anak = 0;
         }
            formatRp.setCurrencySymbol("Rp. ");
            formatRp.setMonetaryDecimalSeparator(',');
            formatRp.setGroupingSeparator('.');
            kursIndonesia.setDecimalFormatSymbols(formatRp);

           
            pajakgapok=1.5/100*gapok;
            gajibersih=((gapok+tun_anak+tun_keluarga)-pajakgapok);

            System.out.println("Nama                 : "+nama);
            System.out.println("Jabatan              : "+jabatan);
            System.out.println("Gaji Pokok           : "+ kursIndonesia.format(gapok));
            System.out.println("status               : "+pesan);
            System.out.println("Tunjangan Anak       : "+kursIndonesia.format(tun_anak));
            System.out.println("Pajak Gaji Pokok     : "+kursIndonesia.format(pajakgapok));
            System.out.println("Tunjangan Keluarga : "+kursIndonesia.format(tun_keluarga));
            System.out.println("Gaji Diterima        : "+kursIndonesia.format(gajibersih));
          
         
  }  
}
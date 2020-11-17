package oyun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class OyunaGiris {
	/* Oyunun Mantýðý : 10 tane kutu vardýr. 1 kutu yarýþmacýnýn diðer kutular da oyundaki dðer kiþilerin
     * kutularýdýr. Yarýþmacý(oyuncu) sýrasýyla kendi kutusu haricindeki kutularý açtýrýr. Her 3 kutu açýldýktan sonra
     * yarýþmanýn yapýmcýsý tarafýndan kendisine belirli bir miktar para teklif edilir. Oyuncu isterse gelen teklifi kabul eder
     * ya da kutularý açtýrmaya devam ederek kendi kutusundaki ödülü alýr.
     * 
     * 1. Kutu : 1 TL
     * 2. Kutu : 10 TL
     * 3. Kutu : 500 TL
     * 4. Kutu : 1000 TL
     * 5. Kutu : 5000 TL
     * 6. Kutu : 10000 TL
     * 7. Kutu : 50000 TL
     * 8. Kutu : 100000 TL
     * 9. Kutu : 250000 TL
     * 10. Kutu: 500000 TL
     * 
     * Bizim kutumuz 8. kutu olsun.
     * 
     * 1. Adým : Önce 10 farklý para miktarýný elimizde tutabileceðimiz bir tane List<Integer> oluþturalým.
     *           ve bu arrayList'e paraListesi ismini verelim.
     * 
     * 2. Adým : 10 tane Kutu oluþturalým ve her kutunun içerisinde az önce oluþturduðumuz 10 farklý para miktarýndan
     *           herhangi birini rastgele olarak atayalým. Bu kutularý "Kutu" isimli bir class oluþturalým ve o class'ý kullanarak
     *           oluþturalým. Ýçerisine "kutuNumarasi" ve "paraMiktari" diye iki tane "int" deðiþken oluþturalým.
     * 
     *          constructor --> bu constructor yardýmýyla "kutuNumarasi" ve "paraMiktari" deðiþkenlerinin deðerlerini ekleyelim.
     *          getTer --> paraMiktari ve kutuNumarasi degiskenlerinin deðerlerini return eden methodlar oluþturalým.
     * 
     * 3. Adým : Kutularý ekleyebilmek ve kutular üzerinde iþlemler yapabilmek için "Kutular" isminde class oluþturalým.
     *          Oluþturduðumuz tüm Kutu nesnelerini Kutular'a ekleyelim.
     *          Bunun için Kutular class'ýnýn içerisinde çeþitli methodlar oluþturalým.
     *          Ayrýca yapýmcýnýn teklifini almak için bu class'a method oluþturalým.
     * 
     *          public void kutuEkle(Kutu kutu)
     *          public void kutuActir(int kutuNumarasi)
     *          public int kalanKutuSayisiniAl()
     *          public int kutulardakiToplamParaMiktari()
     *          public void secilenKutuyuKutularListesindenKaldir(int kutuNumarasi)
     *          public String acilmamisKutulariGoster()
     *          public int yapimcininTeklifiniAl()
     * 
     * 4. Adým : Oyunu baþlatalým, kullancýdan seçmek istediði kutu numarasýný alalým.
     *          Kullanýcýnýn seçmiþ olduðu kutuyu Kutular class'ýndaki secilenKutuyuKutularListesindenKaldir methoduna gönderelim.
     *          
     *          
     * 
     */
    
    static List<Integer> paraListesi = new ArrayList<>();
    static int kutuNumaram, paraMiktarim;
    static Scanner input = new Scanner(System.in);
    static Kutular kutular = new Kutular();
    
    public static void main(String[] args) {
        paraListesi.add(1);        // 0. index          5000    --> 1. kutu
        paraListesi.add(10);       // 1. index          100000  --> 2. kutu
        paraListesi.add(500);      // 2. index          1       --> 3. kutu
        paraListesi.add(1000);     // 3. index          500     --> 4. kutu
        paraListesi.add(5000);     // 4. index          10      --> 5. kutu
        paraListesi.add(10000);    // 5. index          50000   --> 6. kutu
        paraListesi.add(50000);    // 6. index          250000  --> 7. kutu
        paraListesi.add(100000);   // 7. index          500000  --> 8. kutu
        paraListesi.add(250000);   // 8. index          1000    --> 9. kutu
        paraListesi.add(500000);   // 9. index          500     --> 10. kutu
        
        // arraylistlerimizi rastgele hale getirme..
        Collections.shuffle(paraListesi);
        
        for(int i = 0 ; i < paraListesi.size() ; i++) { // 0 1 2 3 4 5 6 7 8 9
            int kutuNo = i + 1;                         // 1 2 3 4 5 6 7 8 9 10
            Kutu kutu = new Kutu(kutuNo , paraListesi.get(i));
            
            System.out.println("Kutu No : " + kutuNo + " Para Miktari : " + paraListesi.get(i));
            
            kutular.kutuEkle(kutu);
            
        }
        
        System.out.println("     OYUNUMUZA HOÞGELDÝNÝZ    ");
        System.out.println("Lütfen Kutu Seçiniz : ");
        
        kutuNumaram  = input.nextInt();
        paraMiktarim = paraListesi.get( kutuNumaram - 1 );
        
        kutular.secilenKutuyuKutularListesindenKaldir(kutuNumaram);
        
        kutuSecmeActirma();
        
    }
    
    
    
    private static void kutuSecmeActirma() {
        
        System.out.println("\nKalan Kutular : " + kutular.acilmamisKutulariGoster());
        System.out.println("Hangi kutuyu açtýrmak istersiniz ? : ");
        int secim = input.nextInt();
        kutular.kutuActir(secim);
        
        if(kutular.kalanKutuSayisiniAl() == 7   ||  kutular.kalanKutuSayisiniAl() == 4   ||   kutular.kalanKutuSayisiniAl() == 1) {
            System.out.println("\n Yapýmcýnýn Teklifi : " + kutular.yapimcininTeklifiniAl(paraMiktarim));
            
            System.out.println("\n Teklifi Kabul Ediyor Musunuz ? \n 1 - Evet \n 2 - Hayýr");
            
            int devamMi = input.nextInt();
            
            if( devamMi == 1) {
                System.out.println("Oyun Bitti.");
                System.out.println("Kazandýðýnýz Para Miktarý : " + kutular.yapimcininTeklifiniAl(paraMiktarim));
                System.out.println("Kutunuzdaki Miktar : " + paraMiktarim );
            }else {
                kutuSecmeActirma();
            }
            
        }else {
            if(kutular.kalanKutuSayisiniAl()  > 0) {
                kutuSecmeActirma();
            }else {
                System.out.println("Oyun Bitti !");
                System.out.println("Kutunuzdaki Para : " + paraMiktarim);
            }
        }
        
        
    }
    
    
}








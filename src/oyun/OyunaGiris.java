package oyun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class OyunaGiris {
	/* Oyunun Mant��� : 10 tane kutu vard�r. 1 kutu yar��mac�n�n di�er kutular da oyundaki d�er ki�ilerin
     * kutular�d�r. Yar��mac�(oyuncu) s�ras�yla kendi kutusu haricindeki kutular� a�t�r�r. Her 3 kutu a��ld�ktan sonra
     * yar��man�n yap�mc�s� taraf�ndan kendisine belirli bir miktar para teklif edilir. Oyuncu isterse gelen teklifi kabul eder
     * ya da kutular� a�t�rmaya devam ederek kendi kutusundaki �d�l� al�r.
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
     * 1. Ad�m : �nce 10 farkl� para miktar�n� elimizde tutabilece�imiz bir tane List<Integer> olu�tural�m.
     *           ve bu arrayList'e paraListesi ismini verelim.
     * 
     * 2. Ad�m : 10 tane Kutu olu�tural�m ve her kutunun i�erisinde az �nce olu�turdu�umuz 10 farkl� para miktar�ndan
     *           herhangi birini rastgele olarak atayal�m. Bu kutular� "Kutu" isimli bir class olu�tural�m ve o class'� kullanarak
     *           olu�tural�m. ��erisine "kutuNumarasi" ve "paraMiktari" diye iki tane "int" de�i�ken olu�tural�m.
     * 
     *          constructor --> bu constructor yard�m�yla "kutuNumarasi" ve "paraMiktari" de�i�kenlerinin de�erlerini ekleyelim.
     *          getTer --> paraMiktari ve kutuNumarasi degiskenlerinin de�erlerini return eden methodlar olu�tural�m.
     * 
     * 3. Ad�m : Kutular� ekleyebilmek ve kutular �zerinde i�lemler yapabilmek i�in "Kutular" isminde class olu�tural�m.
     *          Olu�turdu�umuz t�m Kutu nesnelerini Kutular'a ekleyelim.
     *          Bunun i�in Kutular class'�n�n i�erisinde �e�itli methodlar olu�tural�m.
     *          Ayr�ca yap�mc�n�n teklifini almak i�in bu class'a method olu�tural�m.
     * 
     *          public void kutuEkle(Kutu kutu)
     *          public void kutuActir(int kutuNumarasi)
     *          public int kalanKutuSayisiniAl()
     *          public int kutulardakiToplamParaMiktari()
     *          public void secilenKutuyuKutularListesindenKaldir(int kutuNumarasi)
     *          public String acilmamisKutulariGoster()
     *          public int yapimcininTeklifiniAl()
     * 
     * 4. Ad�m : Oyunu ba�latal�m, kullanc�dan se�mek istedi�i kutu numaras�n� alal�m.
     *          Kullan�c�n�n se�mi� oldu�u kutuyu Kutular class'�ndaki secilenKutuyuKutularListesindenKaldir methoduna g�nderelim.
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
        
        System.out.println("     OYUNUMUZA HO�GELD�N�Z    ");
        System.out.println("L�tfen Kutu Se�iniz : ");
        
        kutuNumaram  = input.nextInt();
        paraMiktarim = paraListesi.get( kutuNumaram - 1 );
        
        kutular.secilenKutuyuKutularListesindenKaldir(kutuNumaram);
        
        kutuSecmeActirma();
        
    }
    
    
    
    private static void kutuSecmeActirma() {
        
        System.out.println("\nKalan Kutular : " + kutular.acilmamisKutulariGoster());
        System.out.println("Hangi kutuyu a�t�rmak istersiniz ? : ");
        int secim = input.nextInt();
        kutular.kutuActir(secim);
        
        if(kutular.kalanKutuSayisiniAl() == 7   ||  kutular.kalanKutuSayisiniAl() == 4   ||   kutular.kalanKutuSayisiniAl() == 1) {
            System.out.println("\n Yap�mc�n�n Teklifi : " + kutular.yapimcininTeklifiniAl(paraMiktarim));
            
            System.out.println("\n Teklifi Kabul Ediyor Musunuz ? \n 1 - Evet \n 2 - Hay�r");
            
            int devamMi = input.nextInt();
            
            if( devamMi == 1) {
                System.out.println("Oyun Bitti.");
                System.out.println("Kazand���n�z Para Miktar� : " + kutular.yapimcininTeklifiniAl(paraMiktarim));
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








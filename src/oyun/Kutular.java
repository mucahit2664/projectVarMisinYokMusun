package oyun;

import java.util.ArrayList;
import java.util.List;

public class Kutular {
	/*
     *      ---public void kutuEkle(Kutu kutu)
     *      ---public void kutuActir(int kutuNumarasi)
     *      ---public int kalanKutuSayisiniAl()
     *      ---public int kutulardakiToplamParaMiktari()
     *      ---public void secilenKutuyuKutularListesindenKaldir(int kutuNumarasi)
     *      ---public String acilmamisKutulariGoster()
     *      ---public int yapimcininTeklifiniAl()
     */
    
    private List<Kutu> kutuListesi = new ArrayList<>();
    
    public void kutuEkle(Kutu kutu) {
        kutuListesi.add(kutu);
    }
    public int kalanKutuSayisiniAl() {
        return kutuListesi.size();
    }
    
    public int kutulardakiToplamParaMiktari() {
        int toplamPara = 0;
        
        for(Kutu k : kutuListesi) {
            toplamPara = toplamPara + k.getParaMiktari();  
        }
        
        /*for(int i = 0 ; i < kutuListesi.size() ; i++) {
            toplamPara = toplamPara + kutuListesi.get(i).getParaMiktari();
        }*/
        
        return toplamPara;
    }
    
    public String acilmamisKutulariGoster() {
        String kutular = "";
        
        for(Kutu k : kutuListesi) {
            kutular = kutular + " " + k.getKutuNumarasi();   /// 3 5 7
        }
        
        return kutular;
    }
    
    
    public void secilenKutuyuKutularListesindenKaldir(int kutuNumarasi) {
        for(Kutu k : kutuListesi) {
            if(k.getKutuNumarasi()  == kutuNumarasi) {
                kutuListesi.remove(k);
                break;
            }
        }
    }
        
    
    public void kutuActir(int kutuNumarasi) {
        for(Kutu k : kutuListesi) {
            if(k.getKutuNumarasi()  == kutuNumarasi) {
                System.out.println("Kutudaki Para Miktarý : " + k.getParaMiktari());
                kutuListesi.remove(k);
                break;
            }
        }
    }
    
    
    public int yapimcininTeklifiniAl(int oyuncununKendiParaMiktari) {
        int toplam = kutulardakiToplamParaMiktari()   +   oyuncununKendiParaMiktari;
        return (toplam / 4);
    }
    
}

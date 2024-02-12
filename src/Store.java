import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Store {







    public void printStore() {
        boolean inStore = true;
        mainStory mainStory = new mainStory();

        while (inStore) {

            System.out.println("----------------------------------------------------------");
            System.out.println("| Mağza Yönetim Paneline Hoşgeldiniz                     |");
            System.out.println("----------------------------------------------------------");
            System.out.println("| 1 | Ürünleri Listele                                   |");
            System.out.println("| 2 | Marka Listele                                      |");
            System.out.println("| 3 | Marka Ekle                                         |");
            System.out.println("| 4 | Ürün Ara                                           |");
            System.out.println("| 5 | Ürün Ekle                                          |");
            System.out.println("| 6 | Ürün Sil                                           |");
            System.out.println("| 7 | Filtreleme Yap                                     |");
            System.out.println("| 0 | Çıkış                                              |");
            System.out.println("----------------------------------------------------------");
            System.out.print("Yapmak istediğiniz işlemi seçin: ");

            Scanner inp = new Scanner(System.in);
            int choice = inp.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("\nÇıkış yapılıyor. Tekrar bekleriz....");
                    inStore = false;
                    break;
                case 1:
                    System.out.println("\n----------------------------------------------------------");
                    System.out.println("| Ürünler Listeleniyor                                    |");
                    System.out.println("----------------------------------------------------------");
                    mainStory.productList();
                    System.out.println("Ana Menüye Dönülüyor...");
                    break;
                case 2:
                    System.out.println("\n----------------------------------------------------------");
                    System.out.println("| Markalar Listeleniyor                                   |");
                    System.out.println("----------------------------------------------------------");
                    mainStory.printMobilePhoneBrands(mainStory.brandList());
                    System.out.println("Ana Menüye Dönülüyor...");
                    break;
                case 3:
                    System.out.println("\n----------------------------------------------------------");
                    System.out.println("| Marka Ekleniyor                                        |");
                    System.out.println("----------------------------------------------------------");
                    mainStory.brandAdd();
                    System.out.println("Ana Menüye Dönülüyor...");
                    break;
                case 4:
                    System.out.println("\n----------------------------------------------------------");
                    System.out.println("| Ürün Aranıyor                                          |");
                    System.out.println("----------------------------------------------------------");
                    mainStory.productSearch();
                    System.out.println("Ana Menüye Dönülüyor...");
                    break;
                case 5:
                    System.out.println("\n----------------------------------------------------------");
                    System.out.println("| Ürün Ekleniyor                                         |");
                    System.out.println("----------------------------------------------------------");
                    mainStory.productAdd();
                    System.out.println("Ana Menüye Dönülüyor...");
                    break;
                case 6:
                    System.out.println("\n----------------------------------------------------------");
                    System.out.println("| Ürün Siliniyor                                         |");
                    System.out.println("----------------------------------------------------------");
                    mainStory.deleteProduct();
                    break;
                case 7:
                    System.out.println("\n----------------------------------------------------------");
                    System.out.println("| Ürünler Markaya Göre Filtreleniyor                     |");
                    System.out.println("----------------------------------------------------------");
                    mainStory.filterProductByBrandName();
                    break;
                default:
                    System.out.println("Geçersiz işlem seçeneği! Lütfen tekrar deneyin.");
            }
        }
    }
}







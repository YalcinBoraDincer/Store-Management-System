import java.util.*;

public class mainStory {
    Scanner inp=new Scanner(System.in);

    public TreeSet<Laptop> laptops=new TreeSet<>(new Comparator<Laptop>() {
        @Override
        public int compare(Laptop l1, Laptop l2) {
            return l1.getLaptopID()-l2.getLaptopID();
        }
    });
    public TreeSet<MobilePhones>mobilePhones=new TreeSet<>(new Comparator<MobilePhones>() {
        @Override
        public int compare(MobilePhones m1, MobilePhones m2) {
            return m1.getPhoneID()-m2.getPhoneID();
        }
    });

    public TreeSet<Brand> brands=new TreeSet<>(new Comparator<Brand>() {
        @Override
        public int compare(Brand b1, Brand b2) {
            return b1.getName().compareTo(b2.getName());
        }
    });


    //Producing objects for treesets and filling them
    //###############################################
    public TreeSet<Brand> brandList(){
       brands.add(new Brand(1,"Samsung"));
       brands.add(new Brand(2,"Lenovo"));
       brands.add(new Brand(3,"Apple"));
       brands.add(new Brand(4,"Huawei"));
       brands.add(new Brand(5,"Casper"));
       brands.add(new Brand(6,"Asus"));
       brands.add(new Brand(7,"Hp"));
       brands.add(new Brand(8,"Xiaomi"));
       brands.add(new Brand(9,"Monster"));
       brands.add(new Brand(10,"Nokia"));

       return brands;
   }
    public TreeSet<MobilePhones> mobilePhonelist(){
       mobilePhones.add(new MobilePhones(1,"Samsung","GALAXY A51",3199.0,100,30,6,128,6.5,32,4000,"Siyah"));
       mobilePhones.add(new MobilePhones(2,"Apple","IPhone 11",7379.0,90,10,6,64,6.1,5,3046,"Mavi"));
       mobilePhones.add(new MobilePhones(3,"Xiaomi","Redmi Note 10 Pro",4012.0,200,10,12,128,6.5,35,4000,"Beyaz"));
       mobilePhones.add(new MobilePhones(4,"Huawei","P22",3099.0,60,10,8,128,5.5,16,3700,"Beyaz"));
       mobilePhones.add(new MobilePhones(5,"Huawei","Mate 90",15000.0,100,20,12,256,6.6,128,8000,"Siyah"));
       mobilePhones.add(new MobilePhones(6,"Nokia","Lumia 1020",5199.0,25,5,12,128,5.5,32,3000,"Sari"));
       return mobilePhones;
   }
    public TreeSet<Laptop> laptopLists(){
        laptops.add(new Laptop(1,"Huawei","Matebook 14",7000.0,15,12,16,512,14.0));
        laptops.add(new Laptop(2,"Lenovo","V14 IGL",3699.0,21,11,8,1024,14.0));
        laptops.add(new Laptop(3,"Asus","Tuf Gaming",8199.0,10,3,32,2048,15.6));
        laptops.add(new Laptop(4,"Apple","Macbook pro",9999.0,6,2,8,512,13.0));
        laptops.add(new Laptop(5,"Hp","Pavilion Gaming",8766.0,4,12,16,1024,17.0));
        laptops.add(new Laptop(6,"Huawei","Matebook 13",6000.0,25,11,16,512,14.0));
        laptops.add(new Laptop(7,"Monster","Abra A7",17000.0,5,6,64,2048,17.0));
        laptops.add(new Laptop(8,"Monster","Abra Semruk 7",23000.0,5,3,128,2048,17.0));

         return laptops;
   }
    public void productList(){
        boolean inProductList=true;
        while (inProductList){
            System.out.println("1-Telefonlar");
            System.out.println("2-Laptoplar");
            System.out.println("0-Cikis");
            System.out.println("Seciminizi yapin");
            int choice=inp.nextInt();

            switch (choice){
                case 0:
                    System.out.println("Ana menuye donuluyor...");
                    System.out.println();
                    break;
                case 1:
                    printMobilePhone(mobilePhonelist());
                    System.out.println();
                    System.out.println("Ana Menuye Donuluyor.....");
                    System.out.println();
                    System.out.println();
                    inProductList=false;
                    break;
                case 2:
                    printLaptops(laptopLists());
                    System.out.println();
                    System.out.println("Ana Menuye Donuluyor.....");
                    System.out.println();
                    System.out.println();
                    inProductList=false;
                    break;
                default:
                    System.out.println("Hatali tuslama tekrar deneyin ! ");
                    break;

            }




        }

   }
   //###################################################



    //Adding Methods
public void brandAdd() {
        Scanner inp = new Scanner(System.in);

        System.out.println("Marka ekle:");
        System.out.println("Lütfen aşağıdaki tablodaki markalardan farklı bir marka giriniz:");
        printMobilePhoneBrands(brandList());
        System.out.println();

        System.out.println("Eklemek istediğiniz markayı baş harfi büyük olarak şekilde  giriniz:");
        String input = inp.nextLine();

        
        boolean uniqueName = true;
        do {
            uniqueName = true; 

            for (Brand brand : brands) {
                if (brand.getName().equalsIgnoreCase(input)) {
                    uniqueName = false; 
                    System.out.println("Bu marka zaten var, lütfen farklı bir marka giriniz:");
                    input = inp.nextLine();
                    break; 
                }
            }
        } while (!uniqueName); 

        System.out.println("Eklemek istediğiniz marka için benzersiz bir ID giriniz:");
        int idInput = inp.nextInt();

        
        boolean uniqueId = true;
        do {
            uniqueId = true; 

            for (Brand brand : brands) {
                if (brand.getId() == idInput) {
                    uniqueId = false; 
                    System.out.println("Bu ID zaten kullanılıyor, lütfen farklı bir ID giriniz:");
                    idInput = inp.nextInt();
                    break; 
                }
            }
        } while (!uniqueId); 

        brands.add(new Brand(idInput, input));
        System.out.println("Marka başarıyla eklendi. Yeni ürün listesi:");
        System.out.println("-------------------------------------------");
        System.out.println();
        printMobilePhoneBrands(brandList());
        System.out.println();
        System.out.println();
    }

    public MobilePhones mobilePhoneAdd(){
        System.out.println("Telefon ekle : ");
        int ID;
        while (true) {
            System.out.println("Eklemek istediğiniz telefon için benzersiz bir ID belirleyin (sıfırdan büyük bir tam sayı): ");
            while (!inp.hasNextInt()) {
                System.out.println("Geçersiz giriş. Lütfen sıfırdan büyük bir tam sayı girin:");
                inp.next();
            }
            ID = inp.nextInt();
            inp.nextLine();

            if (ID <= 0) {
                System.out.println("Geçersiz ID. ID sıfırdan büyük bir tam sayı olmalıdır.");
                continue;
            }

            boolean isUniqueID = true;
            for (MobilePhones phone : mobilePhonelist()) {
                if (phone.getPhoneID() == ID) {
                    isUniqueID = false;
                    System.out.println("Bu ID'ye sahip bir telefon zaten var. Lütfen benzersiz bir ID girin:");
                    break;
                }
            }

            if (!isUniqueID) {
                continue;
            }


            break;
        }

        inp.nextLine();


        boolean isUniqueID = false;
        while (!isUniqueID) {
            isUniqueID = true;
            for (MobilePhones phone : mobilePhonelist()) {
                if (phone.getPhoneID() == ID) {
                    isUniqueID = false;
                    System.out.println("Bu ID'ye sahip bir telefon zaten var. Lütfen benzersiz bir ID girin:");
                    ID = inp.nextInt();
                    inp.nextLine();
                    break;
                }
            }
        }




        System.out.println("Eklemek istediğiniz telefonun markasını seçiniz! ");
        String phoneBrand = inp.nextLine();
        boolean isContain = false;

        while (true) {
            Iterator<Brand> itr = brands.iterator();
            while (itr.hasNext()) {
                Brand brand = itr.next();
                if (brand.getName().equals(phoneBrand)) {
                    System.out.println("Seçim başarılı, seçilen marka: " + brand.getName());
                    isContain = true;
                    break;
                }
            }
            if (isContain) {
                break;
            } else {
                System.out.println("Lütfen aşağıdaki markalardan birini seçin! ");
                for (Brand b : brandList()) {
                    System.out.println("- " + b.getName());
                }
                System.out.println("Ürünün markasını seçin: ");
                phoneBrand = inp.nextLine();
            }
        }

        System.out.println("Eklemek istediğiniz telefonun modelini giriniz: ");
        String model = inp.nextLine();

        System.out.println("Eklemek istediğiniz telefonun ücretini giriniz: ");
        int price = inp.nextInt();
        inp.nextLine(); // Yeni satır karakterini temizle

        System.out.println("Eklemek istediğiniz telefonun stok adedini giriniz: ");
        int stock = inp.nextInt();
        inp.nextLine(); // Yeni satır karakterini temizle

        System.out.println("Eklemek istediğiniz telefonun indirim oranını giriniz: ");
        double discount = inp.nextDouble();
        inp.nextLine(); // Yeni satır karakterini temizle

        System.out.println("Eklemek istediğiniz telefonun RAM miktarını giriniz: ");
        int ram = inp.nextInt();
        inp.nextLine(); // Yeni satır karakterini temizle

        System.out.println("Eklemek istediğiniz telefonun hafızasını belirleyin: ");
        int storage = inp.nextInt();
        inp.nextLine(); // Yeni satır karakterini temizle

        System.out.println("Eklemek istediğiniz telefonun ekran boyutunu giriniz: ");
        double screenSize = inp.nextDouble();
        inp.nextLine(); // Yeni satır karakterini temizle

        System.out.println("Eklemek istediğiniz telefonun kamera megapikselini giriniz: ");
        double megapixel = inp.nextDouble();
        inp.nextLine(); // Yeni satır karakterini temizle

        System.out.println("Eklemek istediğiniz telefonun batarya kapasitesini giriniz: ");
        int battery = inp.nextInt();
        inp.nextLine(); // Yeni satır karakterini temizle

        System.out.println("Eklemek istediğiniz telefonun rengini giriniz: ");
        String color = inp.nextLine();

        MobilePhones mobilePhones = new MobilePhones(ID, phoneBrand, model, price, stock, discount, ram, storage, screenSize, megapixel, battery, color);
        System.out.println("Telefon başarıyla veritabanına eklendi!");
        return mobilePhones;


    }
    public Laptop laptopAdd() {
        System.out.println("Laptop ekle:");

        int ID;
        while (true) {
            System.out.println("Eklemek istediğiniz laptop için benzersiz bir ID belirleyin (sıfırdan büyük bir tam sayı): ");
            while (!inp.hasNextInt()) {
                System.out.println("Geçersiz giriş. Lütfen sıfırdan büyük bir tam sayı girin:");
                inp.next();
            }
            ID = inp.nextInt();
            inp.nextLine(); // Buffer temizle

            if (ID <= 0) {
                System.out.println("Geçersiz ID. ID sıfırdan büyük bir tam sayı olmalıdır.");
                continue;
            }

            boolean isUniqueID = true;
            for (Laptop laptop : laptopLists()) {
                if (laptop.getLaptopID() == ID) {
                    isUniqueID = false;
                    System.out.println("Bu ID'ye sahip bir laptop zaten var. Lütfen benzersiz bir ID girin:");
                    break;
                }
            }

            if (!isUniqueID) {
                continue;
            }

            break;
        }

        System.out.println("Eklemek istediğiniz laptopun markasını seçiniz:");
        String laptopBrand = inp.nextLine().trim();
        boolean isContain = false;

        while (true) {
            for (Brand brand : brandList()) {
                if (brand.getName().equalsIgnoreCase(laptopBrand)) {
                    System.out.println("Seçim başarılı, seçilen marka: " + brand.getName());
                    isContain = true;
                    break;
                }
            }
            if (isContain) {
                break;
            } else {
                System.out.println("Lütfen aşağıdaki markalardan birini seçin:");
                for (Brand b : brandList()) {
                    System.out.println("- " + b.getName());
                }
                System.out.println("Ürünün markasını seçin:");
                laptopBrand = inp.nextLine().trim();
            }
        }

        System.out.println("Eklemek istediğiniz laptopun modelini giriniz:");
        String model = inp.nextLine();

        System.out.println("Eklemek istediğiniz laptopun ücretini giriniz:");
        int price;
        while (true) {
            if (inp.hasNextInt()) {
                price = inp.nextInt();
                inp.nextLine();
                break;
            } else {
                System.out.println("Geçersiz giriş. Lütfen bir tamsayı girin:");
                inp.next();
            }
        }

        System.out.println("Eklemek istediğiniz laptopun stok adedini giriniz:");
        int stock;
        while (true) {
            if (inp.hasNextInt()) {
                stock = inp.nextInt();
                inp.nextLine();
                break;
            } else {
                System.out.println("Geçersiz giriş. Lütfen bir tamsayı girin:");
                inp.next();
            }
        }

        System.out.println("Eklemek istediğiniz laptopun indirim oranını giriniz:");
        double discount;
        while (true) {
            if (inp.hasNextDouble()) {
                discount = inp.nextDouble();
                inp.nextLine();
                break;
            } else {
                System.out.println("Geçersiz giriş. Lütfen bir ondalık sayı girin:");
                inp.next();
            }
        }

        System.out.println("Eklemek istediğiniz laptopun RAM miktarını giriniz:");
        int ram;
        while (true) {
            if (inp.hasNextInt()) {
                ram = inp.nextInt();
                inp.nextLine();
                break;
            } else {
                System.out.println("Geçersiz giriş. Lütfen bir tamsayı girin:");
                inp.next();
            }
        }

        System.out.println("Eklemek istediğiniz laptopun hafızasını belirleyin:");
        int storage;
        while (true) {
            if (inp.hasNextInt()) {
                storage = inp.nextInt();
                inp.nextLine();
                break;
            } else {
                System.out.println("Geçersiz giriş. Lütfen bir tamsayı girin:");
                inp.next();
            }
        }

        System.out.println("Eklemek istediğiniz laptopun ekran boyutunu giriniz:");
        double screenSize;
        while (true) {
            if (inp.hasNextDouble()) {
                screenSize = inp.nextDouble();
                inp.nextLine();
                break;
            } else {
                System.out.println("Geçersiz giriş. Lütfen bir ondalık sayı girin:");
                inp.next();
            }
        }

        Laptop laptop = new Laptop(ID, laptopBrand, model, price, stock, discount, ram, storage, screenSize);
        System.out.println("Laptop başarıyla veritabanına eklendi!");
        return laptop;
    }




    public void productAdd(){
        System.out.println("Urun Ekle :");
        brandList();
        boolean wannaEnd=true;
        while (wannaEnd){

            for (Products p: Products.catagories()) {
                System.out.println(p.getCatagoryId()+" - "+p.getCaragoryName());
            }
            System.out.println("0-Cikis");
            System.out.println("Katagori Secin : ");
            int catagory=inp.nextInt();

            switch (catagory){
                case 0:
                    System.out.println("Cikmak istediniz sonra gorusruuz ");
                    wannaEnd=false;
                    break;
                case 1:
                    System.out.println("Telefon ekleme istediniz isleminiz devam ediyor ......");
                    mobilePhones.add(mobilePhoneAdd());
                    System.out.println("Ekleme basarili");
                    wannaEnd=false;
                    break;

                case 2:
                    System.out.println("Laptop ekleme istediniz isleminiz devam ediyor ......");
                    laptops.add(laptopAdd());
                    System.out.println("Ekleme basarili");
                    wannaEnd=false;
                    break;
                default:
                    System.out.println("Gecerli bir katagori secin ! ");
                    break;


            }



        }






    }

    //Print Methods

    public void printMobilePhone(TreeSet<MobilePhones> m1){

        System.out.println(" Cep Telefonu Listesi");
        System.out.println(" ----------------------------------------------------------------------------------------------------------------|");
        System.out.println(" | ID | Ürün Adı                | Fiyat    | Marka    | Depolama   | Ekran   | Kamera | Batarya | RAM  | Renk    |");
        System.out.println(" ----------------------------------------------------------------------------------------------------------------|");
        for (MobilePhones p1 : mobilePhones) {
            System.out.printf(" | %-2s| %-24s| %-9s| %-9s| %-11s| %-8s| %-7s| %-9s| %-5s| %-8s|\n",
                    p1.getPhoneID(), p1.getName(), p1.getPrice(), p1.getBrand(), p1.getStorage(), p1.getScreenSize(),
                    p1.getCameraMegapixel(), p1.getBaterrycapacity(), p1.getRam(), p1.getColor());
        }
        System.out.println(" -----------------------------------------------------------------------------------------------------------------");
    }
    public void printLaptops(TreeSet<Laptop> laptops){
        System.out.println(" Laptop Telefonu Listesi");
        System.out.println(" ----------------------------------------------------------------------------------|");
        System.out.println(" | ID | Ürün Adı                | Fiyat    | Marka    | Depolama   | Ekran   | Ram |");
        System.out.println(" ----------------------------------------------------------------------------------|");
        for (Laptop laptop : laptops) {
            System.out.printf(" | %-2s| %-24s| %-9s| %-9s| %-11s| %-8s| %-5s|\n",
                    laptop.getLaptopID(), laptop.getName(), laptop.getPrice(), laptop.getBrand(), laptop.getStorage(), laptop.getScreenSize(),
                    laptop.getRam());
        }
        System.out.println(" ------------------------------------------------------------------------------------");
    }
    public void printMobilePhoneBrands(TreeSet<Brand> brands){
        System.out.println(" Marka  Listesi");
        System.out.println(" ----------------------------------");
        System.out.println(" | ID |      Marka");
        System.out.println(" ----------------------------------");
        for (Brand brand : brands) {
            System.out.printf(" | %-2s| %-24s|\n",
                    brand.getId(), brand.getName());
        }
        System.out.println(" ----------------------------------");
    }
    /*public void printLaptopBrands(TreeSet<Laptop> brands){

            System.out.println(" Marka  Listesi");
            System.out.println(" ----------------------------------");
            System.out.println(" | ID |      Marka");
            System.out.println(" ----------------------------------");
            for (Laptop brand : brands) {
                System.out.printf(" | %-2s| %-24s|\n",
                        brand.getLaptopID(), brand.getBrand());
            }
            System.out.println(" ----------------------------------");
            }
    */





    //Id gore silme islemleri

    public MobilePhones deleteMobilePhone(int idNo) {
        MobilePhones mobilePhone = null;
        Iterator<MobilePhones> itr = mobilePhones.iterator();
        while (itr.hasNext()) {
            MobilePhones currentPhone = itr.next();
            if (currentPhone.getPhoneID() == idNo) {
                mobilePhone = currentPhone;
                itr.remove();
                break;
            }
        }
        return mobilePhone;
    }

    public Laptop deleteLaptop(int idNo) {
        Laptop laptop = null;
        Iterator<Laptop> itr = laptops.iterator();
        while (itr.hasNext()) {
            Laptop currentLaptop = itr.next();
            if (currentLaptop.getLaptopID() == idNo) {
                laptop = currentLaptop;
                itr.remove();
                break;
            }
        }
        return laptop;
    }

    public void deleteProduct(){

        mobilePhonelist();
        laptopLists();

        boolean check=true;
        while (check){
            System.out.println("1-Ürün Sil !");
            System.out.println("0-Cikis yap");
            int choice=inp.nextInt();

            switch (choice){
                case 0:
                    System.out.println("Cikis yapiliyor .....");
                    check=false;
                    break;
                case 1:
                    System.out.println("Silmek istediginiz urun kategorisini seciniz :");
                    System.out.println("1- Telefonlar");
                    System.out.println("2- Laptoplar");
                    System.out.println("0- Ana ekran");
                    int secim=inp.nextInt();
                    if (secim==0){
                        System.out.println("Ana menuye donuluyor...");
                        System.out.println();
                        break;
                    }
                    if (secim==1){
                        printMobilePhone(mobilePhones);
                        System.out.println("Silmek telefonun ID numarasini giriniz: ");
                        int phoneId=inp.nextInt();
                        System.out.println("Urun basariyla silindi yeni telefon listesi :");
                        deleteMobilePhone(phoneId);
                        printMobilePhone(mobilePhones);
                        break;
                    } else if (secim==2) {
                        printLaptops(laptops);
                        System.out.println("Silmek istediginiz laptopun ID numarasini giriniz: ");
                        int laptopId=inp.nextInt();
                        deleteLaptop(laptopId);
                        System.out.println("Urun basariyla silindi yeni laptop listesi :");
                        printLaptops(laptops);
                        break;
                    } else {
                        System.out.println("Hatali giris yaptiniz! Lutfen gecerli bir secenek seciniz.");
                        break;
                    }
                default:
                    System.out.println("Gecersiz deger tekrar deneyin !");
                    break;
            }
        }


    }

    


    //Arama metodlari

    public void searchMobilePhonebyID(int mobilePhoneID){

        boolean found = false;

        for (MobilePhones currentPhone : mobilePhones) {
            if (currentPhone.getPhoneID() == mobilePhoneID) {
                found = true;
                System.out.println("Tebrikler aradiginiz ID'de olan telefon bulundu ");
                System.out.println(" Bilgiler :");
                System.out.println(" ----------------------------------------------------------------------------------------------------------------|");
                System.out.println(" | ID | Ürün Adı                | Fiyat    | Marka    | Depolama   | Ekran   | Kamera | Batarya | RAM  | Renk    |");
                System.out.println(" ----------------------------------------------------------------------------------------------------------------|");
                System.out.printf(" | %-2s| %-24s| %-9s| %-9s| %-11s| %-8s| %-7s| %-9s| %-5s| %-8s|\n",
                        currentPhone.getPhoneID(), currentPhone.getName(), currentPhone.getPrice(), currentPhone.getBrand(), currentPhone.getStorage(), currentPhone.getScreenSize(),
                        currentPhone.getCameraMegapixel(), currentPhone.getBaterrycapacity(), currentPhone.getRam(), currentPhone.getColor());

                System.out.println(" -----------------------------------------------------------------------------------------------------------------");
                break;
            }
        }

        if (!found) {
            System.out.println("Aradığınız ID'de telefon bulunamadı !");
            System.out.println("Ana menuye donuluyor...");
            System.out.println();
        }
    }

    public void searchLaptopbyID(int laptopId){

        boolean found = false;

        for (Laptop currentLaptop : laptops) {
            if (currentLaptop.getLaptopID() == laptopId) {
                found = true;
                System.out.println("Tebrikler aradığınız ID'de olan laptop bulundu ");
                System.out.println(" Bilgiler :");
                System.out.println(" ----------------------------------------------------------------------------------|");
                System.out.println(" | ID | Ürün Adı                | Fiyat    | Marka    | Depolama   | Ekran   | Ram |");
                System.out.println(" ----------------------------------------------------------------------------------|");


                System.out.printf(" | %-2s| %-24s| %-9s| %-9s| %-11s| %-8s| %-5s|\n",
                        currentLaptop.getLaptopID(), currentLaptop.getName(), currentLaptop.getPrice(), currentLaptop.getBrand(), currentLaptop.getStorage(), currentLaptop.getScreenSize(),
                        currentLaptop.getRam());

                System.out.println(" ------------------------------------------------------------------------------------");


                break;
            }
        }


        if (!found) {
            System.out.println("Aradığınız ID'de laptop bulunamadı !");
            System.out.println("Ana menuye donuluyor...");
            System.out.println();
        }
    }

    public void productSearch(){
        mobilePhonelist();
        laptopLists();

        boolean check=true;
        while (check){
            System.out.println("1-Urun aramasi yap !");
            System.out.println("0-Cikis yap");
            int choice=inp.nextInt();

            switch (choice){
                case 0:
                    System.out.println("Cikis yapiliyor .....");
                    check=false;
                    break;
                case 1:
                    System.out.println("Arama yapmak istediginiz urun kategorisini seciniz :");
                    System.out.println("1- Telefonlar");
                    System.out.println("2- Laptoplar");
                    System.out.println("0- Ana ekran");
                    int secim=inp.nextInt();
                    if (secim==0){
                        System.out.println("Ana menuye donuluyor...");
                        System.out.println();
                        break;
                    }
                    if (secim==1){
                        System.out.println("Aramak istediginiz telefonun ID numarasini giriniz: ");
                        int phoneId=inp.nextInt();
                        searchMobilePhonebyID(phoneId);
                        break;
                    } else if (secim==2) {
                        System.out.println("Aramak istediginiz laptopun ID numarasini giriniz: ");
                        int laptopId=inp.nextInt();
                        searchLaptopbyID(laptopId);
                        break;
                    } else {
                        System.out.println("Hatali giris yaptiniz! Lutfen gecerli bir secenek seciniz.");
                        break;
                    }
                default:
                    System.out.println("Gecersiz deger tekrar deneyin !");
                    break;
            }
        }
    }



    // Filtreleme islemleri
    public void filterMobilePhoneByBrand(String brand){
        ArrayList<MobilePhones> sameBrandPhones = new ArrayList<>();
        boolean found = false;

        for (MobilePhones currentPhone : mobilePhones) {
            if (currentPhone.getBrand().equalsIgnoreCase(brand)) {
                sameBrandPhones.add(currentPhone);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Aradığınız markada telefon bulunamadı !");
            System.out.println("Ana menüye dönülüyor...");
            System.out.println();
            return;
        }

        System.out.println("Tebrikler, aradığınız markada olan telefonlar bulundu:");
        System.out.println(" Bilgiler :");
        System.out.println(" ----------------------------------------------------------------------------------------------------------------|");
        System.out.println(" | ID | Ürün Adı                | Fiyat    | Marka    | Depolama   | Ekran   | Kamera | Batarya | RAM  | Renk    |");
        System.out.println(" ----------------------------------------------------------------------------------------------------------------|");

        for (MobilePhones m2 : sameBrandPhones) {
            System.out.printf(" | %-2s| %-24s| %-9s| %-9s| %-11s| %-8s| %-7s| %-9s| %-5s| %-8s|\n",
                    m2.getPhoneID(), m2.getName(), m2.getPrice(), m2.getBrand(), m2.getStorage(), m2.getScreenSize(),
                    m2.getCameraMegapixel(), m2.getBaterrycapacity(), m2.getRam(), m2.getColor());
        }

        System.out.println(" -----------------------------------------------------------------------------------------------------------------");
    }

    public void filterLaptopsByBrand(String brand){
        ArrayList<Laptop> sameBrandLaptops = new ArrayList<>();
        boolean found = false;

        for (Laptop currentLaptop : laptops) {
            if (currentLaptop.getBrand().equalsIgnoreCase(brand)) {
                sameBrandLaptops.add(currentLaptop);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Aradığınız markada laptop bulunamadı !");
            System.out.println("Ana menüye dönülüyor...");
            System.out.println();
            return;
        }

        System.out.println(" Laptop Telefonu Listesi");
        System.out.println(" ----------------------------------------------------------------------------------|");
        System.out.println(" | ID | Ürün Adı                | Fiyat    | Marka    | Depolama   | Ekran   | Ram |");
        System.out.println(" ----------------------------------------------------------------------------------|");

        for (Laptop l2 : sameBrandLaptops) {
            System.out.printf(" | %-2s| %-24s| %-9s| %-9s| %-11s| %-8s| %-5s|\n",
                    l2.getLaptopID(), l2.getName(), l2.getPrice(), l2.getBrand(), l2.getStorage(), l2.getScreenSize(),
                    l2.getRam());
        }
        System.out.println(" ----------------------------------------------------------------------------------|");
    }

    public void filterProductByBrandName(){

        mobilePhonelist();
        laptopLists();

        boolean check=true;
        while (check){
            System.out.println("1-Markaya göre ürün filtrele  !");
            System.out.println("0-Cikis yap");
            int choice=inp.nextInt();

            switch (choice){
                case 0:
                    System.out.println("Cikis yapiliyor .....");
                    check=false;
                    break;
                case 1:
                    System.out.println("Filtreleme yapmak istediginiz urun kategorisini seciniz :");
                    System.out.println("1- Telefonlar");
                    System.out.println("2- Laptoplar");
                    System.out.println("0- Ana ekran");
                    int secim=inp.nextInt();
                    if (secim==0){
                        System.out.println("Ana menuye donuluyor...");
                        System.out.println();
                        break;
                    }
                    if (secim==1){
                        System.out.println("Filtrelemek istediginiz telefonun markasını  giriniz: ");
                        String phoneBrandName=inp.next();
                        filterMobilePhoneByBrand(phoneBrandName);
                        break;
                    } else if (secim==2) {
                        System.out.println("Filtrelemek istediginiz laptopun markasını giriniz: ");
                        String laptopBrand=inp.next();
                        filterLaptopsByBrand(laptopBrand);
                        break;
                    } else {
                        System.out.println("Hatali giris yaptiniz! Lutfen gecerli bir secenek seciniz.");
                        break;
                    }
                default:
                    System.out.println("Gecersiz deger tekrar deneyin !");
                    break;
            }
        }
    }




}//End of mainStory
































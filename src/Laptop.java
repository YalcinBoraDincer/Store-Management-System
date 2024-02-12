public class Laptop {
    private int laptopID;
    private String brand;
    private String name;
    private double price;
    private int stock;
    private double discountRate;
    private int ram;
    private int storage;
    private double screenSize;

    public Laptop(int laptopID, String brand, String name, double price, int stock, double discountRate, int ram, int storage, double screenSize) {
        this.laptopID = laptopID;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.discountRate = discountRate;
        this.ram = ram;
        this.storage = storage;
        this.screenSize = screenSize;
    }

    public int getLaptopID() {
        return laptopID;
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public double getScreenSize() {
        return screenSize;
    }
}


import java.util.ArrayList;

public class Products {
    private int catagoryId;
    private String caragoryName;

    public Products(int catagoryId, String caragoryName) {
        this.catagoryId = catagoryId;
        this.caragoryName = caragoryName;
    }
    public static ArrayList<Products> catagories(){
        ArrayList<Products> catagories=new ArrayList<>();
        catagories.add(new Products(1,"Telefonlar"));
        catagories.add(new Products(2,"Laptoplar"));
        return catagories;
}

    public int getCatagoryId() {
        return catagoryId;
    }

    public String getCaragoryName() {
        return caragoryName;
    }
}

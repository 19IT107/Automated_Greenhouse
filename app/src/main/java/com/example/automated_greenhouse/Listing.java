package  com.example.automated_greenhouse;


public class Listing {
    private int ItemImage;
    private String ItemTemperature;
    private String ItemSoil;
    private String ItemHumidity;
    private String ItemPH;
    private String ItemName;

    public Listing(int itemImage, String itemTemperature, String itemSoil, String itemHumidity, String itemPH, String itemName) {
        ItemImage = itemImage;
        ItemTemperature = itemTemperature;
        ItemSoil = itemSoil;
        ItemHumidity = itemHumidity;
        ItemPH = itemPH;
        ItemName = itemName;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public int getItemImage() {
        return ItemImage;
    }

    public void setItemImage(int itemImage) {
        ItemImage = itemImage;
    }

    public String getItemTemperature() {
        return ItemTemperature;
    }

    public void setItemTemperature(String itemTemperature) {
        ItemTemperature = itemTemperature;
    }

    public String getItemSoil() {
        return ItemSoil;
    }

    public void setItemSoil(String itemSoil) {
        ItemSoil = itemSoil;
    }

    public String getItemHumidity() {
        return ItemHumidity;
    }

    public void setItemHumidity(String itemHumidity) {
        ItemHumidity = itemHumidity;
    }

    public String getItemPH() {
        return ItemPH;
    }

    public void setItemPH(String itemPH) {
        ItemPH = itemPH;
    }
}


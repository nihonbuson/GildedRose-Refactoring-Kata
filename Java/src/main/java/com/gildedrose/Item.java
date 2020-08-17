package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    void increaseQuality() {
        quality = quality + 1;
    }

    void decreaseQuality() {
        quality = quality - 1;
    }

    void decreaseSellIn() {
        sellIn = sellIn - 1;
    }

    boolean isMaxQuality() {
        return quality >= 50;
    }

    boolean isMinQuality() {
        return quality <= 0;
    }

    boolean isWithinSales() {
        return sellIn >= 0;
    }
}

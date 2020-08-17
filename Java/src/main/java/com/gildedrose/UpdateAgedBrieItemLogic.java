package com.gildedrose;

public class UpdateAgedBrieItemLogic implements UpdateItemLogic {
    @Override
    public void updateSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    @Override
    public void updateQuality(Item item) {
        if (item.quality < 50) {
            increaseQuality(item);
        }
        if (item.sellIn < 0) {
            if (item.quality < 50) {
                increaseQuality(item);
            }
        }
    }

    private void increaseQuality(Item item) {
        item.quality = item.quality + 1;
    }
}

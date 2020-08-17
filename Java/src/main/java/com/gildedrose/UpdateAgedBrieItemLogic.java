package com.gildedrose;

public class UpdateAgedBrieItemLogic implements UpdateItemLogic {
    @Override
    public void updateSellIn(Item item) {
        item.decreaseSellIn();
    }

    @Override
    public void updateQuality(Item item) {
        if (item.quality < 50) {
            item.increaseQuality();
        }
        if (item.sellIn < 0) {
            if (item.quality < 50) {
                item.increaseQuality();
            }
        }
    }

}

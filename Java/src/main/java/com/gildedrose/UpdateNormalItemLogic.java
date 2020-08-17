package com.gildedrose;

public class UpdateNormalItemLogic implements UpdateItemLogic {
    @Override
    public void updateSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    @Override
    public void updateQuality(Item item) {
        if (item.quality > 0) {
            item.decreaseQuality();
        }
        if (item.sellIn < 0) {
            if (item.quality > 0) {
                item.decreaseQuality();
            }
        }
    }

}

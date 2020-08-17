package com.gildedrose;

public class UpdateBackstagePassItemLogic implements UpdateItemLogic {
    @Override
    public void updateSellIn(Item item) {
        item.decreaseSellIn();
    }

    @Override
    public void updateQuality(Item item) {
        if (!item.isMaxQuality()) {
            item.increaseQuality();

            if (item.sellIn < 10) {
                if (!item.isMaxQuality()) {
                    item.increaseQuality();
                }
            }

            if (item.sellIn < 5) {
                if (!item.isMaxQuality()) {
                    item.increaseQuality();
                }
            }
        }
        if (!item.isWithinSales()) {
            item.quality = 0;
        }
    }

}

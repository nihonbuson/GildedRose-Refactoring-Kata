package com.gildedrose;

public class UpdateAgedBrieItemLogic implements UpdateItemLogic {
    @Override
    public void updateSellIn(Item item) {
        item.decreaseSellIn();
    }

    @Override
    public void updateQuality(Item item) {
        if (!item.isMaxQuality()) {
            item.increaseQuality();
        }
        if (!item.isWithinSales()) {
            if (!item.isMaxQuality()) {
                item.increaseQuality();
            }
        }
    }

}

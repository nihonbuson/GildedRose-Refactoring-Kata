package com.gildedrose;

public class UpdateBackstagePassItemLogic implements UpdateItemLogic {
    @Override
    public void updateSellIn(Item item) {
        item.decreaseSellIn();
    }

    @Override
    public void updateQuality(Item item) {
        if (item.isLessMaxValue()) {
            item.increaseQuality();

            if (item.sellIn < 10) {
                if (item.isLessMaxValue()) {
                    item.increaseQuality();
                }
            }

            if (item.sellIn < 5) {
                if (item.isLessMaxValue()) {
                    item.increaseQuality();
                }
            }
        }
        if (!item.isWithinSales()) {
            item.quality = 0;
        }
    }

}

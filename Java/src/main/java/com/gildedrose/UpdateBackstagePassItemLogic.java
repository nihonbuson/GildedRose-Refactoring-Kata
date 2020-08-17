package com.gildedrose;

public class UpdateBackstagePassItemLogic implements UpdateItemLogic {
    @Override
    public void updateSellIn(Item item) {
        item.decreaseSellIn();
    }

    @Override
    public void updateQuality(Item item) {
        if (item.quality < 50) {
            item.increaseQuality();

            if (item.sellIn < 10) {
                if (item.quality < 50) {
                    item.increaseQuality();
                }
            }

            if (item.sellIn < 5) {
                if (item.quality < 50) {
                    item.increaseQuality();
                }
            }
        }
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

}

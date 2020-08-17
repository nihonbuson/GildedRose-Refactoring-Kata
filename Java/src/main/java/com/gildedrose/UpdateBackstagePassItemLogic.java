package com.gildedrose;

public class UpdateBackstagePassItemLogic implements UpdateItemLogic {
    @Override
    public void updateSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    @Override
    public void updateQuality(Item item) {
        if (item.quality < 50) {
            increaseQuality(item);

            if (item.sellIn < 10) {
                if (item.quality < 50) {
                    increaseQuality(item);
                }
            }

            if (item.sellIn < 5) {
                if (item.quality < 50) {
                    increaseQuality(item);
                }
            }
        }
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private void increaseQuality(Item item) {
        item.quality = item.quality + 1;
    }
}

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

            if (isWithInDaysRemaining(item, 10)) {
                if (item.isLessMaxValue()) {
                    item.increaseQuality();
                }
            }

            if (isWithInDaysRemaining(item, 5)) {
                if (item.isLessMaxValue()) {
                    item.increaseQuality();
                }
            }
        }
        if ((item.isWithinSales()) == false) {
            item.quality = 0;
        }
    }

    private boolean isWithInDaysRemaining(Item item, int i) {
        return item.sellIn < i;
    }

}

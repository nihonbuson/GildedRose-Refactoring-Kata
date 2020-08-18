package com.gildedrose;

public class UpdateNormalItemLogic implements UpdateItemLogic {
    @Override
    public void updateSellIn(Item item) {
        item.decreaseSellIn();
    }

    @Override
    public void updateQuality(Item item) {
        if (item.isPlusValue()) {
            item.decreaseQuality();
        }
        if (!item.isWithinSales()) {
            if (item.isPlusValue()) {
                item.decreaseQuality();
            }
        }
    }

}

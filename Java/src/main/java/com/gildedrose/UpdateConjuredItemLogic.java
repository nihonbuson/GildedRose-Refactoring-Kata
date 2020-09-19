package com.gildedrose;

public class UpdateConjuredItemLogic implements UpdateItemLogic {
    @Override
    public void updateSellIn(Item item) {
        item.decreaseSellIn();
    }

    @Override
    public void updateQuality(Item item) {
        item.decreaseQuality();
        item.decreaseQuality();
    }
}

package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            updateItem(items[i]);
        }
    }

    private void updateItem(Item item) {
        UpdateItemLogic updateItemLogic = selectItemLogic(item);
        updateItemLogic.updateSellIn(item);
        updateItemLogic.updateQuality(item);
    }

    private UpdateItemLogic selectItemLogic(Item item) {
        if (isSulfuras(item)) {
            return new UpdateSulfurasItemLogic();
        }
        if (isAgedBrie(item)) {
            return new UpdateAgedBrieItemLogic();
        }
        if (isBackstagePass(item)) {
            return new UpdateBackstagePassItemLogic();
        }
        return new UpdateNormalItemLogic();
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isBackstagePass(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }
}
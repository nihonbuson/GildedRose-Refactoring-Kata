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
        ICategorizedItem categorizedItem;
        if (isSulfuras(item)) {
            categorizedItem = new SulfurasItem(item);
            categorizedItem.updateItem();
            return;
        }

        if (isAgedBrie(item)) {
            categorizedItem = new AgedBrieItem(item);
            categorizedItem.updateItem();
        } else if (isBackstagePass(item)) {
            categorizedItem = new BackstagePassItem(item);
            categorizedItem.updateItem();
        } else {
            categorizedItem = new NormalItem(item);
            categorizedItem.updateItem();
        }

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
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
        if (isSulfuras(item)) {
            updateSulfurasItem(item);
            return;
        }

        item.sellIn = item.sellIn - 1;

        if (isAgedBrie(item)) {
            if (item.quality < 50) {
                increaseQuality(item);
            }
            if (item.sellIn < 0) {
                if (item.quality < 50) {
                    increaseQuality(item);
                }
            }
        } else if (isBackstagePass(item)) {
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
        } else {
            if (item.quality > 0) {
                decreaseQuality(item);
            }
            if (item.sellIn < 0) {
                if (item.quality > 0) {
                    decreaseQuality(item);
                }
            }
        }

        if (isAgedBrie(item)) {
        } else {
            if (isBackstagePass(item)) {
            } else {
            }
        }
    }

    private void updateSulfurasItem(Item item) {

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

    private void decreaseQuality(Item item) {
        item.quality = item.quality - 1;
    }

    private void increaseQuality(Item item) {
        item.quality = item.quality + 1;
    }
}
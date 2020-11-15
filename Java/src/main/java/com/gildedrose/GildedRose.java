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
        if (isSulfuras(item)){
            return;
        }

        if (isAgedBrie(item)) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;

                if (isBackstagePass(item)) {
                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
            }
        } else if (isBackstagePass(item)) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;

                if (isBackstagePass(item)) {
                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
            }
        } else {
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            if (isAgedBrie(item)) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            } else {
                if (isBackstagePass(item)) {
                    item.quality = item.quality - item.quality;
                } else {
                    if (item.quality > 0) {
                        item.quality = item.quality - 1;
                    }
                }
            }
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
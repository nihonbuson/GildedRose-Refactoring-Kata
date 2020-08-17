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

    private void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void updateNormalQuality(Item item) {
        if (item.quality > 0) {
            decreaseQuality(item);
        }
        if (item.sellIn < 0) {
            if (item.quality > 0) {
                decreaseQuality(item);
            }
        }
    }

    private void updateBackstageQuality(Item item) {
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

    private void updateAgedBrieQuality(Item item) {
        if (item.quality < 50) {
            increaseQuality(item);
        }
        if (item.sellIn < 0) {
            if (item.quality < 50) {
                increaseQuality(item);
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
package com.gildedrose;

import com.gildedrose.categorizeditem.ICategorizedItem;

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
        ICategorizedItem categorizedItem = CategorizedItemFactory.create(item);

        categorizedItem.updateItem();

    }
}
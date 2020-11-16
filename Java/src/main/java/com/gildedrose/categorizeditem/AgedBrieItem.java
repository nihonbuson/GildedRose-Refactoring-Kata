package com.gildedrose.categorizeditem;

import com.gildedrose.Item;

public class AgedBrieItem implements ICategorizedItem {
	private Item item;

	public AgedBrieItem(Item item) {

		this.item = item;
	}

	@Override
	public void updateItem() {
		item.increaseQuality();
		item.decreaseSellIn();
		if (item.sellIn < 0) {
			item.increaseQuality();
		}
	}

}

package com.gildedrose.categorizeditem;

import com.gildedrose.Item;

public class NormalItem implements ICategorizedItem {
	private Item item;

	public NormalItem(Item item) {
		this.item = item;
	}

	@Override
	public void updateItem() {
		item.decreaseQuality();
		item.decreaseSellIn();
		if (item.sellIn < 0) {
			item.decreaseQuality();
		}

	}

}

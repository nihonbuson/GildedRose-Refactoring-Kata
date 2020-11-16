package com.gildedrose.categorizeditem;

import com.gildedrose.Item;

public class BackstagePassItem implements ICategorizedItem {
	private Item item;

	public BackstagePassItem(Item item) {
		this.item = item;
	}

	@Override
	public void updateItem() {
		if (item.sellIn <= 5) {
			increaseQuality(3);
		} else if (item.sellIn <= 10) {
			increaseQuality(2);
		} else {
			increaseQuality(1);
		}
		item.decreaseSellIn();
		if (item.sellIn < 0) {
			item.quality = 0;
		}

	}

	private void increaseQuality(int times) {
		for (int i=0;i<times;i++){
			item.increaseQuality();
		}
	}

}

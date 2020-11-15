package com.gildedrose;

public class AgedBrieItem implements ICategorizedItem {
	private Item item;

	public AgedBrieItem(Item item) {

		this.item = item;
	}

	@Override
	public void updateItem() {
		item.increaseQuality();
		item.sellIn = item.sellIn - 1;
		if (item.sellIn < 0) {
			item.increaseQuality();
		}
	}

}

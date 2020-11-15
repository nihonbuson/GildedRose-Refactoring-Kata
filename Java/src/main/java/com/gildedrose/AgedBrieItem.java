package com.gildedrose;

public class AgedBrieItem implements ICategorizedItem {
	private Item item;

	public AgedBrieItem(Item item) {

		this.item = item;
	}

	@Override
	public void updateItem() {
		if (item.quality < 50) {
			item.quality = item.quality + 1;
		}
		item.sellIn = item.sellIn - 1;
		if (item.sellIn < 0) {
			if (item.quality < 50) {
				item.quality = item.quality + 1;
			}
		}
	}
}

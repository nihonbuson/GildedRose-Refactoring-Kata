package com.gildedrose;

public class AgedBrieItem implements ICategorizedItem {
	private Item item;

	public AgedBrieItem(Item item) {

		this.item = item;
	}

	@Override
	public void updateItem() {
		increaseQuality();
		item.sellIn = item.sellIn - 1;
		if (item.sellIn < 0) {
			increaseQuality();
		}
	}

	private void increaseQuality() {
		if (item.quality < 50) {
			item.quality = item.quality + 1;
		}
	}
}

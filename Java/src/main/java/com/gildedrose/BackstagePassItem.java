package com.gildedrose;

public class BackstagePassItem implements ICategorizedItem {
	private Item item;

	public BackstagePassItem(Item item) {
		this.item = item;
	}

	@Override
	public void updateItem() {
		if (item.quality < 50) {
			item.increaseQuality();

			if (item.sellIn < 11) {
				item.increaseQuality();
			}

			if (item.sellIn < 6) {
				item.increaseQuality();
			}
		}
		item.sellIn = item.sellIn - 1;
		if (item.sellIn < 0) {
			item.quality = item.quality - item.quality;
		}

	}

}

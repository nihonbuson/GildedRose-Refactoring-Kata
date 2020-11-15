package com.gildedrose;

public class NormalItem implements ICategorizedItem {
	private Item item;

	public NormalItem(Item item) {
		this.item = item;
	}

	@Override
	public void updateItem() {
		if (item.quality > 0) {
			descreaseQuality();
		}
		item.sellIn = item.sellIn - 1;
		if (item.sellIn < 0) {
			if (item.quality > 0) {
				descreaseQuality();
			}
		}

	}

	private void descreaseQuality() {
		item.quality = item.quality - 1;
	}
}

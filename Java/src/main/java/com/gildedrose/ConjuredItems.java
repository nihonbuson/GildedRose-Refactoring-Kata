package com.gildedrose;

public class ConjuredItems implements ICategorizedItems {
	private Item item;

	public ConjuredItems(Item item) {
		this.item = item;
	}

	@Override
	public void updateItem() {
		item.decreaseQuality();
		item.decreaseQuality();
		item.decreaseSellIn();
		if (item.isNotInSale()) {
			item.decreaseQuality();
			item.decreaseQuality();
		}
	}
}

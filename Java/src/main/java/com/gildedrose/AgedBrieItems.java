package com.gildedrose;

public class AgedBrieItems implements ICategorizedItems {
	private Item item;

	public AgedBrieItems(Item item) {
		this.item = item;
	}

	@Override
	public void updateItem() {
		item.increaseQuality();
		item.decreaseSellIn();
		if (item.isNotInSale()) {
			item.increaseQuality();
		}
	}

}

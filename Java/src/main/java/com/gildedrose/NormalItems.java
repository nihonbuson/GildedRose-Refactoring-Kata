package com.gildedrose;

public class NormalItems implements ICategorizedItems {
	private Item item;

	public NormalItems(Item item) {
		this.item = item;
	}

	@Override
	public void updateItem() {
		item.decreaseQuality();
		item.decreaseSellIn();
		if (item.isNotInSale()) {
			item.decreaseQuality();
		}

	}

}

package com.gildedrose;

public class BackstageItems implements ICategorizedItems {
	private Item item;

	public BackstageItems(Item item) {

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
		if (item.isNotInSale()) {
			item.quality = 0;
		}
	}

	private void increaseQuality(int plusValue) {
		for(int i = 0; i < plusValue ; i++){
			item.increaseQuality();
		}
	}
}

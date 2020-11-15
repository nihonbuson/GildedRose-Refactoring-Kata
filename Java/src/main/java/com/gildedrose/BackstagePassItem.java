package com.gildedrose;

public class BackstagePassItem implements ICategorizedItem {
	private Item item;

	public BackstagePassItem(Item item) {
		this.item = item;
	}

	@Override
	public void updateItem() {
		if (item.sellIn < 6) {
			increaseQuality(3);
		} else if (item.sellIn < 11) {
			increaseQuality(2);
		} else if (item.quality < 50) {
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

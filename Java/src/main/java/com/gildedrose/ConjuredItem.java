package com.gildedrose;

public class ConjuredItem implements ICategorizedItem {
	private Item item;

	public ConjuredItem(Item item) {
		this.item = item;
	}

	@Override
	public void updateItem() {
		item.decreaseQuality();
		if(item.name.equals("Conjured")){
			item.decreaseQuality();
		}
		item.decreaseSellIn();
		if (item.sellIn < 0) {
			item.decreaseQuality();
			if(item.name.equals("Conjured")){
				item.decreaseQuality();
			}
		}

	}
}

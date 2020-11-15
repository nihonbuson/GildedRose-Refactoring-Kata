package com.gildedrose;

public class CategorizedItemFactory {
	public static ICategorizedItem create(Item item) {
		if (isSulfuras(item)) {
			return new SulfurasItem(item);
		} else if (isAgedBrie(item)) {
			return new AgedBrieItem(item);
		} else if (isBackstagePass(item)) {
			return new BackstagePassItem(item);
		} else {
			return new NormalItem(item);
		}
	}
	private static boolean isSulfuras(Item item) {
		return item.name.equals("Sulfuras, Hand of Ragnaros");
	}

	private static boolean isBackstagePass(Item item) {
		return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
	}

	private static boolean isAgedBrie(Item item) {
		return item.name.equals("Aged Brie");
	}

}

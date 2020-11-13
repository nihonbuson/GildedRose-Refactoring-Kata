package com.gildedrose;

public class CategorizedFactory {

	private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";;
	private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
	private static final String AGED_BRIE = "Aged Brie";
	private static final String CONJURED = "Conjured";

	public static ICategorizedItems create(Item item) {
		if(isSulfuras(item)){
			return new SulfurasItems(item);
		} else if (isBackstage(item)) {
			return new BackstageItems(item);
		} else if (isAgedBrie(item)) {
			return new AgedBrieItems(item);
		} else if(isConjured(item)){
			return new ConjuredItems(item);
		} else {
			return new NormalItems(item);
		}
	}

	private static boolean isConjured(Item item) {
		return item.name.equals(CONJURED);
	}

	private static boolean isSulfuras(Item item) {
		return item.name.equals(SULFURAS);
	}

	private static boolean isBackstage(Item item) {
		return item.name.equals(BACKSTAGE);
	}

	private static boolean isAgedBrie(Item item) {
		return item.name.equals(AGED_BRIE);
	}
}

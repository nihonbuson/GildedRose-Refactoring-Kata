package com.gildedrose;

import com.gildedrose.categorizeditem.AgedBrieItem;
import com.gildedrose.categorizeditem.BackstagePassItem;
import com.gildedrose.categorizeditem.ConjuredItem;
import com.gildedrose.categorizeditem.ICategorizedItem;
import com.gildedrose.categorizeditem.NormalItem;
import com.gildedrose.categorizeditem.SulfurasItem;

public class CategorizedItemFactory {

	private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
	private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
	private static final String AGED_BRIE = "Aged Brie";
	private static final String CONJURED = "Conjured";

	public static ICategorizedItem create(Item item) {
		if (isSulfuras(item)) {
			return new SulfurasItem(item);
		} else if (isAgedBrie(item)) {
			return new AgedBrieItem(item);
		} else if (isBackstagePass(item)) {
			return new BackstagePassItem(item);
		} else if (isConjured(item)) {
			return new ConjuredItem(item);
		} else {
			return new NormalItem(item);
		}
	}

	public static boolean isConjured(Item item) {
		return item.name.equals(CONJURED);
	}

	private static boolean isSulfuras(Item item) {
		return item.name.equals(SULFURAS);
	}

	private static boolean isBackstagePass(Item item) {
		return item.name.equals(BACKSTAGE_PASSES);
	}

	private static boolean isAgedBrie(Item item) {
		return item.name.equals(AGED_BRIE);
	}

}

package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void _通常商品で更新しても商品名は変わらない() {
        Item[] items = new Item[] { new Item("foo", 20, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void _通常商品で更新するとsellIn値が1減る() {
        Item[] items = new Item[] { new Item("foo", 20, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(19, app.items[0].sellIn);
    }

    @Test
    void _通常商品で更新するとquality値が1減る() {
        Item[] items = new Item[] { new Item("foo", 20, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(29, app.items[0].quality);
    }

}

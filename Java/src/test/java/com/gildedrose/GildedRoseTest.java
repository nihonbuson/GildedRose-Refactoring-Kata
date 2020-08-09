package com.gildedrose;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Nested
    class _通常のItem{
        @Test
        void _updateQualityを実行してもitem名が変わらない() {
            Item[] items = new Item[] { new Item("foo", 10, 20) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals("foo", app.items[0].name);
        }

        @Test
        void _updateQualityを実行するとsellIn値が1減る() {
            Item[] items = new Item[] { new Item("foo", 10, 20) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(9, app.items[0].sellIn);
        }

        @Test
        void _updateQualityを実行するとquality値が1減る() {
            Item[] items = new Item[] { new Item("foo", 10, 20) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(19, app.items[0].quality);
        }
    }

    @Nested
    class _Aged_BrieのItem{
        @Test
        void _Aged_BrieのitemでupdateQualityを実行してもitem名が変わらない() {
            Item[] items = new Item[] { new Item("Aged Brie", 10, 20) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals("Aged Brie", app.items[0].name);
        }

        @Test
        void _Aged_BrieのitemでupdateQualityを実行するとsellIn値が1減る() {
            Item[] items = new Item[] { new Item("Aged Brie", 10, 20) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(9, app.items[0].sellIn);
        }

        @Test
        void _Aged_BrieのitemでupdateQualityを実行するとquality値が1増える() {
            Item[] items = new Item[] { new Item("Aged Brie", 10, 20) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(21, app.items[0].quality);
        }
    }

}

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

        @Test
        void _Quality値が1の時にupdateQualityを実行するとquality値が1減る() {
            Item[] items = new Item[] { new Item("foo", 10, 1) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(0, app.items[0].quality);
        }

        @Test
        void _Quality値が0の時にupdateQualityを実行するとquality値が変わらない() {
            Item[] items = new Item[] { new Item("foo", 10, 0) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(0, app.items[0].quality);
        }

        @Test
        void _SellIn値が1の時にupdateQualityを実行するとquality値が1減る() {
            Item[] items = new Item[] { new Item("foo", 1, 20) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(19, app.items[0].quality);
        }

        @Test
        void _SellIn値が0の時にupdateQualityを実行するとquality値が2減る() {
            Item[] items = new Item[] { new Item("foo", 0, 20) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(18, app.items[0].quality);
        }

        @Test
        void _SellIn値が0でQuality値が1の時にupdateQualityを実行するとquality値がマイナスにはならず0になる() {
            Item[] items = new Item[] { new Item("foo", 1, 1) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(0, app.items[0].quality);
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
            Item[] items = new Item[] { new Item("Aged Brie", 10, 49) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(50, app.items[0].quality);
        }

        @Test
        void _Aged_BrieのitemでQuality値が50以上だった時にupdateQualityを実行するとquality値が変わらない() {
            Item[] items = new Item[] { new Item("Aged Brie", 10, 50) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(50, app.items[0].quality);
        }

        @Test
        void _Aged_BrieのitemでSellIn値が1の時にupdateQualityを実行するとquality値が1増える() {
            Item[] items = new Item[] { new Item("Aged Brie", 1, 20) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(21, app.items[0].quality);
        }

        @Test
        void _Aged_BrieのitemでSellIn値が0の時にupdateQualityを実行するとquality値が2増える() {
            Item[] items = new Item[] { new Item("Aged Brie", 0, 20) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(22, app.items[0].quality);
        }

        @Test
        void _Aged_BrieのitemでSellIn値が0_Quality値が49の時にupdateQualityを実行するとquality値が50になる() {
            Item[] items = new Item[] { new Item("Aged Brie", 0, 49) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(50, app.items[0].quality);
        }
    }

    @Nested
    class _BackstageのItem{
        @Test
        void _BackstageのitemでupdateQualityを実行してもitem名が変わらない() {
            Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        }

        @Test
        void _BackstageのitemでupdateQualityを実行するとsellIn値が1減る() {
            Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(14, app.items[0].sellIn);
        }

        @Test
        void _BackstageのitemでSellIn値が11以上だった時にupdateQualityを実行するとquality値が1増える() {
            Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(21, app.items[0].quality);
        }

        @Test
        void _BackstageのitemでSellIn値が10以下だった時にupdateQualityを実行するとquality値が2増える() {
            Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(22, app.items[0].quality);
        }

        @Test
        void _BackstageのitemでSellIn値が6以上だった時にupdateQualityを実行するとquality値が2増える() {
            Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 6, 20) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(22, app.items[0].quality);
        }

        @Test
        void _BackstageのitemでSellIn値が5以下だった時にupdateQualityを実行するとquality値が3増える() {
            Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(23, app.items[0].quality);
        }

        @Test
        void _BackstageのitemでQuality値が50以上だった時にupdateQualityを実行するとquality値が変わらない() {
            Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(50, app.items[0].quality);
        }

        @Test
        void _BackstageのitemでSellIn値が1の時にupdateQualityを実行するとquality値が3増える() {
            Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 1, 20) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(23, app.items[0].quality);
        }

        @Test
        void _BackstageのitemでSellIn値が0の時にupdateQualityを実行するとquality値が0になる() {
            Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(0, app.items[0].quality);
        }
    }

    @Nested
    class _SulfurasのItem{
        @Test
        void _SulfurasのitemでupdateQualityを実行してもitem名が変わらない() {
            Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 20) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        }

        @Test
        void _SulfurasのitemでupdateQualityを実行してもsellIn値は増減しない() {
            Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 20) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(10, app.items[0].sellIn);
        }

        @Test
        void _SulfurasのitemでupdateQualityを実行してもquality値は増減しない() {
            Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 20) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(20, app.items[0].quality);
        }

        @Nested
        class _ConjuredのItem{
            @Test
            void _ConjuredのItemでupdateQualityを実行してもitem名が変わらない() {
                Item[] items = new Item[] { new Item("Conjured", 10, 20) };
                GildedRose app = new GildedRose(items);
                app.updateQuality();
                assertEquals("Conjured fail test case", app.items[0].name);
            }
        }
    }
}

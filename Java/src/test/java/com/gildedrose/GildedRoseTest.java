package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    Item[] items;

    @Nested
    class _通常商品の場合 {
        @BeforeEach
        void setup(){
            items = new Item[] { new Item("foo", 20, 30) };
        }

        @Test
        void _通常商品で更新しても商品名は変わらない() {
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals("foo", app.items[0].name);
        }

        @Test
        void _通常商品で更新するとsellIn値が1減る() {
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(19, app.items[0].sellIn);
        }

        @Test
        void _通常商品で更新するとquality値が1減る() {
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(29, app.items[0].quality);
        }

        @Nested
        class _sellInが0に近い場合{
            @Test
            void _通常商品でSellInが1のとき更新するとquality値が1減る() {
                items = new Item[] { new Item("foo", 1, 30) };
                GildedRose app = new GildedRose(items);
                app.updateQuality();
                assertEquals(29, app.items[0].quality);
            }

            @Test
            void _通常商品でSellInが0のとき更新するとquality値が1減る() {
                items = new Item[] { new Item("foo", 0, 30) };
                GildedRose app = new GildedRose(items);
                app.updateQuality();
                assertEquals(28, app.items[0].quality);
            }

        }

    }

    @Nested
    class _Sulfurasの場合 {
        @BeforeEach
        void setup() {
            items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 20, 30) };
        }

        @Test
        void _Sulfurasで更新しても商品名は変わらない() {
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        }

        @Test
        void _Sulfurasで更新してもsellIn値は変わらない() {
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(20, app.items[0].sellIn);
        }

        @Test
        void _Sulfurasで更新してもquality値は変わらない() {
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(30, app.items[0].quality);
        }
    }

    @Nested
    class _AgedBrieの場合 {
        @BeforeEach
        void setup() {
            items = new Item[] { new Item("Aged Brie", 20, 30) };
        }

        @Test
        void _AgedBrieで更新しても商品名は変わらない() {
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals("Aged Brie", app.items[0].name);
        }

        @Test
        void _AgedBrieで更新するとsellIn値が1減る() {
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(19, app.items[0].sellIn);
        }

        @Test
        void _AgedBrieで更新するとquality値が1増える() {
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(31, app.items[0].quality);
        }

        @Nested
        class _sellInが0に近い場合 {
            @Test
            void _AgedBrieでsellIn値が1のとき更新するとquality値が1増える() {
                items = new Item[] { new Item("Aged Brie", 1, 30) };
                GildedRose app = new GildedRose(items);
                app.updateQuality();
                assertEquals(31, app.items[0].quality);
            }

            @Test
            void _AgedBrieでsellIn値が0のとき更新するとquality値が2増える() {
                items = new Item[] { new Item("Aged Brie", 0, 30) };
                GildedRose app = new GildedRose(items);
                app.updateQuality();
                assertEquals(32, app.items[0].quality);
            }
        }

    }

}

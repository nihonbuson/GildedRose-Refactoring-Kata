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
        void _準備() {
            items = new Item[] { new Item("foo", 20, 30) };
        }

        @Test
        void _通常商品は更新してもItem名は変わらない() {
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals("foo", app.items[0].name);
        }

        @Test
        void _通常商品は更新するとsellIn値が1減る() {
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(19, app.items[0].sellIn);
        }

        @Test
        void _通常商品は更新するとquality値が1減る() {
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(29, app.items[0].quality);
        }

        @Nested
        class _sellIn値が0に近づいた場合 {
            @Test
            void _通常商品はでsellIn値が1の時に更新するとquality値が1減る() {
                items = new Item[] { new Item("foo", 1, 30) };
                GildedRose app = new GildedRose(items);
                app.updateQuality();
                assertEquals(29, app.items[0].quality);
            }

            @Test
            void _通常商品はでsellIn値が0の時に更新するとquality値が2減る() {
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
        void _準備() {
            items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 20, 30) };
        }

        @Test
        void _Sulfurasは更新してもItem名は変わらない() {
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        }

        @Test
        void _Sulfurasは更新してもsellIn値は変わらない() {
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(20, app.items[0].sellIn);
        }

        @Test
        void _Sulfurasは更新してもquality値は変わらない() {
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(30, app.items[0].quality);
        }
    }

    @Nested
    class _Backstageの場合 {

        @BeforeEach
        void _準備() {
            items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 20, 30) };
        }
        @Test
        void _Backstageは更新してもItem名は変わらない() {
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        }

        @Test
        void _Backstageは更新するとsellIn値が1減る() {
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(19, app.items[0].sellIn);
        }

        @Nested
        class _通常期間の場合 {
            @Test
            void _Backstageは更新するとquality値が1増える() {
                GildedRose app = new GildedRose(items);
                app.updateQuality();
                assertEquals(31, app.items[0].quality);
            }

        }

        @Nested
        class _sellIn値が0に近づいた場合 {
            @Test
            void _BackstageでsellIn値が11の時に更新するとquality値が1増える() {
                items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 30) };
                GildedRose app = new GildedRose(items);
                app.updateQuality();
                assertEquals(31, app.items[0].quality);
            }

            @Test
            void _BackstageでsellIn値が10の時に更新するとquality値が2増える() {
                items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 30) };
                GildedRose app = new GildedRose(items);
                app.updateQuality();
                assertEquals(32, app.items[0].quality);
            }

            @Test
            void _BackstageでsellIn値が6の時に更新するとquality値が2増える() {
                items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 6, 30) };
                GildedRose app = new GildedRose(items);
                app.updateQuality();
                assertEquals(32, app.items[0].quality);
            }

            @Test
            void _BackstageでsellIn値が5の時に更新するとquality値が3増える() {
                items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 30) };
                GildedRose app = new GildedRose(items);
                app.updateQuality();
                assertEquals(33, app.items[0].quality);
            }

            @Test
            void _BackstageでsellIn値が1の時に更新するとquality値が3増える() {
                items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 1, 30) };
                GildedRose app = new GildedRose(items);
                app.updateQuality();
                assertEquals(33, app.items[0].quality);
            }

            @Test
            void _BackstageでsellIn値が0の時に更新するとquality値が0になる() {
                items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 30) };
                GildedRose app = new GildedRose(items);
                app.updateQuality();
                assertEquals(0, app.items[0].quality);
            }

        }
    }

    @Nested
    class _AgedBrieの場合 {

        @BeforeEach
        void _準備() {
            items = new Item[] { new Item("Aged Brie", 20, 30) };
        }
        @Test
        void _AgedBrieは更新してもItem名は変わらない() {
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals("Aged Brie", app.items[0].name);
        }

        @Test
        void _AgedBrieは更新するとsellIn値が1減る() {
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(19, app.items[0].sellIn);
        }

        @Nested
        class _通常期間の場合 {
            @Test
            void _AgedBrieは更新するとquality値が1増える() {
                GildedRose app = new GildedRose(items);
                app.updateQuality();
                assertEquals(31, app.items[0].quality);
            }

        }

        @Nested
        class _sellIn値が0に近づいた場合 {
            @Test
            void _AgedBrieでsellIn値が1の時に更新するとquality値が1増える() {
                items = new Item[] { new Item("Aged Brie", 1, 30) };
                GildedRose app = new GildedRose(items);
                app.updateQuality();
                assertEquals(31, app.items[0].quality);
            }

            @Test
            void _AgedBrieでsellIn値が0の時に更新するとquality値が2増える() {
                items = new Item[] { new Item("Aged Brie", 0, 30) };
                GildedRose app = new GildedRose(items);
                app.updateQuality();
                assertEquals(32, app.items[0].quality);
            }

        }
    }

    @Nested
    class _Conjuredの場合 {
        @BeforeEach
        void _準備() {
            items = new Item[] { new Item("Conjured", 20, 30) };
        }

        @Test
        void _Conjuredは更新してもItem名は変わらない() {
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals("Conjured", app.items[0].name);
        }

        @Test
        void _Conjuredは更新するとsellIn値が1減る() {
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(19, app.items[0].sellIn);
        }

        @Test
        void _Conjuredは更新するとquality値が2減る() {
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(28, app.items[0].quality);
        }
        @Nested
        class _sellIn値が0に近づいた場合 {
            @Test
            void _ConjuredでsellIn値が1の時に更新するとquality値が2減る() {
                items = new Item[] { new Item("Conjured", 1, 30) };
                GildedRose app = new GildedRose(items);
                app.updateQuality();
                assertEquals(28, app.items[0].quality);
            }

            @Test
            void _ConjuredでsellIn値が0の時に更新するとquality値が4減る() {
                items = new Item[] { new Item("Conjured", 0, 30) };
                GildedRose app = new GildedRose(items);
                app.updateQuality();
                assertEquals(26, app.items[0].quality);
            }
        }

    }
}

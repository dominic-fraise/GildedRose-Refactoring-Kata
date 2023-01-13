package com.gildedrose;


//magic numbers
//simplify code
//extract methods for increase and decrease

class GildedRose {
    public static final int MAX_QUALITY = 50;
    public static final int MIN_QUALITY = 0;
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final String AGED_BRIE = "Aged Brie";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    // TODO:
    // - OOP

    public void updateQuality() {
        for (Item item : items) {
            item.adjustQuality();

            item.decreaseSellIn();

            if (item.sellIn < 0) {
                item.handleExpiredItems();
            }
        }
    }

}

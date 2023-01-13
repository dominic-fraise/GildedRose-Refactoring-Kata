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
            item.adjustQuality(this);

            item.decreaseSellIn(this);

            if (item.sellIn < 0) {
                item.handleExpiredItems(this);
            }
        }
    }

    public boolean nameIsNot(String itemName, Item item) {
        return !nameIs(itemName, item);
    }

    public int increaseQuality(Item item) {
        return item.quality++;
    }

    public int decreaseQuality(Item item) {
        return item.quality--;
    }

    public boolean qualityCanBeIncreased(Item item) {
        return item.quality < MAX_QUALITY;
    }

    public boolean nameIs(String itemName, Item item) {
        return item.name.equals(itemName);
    }

    public boolean qualityCanBeReduced(Item item) {
        return item.quality > MIN_QUALITY;
    }

    public void increaseBackstagePassQuality(Item item) {
        if (item.quality >= MAX_QUALITY) {
            return;
        }
        if (item.sellIn < 6) {
            item.quality += 2;
        } else if (item.sellIn < 11) {
            item.quality += 1;
        }
    }
}

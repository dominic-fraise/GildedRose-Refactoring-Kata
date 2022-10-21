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

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals(AGED_BRIE)
                    && !items[i].name.equals(BACKSTAGE_PASSES)) {
                if (items[i].quality > MIN_QUALITY && !items[i].name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                    items[i].quality--;
                }
            } else {
                if (items[i].quality < MAX_QUALITY) {
                    items[i].quality++;

                    if (items[i].name.equals(BACKSTAGE_PASSES)) {
                        increaseBackstagePassQuality(i);
                    }
                }
            }

            if (!items[i].name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                items[i].sellIn--;
            }

            if (items[i].sellIn < 0) {
                handleExpiredItem(i);
            }
        }
    }

    private void handleExpiredItem(int i) {
        if (!items[i].name.equals(AGED_BRIE)) {
            if (!items[i].name.equals(BACKSTAGE_PASSES)) {
                if (items[i].quality > MIN_QUALITY) {
                    if (!items[i].name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                        items[i].quality--;
                    }
                }
            } else {
                items[i].quality = 0;
            }
        } else {
            if (items[i].quality < MAX_QUALITY) {
                items[i].quality++;
            }
        }
    }

    private void increaseBackstagePassQuality(int i) {
        if (items[i].quality >= MAX_QUALITY) {
            return;
        }
        if (items[i].sellIn < 6) {
            items[i].quality += 2;
        } else if (items[i].sellIn < 11) {
            items[i].quality += 1;
        }
    }
}

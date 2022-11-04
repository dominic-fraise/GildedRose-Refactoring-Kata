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
            if (!nameIs(i, AGED_BRIE)
                    && !nameIs(i, BACKSTAGE_PASSES)) {
                if (qualityCanBeReduced(i) && !nameIs(i, SULFURAS_HAND_OF_RAGNAROS)) {
                    items[i].quality--;
                }
            } else {
                if (qualityCanBeIncreased(i)) {
                    items[i].quality++;

                    if (nameIs(i, BACKSTAGE_PASSES)) {
                        increaseBackstagePassQuality(i);
                    }
                }
            }

            if (!nameIs(i, SULFURAS_HAND_OF_RAGNAROS)) {
                items[i].sellIn--;
            }

            if (items[i].sellIn < 0) {
                handleExpiredItem(i);
            }
        }
    }

    private boolean qualityCanBeIncreased(int i) {
        return items[i].quality < MAX_QUALITY;
    }

    private void handleExpiredItem(int i) {
        if (!nameIs(i, AGED_BRIE)) {
            if (!nameIs(i, BACKSTAGE_PASSES)) {
                if (qualityCanBeReduced(i)) {
                    if (!nameIs(i, SULFURAS_HAND_OF_RAGNAROS)) {
                        items[i].quality--;
                    }
                }
            } else {
                items[i].quality = 0;
            }
        } else {
            if (qualityCanBeIncreased(i)) {
                items[i].quality++;
            }
        }
    }

    private boolean nameIs(int i, String itemName) {
        return items[i].name.equals(itemName);
    }

    private boolean qualityCanBeReduced(int i) {
        return items[i].quality > MIN_QUALITY;
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

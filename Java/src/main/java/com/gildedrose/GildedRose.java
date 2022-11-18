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
            if (nameIsNot(AGED_BRIE, items[i])
                    && nameIsNot(BACKSTAGE_PASSES, items[i])) {
                if (qualityCanBeReduced(i) && nameIsNot(SULFURAS_HAND_OF_RAGNAROS, items[i])) {
                    decreaseQuality(items[i]);
                }
            } else {
                if (qualityCanBeIncreased(items[i])) {
                    increaseQuality(items[i]);

                    if (nameIs(BACKSTAGE_PASSES, items[i])) {
                        increaseBackstagePassQuality(i);
                    }
                }
            }

            if (nameIsNot(SULFURAS_HAND_OF_RAGNAROS, items[i])) {
                items[i].sellIn--;
            }

            if (items[i].sellIn < 0) {
                handleExpiredItem(i);
            }
        }
    }

    private boolean nameIsNot(String itemName, Item item) {
        return !nameIs(itemName, item);
    }

    private int increaseQuality(Item item) {
        return item.quality++;
    }

    private int decreaseQuality(Item item) {
        return item.quality--;
    }

    private boolean qualityCanBeIncreased(Item item) {
        return item.quality < MAX_QUALITY;
    }

    private void handleExpiredItem(int i) {
        if (nameIsNot(AGED_BRIE, items[i])) {
            if (nameIsNot(BACKSTAGE_PASSES, items[i])) {
                if (qualityCanBeReduced(i)) {
                    if (nameIsNot(SULFURAS_HAND_OF_RAGNAROS, items[i])) {
                        decreaseQuality(items[i]);
                    }
                }
            } else {
                items[i].quality = 0;
            }
        } else {
            if (qualityCanBeIncreased(items[i])) {
                increaseQuality(items[i]);
            }
        }
    }

    private boolean nameIs(String itemName, Item item) {
        return item.name.equals(itemName);
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

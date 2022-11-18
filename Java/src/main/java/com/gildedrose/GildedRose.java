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
        for (Item item : items) {
            if (nameIsNot(AGED_BRIE, item)
                && nameIsNot(BACKSTAGE_PASSES, item)) {
                if (qualityCanBeReduced(item) && nameIsNot(SULFURAS_HAND_OF_RAGNAROS, item)) {
                    decreaseQuality(item);
                }
            } else {
                if (qualityCanBeIncreased(item)) {
                    increaseQuality(item);

                    if (nameIs(BACKSTAGE_PASSES, item)) {
                        increaseBackstagePassQuality(item);
                    }
                }
            }

            if (nameIsNot(SULFURAS_HAND_OF_RAGNAROS, item)) {
                item.sellIn--;
            }

            if (item.sellIn < 0) {
                handleExpiredItem(item);
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

    private void handleExpiredItem(Item item) {
        if (nameIsNot(AGED_BRIE, item)) {
            if (nameIsNot(BACKSTAGE_PASSES, item)) {
                if (qualityCanBeReduced(item)) {
                    if (nameIsNot(SULFURAS_HAND_OF_RAGNAROS, item)) {
                        decreaseQuality(item);
                    }
                }
            } else {
                item.quality = 0;
            }
        } else {
            if (qualityCanBeIncreased(item)) {
                increaseQuality(item);
            }
        }
    }

    private boolean nameIs(String itemName, Item item) {
        return item.name.equals(itemName);
    }

    private boolean qualityCanBeReduced(Item item) {
        return item.quality > MIN_QUALITY;
    }

    private void increaseBackstagePassQuality(Item item) {
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

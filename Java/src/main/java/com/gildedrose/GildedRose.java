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
            if (nameIs(AGED_BRIE, item)) {
                if (qualityCanBeIncreased(item)) {
                    increaseQuality(item);
                }
            }
            else if (nameIs(BACKSTAGE_PASSES, item)) {
                if (qualityCanBeIncreased(item)) {
                    increaseQuality(item);
                    increaseBackstagePassQuality(item);
                }
            } else {
                if (qualityCanBeReduced(item) && nameIsNot(SULFURAS_HAND_OF_RAGNAROS, item)) {
                    decreaseQuality(item);
                }
            }

            if (nameIsNot(SULFURAS_HAND_OF_RAGNAROS, item)) {
                item.sellIn--;
            }

            if (item.sellIn < 0) {
                if (nameIs(BACKSTAGE_PASSES, item)) {
                    item.quality = 0;
                }
                if (nameIs(AGED_BRIE, item)) {
                    if (qualityCanBeIncreased(item)) {
                        increaseQuality(item);
                    }
                } else if (qualityCanBeReduced(item) && nameIsNot(SULFURAS_HAND_OF_RAGNAROS, item)) {
                    decreaseQuality(item);
                }
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

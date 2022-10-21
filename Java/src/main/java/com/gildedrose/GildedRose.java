package com.gildedrose;


//magic numbers
//simplify code
//extract methods for increase and decrease

class GildedRose {
    public static final int MAX_QUALITY = 50;
    public static final int MIN_QUALITY = 0;
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie" )
                    && !items[i].name.equals(BACKSTAGE_PASSES)) {
                if (items[i].quality > MIN_QUALITY && !items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                    items[i].quality = items[i].quality - 1;
                }
            } else {
                if (items[i].quality < MAX_QUALITY) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals(BACKSTAGE_PASSES)) {
                        increaseBackstagePassQuality(i);
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals(BACKSTAGE_PASSES)) {
                        if (items[i].quality > MIN_QUALITY) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < MAX_QUALITY) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }

    private void increaseBackstagePassQuality(int i) {
        if (items[i].quality >= MAX_QUALITY) {
            return;
        }
        if (items[i].sellIn < 6) {
            items[i].quality = items[i].quality + 2;
        } else if (items[i].sellIn < 11) {
            items[i].quality = items[i].quality + 1;
        }
    }
}

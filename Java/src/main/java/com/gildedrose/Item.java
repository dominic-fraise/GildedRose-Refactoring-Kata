package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void adjustQuality(GildedRose gildedRose) {
        if (gildedRose.nameIs(GildedRose.AGED_BRIE, this)) {
            if (gildedRose.qualityCanBeIncreased(this)) {
                gildedRose.increaseQuality(this);
            }
        }
        else if (gildedRose.nameIs(GildedRose.BACKSTAGE_PASSES, this)) {
            if (gildedRose.qualityCanBeIncreased(this)) {
                gildedRose.increaseQuality(this);
                gildedRose.increaseBackstagePassQuality(this);
            }
        } else {
            if (gildedRose.qualityCanBeReduced(this) && gildedRose.nameIsNot(GildedRose.SULFURAS_HAND_OF_RAGNAROS, this)) {
                gildedRose.decreaseQuality(this);
            }
        }
    }

    public void decreaseSellIn(GildedRose gildedRose) {
        if (gildedRose.nameIsNot(GildedRose.SULFURAS_HAND_OF_RAGNAROS, this)) {
            sellIn--;
        }
    }

    public void handleExpiredItems(GildedRose gildedRose) {
        if (gildedRose.nameIs(GildedRose.BACKSTAGE_PASSES, this)) {
            quality = 0;
        }
        if (gildedRose.nameIs(GildedRose.AGED_BRIE, this)) {
            if (gildedRose.qualityCanBeIncreased(this)) {
                gildedRose.increaseQuality(this);
            }
        } else if (gildedRose.qualityCanBeReduced(this) && gildedRose.nameIsNot(GildedRose.SULFURAS_HAND_OF_RAGNAROS, this)) {
            gildedRose.decreaseQuality(this);
        }
    }
}

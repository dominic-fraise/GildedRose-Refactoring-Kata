package com.gildedrose;

public class AgedBrie extends Item {

    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void adjustQuality() {
        if (nameIs(GildedRose.AGED_BRIE)) {
            if (qualityCanBeIncreased()) {
                increaseQuality();
            }
        }
    }

    public void decreaseSellIn() {
        if (nameIsNot(GildedRose.SULFURAS_HAND_OF_RAGNAROS)) {
            sellIn--;
        }
    }

    public void handleExpiredItems() {
        if (nameIs(GildedRose.BACKSTAGE_PASSES)) {
            quality = 0;
        }
        if (nameIs(GildedRose.AGED_BRIE)) {
            if (qualityCanBeIncreased()) {
                increaseQuality();
            }
        } else if (qualityCanBeReduced() && nameIsNot(GildedRose.SULFURAS_HAND_OF_RAGNAROS)) {
            decreaseQuality();
        }
    }

    public boolean nameIs(String itemName) {
        return name.equals(itemName);
    }

    public boolean qualityCanBeIncreased() {
        return quality < GildedRose.MAX_QUALITY;
    }

    public int increaseQuality() {
        return quality++;
    }

    public void increaseBackstagePassQuality() {
        if (quality >= GildedRose.MAX_QUALITY) {
            return;
        }
        if (sellIn < 6) {
            quality += 2;
        } else if (sellIn < 11) {
            quality += 1;
        }
    }

    public boolean qualityCanBeReduced() {
        return quality > GildedRose.MIN_QUALITY;
    }

    public boolean nameIsNot(String itemName) {
        return !nameIs(itemName);
    }

    public int decreaseQuality() {
        return quality--;
    }
}

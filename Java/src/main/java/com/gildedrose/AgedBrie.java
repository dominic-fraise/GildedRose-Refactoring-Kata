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
        if (qualityCanBeIncreased()) {
            increaseQuality();
        }
    }

    public void decreaseSellIn() {
        sellIn--;
    }

    public void handleExpiredItems() {
        if (qualityCanBeIncreased()) {
            increaseQuality();
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

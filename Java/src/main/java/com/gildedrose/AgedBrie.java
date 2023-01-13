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
}

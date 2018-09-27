package training.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        //iterates through list and adjusts accordingly//
        for (int i = 0; i < items.length; i++) {
            if (items[i].name.equals("Aged Brie")) {
                agedBrie(items[i]);
                items[i].sellIn--;
            } else if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                backStagePass(items[i]);
                items[i].sellIn--;
            } else if (items[i].name.equals("Conjured")) {
                qualityDecrease(items[i],2);
                items[i].sellIn--;
            } else if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")){
                qualityDecrease(items[i],1);
            }
        }
    }

    //sets the agedBrie to appropriate value//
    public void agedBrie(Item agedBrie){
        if (agedBrie.quality < 50){
         agedBrie.quality++;
        }
    }

    //sets backStagePass to appropriate value//
    public void backStagePass(Item backStagePass){
        if (backStagePass.sellIn > 10 && backStagePass.quality < 50){
            backStagePass.quality++;
        } else if (backStagePass.sellIn > 5 && backStagePass.quality < 49){
            backStagePass.quality = backStagePass.quality + 2;
        } else if (backStagePass.sellIn > 0 && backStagePass.quality < 48){
            backStagePass.quality = backStagePass.quality + 3;
        }else if (backStagePass.sellIn == 0) {
            backStagePass.quality = 0;
        }
    }

    //decreases the quality of items//
    public void qualityDecrease(Item item, int i) {
        if (item.sellIn < 1) {
            item.quality = item.quality - i*2;
        } else {
            item.quality = item.quality - i;
        }
        if (item.quality < 0){
            item.quality = 0;
        }
    }
}
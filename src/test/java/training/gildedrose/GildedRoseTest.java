package training.gildedrose;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class GildedRoseTest {

    @Test
    //tests to see if sulfuras sellIn or quality goes down//
    public void sulfurasTest() {
        //Arrange//
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros",10,80);
        Item[] items = new Item[]{sulfuras};
        GildedRose gildedRose = new GildedRose(items);

        //Act//
        gildedRose.updateQuality();

        //Assert//
        assertThat(sulfuras.sellIn).isEqualTo(10);
        assertThat(sulfuras.quality).isEqualTo(80);
    }

    @Test
    //to test that the quality never goes below 0//
    public void qualityStaysPositive(){
        //Arrange//
        Item test = new Item("test",-1,0);
        Item[] items = new Item[]{test};
        GildedRose gildedRose = new GildedRose(items);

        //Act//
        gildedRose.updateQuality();

        //Assert//
        assertThat(test.quality).isEqualTo(0);
    }

    @Test
    //test that quality has degraded twice as fast once sell by has passed//
    public void qualityDegradesTwiceAsFast(){
        //Arrange//
        Item test = new Item("test",-1,10);
        Item[] items = new Item[]{test};
        GildedRose gildedRose = new GildedRose(items);

        //Act//
        gildedRose.updateQuality();

        //Assert//
        assertThat(test.quality).isEqualTo(8);
    }

    @Test
    //test that quality of aged Bree increases with time//
    public void qualityOfBrieIncreases() {
        //Arrange//
        Item test = new Item("Aged Brie", 10, 10);
        Item[] items = new Item[]{test};
        GildedRose gildedRose = new GildedRose(items);

        //Act//
        gildedRose.updateQuality();

        //Assert//
        assertThat(test.quality).isEqualTo(11);
    }

    @Test
    //test that quality of an item can never be over 50//
    public void qualityNeverOverFifty() {
        //Arrange//
        Item agedBrie = new Item("Aged Brie", 10, 50);
        Item  ticket = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 50);
        Item[] items = new Item[]{ticket,agedBrie};
        GildedRose gildedRose = new GildedRose(items);

        //Act//
        gildedRose.updateQuality();

        //Assert//
        assertThat(agedBrie.quality).isEqualTo(50);
        assertThat(ticket.quality).isEqualTo(50);
    }

    @Test
    //test that quality of backstage pass increases//
    public void backstagePassIncreases() {
        //Arrange//
        Item ticket = new Item("Backstage passes to a TAFKAL80ETC concert", 20, 10);
        Item[] items = new Item[]{ticket};
        GildedRose gildedRose = new GildedRose(items);

        //Act//
        gildedRose.updateQuality();

        //Assert//
        assertThat(ticket.quality).isEqualTo(11);
    }

    @Test
    //test that quality of pass increases by two if 10 or less//
    public void backstagePassIncreasesByTwo() {
        //Arrange//
        Item ticket = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10);
        Item[] items = new Item[]{ticket};
        GildedRose gildedRose = new GildedRose(items);

        //Act//
        gildedRose.updateQuality();

        //Assert//
        assertThat(ticket.quality).isEqualTo(12);
    }

    @Test
    //test that quality of pass increases by three if 5 or less//
    public void backstagePassIncreasesByThree() {
        //Arrange//
        Item ticket = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10);
        Item[] items = new Item[]{ticket};
        GildedRose gildedRose = new GildedRose(items);

        //Act//
        gildedRose.updateQuality();

        //Assert//
        assertThat(ticket.quality).isEqualTo(13);
    }

    @Test
    //test that quality pass goes to 0 if SellIn is 0//
    public void backstagePassFallsToZero() {
        //Arrange//
        Item ticket = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10);
        Item[] items = new Item[]{ticket};
        GildedRose gildedRose = new GildedRose(items);

        //Act//
        gildedRose.updateQuality();

        //Assert//
        assertThat(ticket.quality).isEqualTo(0);
    }

    @Test
    //tests that "Conjured" items degrades twice as fast//
    public void conjuredDegradesTwiceAsFast() {
        //Arrange//
        Item conjured = new Item("Conjured", 10, 10);
        Item[] items = new Item[]{conjured};
        GildedRose gildedRose = new GildedRose(items);

        //Act//
        gildedRose.updateQuality();

        //Assert//
        assertThat(conjured.quality).isEqualTo(8);
    }
}

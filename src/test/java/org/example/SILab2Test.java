package org.example;
import org.example.SILab2;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {

    private List<Item> create(Item... items) {
        return new ArrayList<>(Arrays.asList(items));
    }

    @Test(expected = RuntimeException.class)
    public void testEveryBranch_NullItems() {
        SILab2.checkCart(null, 100);
    }

    @Test
    public void testEveryBranch_EmptyList() {
        List<Item> items = new ArrayList<>();
        boolean result = SILab2.checkCart(items, 0);
        Assert.assertTrue(result);
    }

    @Test
    public void testEveryBranch_ItemWithNoNameAndNoDiscount() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(null, "12345", 100, 0.0f));
        boolean result = SILab2.checkCart(items, 100);
        Assert.assertTrue(result);
    }

    @Test(expected = RuntimeException.class)
    public void testEveryBranch_InvalidBarcode() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item1", "12a45", 100, 0.0f));
        SILab2.checkCart(items, 100);
    }

    @Test(expected = RuntimeException.class)
    public void testEveryBranch_NoBarcode() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item1", null, 100, 0.0f));
        SILab2.checkCart(items, 100);
    }

    @Test
    public void testEveryBranch_ItemWithDiscount() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item1", "12345", 100, 0.1f));
        boolean result = SILab2.checkCart(items, 10);
        Assert.assertTrue(result);
    }

    @Test
    public void testEveryBranch_ItemWithDiscountAndBarcodeStartingWith0() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item1", "012345", 350, 0.1f));
        boolean result = SILab2.checkCart(items, 5);
        Assert.assertTrue(result);
    }

    @Test
    public void testEveryBranch_TotalPriceGreaterThanPayment() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item1", "12345", 200, 0.0f));
        boolean result = SILab2.checkCart(items, 100);
        Assert.assertFalse(result);
    }

    @Test
    public void testMultipleCondition_Condition1() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item1", "12345", 100, 0.0f));
        boolean result = SILab2.checkCart(items, 100);
        Assert.assertTrue(result);
    }

    @Test
    public void testMultipleCondition_Condition2() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item2", "012345", 100, 0.0f));
        boolean result = SILab2.checkCart(items, 100);
        Assert.assertTrue(result);
    }

    @Test
    public void testMultipleCondition_Condition3() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item3", "12345", 100, 0.1f));
        boolean result = SILab2.checkCart(items, 10);
        Assert.assertTrue(result);
    }

    @Test
    public void testMultipleCondition_Condition4() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item4", "012345", 100, 0.1f));
        boolean result = SILab2.checkCart(items, 10);
        Assert.assertTrue(result);
    }

    @Test
    public void testMultipleCondition_Condition5() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item5", "12345", 350, 0.0f));
        boolean result = SILab2.checkCart(items, 350);
        Assert.assertTrue(result);
    }

    @Test
    public void testMultipleCondition_Condition6() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item6", "012345", 350, 0.0f));
        boolean result = SILab2.checkCart(items, 350);
        Assert.assertTrue(result);
    }

    @Test
    public void testMultipleCondition_Condition7() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item7", "12345", 350, 0.1f));
        boolean result = SILab2.checkCart(items, 35);
        Assert.assertTrue(result);
    }

    @Test
    public void testMultipleCondition_Condition8() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item8", "012345", 350, 0.1f));
        boolean result = SILab2.checkCart(items, 5);
        Assert.assertTrue(result);
    }
}

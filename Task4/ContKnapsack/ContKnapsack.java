package ContKnapsack;

import java.util.Arrays;

public class ContKnapsack {
    int C;
    public ContKnapsack(int C) {
        this.C = C;
    }
    public ContKnapsack(int C, Item[] items) {
        this.C = C;
        putItems(items);
    }

    void printItems(Item[] items) {
        System.out.println("<연속 배낭문제>");
        for (Item e: items) {
            System.out.println(" - ["+e.i+"] w:"+ e.weight+" p:"+e.price+" rate:"+e.rate);
        }
    }

    void putItems(Item[] items) {
        Arrays.sort(items, new Item.weightOrder()); // 오름차순 정렬

        for (Item e: items) {
            putItem(e);
        }
    }

    void putItem(Item e) {
        if (e.weight <= C) {
            e.rate = 1.0;
            this.C -= e.weight;
        } else {
            e.rate = (double) C / e.weight;
            this.C = 0;
        }
    }
}

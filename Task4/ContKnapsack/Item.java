package ContKnapsack;

import java.util.Comparator;

public class Item {
    int i;
    int weight; // 무게
    int price;  // 가치
    double rate;  // 담은 비율
    public Item(int i, int weight, int price) {
        this.i = i;
        this.weight = weight;
        this.price = price;
    }

    //Edge 가중치를 기준으로 오름차순 비교기
    public static class weightOrder implements Comparator<Item> {
        public int compare(Item e1, Item e2) {
            if(e1.weight < e2.weight) return -1; // 낮은거 큰거:-1 (오름차순)
            if(e1.weight > e2.weight) return 1; // 큰거 작은거
            if(e1.price > e2.price) return -1;
            return 0;
        }
    }
}

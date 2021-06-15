package ContKnapsack;

public class Test {
    public static void main(String[] args) {
        Item[] items = new Item[6];
        int i = 0;
        items[i++] = new Item(0, 4, 7);
        items[i++] = new Item(1, 10, 4);
        items[i++] = new Item(2, 6, 6);
        items[i++] = new Item(3, 4, 7);
        items[i++] = new Item(4, 2, 5);
        items[i++] = new Item(5, 2, 10);

        ContKnapsack ck = new ContKnapsack(17, items);
        ck.printItems(items);
    }
}

public class P7_1_Main {
    public static void main(String [] args){
        P7_1 sale1 = new P7_1();
        sale1.addItem(2.0);
        sale1.addItem(1.29);


        System.out.println("Number of items: " + sale1.getCount());
        System.out.println("Total sale: " + sale1.getTotal());
        sale1.clear();
        System.out.println(sale1.getCount());


        sale1.addItem(3.0);
        sale1.addItem(2.0);
        System.out.println("Total sale: " + sale1.getTotal());

        System.out.println("Today total sales: "+sale1.getSalesTotal()); //8/.29
        System.out.println("Sales count: "+ sale1.getSalesCount()); //4

    }
}

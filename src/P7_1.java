import java.util.ArrayList;

public class P7_1 {
    private double totalSales;
    private int salesCount;
    private ArrayList<Double> priceList = new ArrayList<>();

    public int getCount(){
        return priceList.size();
    }

    public int getTotal(){
        double total = 0;
        for (Double e: priceList
             ) {
            total+=e;
        }
        totalSales+=total;
        int changeToint = (int)(total *100);
        return changeToint;
    }

    public void displayAll(){
        for (Double e: priceList
             ) {
            System.out.println(e);
        }
    }
    public void addItem(Double price){
        this.priceList.add(price);
        salesCount++;
    }
    public void clear(){
        priceList.clear();
    }

    public double getSalesTotal(){
        return totalSales;
    }

    public int getSalesCount(){
        return salesCount;
    }
}

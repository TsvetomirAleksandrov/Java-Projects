import java.util.*;
import java.io.*;
public class CashRegister extends Receipt implements Runnable{
    protected File receipt;
    protected Cashier current = new Cashier(0,"N/A");
    protected static double moneyMade;
    protected Date currentDate = new Date();
    private List<String> tmpName= new ArrayList<>();
    private List<Double> tmpPrice= new ArrayList<>();
    private List<Integer> tmpQuantity= new ArrayList<>();
    Thread t;
    CashRegister(){}
    CashRegister(Cashier a){
        this.current.name = a.name;
        this.current.id = a.id;
        t = new Thread(this, "Thread");

    };
    public void run(){
        try{
            FileWriter fw = new FileWriter("Receipt" + numberOfReceipts + ".txt");
            PrintWriter pw = new PrintWriter(fw);
            pw.println("Number of Receipt:  " + numberOfReceipts);
            pw.println(currentDate);
            pw.println("Cashier: " + current.name);
            pw.println("Goods:");
            for (int i=0;i<tmpQuantity.size();i++)
            {
                pw.println(tmpName.get(i) + "    " + tmpPrice.get(i) + "lv  " + "x" + tmpQuantity.get(i));
            }
            pw.close();
            t.start();
        }catch (IOException e)
        {
            System.out.println("error");
        }
        catch (IllegalThreadStateException e)
        {
            System.out.println(" ");
        }

    }
    public void getReceipt(Receipt customer){

        for (Map.Entry<Goods, Integer> entry : customer.Cart.entrySet()) {
            Goods key = entry.getKey();
            Integer quantityReceipt = entry.getValue();
            tmpName.add(key.getName());
            tmpPrice.add(key.getPrice());
            tmpQuantity.add(quantityReceipt);
            moneyMade += key.getPrice()*quantityReceipt;
        }

            t.start();

    }
    public static double getMoneyMade(){
        return moneyMade;
    }

}

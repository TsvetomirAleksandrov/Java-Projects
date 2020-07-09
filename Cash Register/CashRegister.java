import java.util.*;
import java.io.*;

public class CashRegister extends Receipt implements Runnable
{
    protected Cashier currentCashier = new Cashier(0,"N/A");
    protected Date currentDate = new Date();

    private List<String> tmpName= new ArrayList<>();
    private List<Double> tmpPrice= new ArrayList<>();
    private List<Integer> tmpQuantity= new ArrayList<>();

    double allSum;
    Thread t;


//vruzka m/u kasa i kasier
    CashRegister(Cashier c)
    {
        this.currentCashier.name = c.name;
        this.currentCashier.id = c.id;
        t = new Thread(this, "Thread");
    };

    public void run()
    {
        try
        {
            FileWriter fw = new FileWriter("Receipt" + numberOfReceipts + ".txt");
            PrintWriter pw = new PrintWriter(fw);

            pw.println("Number of Receipt:  " + numberOfReceipts);
            pw.println(currentDate);
            pw.println("Cashier: " + currentCashier.name);
            pw.println("Goods:");

            for (int i=0;i<tmpQuantity.size();i++)
            {
                allSum += (tmpPrice.get(i) * tmpQuantity.get(i));
                pw.println(tmpName.get(i) + "    " + tmpPrice.get(i) + "lv  " + "x" + tmpQuantity.get(i));
            }
            pw.println(" ");
            pw.println("Obshta suma: " + allSum + "lv.");
            pw.close();
            t.start();
        }

        catch (IOException e)
        {
            System.out.println("error");
        }
        catch (IllegalThreadStateException e)
        {
            System.out.println(" ");
        }
    }

    public void getReceipt(Receipt customer)
    {
        for (Map.Entry<Goods, Integer> entry : customer.Cart.entrySet())
        {
            Goods key = entry.getKey();
            Integer quantityReceipt = entry.getValue();
            tmpName.add(key.getName());
            tmpPrice.add(key.getPrice());
            tmpQuantity.add(quantityReceipt);
        }
            t.start();
    }


}

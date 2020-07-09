import java.util.*;
public class Shop
{
    public HashMap<Goods, Integer> allGoods = new HashMap<>();
    private List<Cashier> allCashiers = new ArrayList<>();
    private static int allReceipts = Receipt.getNumberOfReceipts();
    private static double allMoney = CashRegister.getMoneyMade();
    public void addCashier(Cashier a)
    {
        allCashiers.add(a);
    }
    public void addGood(Goods a, int quantity)
    {
        allGoods.put(a,quantity);
    }
    public int getQuantity(Goods a)
    {
        return allGoods.get(a);
    }
    public static double checkMoney()
    {
        return allMoney;
    }
    public static int getReceipts()
    {
        return allReceipts;
    }
}

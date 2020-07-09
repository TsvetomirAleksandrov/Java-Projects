import java.util.*;
public class Shop
{
    //spisuk sus stokite
    public HashMap<Goods, Integer> allGoods = new HashMap<>();
//spisuk s prodavachite
    private List<Cashier> allCashiers = new ArrayList<>();


    public void addCashier(Cashier cashier)
    {
        allCashiers.add(cashier);
    }
    public void addGood(Goods goods, int quantity)
    {
        allGoods.put(goods, quantity);
    }
    public int getQuantity(Goods goods)
    {
        return allGoods.get(goods);
    }

}

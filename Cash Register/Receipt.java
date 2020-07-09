import java.util.*;

public class Receipt {
    public HashMap<Goods, Integer> Cart = new HashMap<>();
    public static int numberOfReceipts = -1;
    protected HashMap<String, HashMap<Double,Integer>> theGoods = new HashMap<String, HashMap<Double,Integer>>();

    Receipt()
    {
        numberOfReceipts += 1;
    }

    public void addToCart(Goods goods, int buyQuantity, Shop shop)
    {
        try
        {
            if (buyQuantity > shop.getQuantity(goods))
            {
                int tmp = buyQuantity-shop.getQuantity(goods);
                throw new NotEoughQuantityException("Not enough quantity of " + goods.getName() + ", " + tmp + " more needed");
            }
            else
                {
                Cart.put(goods, buyQuantity);
            }
        }
        catch(NotEoughQuantityException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public static int getNumberOfReceipts()
    {
        return numberOfReceipts;
    }
}

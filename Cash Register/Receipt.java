import java.util.*;

public class Receipt extends Shop
{
    //kolichka
    public HashMap<Goods, Integer> Cart = new HashMap<>();

    public static int numberOfReceipts = -1;

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
                int tmp = buyQuantity - shop.getQuantity(goods);
                throw new NotEoughQuantityException("Not enough quantity of " + goods.getName() + ", " + tmp + " more needed");
            }
            else
                {
                    int goodQuantityUpdate = shop.getQuantity(goods) - buyQuantity;
                Cart.put(goods, buyQuantity);
                allGoods.replace(goods, goodQuantityUpdate);
            }
        }
        catch(NotEoughQuantityException e)
        {
            System.out.println(e.getMessage());
        }
    }
}

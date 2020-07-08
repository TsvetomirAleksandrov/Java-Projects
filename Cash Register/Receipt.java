import java.util.*;

public class Receipt {
    public HashMap<Goods, Integer> Cart = new HashMap<>();
    public static int numberOfReceipts = -1;
    protected HashMap<String, HashMap<Double,Integer>> theGoods = new HashMap<String, HashMap<Double,Integer>>();
    protected static double allSum;
    Receipt(){
        numberOfReceipts += 1;
    }
    public void addToCart(Goods a, int quantity, Shop shop){
        try{
            if (quantity > shop.getQuantity(a)){
                int tmp = quantity-shop.getQuantity(a);
                throw new NotEoughQuantityException("Not enough quantity of " + a.getName() + ", " + tmp + " more needed");
            }else{
                Cart.put(a,quantity);
            }
        } catch(NotEoughQuantityException e){
            System.out.println(e.getMessage());
        }

    }
    public static int getNumberOfReceipts(){
        return numberOfReceipts;
    }

}

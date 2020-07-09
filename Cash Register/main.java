import java.util.*;

public class main
{
    public static void main(String[] args)
    {
        //define cashier
        Cashier cashier1 = new Cashier(45545,"Dimitar Petrov");

        //define  goods
        Goods Beer = new Goods(55,"Beer",2.50,"15-02-2020");
        Goods Chocolate = new Goods(56,"Chocolate",1.950,"15-03-2020");

        //define shop
        Shop FreshMarket = new Shop();

        //add goods and cashier to the shop
        FreshMarket.addCashier(cashier1);
        FreshMarket.addGood(Beer,5);
        FreshMarket.addGood(Chocolate, 40);

        //define receipt
        Receipt person = new Receipt();

        //add to cart
        person.addToCart(Beer,3, FreshMarket);
        person.addToCart(Chocolate, 5, FreshMarket);

        CashRegister one = new CashRegister(cashier1);
        one.getReceipt(person);
    }
}

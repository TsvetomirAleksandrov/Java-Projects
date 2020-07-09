import java.util.*;

public class main
{
    public static void main(String[] args)
    {
        Cashier cashier = new Cashier(45545,"Dimitar Petrov");

        Goods Beer = new Goods(55,"Beer",2.50,"15-02-2020");
        Goods Chocolate = new Goods(56,"Chocolate",1.950,"15-03-2020");

        Shop FreshMarket = new Shop();

        FreshMarket.addCashier(cashier);
        FreshMarket.addGood(Beer,5);
        FreshMarket.addGood(Chocolate, 40);

        Receipt person = new Receipt();

        person.addToCart(Beer,3, FreshMarket);
        person.addToCart(Chocolate, 5, FreshMarket);

        CashRegister one = new CashRegister(cashier);
        one.getReceipt(person);
    }
}

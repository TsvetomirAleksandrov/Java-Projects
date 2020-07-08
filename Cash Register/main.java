import java.util.*;
public class main {
    public static void main(String[] args){
        Cashier boiko = new Cashier(45545,"Boiko");
        Goods banan = new Goods(55,"banan",1.50,"15-02-2020");
        Goods apple = new Goods(56,"apple",1.20,"15-03-2020");
        Shop kaufland = new Shop();
        kaufland.addCashier(boiko);
        kaufland.addGood(banan,5);
        kaufland.addGood(apple, 45);
        Receipt katy = new Receipt();
        katy.addToCart(banan,6, kaufland);
        katy.addToCart(apple, 34, kaufland);
        CashRegister kasa1 = new CashRegister(boiko);
        kasa1.getReceipt(katy);

    }
}

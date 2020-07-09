import java.util.*;
public class Goods
{
    protected static int id;
    protected String name;
    protected double price;
    protected String expiredAt;

    Goods()
    {
        id = 0;
        name = "N/a";
        price = 0;
    }

    Goods(int id, String name, double price, String expiredAt)
    {
        this.id = id;
        this.name = name;
        this.price = price;
        this.expiredAt = expiredAt;
    }

    public String getName()
    {
        return name;
    }

    public double getPrice()
    {
        return price;
    }
}


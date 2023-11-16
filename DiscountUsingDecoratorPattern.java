
interface I {
  int getPrice();
  void setPrice(int price);
}

class Item implements I {
  int price;
  Item(int price){
    this.price = price;
  }
  @Override
  public int getPrice() {
    return price;
  }

  @Override
  public void setPrice(int price) {
    this.price = price;
  }
}

public abstract class Decorator implements I {
  I item;
  Decorator(I item) {
    this.item = item;
  }
  public int getPrice() {
    return item.getPrice();
  }
  public void setPrice(int price) {
    item.setPrice(price);
  }
}

class Discount1 extends Decorator{
  Discount1( I item ) {
    super(item);
    this.item.setPrice(item.getPrice() - 30);
  }
}

class Discount2 extends  Decorator {
  Discount2( I item){
    super(item);
    this.item.setPrice(item.getPrice() - 40);
  }
}

class M {
  public static void main(String[] args) {
    I item = new Item(1000);
    item = new Discount2(new Discount1(item));
    System.out.println(item.getPrice());
  }
}

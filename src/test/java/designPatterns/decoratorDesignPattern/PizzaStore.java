package designPatterns.decoratorDesignPattern;

public class PizzaStore {
  public static void main(String[] args) {
    Pizza pizza = new Margherita();
    System.out.println( pizza.getDescription() +
            " Cost :" + pizza.getCost());

    Pizza pizza2 = new FarmHouse();
    pizza2 = new FreshTomato(pizza2);
    pizza2 = new Barbeque(pizza2);
    System.out.println( pizza2.getDescription() +
            " Cost :" + pizza2.getCost());
  }
}

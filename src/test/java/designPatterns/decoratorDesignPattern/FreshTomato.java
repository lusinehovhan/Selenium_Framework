package designPatterns.decoratorDesignPattern;

public class FreshTomato extends ToppingsDecorator {

  Pizza pizza;

  public FreshTomato(Pizza pizza) {
    this.pizza = pizza;
  }

  public String getDescription() {
    return pizza.getDescription() + ", Fresh Tomato ";
  }

  public int getCost() {
    return 40 + pizza.getCost();
  }
}

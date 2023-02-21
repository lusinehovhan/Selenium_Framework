package designPatterns.decoratorDesignPattern;

public class SimplePizza extends Pizza {

  public SimplePizza() {
    description = "SimplePizza";
  }

  public int getCost() {
    return 50;
  }
}

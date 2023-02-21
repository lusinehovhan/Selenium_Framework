package designPatterns.decoratorDesignPattern;

public class Margherita extends Pizza {

  public Margherita()  {
    description = "Margherita";
  }

  public int getCost() {
    return 100;
  }
}

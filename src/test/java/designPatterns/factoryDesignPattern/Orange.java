package designPatterns.factoryDesignPattern;

public class Orange implements Fruits{
  @Override
  public void getFruit() {
    System.out.println("Get Oranges from market.");
  }
}

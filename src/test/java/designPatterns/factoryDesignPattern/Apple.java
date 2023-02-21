package designPatterns.factoryDesignPattern;

public class Apple implements Fruits{
  @Override
  public void getFruit() {
    System.out.println("Get Apples from market.");
  }
}

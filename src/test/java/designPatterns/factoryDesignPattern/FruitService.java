package designPatterns.factoryDesignPattern;

public class FruitService {
  public static void main(String[] args) {

    FruitFactory fruitFactory = new FruitFactory();
    Fruits fruits = fruitFactory.createFruitDelivery("PEACH");
    fruits.getFruit();
  }
}

package designPatterns.factoryDesignPattern;

public class FruitFactory {
  public Fruits createFruitDelivery(String fruit)
  {
    if (fruit == null || fruit.isEmpty())
      return null;
    switch (fruit) {
      case "APPLE":
        return new Apple();
      case "PEACH":
        return new Peach();
      case "ORANGE":
        return new Orange();
      default:
        throw new IllegalArgumentException("Unknown fruit "+fruit);
    }
  }
}

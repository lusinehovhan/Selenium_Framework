package designPatterns.decoratorDesignPattern;

public class PeppyPaneer extends Pizza {

  public PeppyPaneer() {
    description = "PeppyPaneer";
  }

  public int getCost() {
    return 100;
  }
}

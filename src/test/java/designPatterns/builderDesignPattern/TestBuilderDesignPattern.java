package designPatterns.builderDesignPattern;

public class TestBuilderDesignPattern {

  public static void main(String[] args) {

    Computer comp1 = new Computer.ComputerBuilder(
            "500 GB", "2 GB")
            .setBluetoothEnabled(true)
            .setGraphicsCardEnabled(true)
            .build();

    Computer comp2 = new Computer.ComputerBuilder(
            "500 GB", "2 GB")
            .setBluetoothEnabled(true)
            .build();

    Computer comp3 = new Computer.ComputerBuilder(
            "500 GB", "2 GB")
            .setGraphicsCardEnabled(true)
            .build();
  }
}

package FactoryPattern;

public class TestCar {
    public static void main(String[] args){
        CarFactory factory = new CarFactory();

        Car suvCar = factory.getCar("SUV");
        suvCar.assemble();

        Car sedanCar = factory.getCar("Sedan");
        sedanCar.assemble();

        Car miniCar = factory.getCar("Mini");
        miniCar.assemble();
    }
}

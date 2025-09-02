package FactoryPattern;

public class CarFactory {
    public Car getCar(String carType){
        if(carType==null){
            return null;
        }

        if(carType.equalsIgnoreCase("SUV")){
            return new SUV();
        }else if(carType.equalsIgnoreCase("Sedan")){
            return new Sedan();
        }else if(carType.equalsIgnoreCase("mini")){
            return new Mini();
        }

        return null;
    }
}

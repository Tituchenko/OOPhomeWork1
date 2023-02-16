import java.util.ArrayList;
import java.util.List;

/*
1. Напишите класс Car.
В классе должна храниться следующая информация:
название автомобиля - model;
год выпуска - year;
стоимость - price;
цвет - color;
объем двигателя - power.

2.Добавьте в класс Car метод getInfo без параметров,
который будет печать на экране значения полей объекта класса model , power и yeare.

3. Доработайте программу в свободном стиле.
Можно сравнить 2 автомобиля между собой
Или пусть авто заедет за фруктами :-)
Добавьте несколько произвольных методов и свойств
*/
public class Car {

    String model;
    int year;
    double price;
    String color;
    int power;
    double maxVelocity;

    double accelerat100;
    private boolean powerOn;
    private List<Fruit> fruit;

    public Car(String model,int year,double price,String color,int power, double maxVelocity,double accelerat100){
        this.model=model;
        this.year=year;
        this.price=price;
        this.color=color;
        this.power=power;
        this.maxVelocity=maxVelocity;
        this.accelerat100=accelerat100;
        this.powerOn=false;
        this.fruit = new ArrayList<>();
    }

    public void addFruit (Fruit f){
        this.fruit.add (f);
    }
    public void removeFruit (Fruit f){
        this.fruit.remove (f);
    }
    public void printWeightOfFruit (){
        if (this.fruit.size()>0){

       float weight=0;
            for (Fruit f:this.fruit) {
                weight+=f.weight;
            }
            System.out.println("В машине " + weight + " кг фруктов");
        } else {
            System.out.println("В машине нет фруктов");
        }
    }
    public void printFruitIn (){
        if (this.fruit.size()>0){
            System.out.println("В машине фрукты:");
            for (Fruit f:this.fruit) {
                System.out.println(f.name + " - "+f.weight + "кг;");
            }
        } else {
            System.out.println("В машине нет фруктов");
        }
    }

    public void getInfo(){
        System.out.println("Информация об автомобиле:");
        System.out.println("Модель:        "+model);
        System.out.println("Год:           "+year);
        System.out.println("Цена:          "+getBeautifulMoney(price));
        System.out.println("Цвет:          "+color);
        System.out.println("Мощность:      "+power);
        System.out.println("Макс скорость: "+maxVelocity);
        System.out.println("Разгон до 100: "+accelerat100);
    }

    public static void compareCar(List<Car> cars){
        int colLength=20;
        String models="";
        String ids="";
        String years="";
        String prices="";
        String colors="";
        String powers="";
        String maxV="";
        String accelerT100="";
        System.out.println("Сравнение автомобилей:");
        for (int i = 0; i < cars.size(); i++) {
            ids+=Integer.toString(i+1)+" ".repeat(colLength-Integer.toString(i+1).length());
            models+=cars.get(i).model+" ".repeat(colLength-cars.get(i).model.length());
            years+=Integer.toString(cars.get(i).year)+
                    " ".repeat(colLength-Integer.toString(cars.get(i).year).length());
            prices+=(getBeautifulMoney(cars.get(i).price)+
                    " ".repeat(colLength-getBeautifulMoney(cars.get(i).price).length()));
            colors+=(cars.get(i).color)+ " ".repeat(colLength-cars.get(i).color.length());
            powers+=Integer.toString(cars.get(i).power)+
                    " ".repeat(colLength-Integer.toString(cars.get(i).power).length());
            maxV+=Double.toString(cars.get(i).maxVelocity)+
                    " ".repeat(colLength-Double.toString(cars.get(i).maxVelocity).length());
            accelerT100+=Double.toString(cars.get(i).accelerat100)+
                    " ".repeat(colLength-Double.toString(cars.get(i).accelerat100).length());
        }
        System.out.println("#:             "+ids);
        System.out.println("Модель:        "+models);
        System.out.println("Год:           "+years);
        System.out.println("Цена:          "+prices);
        System.out.println("Цвет:          "+colors);
        System.out.println("Мощность:      "+powers);
        System.out.println("Макс скорость: "+maxV);
        System.out.println("Разгон до 100: "+accelerT100);

    }

    public void startEngine(){
        this.powerOn=true;
        System.out.println(this.model + " - двигатель заведен");
    }

    public void stopEngine(){
        this.powerOn=false;
        System.out.println(this.model + " - двигатель остановлен");
    }

    public void roadTo (String destination){
        if (this.powerOn){
            System.out.println(this.model+ " на пути в "+destination);
        } else {
            System.out.println(this.model +" не заведена. Ехать нельзя.");
        }
    }

    private static String getBeautifulMoney(double money){
        if (money>=1000000){
            return Double.toString((double) Math.round(money/100000)/10) + " млн";
        } else if (money>=1000) {
            return Double.toString((double) Math.round(money/100)/10) + " тыс";

        }
        return Double.toString(money);
    }
}

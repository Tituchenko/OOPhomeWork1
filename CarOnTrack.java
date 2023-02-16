public class CarOnTrack {
    Car currentCar;
    double startTime;
    double richMaxSpeedTime;
    double finishTime;
// Получить ускорение
    private double getA(Car car){
        /*
        чтобы ускорение хоть как то сказывалось домножим его на 60*10
        (как будто 4,2с =4,2*60*10=42 минуты чтобы достичь 100 км/ч)
         */
        return (100*60*60)/ (car.accelerat100*60*10);
    }
    private double getMaxSpeedDestanation(Car car){
        /*
        При V_0=0
        V=a*t
        t=V/a
        s=(a*t^2)/2=(a*(V/a)^2)/2=(V^2/(2*a))
*/
        return Math.pow(car.maxVelocity,2)/(2* getA(car));

    }
    // время для достижения максимальной скорости в секундах
    private double getMaxSpeedTime(Car car){
        /*
        При V_0=0
        V=a*t
        t=V/a
         */
        return car.maxVelocity/getA(car)*60*60;
    }
    //Время для проезда расстояния s в секундах с постоянной скоростью
    private double getTimeToFinishWithConstantV (Car car,double s){
        return s/car.maxVelocity*60*60;
    }
    //Время для проезда расстояния s в секундах с ускорением
    private double getTimeToFinishWithAcceleration (Car car,double s){
                /*
        При V_0=0
        V=a*t
        t=V/a
        s=(a*t^2)/2
        t=sqrt((2*s)/a)
*/
        return Math.sqrt((2*s)/ getA(car))*60*60;
    }
    public CarOnTrack (Car car,double startTime,double s){
        this.startTime=startTime;
        double maxSpeedDestanation=getMaxSpeedDestanation(car);
        if (maxSpeedDestanation<=s){
            this.richMaxSpeedTime=getMaxSpeedTime(car)+startTime;
            this.finishTime=getTimeToFinishWithConstantV(car,s-maxSpeedDestanation)+startTime;
        } else {
            this.richMaxSpeedTime=0;
            this.finishTime=getTimeToFinishWithAcceleration(car,s)+startTime;

        }
    }
}

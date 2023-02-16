import java.sql.SQLOutput;
import java.util.*;

public class Main {


    public static void main(String[] args) {

        Car car1=new Car ("BMW",2022,5600000,"белый",3500,250,4.2);
        car1.getInfo();
        car1.roadTo("Москву");
        car1.startEngine();
        car1.roadTo("Саратов");
        car1.stopEngine();
        Fruit banana = new Fruit("Бананы",3.2);
        Fruit apple = new Fruit("Яблоки",5.6);
        Fruit orange = new Fruit("Апельсины",2.4);
        car1.addFruit(banana);
        car1.addFruit(apple);
        car1.addFruit(orange);
        car1.printFruitIn();
        car1.printWeightOfFruit();
        car1.removeFruit(orange);
        car1.printFruitIn();
        car1.printWeightOfFruit();
        Car car2=new Car ("Mercedes",2022,7800000,"белый",3500,250,3.8);
        Car car3=new Car ("Opel",2019,1800000,"белый",3500,160,6.7);
        Car car4=new Car ("Fiat",2019,1400000,"черный",3500,150,5.8);
        Car car5=new Car ("ГАЗ",1988,600000,"баклажан",1800,100,14.2);
        List<Car> cars=new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
        Car.compareCar(cars);

        game();
    }
    //Выдает случайный String из переданного массива String
    public static String getRandomFromArr (String[] arrString){
        Random r = new Random();
        return arrString[r.nextInt(arrString.length)];
    }
    //Выдает случайный Things из переданного списка Things
    public static TrackThings getRandomThings (List<TrackThings> baseThings){
        Random r = new Random();
        return baseThings.get(r.nextInt(baseThings.size()));
    }
    //Выдает случайный String из переданного списка String, удаляя последний из списка
    public static String getRandomFromList (List<String> listString){
        Random r = new Random();
        int i=r.nextInt(listString.size());
        String result=listString.get(i);
        listString.remove(i);

        return result;
    }
    //Выдает случайный int из переданного диапазона, включая крайние значения
    public static int getRandomInt (int min, int max){
        return min+(int)(Math.random()*(max-min+1));
    }
    //Выдает случайный float одним знаком после запятой из переданного диапазона, включая крайние значения
    public static double getRandomDouble(double min, double max){
        return min+(double)Math.round( (Math.random()*(max-min)*10))/10;
    }
    // Создает n автомобилей со случайными параметрами
    public static List<Car> getRandomCar(int n){
        String[]  brends = {"BMW","Mercedes","Opel","Ford","Ferrari","Mazda","ВАЗ","Lada","Maserati","Bugati"};
        String[]  colors = {"белый","черный","синий", "желтый","красный","голубой",
                "металлик","зеленый","фиолетовый","бежевый"};
        List<Car> cars=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Car car=new Car (getRandomFromArr(brends), getRandomInt(1980,2022), getRandomDouble(500000,10000000),
                    getRandomFromArr(colors), getRandomInt(1000,3000), getRandomInt(100,300), getRandomDouble(2,10));
            cars.add(car);
        }
        return cars;

    }
//    Создает базу по случаям с дорогой
    private static  List<TrackThings> generateThings(){
        TrackThings thingBase = new TrackThings("Обыная дорога",0,0,1,1);
        int speed=getRandomInt(200,500);
        TrackThings thingHiSpeed = new TrackThings("Попутный ветер! У всех машин установлена максимальная скорость " +
                speed+" км/ч",speed,0,1,1);
        speed=getRandomInt(50,90);
        TrackThings thingsLowSpeed = new TrackThings("На трассе дежурит суровый экипаж ГИББД. У всех машин установлена максимальная скорость " +
                speed+" км/ч",speed,0,1,1);
        double acleration= getRandomDouble(1,5);
        TrackThings thingsHiAcleration = new TrackThings("Под горку. Теперь все машины до 100 км/ч разгоняются за  " +
                acleration,0,acleration,1,1);
        acleration= getRandomDouble(9,15);
        TrackThings thingsLowAcleration = new TrackThings("Много поворотов. Теперь все машины до 100 км/ч разгоняются за  " +
                acleration,0,acleration,1,1);
        double kSpeed= getRandomDouble(1,3);
        TrackThings thingsHiKSpeed = new TrackThings("Отличный бензин на трасе. Теперь максимальная скорость умножается на " +
                kSpeed,0,0,kSpeed,1);
        kSpeed= getRandomDouble(0.3,0.8);
        TrackThings thingsLowKSpeed = new TrackThings("Плохой бензин на трасе. Теперь максимальная скорость умножается на " +
                kSpeed,0,0,kSpeed,1);
        double kAcleration= getRandomDouble(1,3);
        TrackThings thingsHiKAcleration = new TrackThings("Хорошая радиоволна. Теперь ускорение умножается на " +
                kAcleration,0,0,1,kAcleration);
        kAcleration= getRandomDouble(0.3,0.8);
        TrackThings thingsLowKAcleration = new TrackThings("Скользкая дорога. Теперь ускорение умножается на " +
                kAcleration,0,0,1,kAcleration);

        List<TrackThings> listThings= new ArrayList<>();
        listThings.add(thingBase);
        listThings.add(thingHiSpeed);
        listThings.add(thingsLowSpeed);
        listThings.add(thingsHiAcleration);
        listThings.add(thingsLowAcleration);
        listThings.add(thingsHiKSpeed);
        listThings.add(thingsLowKSpeed);
        listThings.add(thingsHiKAcleration);
        listThings.add(thingsLowKAcleration);
        listThings.add(thingBase);
        listThings.add(thingBase);
        listThings.add(thingBase);
        listThings.add(thingBase);
        listThings.add(thingBase);
        return listThings;
    }

    private static  List<Track> generateTrack( List<TrackThings> baseThings,int n){
        String[]  towns = {"Вилобаджо","Просеко","Виларибо","Воронеж","Монако","Ницца","Калиниград","Москва"
                ,"Хельсинки","Коста-рика","Нью-йорк","Сан-диего","Нью васюки","Рим","Пенза","Самара","Осло"
                ,"Париж","Ватикан","Санкт-Петербург","Коломна"};
        List<String> townList = new ArrayList<>();
        for (int i = 0; i < towns.length; i++) {
            townList.add(towns[i]);
        }

        String lastTown=getRandomFromList(townList);
        List<Track> tracks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String finishTown=getRandomFromList(townList);
            tracks.add(new Track(lastTown,finishTown,getRandomThings(baseThings),100));
            lastTown = finishTown;

        }
        return tracks;

    }
    public static void showTrack(List<Track> tracks){
        System.out.println("Наша трасса "+tracks.get(0).from+" - "+tracks.get(tracks.size()-1).destanation+":");
        for (int i = 0; i < tracks.size(); i++) {
            System.out.println(i+"."+tracks.get(i).from+"-"+tracks.get(i).destanation+". Расстояние:"+
                    tracks.get(i).s+" км." + tracks.get(i).thigs.text);
        }

    }

    public static String getBuityTime(double time){
        int h,m,s;
        h=(int) Math.floor(time/(60*60));
        m=(int) Math.floor((time-h*60*60)/60);
        s=(int) Math.round(time-h*60*60-m*60);
        String hStr,mStr,sStr;
        hStr=Integer.toString(h);
        if (hStr.length()==1){
            hStr="0"+hStr;
        }
        mStr=Integer.toString(m);
        if (mStr.length()==1){
            mStr="0"+mStr;
        }
        sStr=Integer.toString(s);
        if (sStr.length()==1){
            sStr="0"+sStr;
        }
        return " "+hStr+":"+mStr+":"+sStr;

    }

    public static void show2UsersCompetition(User user1,User user2){
        for (int i = 0; i < user1.carOnTrackList.size(); i++) {
            System.out.println((i+1)+".Время финиша:");
            System.out.println(user1.getName()+getBuityTime(user1.carOnTrackList.get(i).finishTime));
            System.out.println(user2.getName()+getBuityTime(user2.carOnTrackList.get(i).finishTime));
            if (user1.carOnTrackList.get(i).finishTime>user2.carOnTrackList.get(i).finishTime){
                System.out.println(user2.getName()+ " впереди (+"+getBuityTime(user1.carOnTrackList.get(i).finishTime-
                        user2.carOnTrackList.get(i).finishTime)+")");
            } else {
                System.out.println(user1.getName()+ " впереди (+"+getBuityTime(user2.carOnTrackList.get(i).finishTime-
                        user1.carOnTrackList.get(i).finishTime)+")");
            }



        }
    }

    public static void game(){
        User user = new User(5000000,"Пользователь");
        User comp = new User(5000000,"Компьютер");


        System.out.println("Добро пожаловать в игру:");


        List<TrackThings> baseThings=generateThings();
        List<Track> tracks=generateTrack(baseThings,10);
        showTrack(tracks);

        List<Car> randomCars=getRandomCar(5);
        System.out.println("У тебя "+user.getMoney()+" руб");
        System.out.println("Выбери машину:");
        Car.compareCar(randomCars);
        Scanner scanner = new Scanner(System.in);
        String p = scanner.nextLine();
        user.setCar(randomCars.get(Integer.parseInt(p)));




        comp.setCar(randomCars.get((int) (Math.random()*5)));

        System.out.println("У компьютера:");
        comp.showCar();


        user.goTrack(tracks);
        comp.goTrack(tracks);
        show2UsersCompetition(user,comp);

        if (user.carOnTrackList.get(user.carOnTrackList.size()-1).finishTime>
                comp.carOnTrackList.get(comp.carOnTrackList.size()-1).finishTime){
            System.out.println("Ты проиграл!");
        } else {
            System.out.println("Ты выиграл!");
        }




    }
}
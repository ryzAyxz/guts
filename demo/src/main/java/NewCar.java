public class NewCar {
    public static void main(String[] args) {
      Car car=new Car(20);//创建一个汽车对象
        car.init();//对汽车进行初始化
    }
    static class Car{
        Framework framework;
        public Car(int size){//有参构造函数，通过参数来确定轮胎的尺寸
            //创建汽车需要依赖于车身，所以创建一个车身对象
             framework=new Framework(size);
        }
        public void init(){
            framework.init();
        }
    }
    static class Framework{
        Bottom bottom;
        public Framework(int size) {
            //创建车身需要依赖于地盘，所以创建一个地盘对象，并且对地盘进行初始化
            bottom = new Bottom(size);
        }
        public void init(){
            bottom.init();
        }
    }
    static class Bottom{
        Tire tire;
        public Bottom(int size) {
            tire = new Tire(size);
        }
        public void init(){
           tire.init();
        }
    }
    static class Tire{
        int size;
        public Tire(int size) {
            this.size = size;
        }
        public void init(){
            //声明轮胎的尺寸
            System.out.println("轮胎尺寸："+size);
        }
    }
}

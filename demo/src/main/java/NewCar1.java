public class NewCar1 {//通过控制反转思想重新创建一部车

    public static void main(String[] args) {
        //创建尺寸为20的轮胎
        Tire tire = new Tire(20);
        //使用轮胎对象创建地盘
        Bottom bottom = new Bottom(tire);
        //使用地盘构造车身
        Framework framework=new Framework(bottom);
        //使用车身构造汽车
        Car car=new Car(framework);
        car.init();
    }
    static class Tire{
        private int size;//轮胎尺寸

        public Tire(int size) {
            this.size = size;
        }
        public void init(){
            System.out.println("控制反转思想创建的汽车轮胎："+size);
        }
    }
    static class Bottom {
        Tire tire;
        public Bottom(Tire tire) {
            this.tire = tire;
        }
        public void init() {
            tire.init();
        }
    }
    static class Framework{
        Bottom bottom;//将轮胎作为整体，不需要去了解轮胎的尺寸等等轮胎具体的创建过程

        public Framework(Bottom bottom) {
            this.bottom = bottom;
        }
        public void init(){
            bottom.init();
        }
    }

    static class Car{
        Framework framework;
        public Car(Framework framework) {
            this.framework = framework;
        }
        public void init(){
            framework.init();
        }
    }
}

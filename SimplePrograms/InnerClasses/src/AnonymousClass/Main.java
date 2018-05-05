package AnonymousClass;

public class Main {

    public  static  void  main(String args []) {

        anyInterface inter = new anyInterface() {
            @Override
            public void sayHello(String hello) {
                System.out.println(hello);
            }
        };

        inter.sayHello("HI");

    }
}

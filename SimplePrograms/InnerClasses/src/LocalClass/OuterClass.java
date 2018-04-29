package LocalClass;

public class OuterClass
{
    private int x;

    public void example()
    {
        class Localclass {
             private int y=10;

             public void method()
             {
                 System.out.println("TEXT");
             }


        }

        Localclass localclass = new Localclass();
        localclass.method();
    }
}


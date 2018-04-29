package InnerClasses;

public class OuterClass
{
     private int x;

    public OuterClass(){}

    public OuterClass(int x)
    {
        this.x=x;
    }

    public  class  InnerClass
    {
         private int y;

        public InnerClass(){};

        public InnerClass(int y){
            this.y=y;

        }
    }
}

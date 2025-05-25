package annotation;

public class MyService
{
    @MeasureTime
    public void doTimeConsumingStuff(){
        String str = "";
        for(int i = 0; i < 100_000; i++)
            str += str;
    }
}

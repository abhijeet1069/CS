# Enums

Enumeration is the action of mentioning a number of things one by one.

```java
//Earlier approach
public class Day{
    public static final String SUNDAY = "SUNDAY";
    public static final String MONDAY = "MONDAY";
}

//modern approach
public enum Day{
    SUNDAY,MONDAY;
}

//During compile time code becomes
public final class Day extends java.lang.Enum<Day>{
    public static final String SUNDAY = new Day("SUNDAY",0);
    public static final String SUNDAY = new Day("MONDAY",0);
    
    public static final Day[] VALUES = {SUNDAY,MONDAY};
    
    private Day(String name, int ordinal){
        super(name,ordinal);
    }
    
    private static Day[] values(){
        super(name,ordinal);
    }
    
    public static Day[] values(){
        return VALUES.clone();
    }
    
    public static Day[] values(){
        return VALUES.clone();
    }
    
    public static Day valueOf(String name){
        for(Day day : VALUES){
            if(day.name().equals(name)){
                return day;
            }
        }
        throw new IllegalArgumentException("No enum constant "+name);
    }
}

```
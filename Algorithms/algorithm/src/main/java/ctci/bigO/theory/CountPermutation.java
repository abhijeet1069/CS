package ctci.bigO.theory;

public class CountPermutation {

    public static void permutation(String str){
        permutation(str,"");
    }

    public static void permutation(String str, String prefix){
        //System.out.println("P("+str+ ","+prefix+")");
        if(str.isEmpty())
            System.out.println("Result = "+prefix);
        else{
            for(int i = 0;i < str.length(); i++){
                String rem = str.substring(0,i) + str.substring(i+1);
                System.out.println("Loop "+i+","+str+","+prefix);
                permutation(rem,prefix+str.charAt(i));
            }
        }
    }

    public static void main(String[] args) {
        String str = "ABC";
        permutation(str);
    }
}

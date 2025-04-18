package ctci.arraysStrings;

public class URLify {

    public static String urlify(String str){
        String[] arr = str.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        int i;
        for(i = 0; i < arr.length-1; i++){
            sb.append(arr[i]).append("%20");
        }
        sb.append(arr[i]);
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "Mr John Smith    ";
        System.out.println(urlify(str));
    }
}

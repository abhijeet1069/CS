package staticMemory;

public class Outer {
    int num;

    public Outer(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    class Inner{
        int num;

        public Inner(int num){
            this.num = num;
        }

        public int getNum() {
            return num;
        }
    }
}

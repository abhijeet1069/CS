package javaLang.staticMemory;

public class Main {
    public static void main(String[] args) {
       /**
        * Output
        * Mobile{company='Apple', model='Galaxy S10'} //this 16 pro max gone
        * Mobile{company='Samsung', model='Galaxy S10'}

        Mobile apple = new Mobile();
        apple.setCompany("Apple");
        apple.setModel("16 pro max");

        Mobile samsung = new Mobile();
        samsung.setCompany("Samsung");
        samsung.setModel("Galaxy S10");

        System.out.println(apple);
        System.out.println(samsung);
        **/

        /**
         * Output
         * 23
         * 100
         *
         * Outer outer = new Outer(23);
         * Outer.Inner inner = outer.new Inner(100); //wierd syntax
         * System.out.println(outer.getNum());
         * System.out.println(inner.getNum());
         * */


    }
}

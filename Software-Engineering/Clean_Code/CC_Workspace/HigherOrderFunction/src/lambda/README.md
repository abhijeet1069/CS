# Lambda Expression

✅ You can think of lambda as a function when writing code.
❌ But behind the scenes, it is an object implementing a functional interface.

- Not having any name
- Not having any return type
- Not having modifier

Java requires lambda to be assigned or passed

## Make any function a lambda expression

- remove modifier
- remove return type
- remove method name
- place arrow

```java

private void sayHello(){
	System.out.println("Hello World");
}

//Corresponding lambda expression

() -> {System.out.println("Hello World")}

```

```java

private void add(int a, int b){
	System.out.println(a+b);
}

//Corresponding lambda expression
(int a, int b) -> {System.out.println(a+b);}

```

```java

private int getStringLength(String str){
	return str.length();
}

//Corresponding lambda expression
(String str) -> {return str.length()}

```

## Lambda syntax

- If a lambda has single statement in body we can remove braces
- You can skip parameter types
- You can skip parameter braces if only one parameter
- You can remove return type
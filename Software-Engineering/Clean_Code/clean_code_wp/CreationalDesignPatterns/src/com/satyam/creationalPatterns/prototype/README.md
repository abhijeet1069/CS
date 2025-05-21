# Prototype Design Pattern

The Prototype Design Pattern is a creational design pattern used when the cost of creating a new object is expensive or complex. It allows you to create new objects by copying an existing object, known as the prototype, instead of creating a new instance from scratch.

## Structure

- Prototype (interface or abstract class) – Declares a clone() method.
- ConcretePrototype – Implements the clone() method.
- Client – Uses the clone() method to create a new object.

## Saving costs

The Prototype pattern saves cost by:
- Avoiding repetitive, expensive setup logic.
- Reusing configuration/state from an existing object.

```java
class Image {
    private byte[] data;

    public Image(String filePath) {
        // Expensive operation
        this.data = loadFromDisk(filePath);
    }
}

Image original = new Image("photo.jpg");
// Copy the already-loaded data and skips expensive disk operation
Image clone = original.clone();  

```
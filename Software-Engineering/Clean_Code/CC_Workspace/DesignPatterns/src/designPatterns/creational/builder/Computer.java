package designPatterns.creational.builder;

public class Computer {
    // Required parameters
    private String CPU;
    private int RAM;

    // Optional parameters
    private int storage;
    private boolean hasGraphicsCard;

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.hasGraphicsCard = builder.hasGraphicsCard;
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", Storage=" + storage + ", GraphicsCard=" + hasGraphicsCard + "]";
    }

    // Static nested Builder class
    public static class Builder {
        // Required
        private String CPU;
        private int RAM;

        // Optional - initialized to default
        private int storage = 256;
        private boolean hasGraphicsCard = false;

        public Builder(String CPU, int RAM) {
            this.CPU = CPU;
            this.RAM = RAM;
        }

        public Builder setStorage(int storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCard(boolean hasGraphicsCard) {
            this.hasGraphicsCard = hasGraphicsCard;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}


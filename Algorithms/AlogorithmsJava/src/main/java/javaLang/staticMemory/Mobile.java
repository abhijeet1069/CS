package javaLang.staticMemory;

public class Mobile {
    String company;
    static String model;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "company='" + company + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}

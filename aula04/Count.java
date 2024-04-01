package aula04;

public class Count {
    private Integer value;

    public Count(Integer value) {
        this.value = value;
    }

    public void increment() {
        this.value++;
    }

    public Integer getValue() {
        return this.value;
    }
}

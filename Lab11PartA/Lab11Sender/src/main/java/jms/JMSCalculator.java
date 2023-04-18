package jms;

public class JMSCalculator {
    private String operator;
    private long number;

    protected JMSCalculator(){}

    public JMSCalculator(String operator, long number) {
        this.operator = operator;
        this.number = number;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "JMSCalculator{" +
                "operator='" + operator + '\'' +
                ", number=" + number +
                '}';
    }
}

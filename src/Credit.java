/**
 * Данный код представляет класс Credit (Кредит), который предназначен для представления информации о кредите в банковской системе.
 * Краткое описание каждого элемента класса:
 * 1.	Приватные переменные:
 *   creditType: хранит тип кредита.
 *   name: хранит наименование кредита.
 *   currency: хранит валюту кредита.
 *  annualInterestRate: хранит годовую процентную ставку по кредиту.
 * 2.	Конструктор Credit инициализирует объект класса Credit с заданными типом кредита, наименованием, валютой и годовой процентной ставкой.
 * Конструктор принимает эти значения и устанавливает их в соответствующие приватные переменные класса.
 * 3.	Геттеры и сеттеры  позволяют получать значения и устанавливать новые значения для соответствующих свойств кредита.
 * 4.	Переопределенный метод toString(): возвращает строковое представление кредита, содержащее его тип, наименование, валюту и годовую процентную ставку.
 * Этот класс позволяет представлять информацию о кредите в банковской системе.
 * Объекты класса Credit могут использоваться для хранения и управления данными о кредитах, таких как тип, наименование, валюта и процентная ставка.
 * @author Ganziuc Alexandr
 * @version 17.0.3.1
 */
public class Credit {
    private String creditType;
    private String name;
    private String currency;
    private double annualInterestRate;

    public Credit(String creditType, String name, String currency, double annualInterestRate) {
        this.creditType = creditType;
        this.name = name;
        this.currency = currency;
        this.annualInterestRate = annualInterestRate;
    }

    public String getCreditType() {
        return creditType;
    }

    public void setCreditType(String creditType) {
        this.creditType = creditType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {this.currency = currency;}

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }
    @Override
    public String toString() {
        return "Кредит: " +
                "Тип = " + creditType +
                ", Наименование = " + name +
                ", Валюта = " + currency +
                ", Годовая процентная ставка = " + annualInterestRate;
    }
}

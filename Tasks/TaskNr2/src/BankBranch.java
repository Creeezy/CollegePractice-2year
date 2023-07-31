/**
 * Базовый класс "Филиал банка"
 * Этот класс служит в качестве базового класса для представления филиалов банка и содержит некоторые свойства и методы для работы с ними.
 * 1.	Приватные переменные:
 * 	 name: хранит имя филиала банка.
 *   address: хранит адрес филиала банка.
 *   phoneNumber: хранит номер телефона филиала банка.
 * 2.	Конструктор BankBranch инициализирует объект класса BankBranch с заданными именем, адресом и номером телефона филиала.
 * 3.	Геттеры и сеттеры для свойств name, address и phoneNumber: позволяют получать значения и устанавливать новые значения для соответствующих свойств филиала банка.
 * 4.	Переопределенный метод toString(): возвращает строковое представление филиала банка, содержащее его имя, адрес и номер телефона.
 * Этот класс предоставляет базовый функционал для представления филиала банка.
 * Можно использовать его как основу для создания объектов филиалов и управления их свойствами.
 * @author Ganziuc Alexandr
 * @version 17.0.3.1
 */
public class BankBranch {
    private String name;
    private String address;
    private String phoneNumber;

    public BankBranch(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {return name;}

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}
    @Override
    public String toString() {
        return "Филиал банка: " +
                "Имя = " + name +
                ", Адрес = " + address +
                ", Телефон = " + phoneNumber;
    }
}
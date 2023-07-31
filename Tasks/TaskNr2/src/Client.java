/**
 * Данный код представляет абстрактный класс Client (Клиент).
 * Этот класс служит базовым классом для представления клиентов банка и содержит общие свойства и методы для работы с клиентами.
 * Краткое описание каждого элемента класса:
 * 1.	Приватные переменные:
 *   name: хранит имя клиента.
 *   address: хранит адрес клиента.
 *   phoneNumber: хранит номер телефона клиента.
 * 2.	Конструктор Client инициализирует объект класса Client с заданными именем, адресом и номером телефона клиента.
 * 3.	Геттеры и сеттеры для свойств name, address и phoneNumber: позволяют получать значения и устанавливать новые значения для соответствующих свойств клиента.
 * 4.	Абстрактный метод calculateCreditLimit(): предоставляет абстрактную реализацию для расчета кредитного лимита клиента. Этот метод должен быть реализован в подклассах, наследующих абстрактный класс Client.
 * 5.	Переопределенный метод toString(): возвращает строковое представление клиента, содержащее его имя, адрес и номер телефона.
 * Этот абстрактный класс предоставляет базовый функционал для представления клиентов банка.
 * Он может быть использован в качестве основы для создания подклассов, представляющих конкретные типы клиентов
 * (например, физические лица и юридические лица), и расширения функциональности клиентов в этих подклассах.

 * @author Ganziuc Alexandr
 * @version 17.0.3.1
 */
public abstract class Client {
    private String name;
    private String address;
    private String phoneNumber;

    public Client(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

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

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Клиент: " +
                "Имя = " + name +
                ", Адрес = " + address +
                ", Телефон = " + phoneNumber;
    }
}
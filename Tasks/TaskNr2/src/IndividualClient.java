/**
 * Данный код представляет класс IndividualClient (Физическое лицо), который является подклассом класса Client.
 * Этот класс расширяет функциональность базового класса Client, добавляя специфичные свойства и методы для представления физических лиц в банковской системе. Вот краткое описание каждого элемента класса:
 * 1.	Приватная переменная:
 *  personalCode: хранит личный код физического лица.
 * 2.	Конструктор IndividualClient инициализирует объект класса IndividualClient с заданными именем, адресом, номером телефона и личным кодом физического лица. Конструктор также вызывает конструктор базового класса Client с помощью ключевого слова super, чтобы инициализировать общие свойства клиента.
 * 3.	Геттер и сеттер для свойства personalCode: позволяют получать значение и устанавливать новое значение личного кода физического лица.
 * 4.	Переопределенный метод toString(): возвращает строковое представление физического лица, содержащее его имя, адрес, номер телефона и личный код.
 * Этот класс предоставляет конкретную реализацию для представления физического лица в банковской системе.
 * Он наследует общий функционал от базового класса Client и добавляет специфичные свойства и методы для физических лиц.
 * Это позволяет использовать объекты класса IndividualClient для представления и управления информацией о физических лицах в банковской системе.
 * @author Ganziuc Alexandr
 * @version 17.0.3.1
 */
public class IndividualClient extends Client {
    private String personalCode;

    public IndividualClient(String name, String address, String phoneNumber, String personalCode) {
        super(name, address, phoneNumber);
        this.personalCode = personalCode;
    }

    public String getPersonalCode() {
        return personalCode;
    }

    public void setPersonalCode(String personalCode) {
        this.personalCode = personalCode;
    }


    @Override
    public String toString() {
        return "Имя: " + getName() + "\n" +
                "Адрес: " + getAddress() + "\n" +
                "Телефон: " + getPhoneNumber() + "\n" +
                "Личный код: " + personalCode;
    }
}
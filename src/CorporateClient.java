/**
 * Данный код представляет класс CorporateClient (Юридическое лицо), который также является подклассом класса Client.
 * Этот класс расширяет функциональность базового класса Client, добавляя специфичные свойства и методы для представления юридических лиц в банковской системе. Вот краткое описание каждого элемента класса:
 * 1.	Приватные переменные:
 *   taxIdentificationNumber: хранит налоговый идентификационный номер юридического лица.
 *   administratorName: хранит имя администратора юридического лица.
 *   contactPerson: хранит имя контактного лица юридического лица.
 * 2.	Конструктор CorporateClient инициализирует объект класса CorporateClient с заданными именем, адресом, номером телефона, налоговым идентификационным номером, именем администратора и контактным лицом юридического лица.
 * Конструктор также вызывает конструктор базового класса Client с помощью ключевого слова super, чтобы инициализировать общие свойства клиента.
 * 3.	Геттеры и сеттеры позволяют получать значения и устанавливать новые значения для соответствующих свойств юридического лица.
 * 4.	Переопределенный метод toString(): возвращает строковое представление юридического лица.
 * Этот класс предоставляет конкретную реализацию для представления юридического лица в банковской системе.
 * Он наследует общий функционал от базового класса Client и добавляет специфичные свойства и методы для юридических лиц.
 * Это позволяет использовать объекты класса CorporateClient для представления и управления информацией о юридических лицах в банковской системе.
 * @author Ganziuc Alexandr
 * @version 17.0.3.1
 */
public class CorporateClient extends Client {
    private String taxIdentificationNumber;
    private String administratorName;
    private String contactPerson;

    public CorporateClient(String name, String address, String phoneNumber, String taxIdentificationNumber, String administratorName, String contactPerson) {
        super(name, address, phoneNumber);
        this.taxIdentificationNumber = taxIdentificationNumber;
        this.administratorName = administratorName;
        this.contactPerson = contactPerson;
    }

    public String getTaxIdentificationNumber() {
        return taxIdentificationNumber;
    }

    public void setTaxIdentificationNumber(String taxIdentificationNumber) {this.taxIdentificationNumber = taxIdentificationNumber;}

    public String getAdministratorName() {
        return administratorName;
    }

    public void setAdministratorName(String administratorName) {
        this.administratorName = administratorName;
    }

    public String getContactPerson() {return contactPerson;}

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    @Override
    public String toString() {
        return "Наименование: " + getName() + "\n" +
                "Адрес: " + getAddress() + "\n" +
                "Телефон: " + getPhoneNumber() + "\n" +
                "Налоговый идентификационный номер: " + taxIdentificationNumber + "\n" +
                "Имя администратора: " + administratorName + "\n" +
                "Контактное лицо: " + contactPerson;
    }
}
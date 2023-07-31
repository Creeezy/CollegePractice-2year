/**
 * Интерфейс BankSystem
 * Данный интерфейс определяет набор методов, которые должны быть реализованы в классе, который использует этот интерфейс.
 * Он служит для описания функциональности банковской системы, а именно для управления филиалами банка, клиентами, кредитами, контрактами и другими операциями.
 * Вот краткое описание каждого метода в интерфейсе:
 * 1.	displayBankBranches(): Этот метод используется для отображения информации о всех филиалах банка.
 * 2.	displayClients(List<IndividualClient> individualClients, List<CorporateClient> corporateClients): Этот метод используется для отображения информации о клиентах банка. Он принимает два списка клиентов: individualClients (список физических лиц) и corporateClients (список юридических лиц).
 * 3.	displayCredits(): Этот метод используется для отображения информации о кредитах, доступных в банковской системе.
 * 4.	addBankBranch(): Этот метод используется для добавления нового филиала банка в систему.
 * 5.	addClient(): Этот метод используется для добавления нового клиента в систему. Новый клиент может быть как физическим лицом (IndividualClient), так и юридическим лицом (CorporateClient).
 * 6.	addCredit(): Этот метод используется для добавления нового кредита в систему.
 * 7.	createContract(): Этот метод используется для создания нового контракта в системе.
 * 8.	calculateBankIncome(): Этот метод используется для расчета дохода банка.
 * 9.	displayContracts(): Этот метод используется для отображения информации о контрактах, заключенных в банковской системе.
 * 10.	convertPriceToEuro(): Этот метод используется для конвертации цены в евро.
 * Интерфейс предоставляет абстракцию для операций, которые могут быть выполнены в банковской системе.
 * Реализация этих методов будет зависеть от конкретного класса, который реализует данный интерфейс и предоставляет конкретную функциональность для работы с банковской системой.
 * @author Ganziuc Alexandr
 * @version 17.0.3.1
 */
import java.util.List;

public interface BankSystem {
    void displayBankBranches();
    void displayClients(List<IndividualClient> individualClients, List<CorporateClient> corporateClients);
    void displayCredits();
    void addBankBranch();
    void addClient();
    void addCredit();
    void createContract();
    void calculateBankIncome();
    void displayContracts();
    void convertPriceToEuro();

}
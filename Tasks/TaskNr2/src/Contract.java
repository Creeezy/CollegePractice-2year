/**
 Данный код представляет класс Contract (Договор), который используется для представления информации о договоре кредита в банковской системе.
 Краткое описание каждого элемента класса:
 1.	Приватные переменные:
   contractNumber: хранит номер договора.
   date: хранит дату заключения договора.
   client: объект класса Client, представляющий клиента, связанного с договором.
   credit: объект класса Credit, представляющий кредит, связанный с договором.
   totalLoanAmount: хранит общую сумму займа по договору.
   loanRepaymentTerm: хранит срок погашения займа по договору.
 2.	Конструктор Contract инициализирует объект класса Contract с заданными параметрами.
    Конструктор принимает данные и устанавливает их в соответствующие приватные переменные класса.
 3.	Геттеры и сеттеры позволяют получать значения и устанавливать новые значения для соответствующих свойств договора.
 4.	Метод calculateIncome(): вычисляет доход банка по договору на основе общей суммы займа и годовой процентной ставки кредита. Результат выводится на экран.
 5.	Переопределенный метод toString(): возвращает строковое представление договора.
 Этот класс позволяет представлять информацию о договоре кредита в банковской системе.
 Объекты класса Contract используются для хранения и управления данными о договорах. Класс также предоставляет метод для вычисления дохода банка по договору.
 * @author Ganziuc Alexandr
 * @version 17.0.3.1
 */
public class Contract {
    private String contractNumber;
    private String date;
    private Client client;
    private Credit credit;
    private double totalLoanAmount;
    private int loanRepaymentTerm;

    public Contract(String contractNumber, String date, Client client, Credit credit, double totalLoanAmount, int loanRepaymentTerm) {
        this.contractNumber = contractNumber;
        this.date = date;
        this.client = client;
        this.credit = credit;
        this.totalLoanAmount = totalLoanAmount;
        this.loanRepaymentTerm = loanRepaymentTerm;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public double getTotalLoanAmount() {
        return totalLoanAmount;
    }

    public void setTotalLoanAmount(double totalLoanAmount) {this.totalLoanAmount = totalLoanAmount;}

    public int getLoanRepaymentTerm() {
        return loanRepaymentTerm;
    }

    public void setLoanRepaymentTerm(int loanRepaymentTerm) {
        this.loanRepaymentTerm = loanRepaymentTerm;
    }

    public void calculateIncome() {
        double income = totalLoanAmount * (credit.getAnnualInterestRate() / 100);
        System.out.println("Доход банка: " + income + " " +credit.getCurrency());
    }

    @Override
    public String toString() {
        return "Номер контракта: " + contractNumber + "\n" +
                "Дата: " + date + "\n" +
                "Клиент: " + client.toString() + "\n" +
                "Кредит: " + credit.toString() + "\n" +
                "Общая сумма займа: " + totalLoanAmount + "\n" +
                "Срок погашения займа: " + loanRepaymentTerm;
    }
}

/**
 * Класс BankManagementSystem управляет всей деятельностью банка
 * Этот класс содержит методы:
 * Метод addIndividualClient добавляет нового физического клиента в список individualClients.
 * Пользователь вводит личный код клиента, а затем создается экземпляр класса IndividualClient с указанными данными и добавляется в список.
 * Метод addClient() предлагает пользователю выбрать тип клиента (физическое или юридическое лицо) и вводит соответствующие данные.
 * Затем вызывается соответствующий метод (addIndividualClient или addLegalClient), который добавляет клиента в соответствующий список.
 * Метод addCredit() позволяет пользователю добавить новый кредит.
 * Пользователь вводит информацию о кредите. Создается экземпляр класса Credit с указанными данными и добавляется в список credits.
 * Метод createContract() позволяет пользователю создать новый контракт. Созданный контракт добавляется в список contracts.
 * Метод calculateBankIncome() предназначен для расчета дохода банка.
 * Метод ищет введённый номер контракта в списке contracts по указанному номеру и вызывает метод calculateIncome() для расчета дохода контракта.
 * Метод convertPriceToEuro() позволяет пользователю конвертировать цену из леев в евро.
 * Пользователь вводит текущую цену в леях и курс обмена (1 евро в леях), а затем производится конвертация цены в евро и результат выводится на экран.
 * Метод findContractByNumber выполняет поиск контракта по указанному номеру в списке contracts и возвращает соответствующий контракт.
 * В коде также присутствуют блоки try-catch для обработки исключений, таких как некорректный ввод данных и многие другие.
 * @author Ganziuc Alexandr
 * @version 17.0.3.1
 */
import java.text.DecimalFormat;
import java.util.*;

public class BankManagementSystem implements BankSystem{
    List<BankBranch> bankBranches;
    List<IndividualClient> individualClients;
    List<CorporateClient> corporateClients;
    private static List<Credit> credits;
    private static List<Contract> contracts;
    private static final Scanner scanner = new Scanner(System.in);

    public BankManagementSystem() {
        bankBranches = new ArrayList<>();
        individualClients = new ArrayList<>();
        corporateClients = new ArrayList<>();
        contracts = new ArrayList<>();
        credits = new ArrayList<>();
    }
    /*
    //Добавление информации для тестов
 private void addForTest(){
     //<editor-fold desc="Добавление филиалов банка">
     bankBranches.add(new BankBranch("MAIB","Stefan Cel Mare 16","+37368773211"));
     bankBranches.add(new BankBranch("MAIB","Stefan Cel Mare 36","+3736812321"));
     bankBranches.add(new BankBranch("MAIB","Ismail 26","+37368563213"));
     bankBranches.add(new BankBranch("MAIB","Dacia 47","+373687950214"));
     bankBranches.add(new BankBranch("MAIB","Milestiu 22","+373687123215"));
     bankBranches.add(new BankBranch("MAIB","Ciuflea 48","+37368655223"));
     bankBranches.add(new BankBranch("MAIB","Dacia 116","+37368224423"));
     bankBranches.add(new BankBranch("MAIB","Cuza-Voda 116","+37368223344"));
     bankBranches.add(new BankBranch("MAIB","Cuza-Voda 11","+373682233445"));
     bankBranches.add(new BankBranch("MAIB","Lev Tolstoi 111","+37368214906"));
     //</editor-fold>

     //<editor-fold desc="Добавление физических клиентов">
     individualClients.add(new IndividualClient( "Ulises Patterson", "Bucuresti 5", "+37368234567", "2004023456789"));
     individualClients.add(new IndividualClient("Thatcher Jackson", "Stefan cel Mare 12", "+37369345678", "2004067890123"));
     individualClients.add(new IndividualClient("Sterling Sanchez", "Ion Creanga 27", "+37366456789", "2004012345678"));
     individualClients.add(new IndividualClient("Shepherd Green", "Mitropolit Grigore Banulescu-Bodoni 14", "+37367987654", "2004098765432"));
     individualClients.add(new IndividualClient("Rhys Young", "Mircea cel Batran 33", "+37368876543", "2004054321098"));
     individualClients.add(new IndividualClient("Quinnton Moore", "Vasile Alecsandri 19", "+37369543210", "2004076543210"));
     individualClients.add(new IndividualClient("Otis Butler", "Decebal 22", "+37366765432", "2004087654321"));
     individualClients.add(new IndividualClient("Israel Rogers", "Alecu Russo 9", "+37367432109", "2004032109876"));
     individualClients.add(new IndividualClient("Griffin Watson", "Cetatea Alba 6", "+37368109876", "2004043210987"));
     individualClients.add(new IndividualClient("Desmond Torres", "Dacia 8", "+37369098765", "2004009876543"));
     //</editor-fold>

     //<editor-fold desc="Добавление юридических клиентов">
     corporateClients.add(new CorporateClient("GlobalTech Solutions", "Victoriei 10", "+37368234567", "1021234567", "John Smith", "Alex Turner"));
     corporateClients.add(new CorporateClient("PrimeFinancial Group", "Stefan cel Mare 25", "+37369345678", "1029876543", "John Smith", "Emma Davis"));
     corporateClients.add(new CorporateClient("TechNova Corporatio", "Mihai Eminescu 7", "+37366456789", "1025432167", "Michael Brown", "Benjamin Scott"));
     corporateClients.add(new CorporateClient("EliteMarketing Strategies", "Dacia 14", "+37367987654", "1028765432", "Olivia Davis", "Olivia Hughes"));
     corporateClients.add(new CorporateClient("PowerTech Industries", "Primaverii 3", "+37368876543", "1023145678", "Ethan Wilson", "Ethan Carter"));
     corporateClients.add(new CorporateClient("OptiPro Logistics", "Decebal 21", "+37369543210", "1027654321", "Sophia Thompson", "Sophia Brooks"));
     corporateClients.add(new CorporateClient("NovaTech Solutions", "Ion Creanga 12", "+37366765432", "1022345678", "William Clark", "William Mitchell"));
     corporateClients.add(new CorporateClient("ApexCorp Holdings", " Renasterii 9", "+37367432109", "1028765432", "Ava Anderson", "Ava Reed"));
     corporateClients.add(new CorporateClient("InnovateTech Solutions", "Unirii 17", "+37368109876", "1027654321", "James Green", "James Foster"));
     corporateClients.add(new CorporateClient("SecureNet Systems", "Alexandru cel Bun 6", "+37369098765", "1021234567", "Mia Taylor", "Mia Collins"));
     //</editor-fold>

     //<editor-fold desc="Добавление кредитов">
     credits.add(new Credit("Mortgage", "Home Loan", "MDL", 3.5));
     credits.add(new Credit("Personal", "Personal Loan", "EUR", 8.2));
     credits.add(new Credit("Auto", "Car Loan", "USD", 5.9));
     credits.add(new Credit("Business", "Small Business Loan", "EUR", 12.5));
     credits.add(new Credit("Student", "Education Loan", "MDL", 4.8));
     credits.add(new Credit("Mortgage", "Property Loan", "EUR", 4.1));
     credits.add(new Credit("Personal", "Wedding Loan", "MDL", 9.5));
     credits.add(new Credit("Auto", "Lease Financing", "EUR", 6.4));
     credits.add(new Credit("Business", "Equipment Loan", "MDL", 10.8));
     credits.add( new Credit("Student", "Student Line of Credit", "EUR", 3.9));
     //</editor-fold>

     //<editor-fold desc="Добавление контрактов">
     contracts.add(new Contract("1", "2023-06-01", individualClients.get(0), credits.get(0), 250000, 20));
     contracts.add(new Contract("2", "2023-06-02", individualClients.get(1), credits.get(1), 5000, 3));
     contracts.add(new Contract("3", "2023-06-03", individualClients.get(2), credits.get(2), 30000, 5));
     contracts.add(new Contract("4", "2023-06-04", individualClients.get(3), credits.get(3), 1000000, 10));
     contracts.add(new Contract("5", "2023-06-05", individualClients.get(4), credits.get(4), 15000, 2));
     contracts.add(new Contract("6", "2023-06-06", corporateClients.get(5), credits.get(5), 200000, 15));
     contracts.add(new Contract("7", "2023-06-07", corporateClients.get(6), credits.get(6), 10000, 2));
     contracts.add(new Contract("8", "2023-06-08", corporateClients.get(7), credits.get(7), 40000, 4));
     contracts.add(new Contract("9", "2023-06-09", corporateClients.get(8), credits.get(8), 500000, 7));
     contracts.add( new Contract("10", "2023-06-10", corporateClients.get(9), credits.get(9), 20000, 3));

     //</editor-fold>
    }
*/
    public static void main(String[] args) {
        BankManagementSystem bankManagementSystem = new BankManagementSystem(); // Создаем экземпляр класса
    //    bankManagementSystem.addForTest();
        bankManagementSystem.displayMenu(); // Используем экземпляр для вызова метода displayMenu()
    }

// вывод меню
    private void displayMenu() {
        int choice = 0;
        do {
            System.out.println("\n\nМеню:");
            System.out.println("1. Добавить/создать");
            System.out.println("2. Вывести");
            System.out.println("3. Рассчитать доход банка");
            System.out.println("4. Конвертировать цену в евро");
            System.out.println("5. Выход");
            System.out.print("Выберите пункт меню: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> {
                        System.out.println("1. Добавить филиал банка");
                        System.out.println("2. Добавить клиента");
                        System.out.println("3. Добавить кредит");
                        System.out.println("4. Заключить договор");
                        System.out.println("5. Обратно");
                        System.out.print("Выберите пункт меню: ");
                        int subChoice = Integer.parseInt(scanner.nextLine());
                        System.out.println(subChoice);
                        switch (subChoice) {
                            case 1 -> addBankBranch();
                            case 2 -> addClient();
                            case 3 -> addCredit();
                            case 4 -> createContract();
                            case 5 -> System.out.println("Возвращаемся обратно...");
                            default -> System.out.println("Неверный пункт меню. Повторите выбор.");
                        }
                    }
                    case 2 -> {
                        System.out.println("1. Вывести список договоров");
                        System.out.println("2. Вывести список филиалов");
                        System.out.println("3. Вывести список клиентов");
                        System.out.println("4. Вывести список кредитов");
                        System.out.println("5. Обратно");
                        System.out.print("Выберите пункт меню: ");
                        int subChoice = Integer.parseInt(scanner.nextLine());
                        switch (subChoice) {
                            case 1 -> displayContracts();
                            case 2 -> displayBankBranches();
                            case 3 -> displayClients(individualClients, corporateClients);
                            case 4 -> displayCredits();
                            case 5 -> System.out.println("Возвращаемся обратно...");
                            default -> System.out.println("Неверный пункт меню. Повторите выбор.");
                        }
                    }
                    case 3 -> calculateBankIncome();
                    case 4 -> convertPriceToEuro();
                    case 5 -> System.out.println("Программа завершена.");
                    default -> System.out.println("Неверный пункт меню. Повторите выбор.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверный пункт меню. Повторите выбор.");
            }
        } while (choice != 5);
    }

    // вывод филиалов банка
    @Override
    public void displayBankBranches() {
        if(bankBranches.size()>0)
        for (BankBranch branch : bankBranches) System.out.println(branch.toString());
        else System.out.println("Филиалов нет!");
    }

    // вывод клиентов банка
    @Override
    public void displayClients(List<IndividualClient> individualClients, List<CorporateClient> corporateClients) {
        if(individualClients.size()>0) {
            System.out.println("Список клиентов:");
            System.out.println("\n\nФизические лица:");
            for (IndividualClient client : individualClients) System.out.println(individualClients.indexOf(client)+1+". "+ client.toString()+"\n");
        }else System.out.println("\n\nФизических лиц нет!");
        if(corporateClients.size()>0) {
            System.out.println("\n\nЮридические лица:");
            for (CorporateClient client : corporateClients) System.out.println(corporateClients.indexOf(client)+1+individualClients.size() + ". "+client.toString()+"\n");
        }else System.out.println("\n\nЮридических лиц нет!");
    }

    // вывод кредитов
    @Override
    public void displayCredits() {
        if (credits.size()>0) {
            System.out.println("Список кредитов:");
            for (Credit credit : credits) {
                System.out.println(credits.indexOf(credit) + ". " + credit);
            }
        }else System.out.println("\nКредитов нет!\n");
    }
    // вывод контрактов
    @Override
    public void displayContracts() {
        if(contracts.size()>0) {
            System.out.println("Список договоров:");
            for (Contract contract : contracts) {
                System.out.println("Номер договора: " + contract.getContractNumber());
                System.out.println("Дата договора: " + contract.getDate());
                System.out.println("Имя клиента: " + contract.getClient().getName());
                System.out.println("Тип кредита: " + contract.getCredit().getCreditType());
                System.out.println("Сумма кредита: " + contract.getTotalLoanAmount());
                System.out.println("Срок погашения кредита: " + contract.getLoanRepaymentTerm() + " месяцев");
                System.out.println();
            }
        }else System.out.println("\nДоговоров нет!\n");
    }
    // добавление нового филиала банка
    @Override
    public void addBankBranch() {
        System.out.println("Добавление филиала банка:");
        System.out.print("Введите имя филиала: ");
        String name = scanner.nextLine();
        System.out.print("Введите адрес филиала: ");
        String address = scanner.nextLine();
        System.out.print("Введите телефон филиала: ");
        String phoneNumber = scanner.nextLine();

        BankBranch bankBranch = new BankBranch(name, address, phoneNumber);
        bankBranches.add(bankBranch);
        // Добавление филиала в список или другую структуру данных
        System.out.println("Филиал банка добавлен.");
    }
    // добавление нового юридического лица
    public void addLegalClient(String name, String address, String phoneNumber) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите идентификационный номер налогоплательщика: ");
        String taxIdentificationNumber = scanner.nextLine();

        System.out.print("Введите имя администратора: ");
        String administratorName = scanner.nextLine();

        System.out.print("Введите имя контактного лица: ");
        String contactPerson = scanner.nextLine();

        CorporateClient client = new CorporateClient(name, address, phoneNumber, taxIdentificationNumber, administratorName, contactPerson);
        corporateClients.add(client);
        System.out.println("Юридический клиент добавлен.");
    }
    // добавление нового физического лица
    public void addIndividualClient(String name, String address, String phoneNumber) {
        System.out.print("Введите личный код: ");
        String personalCode = scanner.nextLine();

        IndividualClient client = new IndividualClient(name, address, phoneNumber, personalCode);
        individualClients.add(client);
        System.out.println("Физический клиент добавлен.");
    }

    // общая функция добавления клиента
    @Override
    public void addClient() {

        System.out.println("Выберите тип клиента:");
        System.out.println("1. Физическое лицо");
        System.out.println("2. Юридическое лицо");
        int choice;
        try {
           choice = scanner.nextInt();
            scanner.nextLine();
        }catch (InputMismatchException e){
            System.out.println("Введены некорректные данные. Пожалуйста, введите данные в правильном формате.");
            scanner.nextLine(); // очистка буфера
            return;
        }
        System.out.println("Введите имя:");
        String name = scanner.nextLine();

        System.out.println("Введите адрес:");
        String address = scanner.nextLine();

        System.out.println("Введите номер телефона:");
        String phoneNumber = scanner.nextLine();

        if (choice == 1) addIndividualClient(name, address, phoneNumber);
         else if (choice == 2) addLegalClient(name, address, phoneNumber);
         else System.out.println("Неверный выбор типа клиента.");
    }

    // добавление нового кредита
    @Override
    public void addCredit() {
        System.out.println("Добавление кредита:");
        System.out.print("Введите тип кредита: ");
        String creditType = scanner.nextLine();
        System.out.print("Введите наименование кредита: ");
        String name = scanner.nextLine();
        System.out.print("Введите валюту кредита: ");
        String currency = scanner.nextLine();
        System.out.print("Введите годовую процентную ставку кредита: ");
        double annualInterestRate;
        try {
            annualInterestRate = scanner.nextDouble();
            scanner.nextLine(); // Очистка буфера
        }catch (InputMismatchException e){
            System.out.println("Введены некорректные данные. Пожалуйста, введите данные в правильном формате.");
            return;
        }
        Credit credit = new Credit(creditType, name, currency, annualInterestRate);
        credits.add(credit);
    }
    // создание нового контракта
    @Override
    public void createContract() {
        try {
            System.out.println("Заключение договора:");

            System.out.print("Введите номер контракта: ");
            String contractNumber = scanner.nextLine();
            System.out.print("Введите дату контракта dd.mm.yyyy: ");
            String date = scanner.nextLine();

            System.out.println("Выберите клиента:");
            displayClients(individualClients, corporateClients);
            int clientChoice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            Client client;
            if (clientChoice > 0 && clientChoice <= individualClients.size()) {
                client = individualClients.get(clientChoice - 1);
            } else if (clientChoice > individualClients.size() && clientChoice <= individualClients.size() + corporateClients.size()) {
                client = corporateClients.get(clientChoice - individualClients.size() - 1);
            } else {
                System.out.println("Неверный выбор клиента.");
                return;
            }

            System.out.println("Выберите кредит:");
            displayCredits();
            int creditChoice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            Credit credit;
            if (creditChoice > 0 && creditChoice <= credits.size()) {
                credit = credits.get(creditChoice - 1);
            } else {
                System.out.println("Неверный выбор кредита.");
                return;
            }

            System.out.print("Введите общую сумму займа: ");
            double totalLoanAmount = scanner.nextDouble();
            scanner.nextLine(); // Очистка буфера
            System.out.print("Введите срок погашения займа: ");
            int loanRepaymentTerm = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            Contract contract = new Contract(contractNumber, date, client, credit, totalLoanAmount, loanRepaymentTerm);
            contracts.add(contract);
            System.out.println("Договор заключен.");
        }catch (InputMismatchException e){
            System.out.println("Введены некорректные данные. Пожалуйста, введите данные в правильном формате.");
        }catch (NoSuchElementException e){
            System.out.println("Не удалось считать ввод. Пожалуйста, введите данные корректно.");
        }
    }

    // расчет дохода банка
    @Override
    public void calculateBankIncome() {
        System.out.println("Расчет дохода банка:");
        if (contracts == null) {throw new IllegalArgumentException("Контрактов нет!");}

        System.out.print("Введите номер договора: ");
        String contractNumber = scanner.nextLine();
        // Найти договор по номеру
        Contract contract = findContractByNumber(contractNumber);

        if (contract != null) {
            contract.calculateIncome();
        } else {
            System.out.println("Договор не найден.");
        }
    }
    // поиск контракта по номеру
    private static Contract findContractByNumber(String contractNumber) {
        if (contractNumber == null) {throw new IllegalArgumentException("Номер контракта не может быть [" + null + "]");}

        for (Contract contract : contracts) {
            if (contract.getContractNumber().equals(contractNumber)) {
                return contract;
            }
        }
        return null;
    }
    // перевод цены из леев в евро
    @Override
    public void convertPriceToEuro() {
        System.out.println("Конвертация цены в евро:");
        try {
            System.out.print("Введите текущую цену в лей: ");
            double price = scanner.nextDouble();
            System.out.print("Введите курс (1 евро в леях): ");
            double rate = scanner.nextDouble();
            if(rate == 0) throw  new ArithmeticException();
            double euroPrice = price / rate;
            DecimalFormat df = new DecimalFormat("#.00");
            System.out.println("Цена в евро: " + df.format(euroPrice));
        }catch (InputMismatchException e){
            System.out.println("\nОшибка ввода. Пожалуйста, введите числовое значение.\n");
        }catch (ArithmeticException e){
            System.out.println("\nОшибка(деление на ноль):" + e.getMessage() + "\n");
        }finally {
            scanner.nextLine(); // Очистка буфера
        }
    }
}
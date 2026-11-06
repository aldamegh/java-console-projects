import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ConsoleProjectsTest {
    private static int checks;

    private static void check(boolean condition, String message) {
        checks++;
        if (!condition) throw new AssertionError(message);
    }

    private static String balance(Bank bank, String name) {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream original = System.out;
        try {
            System.setOut(new PrintStream(buffer));
            bank.display(name);
        } finally {
            System.setOut(original);
        }
        return buffer.toString().trim();
    }

    public static void main(String[] args) {
        Bank bank = new Bank(2);
        check(bank.addClient("Alex", 100), "Add first client");
        check(!bank.addClient("alex", 20), "Reject duplicate ignoring case");
        check(bank.addClient("Taylor", 20), "Add second client");
        check(!bank.addClient("Casey", 10), "Reject full capacity");
        check(!bank.deposit("Alex", -1), "Reject negative deposit");
        check(!bank.deposit("Alex", Double.NaN), "Reject NaN");
        check(!bank.withdraw("Alex", Double.POSITIVE_INFINITY), "Reject infinity");
        check(bank.withdraw("Alex", 100), "Allow exact-balance withdrawal");
        check(balance(bank, "Alex").equals("Alex 0.0 SR"), "Withdrawal balance");
        check(!bank.withdraw("Alex", 1), "Reject overdraft");
        check(bank.deposit("Alex", 70), "Deposit");
        check(bank.transfer("Alex", "Taylor", 70), "Transfer entire balance");
        check(balance(bank, "Taylor").equals("Taylor 90.0 SR"), "Recipient balance");
        check(!bank.transfer("Taylor", "Taylor", 5), "Reject self-transfer");
        check(!bank.transfer("Taylor", "Missing", 5), "Reject missing recipient");
        Bank other = new Bank(5);
        check(other.addClient("Casey", 10), "Add other-bank client");
        check(!bank.transferToBank("Taylor", other, "Missing", 5), "Unused slots do not cause null dereference");
        check(bank.transferToBank("Taylor", other, "Casey", 30), "Cross-bank transfer");
        check(balance(bank, "Taylor").equals("Taylor 60.0 SR"), "Sender balance");
        check(balance(other, "Casey").equals("Casey 40.0 SR"), "Other bank balance");
        check(bank.deleteClient("Alex"), "Delete client");
        check(bank.findIndexByName("Alex") == -1, "Deleted client absent");
        check(bank.findIndexByName("Taylor") >= 0, "Remaining client retained");
        check(bank.findMax().equals("Taylor"), "Maximum balance");
        check(new Bank().addClient("Example", 0), "Default constructor initializes storage");
        check(!other.addClient("Invalid", -1), "Reject negative opening balance");

        Employees employees = new Employees();
        check(employees.addEmployee(1, "Alex", 2, 500, "IT") == 1, "Add employee");
        check(employees.addEmployee(2, "Taylor", 7, 200, "it") == 1, "Add lower-paid employee last");
        check(employees.findHighestSalary("IT") == 0, "Find true maximum, not last employee");
        check(employees.findHighestSalary("Missing") == -1, "Missing department");
        check(employees.addEmployee(1, "Other", 1, 100, "IT") == -1, "Duplicate employee ID");
        check(employees.calculateBonus(0) == 1000, "Early-career bonus");
        check(employees.calculateBonus(1) == 600, "Mid-career bonus");
        check(employees.calculateBonus(-1) == -1, "Invalid bonus index");
        check(employees.addEmployee(3, "Casey", 11, 100, "HR") == 1, "Add senior employee");
        check(employees.calculateBonus(2) == 400, "Senior bonus");
        check(employees.addEmployee(4, "Invalid", -1, 10, "HR") == -3, "Reject invalid years");
        check(employees.getNEmployees() == 3, "Rejected writes preserve count");
        System.out.println(checks + " checks passed.");
    }
}

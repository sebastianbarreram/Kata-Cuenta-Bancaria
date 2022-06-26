import utilities.*;
import static utilities.Amount.amountOf;
import static utilities.CreatorDate.date;

/**
 * Esta clase es la solucion al [Taller] Kata Cuenta Bancaria
 * del curso Buenas Practicas para el Desarrollo de Software
 * SofkaU DEV C3 - 2022
 * 
 * @author Sebastian Barrera Marín
 * @version 1.0.0 25/06/2022
 */
public class StartApp {

    public static void main(String[] args) {

        Account account = new Account(new Statement());

        account.deposit(amountOf(1000), date("10/01/2021"));
        account.deposit(amountOf(2000), date("13/01/2021"));
        account.withdrawal(amountOf(500), date("14/01/2021"));
        // account.withdrawal(amountOf(800), date("14/01/2021"));
        // account.deposit(amountOf(1000), date("10/01/2021"));
        // account.withdrawal(amountOf(100), date("14/01/2021"));

        account.printStatement(System.out);
    }
}
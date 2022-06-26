import org.junit.Assert;
import org.junit.Test;

import utilities.Account;
import utilities.Amount;
import utilities.Statement;
import utilities.Transaction;

import static utilities.Amount.amountOf;
import static utilities.CreatorDate.date;

public class AcceptanceTest {

    @Test
    public void shouldWhatever() {
        Assert.assertTrue("OMG test!", true);
    }

    @Test
    public void cuandoSeGeneraUnDepositoEnlaCuenta() {
        Account account = new Account(new Statement());
        Amount amount = amountOf(1000);
        account.deposit(amount, date("10/01/2021"));
        Transaction transaction = new Transaction(amount, date("10/01/2021"));

        Assert.assertEquals(account.getBalance().formatCurrency(), transaction.getAmount().formatCurrency());
    }

}
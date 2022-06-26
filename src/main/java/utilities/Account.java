package utilities;

import java.io.PrintStream;
import java.time.LocalDate;

/**
 * Esta clase tiene los atributos y metodos de una cuenta bancaria
 */
public class Account {
    private Statement statement;
    private Amount balance = Amount.amountOf(0);

    /**
     * Esta funcion crea una cuenta bancaria con su atributo extracto bancario
     * 
     * @param statement extracto bancario
     */
    public Account(Statement statement) {
        this.statement = statement;
    }

    /**
     * Esta funcion genera un ingreso de dinero (deposito) en la cuenta bancaria
     * 
     * @param value monto del deposito
     * @param date  fecha del deposito
     */
    public void deposit(Amount value, LocalDate date) {
        transactionSave(value, date);
    }

    /**
     * Esta funcion genera un egreso de dinero (retiro) en la cuenta bancaria
     * 
     * @param value monto del retiro
     * @param date  fecha del retiro
     */
    public void withdrawal(Amount value, LocalDate date) {
        transactionSave(value.amountSubs(), date);
    }

    /**
     * Esta funcion da la orden de mostrar en consola el extracto bancario
     * 
     * @param printer instruccion para concatenar cadenas string
     */
    public void printStatement(PrintStream printer) {
        statement.printTo(printer);
    }

    /**
     * Esta funcion almacena la transaccion en el extracto bancario
     * 
     * @param value monto de la transaccion
     * @param date  fecha de la transaccion
     */
    private void transactionSave(Amount value, LocalDate date) {
        Transaction transaction = new Transaction(value, date);
        Amount amountTransactionLater = transaction.balanceTransactionLater(this.balance);
        setBalance(amountTransactionLater);
        statement.lineAdd(transaction);
    }

    /**
     * Esta funcion establece el valor del atributo saldo
     * 
     * @param amount valor que se desea asignar a saldo
     */
    private void setBalance(Amount amount) {
        this.balance = amount;
    }

    /**
     * Esta funcion obtiene el valor del atributo saldo
     * 
     * @return valor del atributo saldo
     */
    public Amount getBalance() {
        return balance;
    }

}
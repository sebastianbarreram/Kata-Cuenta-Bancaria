package utilities;

import java.time.LocalDate;

/**
 * Esta clase tiene los atributos y metodos de una transaccion bancaria
 */
public class Transaction {

    private Amount amount;
    private Amount balance;
    private LocalDate date;

    /**
     * Esta funcion crea una transaccion con sus atributos monto y fecha
     * 
     * @param amount monto de la transaccion
     * @param date   fecha de la transaccion
     */
    public Transaction(Amount amount, LocalDate date) {
        this.amount = amount;
        this.date = date;
    }

    /**
     * Esta funcion calcula el saldo de la cuenta luego de la transaccion
     * 
     * @param currentBalance saldo actual de la cuenta
     * @return saldo luego de la transaccion
     */
    public Amount balanceTransactionLater(Amount currentBalance) {
        this.balance = currentBalance.amountAdd(this.amount);
        return currentBalance.amountAdd(this.amount);
    }

    /**
     * Esta funcion convierte la transaccion en una linea de texto
     * 
     * @return transaccion en un string
     */
    public String addLine() {
        StringBuilder builder = new StringBuilder();
        String dateLocal = dateChange(this.date);
        builder.append(dateLocal);
        builder.append("\t|");
        if (!this.amount.greaterThan(0)) {
            builder.append("\t\t\t|");
            builder.append(this.amount.formatCurrency());
            builder.append("\t\t\t|");
            builder.append(this.balance.formatCurrency());
            return builder.toString().replace("-", "");
        }
        builder.append(this.amount.formatCurrency());
        builder.append("\t\t|\t\t\t|");
        builder.append(this.balance.formatCurrency());
        return builder.toString();
    }

    /**
     * Esta funcion le cambia el formato a la fecha
     * 
     * @param date fecha de la transaccion
     * @return fecha en formato yyyy/mm/dd
     */
    private static String dateChange(LocalDate date) {
        String dateChange = String.valueOf(date);
        dateChange = dateChange.replace("-", "/");
        return dateChange;
    }

    /**
     * Esta funcion obtiene el valor del atributo monto
     * 
     * @return valor del atributo monto
     */
    public Amount getAmount() {
        return amount;
    }

}
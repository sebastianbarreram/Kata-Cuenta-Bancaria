package utilities;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

/**
 * Esta clase tiene los atributos y metodos de un extracto bancario
 */
public class Statement {

    private final String headerBalance = " Date \t\t| Credit \t\t| Debit \t\t| Balance   ";
    private List<String> balance;

    /**
     * Esta funcion genera una lista con el extracto bancario
     */
    public Statement() {
        this.balance = new LinkedList<String>();
        this.balance.add(headerBalance);
    }

    /**
     * Esta funcion agrega una transaccion al listado del extracto bancario
     * 
     * @param transaction transaccion realizada a la cuenta bancaria
     */
    public void lineAdd(Transaction transaction) {
        this.balance.add(1, transaction.addLine());
    }

    /**
     * Esta funcion muestra en consola el extracto bancario
     * 
     * @param salida orden de mostrar extracto bancario
     */
    public void printTo(PrintStream salida) {
        for (String line : this.balance) {
            salida.println(line);
        }
    }
}
package utilities;

import java.text.DecimalFormat;

/**
 * Esta clase tiene los atributos y metodos de un monto de dinero
 */
public class Amount {
    private DecimalFormat formatDecimal = new DecimalFormat("#.00");
    private Integer value;

    /**
     * Esta funcion crear un monto de dinero con su atributo valor
     * 
     * @param value cantidad de dinero
     */
    public Amount(Integer value) {
        this.value = value;
    }

    /**
     * Esta funcion crea una cantidad de dinero en una transaccion bancaria
     * 
     * @param value cantidad de dinero
     * @return monto de dinero
     */
    public static Amount amountOf(Integer value) {
        return new Amount(value);
    }

    /**
     * Esta funcion adiciona el monto de la transaccion al saldo anterior
     * 
     * @param amountOther monto de la transaccion
     * @return monto actual
     */
    public Amount amountAdd(Amount amountOther) {
        return amountOf(this.value + amountOther.value);
    }

    /**
     * Esta funcion le da formato a los datos numericos del extracto bancario
     * 
     * @return numero con formato de dos decimales
     */
    public String formatCurrency() {
        return formatDecimal.format(this.value);
    }

    /**
     * Esta funcion convierte la cantidad de dinero en un valor negativo
     * 
     * @return monto del retiro de la cuenta bancaria
     */
    public Amount amountSubs() {
        return amountOf(-value);
    }

    /**
     * Esta funcion compara el valor del monto de la transaccion
     * 
     * @param comparator valor con el que se compara
     * @return valor booleano de la comparacion
     */
    public boolean greaterThan(double comparator) {
        return this.value > comparator;
    }
}
package utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Esta clase tiene los atributos y metodos de la fecha
 */
public class CreatorDate {
    private static final String dateFormat = "dd/MM/yyyy";

    /**
     * Esta funcion le da formato dd/MM/yyyy a la fecha
     * 
     * @param date fecha
     * @return fecha en el formato dd/MM/yyyy
     */
    public static LocalDate date(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        return LocalDate.parse(date, formatter);
    }
}
package controller.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public abstract class Validator {

    public static boolean validateObject(Object o) {
        return o != null;
    }

    public static boolean validateInteger(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean validateDouble(String text) {
        try {
            Double.parseDouble(text);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean validateFields(String ... fields) {
        for(String field : fields) {
            if (field.isBlank())
                return false;
        }
        return true;
    }

    public static boolean validateQuantity(int value) {
        return (value >= 0);
    }

    public static boolean validateQuantity(double value) {
        return (value >= 0.0);
    }

    public static boolean validateDate(String date) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            format.setLenient(false);
            format.parse(date);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }
}

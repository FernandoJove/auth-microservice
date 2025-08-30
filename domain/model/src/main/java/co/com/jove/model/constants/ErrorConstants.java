package co.com.jove.model.constants;

import java.math.BigDecimal;

public final class ErrorConstants {

    public static final String EMPTY ="Field is required and cannot be empty : ";
    public static final String MAX_CHAR ="Field must not exceed 40 characters : ";


    public static final String NAME = EMPTY + "Invalid name" ;
    public static final String EMPTY_NAME = EMPTY + NAME ;
    public static final String MAX_NAME = MAX_CHAR + NAME ;

    public static final String LASTNAME =  "Invalid lastName." ;
    public static final String EMPTY_LASTNAME = EMPTY + LASTNAME ;
    public static final String MAX_LASTNAME = MAX_CHAR + LASTNAME ;

    public static final String EMAIL = "Invalid email." ;
    public static final String EMPTY_EMAIL = EMPTY + EMAIL ;
    public static final String INVALID_EMAIL = "Must be a valid email address : " + EMAIL ;

    public static final String DNI = EMPTY + "Invalid identification number." ;
    public static final String EMPTY_DNI = EMPTY + DNI ;

    public static final String EMPTY_PHONE = EMPTY + "Invalid phone number." ;

    public static final String SALARY_OUT_OF_RANGE ="Invalid amount. Business rules require the amount to be between 0 and 15,000,000.";


}

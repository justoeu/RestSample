package br.com.justoeu.util.date;
public abstract class CalendarParams {

    public static final int      DAY                  = 1;
    public static final int      MONTH                = 2;
    public static final int      YEAR                 = 3;
    public static final int      HOUR                 = 4;
    public static final int      HOUR24H              = 5;
    public static final int      MIN                  = 6;
    public static final int      SEC                  = 7;
    public static final int      MIL                  = 8;

    public static final int      LOCALE_PT            = 1;
    public static final int      LOCALE_EN            = 2;

    public static final String   TIMEFULL             = "HH:mm:ss";
    public static final String   TIME                 = "HH:mm";
    public static final String   FORMATDATEPT         = "dd/MM/yyyy";
    public static final String   FORMATDATEEN         = "yyyy-MM-dd";
    public static final String   FORMATDATEENGFULL    = "yyyy-MM-dd hh:mm:ss";
    public static final String   FORMATDATEENGFULL24H = "yyyy-MM-dd HH:mm:ss";
    public static final String   FORMATDATETIMEFULLPT = "dd/MM/yyyy hh:mm:ss";
    public static final String   FORMATDATETIMEFULLPTFILE = "dd-MM-yyyy_hh-mm-ss";

    public static final String[] DIASSEMANA           = { "Domingo", 
                                                                                                          "Segunda-Feira", 
                                                                                                          "Terca-Feira", 
                                                                                                          "Quarta-Feira",
                                                                                                          "Quinta-Feira", 
                                                                                                          "Sexta-Feira", 
                                                                                                          "Sabado"  
                                                                                                        };
    public static final String[] MESES                = { "Janeiro", 
                                                                                                          "Fevereiro", 
                                                                                                          "Marco", 
                                                                                                          "Abril", 
                                                                                                          "Maio", 
                                                                                                          "Junho", 
                                                                                                          "Julho",
                                                                                                          "Agosto", 
                                                                                                          "Setembro", 
                                                                                                          "Outubro", 
                                                                                                          "Novembro", 
                                                                                                          "Dezembro" 
                                                                                                        };

        
}
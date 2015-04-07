package br.com.justoeu.util.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Class Utilizada para tratamento de Datas
 * 
 * Data da Ultima alteracao: <b>18/02/2015</b>
 * 
 * @author Valmir Robson Justo
 * @Version 3
 */
public final class CalendarUtils {

    private CalendarUtils() {}

    /**
     * Needed to create XMLGregorianCalendar instances
     */
    private static DatatypeFactory df = null;
    static {
        try {
            df = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException dce) {
            throw new IllegalStateException("Exception while obtaining DatatypeFactory instance", dce);
        }
    }  
    
    /**
     * Metodo que retorna um date com a data Atual
     * 
     * @return Date com a data Atual
     */
    public static Date date() {
        GregorianCalendar cal = new GregorianCalendar();
        return cal.getTime();
    }

    /**
     * Metodo que retorna a Hora atual
     * 
     * @return long representando a hora atual
     */
    public static long time() {
        return date().getTime();
    }

    /**
     * Metodo que retorna a Data Atual Formatada
     * 
     * @param data
     *            - java.util.date new Date - Caso null pega a data Atual
     * @param sFormat
     *            - formatacao ex: dd/MM/yyyy , dd-MM-yyyy, yyyy-MM-dd ,
     *            dd/MM/yyyy hhmmss
     * @param Locate
     *            - locale padrao - (pt-BR) caso null pega o default da classe
     * 
     * @return String com a Data formatada
     */
    public static String formatDate(final Date data, final String sFormat, final Locale locale) {
        final SimpleDateFormat simple = new SimpleDateFormat(sFormat, locale == null ? getLocale(CalendarParams.LOCALE_PT) : locale);
        String dateRetorno;
        if (data == null) {
            final GregorianCalendar cal = new GregorianCalendar();
            dateRetorno = simple.format(cal.getTime());
        } else {
            dateRetorno = simple.format(data);
        }

        return dateRetorno;
    }

    /**
     * Metodo que converta uma String Data em uma data. O formato deve ser igual
     * ao que foi informado no parametro de String Data
     * 
     * @param data
     *            - String referente a Data
     * @param sFormat
     *            - tipo de formato Ex: "dd/MM/yyyy", "yyyy-MM-dd",
     *            "yyyyMMdd HH:mm:ss", MMM/yy -> mes por extenso
     * @param Locate
     *            - locale padrao - (pt-BR) caso null pega o default da classe
     * 
     * @return Date
     */
    public static Date toDate(final String data, final String sFormat, final Locale locale) {
        final SimpleDateFormat formato = new SimpleDateFormat(sFormat, locale == null ? getLocale(CalendarParams.LOCALE_PT) : locale);
        Date date = null;
        try {
            date = formato.parse(data);
        } catch (ParseException e) {
            // LOG.error("Date dont convert ", e);
            System.out.println(e.getMessage());
        }
        return date;
    }

    /**
     * Metodo que retorna a Hora formatada
     * 
     * @param Date
     *            - Date data a ser utilizada para obtencao da hora
     * @param sFormat
     *            - String com o Formato da Hora
     * @param Locate
     *            - locale padrao - (pt-BR) caso null pega o default da classe
     * 
     *            exemplo: "HH:mm:ss", "HH:mm", "hh:mm"
     * 
     * @return String com a Hora Atual
     */
    public static String formatTime(final Date data, final String sFormat, final Locale locale) {
        return formatDate(data, sFormat, locale);
    }

    /**
     * Metodo que retorna Parte de uma Data baseado no seu tipo
     * 
     * Parte validas Dia (DAY), Mes (MONTH), Ano (YEAR), Hora (Hour), Minutos
     * (Min), Segundos (Sec)
     * 
     * @param numDays
     *            - Numero de Dias, sendo positivos ou Negativos
     * @param data
     *            - Date utilizado para a conversao
     * @param typePartDate
     *            - Tipo referente a parte da Data Parte validas Dia (DAY), Mes
     *            (MONTH), Ano (YEAR), Hora (Hour), Minutos (Min), Segundos
     *            (Sec)
     * 
     * @return String com a Parte da Data
     */
    public static String getPartOfDate(final Date date, final int typePartDate) {
        String strRetorno;

        switch (typePartDate) {
        case CalendarParams.DAY:
            strRetorno = formatDate(date, "dd", null);
            break;
        case CalendarParams.MONTH:
            strRetorno = formatDate(date, "MM", null);
            break;
        case CalendarParams.YEAR:
            strRetorno = formatDate(date, "yyyy", null);
            break;
        case CalendarParams.HOUR24H:
            strRetorno = formatDate(date, "HH", null);
            break;
        case CalendarParams.HOUR:
            strRetorno = formatDate(date, "hh", null);
            break;
        case CalendarParams.MIN:
            strRetorno = formatDate(date, "mm", null);
            break;
        case CalendarParams.SEC:
            strRetorno = formatDate(date, "ss", null);
            break;
        default:
            strRetorno = formatDate(date, "dd/MM/yyyy", null);
            break;
        }

        return strRetorno;
    }

    /**
     * Metodo que adiciona / Subtraia Dias, Meses, Anos, Horas, Minutos,
     * Segundos ou Milisegundos de uma Data passada como Parametro
     * 
     * @param numDays
     *            - Numero de Dias, sendo positivos ou Negativos
     * @param data
     *            - Date utilizado para a conversao
     * @param typePartDate
     *            - Tipo referente a parte da Data Parte validas Dia (DAY), Mes
     *            (MONTH), Ano (YEAR), Hora (Hour), Minutos (Min), Segundos
     *            (Sec)
     * 
     * @return new Date
     */
    public static Date plusOrMinusPartsOfDate(final int numDays, final Date data, final int typePartDate) {
        final Calendar calendarData = Calendar.getInstance();
        calendarData.setTime(data);

        switch (typePartDate) {
        case CalendarParams.DAY:
            calendarData.add(Calendar.DATE, numDays);
            break;
        case CalendarParams.MONTH:
            calendarData.add(Calendar.MONTH, numDays);
            break;
        case CalendarParams.YEAR:
            calendarData.add(Calendar.YEAR, numDays);
            break;
        case CalendarParams.HOUR24H:
            calendarData.add(Calendar.HOUR_OF_DAY, numDays);
            break;
        case CalendarParams.HOUR:
            calendarData.add(Calendar.HOUR, numDays);
            break;
        case CalendarParams.MIN:
            calendarData.add(Calendar.MINUTE, numDays);
            break;
        case CalendarParams.SEC:
            calendarData.add(Calendar.SECOND, numDays);
            break;
        case CalendarParams.MIL:
            calendarData.add(Calendar.SECOND, numDays);
            break;
        default:
            calendarData.add(Calendar.DATE, numDays);
            break;
        }

        return calendarData.getTime();
    }

    /**
     * Metodo que retorna a diferenca entre datas
     * 
     * @param DtInicial
     *            = Data inicial
     * @param DtFim
     *            = Data Final
     * @param locateType
     *            - Tipo da Localidade para ser Utilizada podendo ser PT ou EN
     * 
     * @version 1.2
     * @return int qtd de Dias
     */
    public static int between(final String dtInicial, final String dtFim, final int locateType) throws Exception {

        int result;
        SimpleDateFormat sdf;
        if (locateType == CalendarParams.LOCALE_PT) {
            sdf = new SimpleDateFormat(CalendarParams.FORMATDATEPT, getLocale(CalendarParams.LOCALE_PT));
        } else {
            sdf = new SimpleDateFormat(CalendarParams.FORMATDATEEN, getLocale(CalendarParams.LOCALE_EN));
        }

        try {
            final long microTimeInicial = sdf.parse(dtInicial).getTime();
            final long microTimeFinal = sdf.parse(dtFim).getTime();

            result = (int) ((microTimeFinal - microTimeInicial) / (24 * 60 * 60 * 1000));

        } catch (ParseException e) {
            throw new Exception("Erro na Conversao das datas: ", e);
        }

        return result;
    }

    /**
     * Metodo que retorna a quantidade de Dias referente a uma diferenï¿½a
     * 
     * @param dtInicial
     *            - Data Inicial
     * @param dtFim
     *            - Data Final
     * @return
     */
    public static int between(final Date dtInicial, final Date dtFim) {
        final long microTimeInicial = dtInicial.getTime();
        final long microTimeFinal = dtFim.getTime();

        return (int) ((microTimeFinal - microTimeInicial) / (24 * 60 * 60 * 1000));
    }

    /**
     * Calcula a diferenï¿½a de duas datas em minutos <br>
     * <b>Importante:</b> Quando realiza a diferenï¿½a em minutos entre duas
     * datas, este mï¿½todo considera os segundos restantes e os converte em
     * fraï¿½ï¿½o de minutos.
     * 
     * @param dataInicial
     * @param dataFinal
     * @return quantidade de minutos existentes entre a dataInicial e dataFinal.
     */
    public static long minutsOfBetween(final Date dataInicial, final Date dataFinal) {
        final long diferenca = dataFinal.getTime() - dataInicial.getTime();
        final long difEmMin = (diferenca / 1000) / 60; // resultado ï¿½
                                                       // diferenï¿½a entre as
                                                       // datas em minutos
        final long segRestante = (diferenca / 1000) % 60; // calcula os segundos
                                                          // restantes

        return difEmMin + (segRestante / 60L); // transforma os segundos
                                               // restantes em minutos
    }

    /**
     * Calcula a diferenï¿½a de duas datas em horas <br>
     * <b>Importante:</b> Quando realiza a diferenï¿½a em horas entre duas
     * datas, este mï¿½todo considera os minutos restantes e os converte em
     * fraï¿½ï¿½o de horas.
     * 
     * @param dataInicial
     * @param dataFinal
     * @return quantidade de horas existentes entre a dataInicial e dataFinal.
     */
    public static long hourOfBetween(final Date dataInicial, final Date dataFinal) {
        final long diferenca = dataFinal.getTime() - dataInicial.getTime();
        final long difEmHoras = (diferenca / 1000) / 60 / 60;
        final long minRestantes = (diferenca / 1000) / 60 % 60;
        final long horaRestantes = minRestantes / 60L;

        return difEmHoras + (horaRestantes);
    }

    /**
     * Metodo que calcula a diferenca entre horas
     * 
     * @param horaInicial
     *            - String Hora inicial
     * @param horaFinal
     *            - String Hora Final
     * 
     * @return String com a Subtracao das horas
     */
    public static String hourOfBetween(final String sFormaTime, final String horaInicial, final String horaFinal,
            final Locale locale) throws Exception {
        final SimpleDateFormat sdf = new SimpleDateFormat(sFormaTime, locale == null ? getLocale(CalendarParams.LOCALE_PT) : locale);
        Date datEntrada;
        Date datSaida;
        final StringBuffer returnHora = new StringBuffer();

        try {
            datEntrada = sdf.parse(horaInicial);
            datSaida = sdf.parse(horaFinal);

            final long diferencaHoras = (datSaida.getTime() - datEntrada.getTime()) / (1000 * 60 * 60);
            final long diferencaMinutos = (datSaida.getTime() - datEntrada.getTime()) / (1000 * 60);
            final long diferencaSeg = (datSaida.getTime() - datEntrada.getTime()) / (1000);

            long difHoraMin = diferencaMinutos % 60;
            long diferencaSegundos = diferencaSeg % 60;

            if (difHoraMin < 0 || diferencaSegundos < 0) {
                returnHora.append('-');
                difHoraMin = difHoraMin * -1;
                diferencaSegundos = diferencaSegundos * -1;
            }

            if (diferencaHoras <= 9) {
                returnHora.append('0');
                returnHora.append(diferencaHoras);
            } else {
                returnHora.append(String.valueOf(diferencaHoras));
            }

            returnHora.append(':');

            if (difHoraMin <= 9) {
                returnHora.append('0');
                returnHora.append(String.valueOf(difHoraMin));
            } else {
                returnHora.append(String.valueOf(difHoraMin));
            }

            returnHora.append(':');

            if (diferencaSegundos <= 9) {
                returnHora.append('0');
                returnHora.append(String.valueOf(diferencaSegundos));
            } else {
                returnHora.append(String.valueOf(diferencaSegundos));
            }

        } catch (ParseException e) {
            throw new Exception("Erro na Conversao das datas: ", e);
        }

        return returnHora.toString();

    }

    /**
     * Metodo que executa um parse referente a hora passada como parametro
     * 
     * @param sHora
     *            String Hora
     * 
     * @version 1.2
     * @return long contendo a data atual mais a hora que foi utilizada no parse
     */
    public static long toTime(String sHora) throws Exception {

        if (sHora.indexOf("-") > -1) {
            sHora = sHora.replace("-", "");
        }

        final SimpleDateFormat simpleDate = new SimpleDateFormat(CalendarParams.FORMATDATEENGFULL, getLocale(CalendarParams.LOCALE_EN));
        final SimpleDateFormat simpleDateAux = new SimpleDateFormat(CalendarParams.FORMATDATEEN, getLocale(CalendarParams.LOCALE_EN));

        final StringBuffer dateGerada = new StringBuffer();
        try {
            dateGerada.append(simpleDateAux.format(new Date()));
            dateGerada.append(' ');

            dateGerada.append(sHora);

            if (sHora.length() == 5) {
                dateGerada.append(":00");
            }

            return simpleDate.parse(dateGerada.toString()).getTime();
        } catch (ParseException e) {
            throw new Exception("Erro ao Converter Time", e);
        }
    }

    /**
     * Metodo que retorna a data atual trocando o dia e o mes por extenso
     * 
     * @return String com a data atual
     */
    public static String getExtensiveDateByPtBr(final Date data, final Locale locale) {
        final StringBuffer sStringData = new StringBuffer();

        final Calendar calendar = Calendar.getInstance();
        if (data == null) {
            calendar.setTime(data);
        }

        final int posicao = calendar.get(Calendar.DAY_OF_WEEK) - 1;

        sStringData.append(CalendarParams.DIASSEMANA[posicao]);
        sStringData.append(", ");
        sStringData.append(calendar.get(Calendar.DAY_OF_MONTH));
        sStringData.append(" de ");
        sStringData.append(CalendarParams.MESES[calendar.get(Calendar.MONTH)]);
        sStringData.append(" de ");
        sStringData.append(calendar.get(Calendar.YEAR));
        sStringData.append(" - ");

        final SimpleDateFormat sHora = new SimpleDateFormat(CalendarParams.TIMEFULL, locale == null ? getLocale(CalendarParams.LOCALE_PT) : locale);
        sStringData.append(sHora.format(new Date()));

        return sStringData.toString();
    }

    /**
     * Metodo que retorna a Data escrita por extenso baseado na String de uma
     * Data
     * 
     * @param data
     *            - String data
     * @param sFormat
     *            - String com o Formato da Data
     * @param locate
     *            - locale padrao - (pt-BR) caso null pega o default da classe
     * @return
     */
    public static String getExtensiveDateByPtBr(final String data, final String sFormat, final Locale locale) {
        return getExtensiveDateByPtBr(toDate(data, sFormat, locale), locale);
    }

    /**
     * Metodo que retorna o primeiro dia do mes
     * 
     * @return Date com a data no primeiro dia do mes
     */
    public static Date firstDay(final Date date) {
        final Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getMinimum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 00);
        cal.set(Calendar.MINUTE, 00);
        cal.set(Calendar.SECOND, 00);
        cal.set(Calendar.MILLISECOND, 00);
        return cal.getTime();
    }

    /**
     * Metodo que retorna o ultimo dia do mes
     * 
     * @return Date com a data no ultimo dia do mes
     */
    public static Date lastDay(final Date date) {
        final Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }

    /**
     * Metodo que retorna a qtd de anos com base na data passada como parametro
     * 
     * @param date
     *            - java.util.date Objeto
     * 
     * @return int - qtd Anos
     */
    public static int getYearsBirthDay(final Date date) {
        final Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(date);

        final Calendar calAtual = Calendar.getInstance();
        int idade = calAtual.get(Calendar.YEAR) - cal.get(Calendar.YEAR);

        if ((calAtual.get(Calendar.MONTH) + 1) < (cal.get(Calendar.MONTH) + 1)) {
            idade--;
        } else {
            if ((calAtual.get(Calendar.MONTH) + 1) == (cal.get(Calendar.MONTH) + 1)
                    && (calAtual.get(Calendar.DAY_OF_MONTH) < cal.get(Calendar.DAY_OF_MONTH))) {
                idade--;
            }
        }
        if (idade < 0) {
            idade = 0;
        }

        return idade;
    }

    /**
     * Metodo Auxiliar que retorna o Locate Default pt-BR
     * 
     * @return
     */
    public static Locale getLocale(final int typeLocale) {
        Locale locale;
        if (typeLocale == CalendarParams.LOCALE_PT) {
            locale = new Locale("pt", "BR");
        } else {
            locale = new Locale("en", "US");
        }

        return locale;
    }

    
    /**
     * Convete um java.util.Date em uma instance of XMLGregorianCalendar
     *
     * @param  java.util.Date or a null
     * @return XMLGregorianCalendar instancia com base no valor passado como parametro 
     * 
     * @version 1.0
     * @author Valmir Justo
     */
    public static XMLGregorianCalendar dateAsXMLGregorianCalendar(Date date) {
        if (date == null) {
            return null;
        } else {
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTimeInMillis(date.getTime());
            return df.newXMLGregorianCalendar(gc);
        }
    }

    /**
     * Convete um XMLGregorianCalendar em uma instancia de of java.util.Date
     *
     * @param Objeto de XMLGregorianCalendar 
     * @return java.util.Date instancia com base no valor passado como parametro
     * 
     * @version 1.0
     * @author Valmir Justo 
     */
    public static Date xMLGregorianCalendarAsDate(XMLGregorianCalendar xgc) {
        
        Date dReturn = null;
        if (xgc != null) {
            dReturn =  xgc.toGregorianCalendar().getTime();
        }
        
        return dReturn;
    }
}
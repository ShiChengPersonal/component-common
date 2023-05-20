package component.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.*;

/**
 * @Program: component.component.utils
 * @Date: 2023/5/17 22:42
 * @Author: ShiCheng
 * @Description: 时间日期工具类，基于DateTimeFormatter
 */
public class DateUtil {

    public static final String FORMAT_DATE_TIME1 = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_DATE_TIME2 = "yyyyMMdd HH:mm:ss";
    public static final String FORMAT_DATE_TIME3 = "yyyy/MM/dd HH:mm:ss";
    public static final String FORMAT_DATE_TIME4 = "yyyy MMM dd HH:mm:ss";

    public static final String FORMAT_DATE1 = "yyyyMMdd";
    public static final String FORMAT_DATE2 = "yyyy-MM-dd";
    public static final String FORMAT_DATE3 = "yyyy/MM/dd";

    public static final String FORMAT_TIME1 = "HHmmss";
    public static final String FORMAT_TIME2 = "HH:mm:ss";
    public static final String FORMAT_TIME3 = "HH:mm:ss a";

    public static LocalDateTime getLocalDateTime(){
        return LocalDateTime.now();
    }

    public static LocalDateTime getLocalDateTime(ZoneId zone){
        return LocalDateTime.now(zone);
    }

    public static LocalDateTime getLocalDateTime(Clock clock){
        return LocalDateTime.now(clock);
    }

    public static LocalDateTime getLocalDateTime(String origin){
        TemporalAccessor temporalAccessor = DateTimeFormatter.ofPattern(FORMAT_DATE_TIME1).parse(origin);
        return LocalDateTime.of(temporalAccessor.get(ChronoField.YEAR),
                temporalAccessor.get(ChronoField.MONTH_OF_YEAR),
                temporalAccessor.get(ChronoField.DAY_OF_MONTH),
                temporalAccessor.get(ChronoField.HOUR_OF_DAY),
                temporalAccessor.get(ChronoField.MINUTE_OF_HOUR),
                temporalAccessor.get(ChronoField.SECOND_OF_MINUTE));
    }

    public static LocalDateTime getLocalDateTime(String origin, String format){
        TemporalAccessor temporalAccessor = DateTimeFormatter.ofPattern(format).parse(origin);
        return LocalDateTime.of(temporalAccessor.get(ChronoField.YEAR),
                temporalAccessor.get(ChronoField.MONTH_OF_YEAR),
                temporalAccessor.get(ChronoField.DAY_OF_MONTH),
                temporalAccessor.get(ChronoField.HOUR_OF_DAY),
                temporalAccessor.get(ChronoField.MINUTE_OF_HOUR),
                temporalAccessor.get(ChronoField.SECOND_OF_MINUTE));
    }

    public static LocalDate getLocalDate(String origin){
        return DateTimeFormatter.ofPattern(FORMAT_DATE1).parse(origin, TemporalQueries.localDate());
    }

    public static LocalDate getLocalDate(String origin, String format){
        return DateTimeFormatter.ofPattern(format).parse(origin, TemporalQueries.localDate());
    }

    public static LocalTime getLocalTime(String origin){
        return DateTimeFormatter.ofPattern(FORMAT_TIME1).parse(origin, TemporalQueries.localTime());
    }

    public static LocalTime getLocalTime(String origin, String format){
        return DateTimeFormatter.ofPattern(format).parse(origin, TemporalQueries.localTime());
    }

    public static String getLocalDateTimeStr(){
        return DateTimeFormatter.ofPattern(FORMAT_DATE_TIME1).format(LocalDateTime.now());
    }

    public static String getLocalDateTimeStr(LocalDateTime localDateTime){
        return DateTimeFormatter.ofPattern(FORMAT_DATE_TIME1).format(localDateTime);
    }

    public static String getLocalDateTimeStr(String format){
        return DateTimeFormatter.ofPattern(format).format(LocalDateTime.now());
    }

    public static String getLocalDateTimeStr(LocalDateTime localDateTime, String format){
        return DateTimeFormatter.ofPattern(format).format(localDateTime);
    }

    public static String getLocalDateStr(){
        return DateTimeFormatter.ofPattern(FORMAT_DATE1).format(LocalDate.now());
    }

    public static String getLocalDateStr(LocalDateTime localDateTime){
        return DateTimeFormatter.ofPattern(FORMAT_DATE1).format(localDateTime);
    }

    public static String getLocalDateStr(LocalDate localDate){
        return DateTimeFormatter.ofPattern(FORMAT_DATE1).format(localDate);
    }

    public static String getLocalDateStr(String format){
        return DateTimeFormatter.ofPattern(format).format(LocalDate.now());
    }

    public static String getLocalDateStr(LocalDate localDate, String format){
        return DateTimeFormatter.ofPattern(format).format(localDate);
    }

    public static String getLocalTimeStr(){
        return DateTimeFormatter.ofPattern(FORMAT_TIME1).format(LocalTime.now());
    }

    public static String getLocalTimeStr(LocalDateTime localDateTime){
        return DateTimeFormatter.ofPattern(FORMAT_TIME1).format(localDateTime);
    }

    public static String getLocalTimeStr(LocalTime localTime){
        return DateTimeFormatter.ofPattern(FORMAT_TIME1).format(localTime);
    }

    public static String getLocalTimeStr(String format){
        return DateTimeFormatter.ofPattern(format).format(LocalTime.now());
    }

    public static String getLocalTimeStr(LocalTime localTime, String format){
        return DateTimeFormatter.ofPattern(format).format(localTime);
    }

    public static Long toTimeStampWithCTT(LocalDateTime localDateTime){
        return localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

}

package application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.Duration;
import java.time.Instant;


public class Program {

    public static void main(String[] args){
       /**
        *                Instanciação de Data-Hora
        */

        //now() é uma função static que é utilizada para pegar o momento atual do sistema;
        //parse() é uma função static que é utilizada para converte um texto(String) que esteja escrito no padrão ISO 8601 para algum tipo de data;
        //of() e uma função static que é utilizada para instanciar uma datahora com onde informações como ano, mês, dia, horas, minutos e segundos encontravam-se separados;

        //Criou-se uma variavel que ira ser uma data-hora local (devido ao seu tipo "LocalDate" e LocalDateTime) e atribui-se o valor da data-hora local atual(do momento);
        LocalDate d01 = LocalDate.now();
        LocalDateTime d02 = LocalDateTime.now();

        //Criou-se uma variavel que ira ser uma data-hora global (devido ao seu tipo "Instant") e atribui-se o valor da data-hora global atual (do momento) armazenando a data e o horário respectivo ao fuso horário padrão que é o GMT(Fuso Horário de Londres);
        Instant d03 = Instant.now();

        // a função parse() irá receber um texto no forato ISO 8601 e irá converter para o tipo data;
        LocalDate d04 = LocalDate.parse("2022-07-20");
        LocalDateTime d05 = LocalDateTime.parse("2022-07-20T01:30:26");
        Instant d06 = Instant.parse("2022-07-20T01:30:26Z");
        //mesmo passando o fuso horário (-03:00) diferente do fuso horário padrão GMT (Z = horário de londres) se formos chamar o toString(), ou seja imprimir o objeto data-hora teremoes uma data e horário no fuso de londres;  
        Instant d07 = Instant.parse("2022-07-20T01:30:26-03:00");

        //O DateTimeFormatter é uma classe especifica para formatação de data-hora ela permitir utilizar a formatação tanto para ler datas no formato de texto customizado, quanto para exibir datas e horários comp padrões customizados;
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        LocalDate d08 = LocalDate.parse("20/07/2022", fmt1);
        LocalDateTime d09 = LocalDateTime.parse("20/07/2022 01:30", fmt2);

        LocalDate d10 = LocalDate.of(2022, 7, 20);
        LocalDateTime d11 = LocalDateTime.of(2022, 7, 30, 1, 30);

        System.out.println("d01 = " + d01);
        System.out.println("d02 = " + d02);
        System.out.println("d03 = " + d03);
        System.out.println("d03 = " + d04);
        System.out.println("d03 = " + d05);
        System.out.println("d03 = " + d06);
        System.out.println("d03 = " + d07);
        System.out.println("d03 = " + d08);
        System.out.println("d03 = " + d09);
        System.out.println("d03 = " + d10);
        System.out.println("d03 = " + d11);

        //------------------------------------------------------------------------------------
       
        /*
         *                  Formatação de Data-Hora
         */

        /**
         Por padrão o java já imprimi os objetos data-horas no formato ISO 8601
         
         Para exibir a data-hora numa forma customizada pode ser utilizado a função format();
         
         ObjetoDataHora.format(objetoFormatação);
         ou 
         ObjetoFormatação.format(ObjetDataHora);

         Exemplo:
          ObjetoFormatação = fmt3;
          ObjetoDataHora = d14;  

          DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
          
          LocalDate d14 = LocalDate.parse("2022-07-20");
          
          System.out.println("d14 = " + d14.format(fmt3));
                            ou
          System.out.println("d14 = " + d14.format(DateTimeFormatter("dd/MM/yyyy")));                  
                            ou
          System.out.println("d14 = " + fmt3.format(d14));                  

          Saída = "d14 = 20/07/2022"
        */
        LocalDate d14 = LocalDate.parse("2022-07-20");
        LocalDateTime d15 = LocalDateTime.parse("2022-07-20T01:30:26");
        Instant d16 = Instant.parse("2022-07-20T01:30:26Z");

        DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt4 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        DateTimeFormatter fmt5 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
        DateTimeFormatter fmt6 = DateTimeFormatter.ISO_DATE_TIME;
        DateTimeFormatter fmt7 = DateTimeFormatter.ISO_INSTANT;
        
        System.out.println("d14 = " + d14.format(fmt3)); 
        System.out.println("d14 = " + fmt3.format(d14));
        System.out.println("d14 = " + d14.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        System.out.println("d15 = " + d15.format(fmt3));
        System.out.println("d15 = " + d15.format(fmt4));
        System.out.println("d15 = " + d15.format(fmt6));

        System.out.println("d16 = " + fmt5.format(d16));
        System.out.println("d16 = " + fmt7.format(d16));
        System.out.println("d16 = " + d16.toString());


        //------------------------------------------------------------------------------------

        /*
         *             Operações importantes com Data-Hora
         */

        LocalDate d17 = LocalDate.parse("2022-07-20");
        LocalDateTime d18 = LocalDateTime.parse("2022-07-20T01:30:26");
        Instant d19 = Instant.parse("2022-07-20T01:30:26Z");
        
        //Convertendo data-hora global(Instant) para data-hora local(LocalDate, LocalDateTime);
        //Data-hora global, timezone(sistema local) ---> data-hora local
        //A função utilizada é a ofInstant()(ofInstant é uma função static que pode ser chamada apartir da classe LocaleDate ou LocalDateTime) que recebe a data-hora global e o timezone(ou ZoneId) para converter na data-hora local de acordo com o fuso horário(indicado pelo timezone(ou ZoneId));
        LocalDate r1 = LocalDate.ofInstant(d19, ZoneId.systemDefault());
        LocalDate r2 = LocalDate.ofInstant(d19, ZoneId.of("Portugal"));
        LocalDateTime r3 = LocalDateTime.ofInstant(d19, ZoneId.systemDefault());
        LocalDateTime r4 =LocalDateTime.ofInstant(d19, ZoneId.of("Portugal"));

        System.out.println("r1 = " + r1);
        System.out.println("r2 = " + r2);
        System.out.println("r3 = " + r3);
        System.out.println("r4 = " + r4);

        //Obter dados de uma data-hora local;
        //Data-hora local ---> dia, mês, ano e horário;

        System.out.println("d17 Dia = " + d17.getDayOfMonth());
        System.out.println("d17 Mês = " + d17.getMonthValue());
        System.out.println("d17 Ano = " + d17.getYear());

        System.out.println("d18 Hora = " + d18.getHour());
        System.out.println("d18 Minutos = " + d18.getMinute());

        //Cálculos com data-hora;

        //1. Data-hora +/- tempo ---> Data-hora;
        /*
         * Em classes como a LocalDate e LocalDateTime para realizar operções/cálculos 
         * de soma e subtração de uma data-hora com algum tempo podem ser utilizados fuções 
         * como a minus() e a plus();
         * 
         * A minus() é uma função de subtração, então ela receberá uma quantidade de tempo (e alguns casos a especificação da unidade de tempo, ou seja se é day, week, month, year, hours, entre outros) e diminuirá o valor de tempo passado da data-hora que se deseja;
         * 
         * A plus() é uma função de adição, então ela receberá uma quantidade de tempo (e alguns casos a especificação da unidade de tempo, ou seja se é day, week, month, year, hours, entre outros) e adicionará/somará o valor de tempo passado na data-hora que se deseja;
         * 
         * Funções minus(): ---> diminuir o tempo de uma data-hora (-)
         * 
         * minus(tempo/quant, ChronoUnit.unidadeDeTempo); ---> unidade de Tempo pode ser (Days, Weeks, Hours, Years, entre outros); --> LocalDate, LocalDateTime, Instant
         * 
         * minusDays(quantDays); --> LocalDate, LocalDateTime
         * minusWeek(quantWekks); --> LocalDate, LocalDateTime
         * minusMonths(quantMonths); --> LocalDate, LocalDateTime
         * minusYears(quantYears); --> LocalDate, LocalDateTime
         * minusHours(quantHours); --> LocalDateTime
         * minusSeconds(quantSeconds); --> LocalDateTime
         * minusMinutes(quantMinutes); --> LocalDateTime
         * minusNanos(quantNanos); --> LocalDateTime
         * 
         * Funções plus(): ---> adicionar o tempo de uma data-hora (+)
         * 
         * plus(tempo/quant, ChronoUnit.unidadeDeTempo);---> unidade de Tempo pode ser (Days, Weeks, Hours, Years, entre outros); --> LocalDate, LocalDateTime, Instant
         * 
         * plusDays(quantDays); --> LocalDate, LocalDateTime
         * plusWeek(quantWekks); --> LocalDate, LocalDateTime
         * plusMonths(quantMonths); --> LocalDate, LocalDateTime
         * plusYears(quantYears); --> LocalDate, LocalDateTime
         * plusHours(quantHours); --> LocalDateTime
         * plusSeconds(quantSeconds); --> LocalDateTime
         * plusMinutes(quantMinutes); --> LocalDateTime
         * plusNanos(quantNanos); --> LocalDateTime
         * 
         */

        LocalDate d20 = LocalDate.parse("2022-07-20");
        LocalDateTime d21 = LocalDateTime.parse("2022-07-20T01:30:26");
        Instant d22 = Instant.parse("2022-07-20T01:30:26Z");

        

        LocalDate pastWeekLocalDate = d20.minusDays(7);
        LocalDate nextWeekLocalDate = d20.plusDays(7);

        System.out.println("pastWeekLocalDate = " + pastWeekLocalDate);
        System.out.println("nextWeekLocalDate = " + nextWeekLocalDate);

        LocalDateTime pastWeekLocalDateTime = d21.minusDays(7);
        LocalDateTime nextWeekLocalDateTime = d21.plusDays(7);

        System.out.println("pastWeekLocalDateTime = " + pastWeekLocalDateTime);
        System.out.println("nextWeekLocalDateTime = " + nextWeekLocalDateTime);

        Instant pastWeekInstant= d22.minus(7, ChronoUnit.DAYS);
        Instant nextWeekInstant = d22.plus(7, ChronoUnit.DAYS);

        System.out.println("pastWeekInstant = " + pastWeekInstant);
        System.out.println("nextWeekInstant = " + nextWeekInstant);

        //2. Duração;
        // No Java tem uma classe específica para trabahar com duração que é a classe Duration;

        Duration t1 = Duration.between(pastWeekLocalDate.atStartOfDay(), d20.atStartOfDay());
        Duration t2 = Duration.between(pastWeekLocalDateTime, d21);
        Duration t3 = Duration.between(pastWeekInstant, d22);
        Duration t4 = Duration.between(d22, pastWeekInstant);

        System.out.println("t1 Dias = " + t1.toDays());
        System.out.println("t2 Dias = " + t2.toDays());
        System.out.println("t3 Dias = " + t3.toDays());
        System.out.println("t4 Dias = " + t4.toDays());

    }
}

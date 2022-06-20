package ru.job4j.design.srp;

import org.junit.Test;

import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ReportXMLTest {
    @Test
    public void whenXMLTest() {
        MemStore store = new MemStore();
        Calendar dateHired = new GregorianCalendar(2022, Calendar.JUNE, 19);
        Calendar dateFired = new GregorianCalendar(2022, Calendar.JUNE, 20);
        dateHired.setTimeZone(TimeZone.getTimeZone(ZoneOffset.of("+6")));
        dateFired.setTimeZone(TimeZone.getTimeZone(ZoneOffset.of("+6")));
        Employee worker = new Employee("Ivan", dateHired, dateFired, 100);
        store.add(worker);
        Report engine = new ReportXML(store);
        StringBuilder expect = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>")
                .append("\n<employees>")
                .append("\n    <employees name=\"").append(worker.getName()).append("\"")
                .append(" hired=\"")
                .append("2022-06-19T00:00:00+06:00")
                .append("\" fired=\"")
                .append("2022-06-20T00:00:00+06:00")
                .append("\" salary=\"").append(worker.getSalary())
                .append("\"/>")
                .append("\n</employees>\n");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}
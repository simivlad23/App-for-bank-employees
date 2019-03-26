package utils;

import model.Person;

import java.util.List;

public interface DataConvertorPerson {
    Object[][] accountToTableData(List<Person> accounts);

    String[] accountToTableColumnNames();
}

package utils;

import model.Account;

import java.util.List;

public interface DataConverter {
    Object[][] accountToTableData(List<Account> accounts);

    String[] accountToTableColumnNames();
}

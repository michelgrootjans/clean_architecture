package cashless.vo;

import cashless.domain.Transaction;
import cashless.domain.Account;

public class AccountMapper {
    public static Account map(AccountVO accountVO) {
        Account account = new Account();

        account.setId(accountVO.getId());
        account.setOwner(accountVO.getOwner());

        for (TransactionVO transactionVO : accountVO.getTransactions()) {
            if(transactionVO.getCredits() == 0 && transactionVO.getDescription().isEmpty()) continue;
            account.getTransactions().add(map(transactionVO));
        }

        return account;
    }

    private static Transaction map(TransactionVO transactionVO) {
        Transaction transaction = new Transaction();

        transaction.setDescription(transactionVO.getDescription());
        transaction.setCredits(transactionVO.getCredits());

        return transaction;
    }
}

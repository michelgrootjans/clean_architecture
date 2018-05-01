package hello;

public class AccountMapper {
    public static Account map(AccountVO accountVO) {
        Account account = new Account();

        account.setId(accountVO.getId());
        account.setOwner(accountVO.getOwner());

        for (TransactionVO transactionVO : accountVO.getTransactions()) {
            account.getTransactions().add(mapp(transactionVO));
        }

        return account;
    }

    private static Transaction mapp(TransactionVO transactionVO) {
        Transaction transaction = new Transaction();

        transaction.setDescription(transactionVO.getDescription());
        transaction.setCredits(transactionVO.getCredits());

        return transaction;
    }
}

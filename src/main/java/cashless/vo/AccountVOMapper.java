package cashless.vo;

import cashless.domain.Transaction;
import cashless.domain.Account;

public class AccountVOMapper {
    public static AccountVO map(Account account) {
        AccountVO vo = new AccountVO();

        vo.setId(account.getId());
        vo.setOwner(account.getOwner());
        vo.setCredits(account.getCredits());

        for (Transaction order: account.getOrders()) {
            vo.getOrders().add(map(order));
        }

        for (Transaction transaction : account.getTransactions()) {
            vo.getTransactions().add(map(transaction));
        }

        return vo;
    }

    private static AccountVO.TransactionVO map(Transaction transaction) {
        AccountVO.TransactionVO transactionVO = new AccountVO.TransactionVO();
        transactionVO.setCredits(transaction.getCredits());
        transactionVO.setDescription(transaction.getDescription());
        return transactionVO;
    }
}

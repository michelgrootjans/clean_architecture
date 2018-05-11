package cashless.vo;

import cashless.domain.Product;
import cashless.domain.Transaction;
import cashless.domain.Account;
import cashless.services.ProductService;

public class AccountMapper {
    public static Account map(AccountVO accountVO, ProductService productService) {
        Account account = new Account();

        account.setId(accountVO.getId());
        account.setOwner(accountVO.getOwner());

        for (AccountVO.TransactionVO vo : accountVO.getOrders()) {
            if(vo.getCredits() == 0 && (vo.getDescription() == null || vo.getDescription().isEmpty())) {
                if (vo.getProductId() != 0) {
                    Product product = productService.findProduct(vo.getProductId());
                    vo.setCredits(-product.getCredits());
                    vo.setDescription(product.getName());
                } else {
                    continue;
                }
            };
            account.getOrders().add(map(vo));
        }

        for (AccountVO.TransactionVO vo : accountVO.getTransactions()) {
            if(vo.getCredits() == 0 && vo.getDescription().isEmpty()) continue;
            account.getTransactions().add(map(vo));
        }

        return account;
    }

    private static Transaction map(AccountVO.TransactionVO transactionVO) {
        Transaction transaction = new Transaction();

        transaction.setDescription(transactionVO.getDescription());
        transaction.setCredits(transactionVO.getCredits());

        return transaction;
    }
}

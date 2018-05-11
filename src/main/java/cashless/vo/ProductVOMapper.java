package cashless.vo;

import cashless.domain.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductVOMapper {
    public static List<ProductVO> map(Collection<Product> products) {

        ArrayList<ProductVO> vos = new ArrayList<>();
        for (Product product : products) {
            vos.add(map(product));
        }

        return vos;
    }

    private static ProductVO map(Product product) {
        ProductVO vo = new ProductVO();
        vo.setId(product.getId());
        vo.setName(product.getName());
        vo.setCredits(product.getCredits());
        return vo;
    }
}

package bestcommerce.test.modules.Products;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsDao extends JpaRepository<Products, Long> {
    @Query(value = """
                select
                p.*
            from
                products p
            left join categories c on
                c.id = p.category_id
            left join stores s on
                s.id = p.store_id
            where
                (s.customer_id = ?1
                or c.customer_id = ?1) and p.actived is true
            group by
                p.id
                    """, nativeQuery = true)
    List<Products> findAllByCustomer(Long customerId);

    @Query(value = """
                select
                p.*
            from
                products p
            left join categories c on
                c.id = p.category_id
            left join stores s on
                s.id = p.store_id
            where
                (s.customer_id = ?1
                    or c.customer_id = ?1)
                and p.actived is true
                and p.category_id = ?2
            group by
                p.id
                            """, nativeQuery = true)
    List<Products> findAllByCategory(Long OwnerId, Long CategoryId);

    @Modifying
    @Query(value = """
                update
                products
            set
                actived = false
            where
                id = ?1
                    """, nativeQuery = true)
    int removeById(Long ProductId);
}

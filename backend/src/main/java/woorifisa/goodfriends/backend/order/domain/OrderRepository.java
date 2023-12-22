package woorifisa.goodfriends.backend.order.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import woorifisa.goodfriends.backend.order.exception.NotFoundOrderException;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {

    Order findByProductIdAndUserId(final Long productId, final Long userId);

    @Query("SELECT o FROM Order o " +
            "JOIN FETCH User u " +
            "ON o.user.id = u.id " +
            "AND o.product.id = :productId")
    List<Order> findOrdersAndUserByProductId(@Param("productId") final Long productId);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Order o " +
            "SET o.confirmStatus = :confirmStatus " +
            "WHERE o.id = :orderId")
    void updateConfirmStatus(@Param("orderId") final Long orderId, @Param("confirmStatus") final ConfirmStatus confirmStatus);

    default Order getById(final Long orderId) {
        return findById(orderId).orElseThrow(NotFoundOrderException::new);
    }

    @Query("SELECT o FROM Order o " +
            "JOIN FETCH Product p " +
            "ON o.product.id = p.id " +
            "AND o.user.id = :userId")
    List<Order> findOrdersAndProductByUserId(@Param("userId") final Long userId);

    @Query("SELECT o FROM Order o " +
            "JOIN FETCH Product p " +
            "ON o.product.id = p.id " +
            "AND o.user.id = :userId " +
            "AND o.confirmStatus = :confirmStatus")
    List<Order> findOrdersAndProductByUserIdAndConfirmStatus(@Param("userId")final Long userId, @Param("confirmStatus")final ConfirmStatus confirmStatus);

    @Query("SELECT count(o) " +
            "FROM Order o " +
            "WHERE o.confirmStatus = :confirmStatus " +
            "AND o.user.id = :userId")
    Long findCountByConfirmStatusAndUserId(@Param("confirmStatus") final ConfirmStatus confirmStatus, @Param("userId") final Long userId);

    @Query("SELECT o " +
            "FROM Order o " +
            "WHERE o.product.id = :productId " +
            "AND o.confirmStatus = :confirmStatus")
    Order findByProductIdAndConfirmStatus(@Param("productId") final Long productId, @Param("confirmStatus") final ConfirmStatus confirmStatus);
}

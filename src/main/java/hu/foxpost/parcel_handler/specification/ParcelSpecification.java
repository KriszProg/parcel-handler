package hu.foxpost.parcel_handler.specification;

import hu.foxpost.parcel_handler.entity.Parcel;
import org.springframework.data.jpa.domain.Specification;

public class ParcelSpecification {

    public static Specification<Parcel> hasSenderId(Integer senderId) {
        return (root, query, criteriaBuilder) -> {
            if (senderId == null) {
                return null;
            }
            return criteriaBuilder.equal(root.get("sender").get("id"), senderId);
        };
    }

    public static Specification<Parcel> hasReceiverId(Integer receiverId) {
        return (root, query, criteriaBuilder) -> {
            if (receiverId == null) {
                return null;
            }
            return criteriaBuilder.equal(root.get("receiver").get("id"), receiverId);
        };
    }

}

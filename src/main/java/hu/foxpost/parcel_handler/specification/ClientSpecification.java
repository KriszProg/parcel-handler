package hu.foxpost.parcel_handler.specification;

import hu.foxpost.parcel_handler.entity.Client;
import org.springframework.data.jpa.domain.Specification;

public class ClientSpecification {

    public static Specification<Client> hasNameLike(String clientName) {
        return (root, query, criteriaBuilder) -> {
            if (clientName == null) {
                return null;
            }
            return criteriaBuilder.like(root.get("clientName"), "%" + clientName + "%");
        };
    }

    public static Specification<Client> hasAddressLike(String address) {
        return (root, query, criteriaBuilder) -> {
            if (address == null) {
                return null;
            }
            return criteriaBuilder.like(root.get("address"), "%" + address + "%");
        };
    }

    public static Specification<Client> hasZipCode(String zipCode) {
        return (root, query, criteriaBuilder) -> {
            if (zipCode == null) {
                return null;
            }
            return criteriaBuilder.equal(root.get("zipCode"), zipCode);
        };
    }

    public static Specification<Client> hasCity(String city) {
        return (root, query, criteriaBuilder) -> {
            if (city == null) {
                return null;
            }
            return criteriaBuilder.equal(root.get("city"), city);
        };
    }

    public static Specification<Client> hasPhone(String phone) {
        return (root, query, criteriaBuilder) -> {
            if (phone == null) {
                return null;
            }
            return criteriaBuilder.equal(root.get("phone"), phone);
        };
    }

    public static Specification<Client> hasEmailLike(String email) {
        return (root, query, criteriaBuilder) -> {
            if (email == null) {
                return null;
            }
            return criteriaBuilder.like(root.get("email"), "%" + email + "%");
        };
    }

}

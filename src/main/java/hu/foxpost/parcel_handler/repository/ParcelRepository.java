package hu.foxpost.parcel_handler.repository;

import hu.foxpost.parcel_handler.dto.ParcelBaseDto;
import hu.foxpost.parcel_handler.entity.Parcel;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ParcelRepository extends JpaRepository<Parcel, Integer>, JpaSpecificationExecutor<Parcel> {

    @EntityGraph(attributePaths = { "sender", "receiver" })
    List<Parcel> findAll(Specification<Parcel> spec);

    @EntityGraph(attributePaths = { "sender", "receiver" })
    List<Parcel> findAll();

    @EntityGraph(attributePaths = { "sender", "receiver" })
    Optional<Parcel> findByParcelNo(String parcelNo);

    @Query("""
            SELECT new hu.foxpost.parcel_handler.dto.ParcelBaseDto(
            p.id, p.parcelNo)
            FROM Parcel p
            WHERE p.parcelNo = :parcelNo
            """)
    Optional<ParcelBaseDto> findParcelBaseByParcelNo(@Param("parcelNo") String parcelNo);

    @EntityGraph(attributePaths = { "sender", "receiver" })
    @Query("""
            SELECT p FROM Parcel p
            WHERE p.sender.id = :senderId
            """)
    List<Parcel> findAllParcelsBySenderId(@Param("senderId") Integer senderId);

    @EntityGraph(attributePaths = { "sender", "receiver" })
    @Query("""
            SELECT p FROM Parcel p
            WHERE p.receiver.id = :receiverId
            """)
    List<Parcel> findAllParcelsByReceiverId(@Param("receiverId") Integer receiverId);

}

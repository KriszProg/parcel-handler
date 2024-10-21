package hu.foxpost.parcel_handler.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "parcels")
@Getter
public class Parcel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private Client sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id", nullable = false)
    private Client receiver;

    @Column(name = "parcel_no", nullable = false)
    private String parcelNo;

    @Override
    public String toString() {
        return "Parcel{" +
                "id=" + id +
                ", sender=" + sender +
                ", receiver=" + receiver +
                ", parcelNo='" + parcelNo + '\'' +
                '}';
    }

}

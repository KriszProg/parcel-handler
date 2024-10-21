package hu.foxpost.parcel_handler.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ParcelsByReceiverDto {

    private ClientDto receiver;
    private List<ParcelBaseDto> parcels;

    public ParcelsByReceiverDto receiver(ClientDto receiver) {
        this.receiver = receiver;
        return this;
    }

    public ParcelsByReceiverDto parcels(List<ParcelBaseDto> parcels) {
        this.parcels = parcels;
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ParcelsByReceiverDto that = (ParcelsByReceiverDto) object;
        return Objects.equals(receiver, that.receiver)
                && Objects.equals(parcels, that.parcels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(receiver, parcels);
    }

    @Override
    public String toString() {
        return "ParcelsByReceiverDto{" +
                "receiver=" + receiver +
                ", parcels=" + parcels +
                '}';
    }

}

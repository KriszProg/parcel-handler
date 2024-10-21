package hu.foxpost.parcel_handler.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ParcelsBySenderDto {

    private ClientDto sender;
    private List<ParcelBaseDto> parcels;

    public ParcelsBySenderDto sender(ClientDto sender) {
        this.sender = sender;
        return this;
    }

    public ParcelsBySenderDto parcels(List<ParcelBaseDto> parcels) {
        this.parcels = parcels;
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ParcelsBySenderDto that = (ParcelsBySenderDto) object;
        return Objects.equals(sender, that.sender)
                && Objects.equals(parcels, that.parcels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sender, parcels);
    }

    @Override
    public String toString() {
        return "ParcelsBySenderDto{" +
                "sender=" + sender +
                ", parcels=" + parcels +
                '}';
    }

}

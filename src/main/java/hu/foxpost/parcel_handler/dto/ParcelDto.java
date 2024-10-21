package hu.foxpost.parcel_handler.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ParcelDto {

    private int id;
    private String parcelNo;
    private ClientDto sender;
    private ClientDto receiver;

    public ParcelDto id(int id) {
        this.id = id;
        return this;
    }

    public ParcelDto parcelNo(String parcelNo) {
        this.parcelNo = parcelNo;
        return this;
    }

    public ParcelDto sender(ClientDto sender) {
        this.sender = sender;
        return this;
    }

    public ParcelDto receiver(ClientDto receiver) {
        this.receiver = receiver;
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ParcelDto parcelDto = (ParcelDto) object;
        return id == parcelDto.id
                && Objects.equals(parcelNo, parcelDto.parcelNo)
                && Objects.equals(sender, parcelDto.sender)
                && Objects.equals(receiver, parcelDto.receiver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, parcelNo, sender, receiver);
    }

    @Override
    public String toString() {
        return "ParcelDto{" +
                "id=" + id +
                ", parcelNo='" + parcelNo + '\'' +
                ", sender=" + sender +
                ", receiver=" + receiver +
                '}';
    }

}

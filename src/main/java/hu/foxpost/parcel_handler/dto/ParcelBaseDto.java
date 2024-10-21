package hu.foxpost.parcel_handler.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ParcelBaseDto {

    private int id;
    private String parcelNo;

    public ParcelBaseDto id(int id) {
        this.id = id;
        return this;
    }

    public ParcelBaseDto parcelNo(String parcelNo) {
        this.parcelNo = parcelNo;
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ParcelBaseDto that = (ParcelBaseDto) object;
        return id == that.id
                && Objects.equals(parcelNo, that.parcelNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, parcelNo);
    }

    @Override
    public String toString() {
        return "ParcelBaseDto{" +
                "id=" + id +
                ", parcelNo='" + parcelNo + '\'' +
                '}';
    }

}

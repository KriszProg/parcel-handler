package hu.foxpost.parcel_handler.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {

    private int id;
    private String clientName;
    private String address;
    private String zipCode;
    private String city;
    private String phone;
    private String email;


    public ClientDto id(int id) {
        this.id = id;
        return this;
    }

    public ClientDto clientName(String clientName) {
        this.clientName = clientName;
        return this;
    }

    public ClientDto address(String address) {
        this.address = address;
        return this;
    }

    public ClientDto zipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public ClientDto city(String city) {
        this.city = city;
        return this;
    }

    public ClientDto phone(String phone) {
        this.phone = phone;
        return this;
    }

    public ClientDto email(String email) {
        this.email = email;
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ClientDto clientDto = (ClientDto) object;
        return id == clientDto.id
                && Objects.equals(clientName, clientDto.clientName)
                && Objects.equals(address, clientDto.address)
                && Objects.equals(zipCode, clientDto.zipCode)
                && Objects.equals(city, clientDto.city)
                && Objects.equals(phone, clientDto.phone)
                && Objects.equals(email, clientDto.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientName, address, zipCode, city, phone, email);
    }

    @Override
    public String toString() {
        return "ClientDto{" +
                "id=" + id +
                ", clientName='" + clientName + '\'' +
                ", address='" + address + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}

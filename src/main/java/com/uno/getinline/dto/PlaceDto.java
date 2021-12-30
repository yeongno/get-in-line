package com.uno.getinline.dto;

import com.uno.getinline.constant.PlaceType;
import com.uno.getinline.domain.Place;

import java.time.LocalDateTime;
import java.util.Objects;

public final class PlaceDto {
    private final Long id;
    private final PlaceType placeType;
    private final String placeName;
    private final String address;
    private final String phoneNumber;
    private final Integer capacity;
    private final String memo;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public PlaceDto(
            Long id,
            PlaceType placeType,
            String placeName,
            String address,
            String phoneNumber,
            Integer capacity,
            String memo,
            LocalDateTime createdAt,
            LocalDateTime modifiedAt
    ) {
        this.id = id;
        this.placeType = placeType;
        this.placeName = placeName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.capacity = capacity;
        this.memo = memo;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public static PlaceDto idOnly(Long id) {
        return PlaceDto.of(id, null, null, null, null, null, null, null, null);
    }

    public static PlaceDto of(
            Long id,
            PlaceType placeType,
            String placeName,
            String address,
            String phoneNumber,
            Integer capacity,
            String memo,
            LocalDateTime createdAt,
            LocalDateTime modifiedAt
    ) {
        return new PlaceDto(id, placeType, placeName, address, phoneNumber, capacity, memo, createdAt, modifiedAt);
    }

    public static PlaceDto of(Place place) {
        return new PlaceDto(
                place.getId(),
                place.getPlaceType(),
                place.getPlaceName(),
                place.getAddress(),
                place.getPhoneNumber(),
                place.getCapacity(),
                place.getMemo(),
                place.getCreatedAt(),
                place.getModifiedAt()
        );
    }

    public Place toEntity() {
        return Place.of(placeType, placeName, address, phoneNumber, capacity, memo);
    }

    public Place updateEntity(Place place) {
        if (placeType != null) {
            place.setPlaceType(placeType);
        }
        if (placeName != null) {
            place.setPlaceName(placeName);
        }
        if (address != null) {
            place.setAddress(address);
        }
        if (phoneNumber != null) {
            place.setPhoneNumber(phoneNumber);
        }
        if (capacity != null) {
            place.setCapacity(capacity);
        }
        if (memo != null) {
            place.setMemo(memo);
        }

        return place;
    }

    public Long id() {
        return id;
    }

    public PlaceType placeType() {
        return placeType;
    }

    public String placeName() {
        return placeName;
    }

    public String address() {
        return address;
    }

    public String phoneNumber() {
        return phoneNumber;
    }

    public Integer capacity() {
        return capacity;
    }

    public String memo() {
        return memo;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }

    public LocalDateTime modifiedAt() {
        return modifiedAt;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (PlaceDto) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.placeType, that.placeType) &&
                Objects.equals(this.placeName, that.placeName) &&
                Objects.equals(this.address, that.address) &&
                Objects.equals(this.phoneNumber, that.phoneNumber) &&
                Objects.equals(this.capacity, that.capacity) &&
                Objects.equals(this.memo, that.memo) &&
                Objects.equals(this.createdAt, that.createdAt) &&
                Objects.equals(this.modifiedAt, that.modifiedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, placeType, placeName, address, phoneNumber, capacity, memo, createdAt, modifiedAt);
    }

    @Override
    public String toString() {
        return "PlaceDto[" +
                "id=" + id + ", " +
                "placeType=" + placeType + ", " +
                "placeName=" + placeName + ", " +
                "address=" + address + ", " +
                "phoneNumber=" + phoneNumber + ", " +
                "capacity=" + capacity + ", " +
                "memo=" + memo + ", " +
                "createdAt=" + createdAt + ", " +
                "modifiedAt=" + modifiedAt + ']';
    }


}

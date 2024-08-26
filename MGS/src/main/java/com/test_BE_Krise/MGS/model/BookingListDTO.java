package com.test_BE_Krise.MGS.model;

import java.time.OffsetDateTime;
import java.util.Set;

public class BookingListDTO {

    private OffsetDateTime bookingDate;
    private String officeName;
    private OffsetDateTime startTime;
    private OffsetDateTime endTime;
    private Set<ConsumptionDTO> listConsumption;
    private int participants;
    private String roomName;
    private Long id;

    public BookingListDTO(OffsetDateTime bookingDate, String officeName, OffsetDateTime startTime, OffsetDateTime endTime, Set<ConsumptionDTO> listConsumption, int participants, String roomName, Long id){
        this.bookingDate = bookingDate;
        this.officeName = officeName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.listConsumption = listConsumption;
        this.participants = participants;
        this.roomName = roomName;
        this.id = id;
    }

    // Getter dan Setter


    public OffsetDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(OffsetDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public OffsetDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(OffsetDateTime startTime) {
        this.startTime = startTime;
    }

    public OffsetDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(OffsetDateTime endTime) {
        this.endTime = endTime;
    }


    public Set<ConsumptionDTO> getListConsumption() {
        return listConsumption;
    }

    public void setListConsumption(Set<ConsumptionDTO> listConsumption) {
        this.listConsumption = listConsumption;
    }
    
    public int getParticipants() {
        return participants;
    }

    public void setParticipants(int participants) {
        this.participants = participants;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
       this.id =id;
    }
}

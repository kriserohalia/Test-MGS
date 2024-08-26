package com.test_BE_Krise.MGS.service;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test_BE_Krise.MGS.entity.BookingList;
import com.test_BE_Krise.MGS.entity.Consumption;
import com.test_BE_Krise.MGS.repository.BookingListRepository;
import com.test_BE_Krise.MGS.repository.ConsumptionRepository;

@Service
public class BookingListService {

    @Autowired
    private BookingListRepository bookingListRepository;

    @Autowired
    private ConsumptionRepository consumptionRepository;


    public BookingList createBooking(BookingList bookingList){
        Set<Consumption> consumption = determineConsumptions(bookingList.getBookingDate(),bookingList.getStartTime(),bookingList.getEndTime());
        bookingList.setListConsumption(consumption);
        return bookingListRepository.save(bookingList);
    }

    private Set<Consumption> determineConsumptions( OffsetDateTime bookingDate, OffsetDateTime startTime, OffsetDateTime endTime){

        if(Duration.between(bookingDate, startTime).toHours()< 1){
            throw new IllegalArgumentException("Booking date must be at least 1 hour before start time meeting");
        }

        Set<Consumption> consumptions = new HashSet<>();

        List<Consumption> allConsumptions = consumptionRepository.findAll();

        if (startTime.getHour() < 11) {
            consumptions.add(findConsumptionByName("Snack Siang", allConsumptions));
            if (endTime.getHour() >= 11 && endTime.getHour() < 14) {
                consumptions.add(findConsumptionByName("Makan Siang", allConsumptions));
            }
            if (endTime.getHour() >= 14) {
                consumptions.add(findConsumptionByName("Makan Siang", allConsumptions));
                consumptions.add(findConsumptionByName("Snack Sore", allConsumptions));
            }
        } else if (startTime.getHour() >= 11 && startTime.getHour() < 14) {
            consumptions.add(findConsumptionByName("Makan Siang", allConsumptions));
            if (endTime.getHour() >= 14) {
                consumptions.add(findConsumptionByName("Snack Sore", allConsumptions));
            }
        } else if (startTime.getHour() >= 14) {
            consumptions.add(findConsumptionByName("Snack Sore", allConsumptions));
        }

        return consumptions;
    }

    public Consumption findConsumptionByName(String name, List<Consumption> allConsumptions) {
        return allConsumptions.stream()
            .filter(c -> c.getName().equalsIgnoreCase(name))
            .findFirst()
            .orElse(null);
    }

    public List<BookingList> getAllBookingLists(){
        return bookingListRepository.findAll();
    }

     
    
}

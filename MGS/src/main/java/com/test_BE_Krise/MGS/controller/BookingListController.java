package com.test_BE_Krise.MGS.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test_BE_Krise.MGS.entity.BookingList;
import com.test_BE_Krise.MGS.model.BookingListDTO;
import com.test_BE_Krise.MGS.model.ConsumptionDTO;
import com.test_BE_Krise.MGS.service.BookingListService;

@RestController
@RequestMapping("/booking-lists")
public class BookingListController {

    @Autowired
    private BookingListService bookingListService;


    @PostMapping
    public BookingList createBooking(@RequestBody BookingList bookingList){
        return bookingListService.createBooking(bookingList);
    }


    @GetMapping
    public ResponseEntity<List<BookingListDTO>> getAllBookingLists() {
        try {
            List<BookingList> bookingLists = bookingListService.getAllBookingLists();

            List<BookingListDTO> dtoList = bookingLists.stream()
                .map(bookingList -> new BookingListDTO(
                    bookingList.getBookingDate(),
                    bookingList.getOfficeName(),
                    bookingList.getStartTime(),
                    bookingList.getEndTime(),
                    bookingList.getListConsumption().stream()
                        .map(consumption -> new ConsumptionDTO(consumption.getName()))
                        .collect(Collectors.toSet()),
                    bookingList.getParticipants(),
                    bookingList.getRoomName(),
                    bookingList.getId()
                ))
                .collect(Collectors.toList());

            return new ResponseEntity<>(dtoList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

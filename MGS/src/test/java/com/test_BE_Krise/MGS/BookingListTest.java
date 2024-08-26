package com.test_BE_Krise.MGS;



import com.test_BE_Krise.MGS.controller.BookingListController;
import com.test_BE_Krise.MGS.entity.BookingList;
import com.test_BE_Krise.MGS.entity.Consumption;
import com.test_BE_Krise.MGS.model.BookingListDTO;
import com.test_BE_Krise.MGS.model.ConsumptionDTO;
import com.test_BE_Krise.MGS.repository.BookingListRepository;
import com.test_BE_Krise.MGS.service.BookingListService;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class BookingListTest {

    @InjectMocks
    private BookingListController bookingListController;

    @Mock
    private BookingListService bookingListService;

    @Mock
    private BookingListRepository bookingListRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllBookingLists() {
        // Arrange
        Set<ConsumptionDTO> consumptionDTOs = new HashSet<>();
        consumptionDTOs.add(new ConsumptionDTO("Snack Siang"));
        consumptionDTOs.add(new ConsumptionDTO("Makan Siang"));
        consumptionDTOs.add(new ConsumptionDTO("Snack Sore"));

        BookingList bookingList1 = new BookingList();
        BookingList bookingList2 = new BookingList();
        List<BookingList> bookingLists = Arrays.asList(bookingList1, bookingList2);
        
        when(bookingListService.getAllBookingLists()).thenReturn(bookingLists);

        // Act
        ResponseEntity<List<BookingListDTO>> response = bookingListController.getAllBookingLists();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());

        BookingListDTO dto1 = response.getBody().get(0);
        assertEquals(bookingList1.getId(), dto1.getId());
        assertEquals(bookingList1.getOfficeName(), dto1.getOfficeName());
        assertEquals(bookingList1.getParticipants(), dto1.getParticipants());
        assertEquals(bookingList1.getRoomName(), dto1.getRoomName());

        BookingListDTO dto2 = response.getBody().get(1);
        assertEquals(bookingList2.getId(), dto2.getId());
        assertEquals(bookingList2.getOfficeName(), dto2.getOfficeName());
        assertEquals(bookingList2.getParticipants(), dto2.getParticipants());
        assertEquals(bookingList2.getRoomName(), dto2.getRoomName());
    }
}

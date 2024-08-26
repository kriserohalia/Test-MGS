package com.test_BE_Krise.MGS;


import com.test_BE_Krise.MGS.entity.Consumption;
import com.test_BE_Krise.MGS.repository.ConsumptionRepository;
import com.test_BE_Krise.MGS.service.ConsumptionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ConsumptionTest {

    @InjectMocks
    private ConsumptionService consumptionService;

    @Mock
    private ConsumptionRepository consumptionRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
public void testCreateConsumption_Success() {
    // Arrange
    Consumption consumption = new Consumption(null, 30000L, "Snack Pagi", OffsetDateTime.now());
    Consumption savedConsumption = new Consumption(1L, 30000L, "Snack Pagi", OffsetDateTime.now());

    when(consumptionRepository.save(consumption)).thenReturn(savedConsumption);

    // Act
    Consumption result = consumptionService.createConsumption(consumption);

    // Assert
    assertEquals(savedConsumption.getId(), result.getId());
    assertEquals(savedConsumption.getMaxPrice(), result.getMaxPrice());
    assertEquals(savedConsumption.getName(), result.getName());
    verify(consumptionRepository, times(1)).save(consumption);
}

@Test
    public void testGetAllConsumptions_Success() {
        // Arrange
        List<Consumption> consumptions = Arrays.asList(
            new Consumption(1L, 20000L, "Snack Pagi", OffsetDateTime.now()),
            new Consumption(2L, 30000L, "Makan Siang", OffsetDateTime.now()),
            new Consumption(3L, 15000L, "Snack Sore", OffsetDateTime.now())
        );

        when(consumptionRepository.findAll()).thenReturn(consumptions);

        // Act
        List<Consumption> result = consumptionService.getAllConsumptions();

        // Assert
        assertEquals(3, result.size());
        assertEquals("Snack Pagi", result.get(0).getName());
        assertEquals("Makan Siang", result.get(1).getName());
        assertEquals("Snack Sore", result.get(2).getName());
        verify(consumptionRepository, times(1)).findAll();
    }


}

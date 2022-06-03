package com.example.demo.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FlightsAndTotalCostDto {
        private String departureGate;
        private Long totalCost;
}

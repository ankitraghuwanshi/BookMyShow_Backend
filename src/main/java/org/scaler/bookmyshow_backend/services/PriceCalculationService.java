package org.scaler.bookmyshow_backend.services;

import org.scaler.bookmyshow_backend.models.Show;
import org.scaler.bookmyshow_backend.models.ShowSeat;
import org.scaler.bookmyshow_backend.models.ShowSeatType;
import org.scaler.bookmyshow_backend.repositories.ShowSeatRepository;
import org.scaler.bookmyshow_backend.repositories.ShowSeatTypeRepository;

import java.util.List;

public class PriceCalculationService {
    private ShowSeatTypeRepository showSeatTypeRepository;

    public PriceCalculationService(ShowSeatRepository showSeatRepository) {
        this.showSeatTypeRepository=showSeatTypeRepository;
    }

    int amount=0;
    public int calculatePrice(List<ShowSeat> showSeats){
        Show show = showSeats.get(0).getShow();
        List<ShowSeatType> showSeatTypes=showSeatTypeRepository.findAllByShow(show);

        for(ShowSeat showSeat:showSeats){
            for(ShowSeatType showSeatType:showSeatTypes){
                if(showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())){
                    amount += showSeatType.getPrice();
                    break;
                }
            }
        }
        return amount;
    }
}

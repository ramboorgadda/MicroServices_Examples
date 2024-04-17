package com.eazybites.cards.mapper;

import com.eazybites.cards.dto.CardsDto;
import com.eazybites.cards.entity.Cards;

public class CardsMapper {

    public static CardsDto mapToCardsDto(Cards cards,CardsDto cardsDto){

        cardsDto.setCardNumber(cards.getCardNumber());
        cardsDto.setCardType(cards.getCardType());
        cardsDto.setMobileNumber(cards.getMobileNumber());
        cardsDto.setTotalLimit(cards.getTotalLimit());
        cardsDto.setAmountUsed(cards.getAmountUsed());
        cardsDto.setAvailableAmount(cards.getAvailableAmount());
        return cardsDto;
    }

    public static Cards mapToCards(Cards cards,CardsDto cardsDto){

       cards.setCardType(cardsDto.getCardType());
       cards.setCardNumber(cardsDto.getCardNumber());
       cards.setAmountUsed(cardsDto.getAmountUsed());
       cards.setMobileNumber(cardsDto.getMobileNumber());
       cards.setTotalLimit(cardsDto.getTotalLimit());
       cards.setAvailableAmount(cardsDto.getAvailableAmount());
        return cards;
    }
}

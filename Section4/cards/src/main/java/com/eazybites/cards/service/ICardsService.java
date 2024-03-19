package com.eazybites.cards.service;

import com.eazybites.cards.dto.CardsDto;

public interface ICardsService {

    void createCard(String mobileNumber);
    CardsDto fetchCard(String mobileNumber);
    boolean updateCard(CardsDto cardsDto);
    boolean deleteCard(String mobileNumber);
}

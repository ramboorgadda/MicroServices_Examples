package com.eazybites.cards.service.impl;

import com.eazybites.cards.constants.CardsConstants;
import com.eazybites.cards.dto.CardsDto;
import com.eazybites.cards.entity.Cards;
import com.eazybites.cards.exception.CardAlreadyExistsException;
import com.eazybites.cards.exception.ResourceNotFoundException;
import com.eazybites.cards.mapper.CardsMapper;
import com.eazybites.cards.repository.CardRepository;
import com.eazybites.cards.service.ICardsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class CardServiceImpl implements ICardsService {

    private  CardRepository cardRepository;
    @Override
    public void createCard(String mobileNumber) {
        Optional<Cards> OptionalCards=cardRepository.findByMobileNumber(mobileNumber);
        if(OptionalCards.isPresent()){
            throw new CardAlreadyExistsException("Card has already registered with given mobile: "+mobileNumber);
        }
        else {
            cardRepository.save(createNewCard(mobileNumber));
        }

    }

    private Cards createNewCard(String mobileNumber) {
        Cards cards = new Cards();
        long randomNumber = 100000000000L+ new Random().nextInt(1000);
        cards.setCardNumber(Long.toString(randomNumber));
        cards.setCardType(CardsConstants.CREDIT_CARD);
        cards.setMobileNumber(mobileNumber);
        cards.setAvailableAmount(CardsConstants.NEW_CARD_LIMIT);
        cards.setTotalLimit(CardsConstants.NEW_CARD_LIMIT);
        cards.setAmountUsed(0);
//        cards.setCreatedBy("CARDS_MS");
//        cards.setCreatedAt(LocalDateTime.now());
//        cards.setUpdatedAt(LocalDateTime.now());
//        cards.setUpdatedBy("CARDS_MS");
        return  cards;
    }

    @Override
    public CardsDto fetchCard(String mobileNumber) {
        Cards cards=cardRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("card","mobileNumber",mobileNumber)
        );
        return CardsMapper.mapToCardsDto(cards,new CardsDto());
    }

    @Override
    public boolean updateCard(CardsDto cardsDto) {
       Cards cards= cardRepository.findByCardNumber(cardsDto.getCardNumber()).orElseThrow(
                () -> new ResourceNotFoundException("card","cardNumber",cardsDto.getCardNumber())
        );
        CardsMapper.mapToCards(cards,cardsDto);
        cardRepository.save(cards);
        return true;
    }

    @Override
    public boolean deleteCard(String mobileNumber) {
        Cards cards= cardRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Card","mobileNumber",mobileNumber)
        );
        cardRepository.deleteById(cards.getCardId());
        return true;
    }
}

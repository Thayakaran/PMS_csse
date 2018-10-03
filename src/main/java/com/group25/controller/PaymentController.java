package com.group25.controller;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.group25.entity.Payment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pay")
public class PaymentController {

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> sendPaymentDetails(@RequestBody Payment paymentDetails){

        if (paymentDetails.getAmount() == null || paymentDetails.getCardholerName() == null || paymentDetails.getCardholerName() == "" || paymentDetails.getCardNo() == null || paymentDetails.getCardNo() == "" || paymentDetails.getCvv() == null || paymentDetails.getCvv() == "" || paymentDetails.getExpDate() == null || paymentDetails.getExpDate() == "") {

            return new ResponseEntity<>("Enter all the card details", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

        } else {

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String paymentString = gson.toJson(paymentDetails);
            System.out.println(paymentString);

            return new ResponseEntity<>("Payment Successful", new HttpHeaders(), HttpStatus.OK);

        }

    }
}


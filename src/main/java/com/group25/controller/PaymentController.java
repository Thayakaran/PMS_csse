package com.group25.controller;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.group25.entity.Payment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pay")
public class PaymentController {

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void sendPaymentDetails(@RequestBody Payment paymentDetails){

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String paymentString = gson.toJson(paymentDetails);

        System.out.println(paymentString);

    }
}

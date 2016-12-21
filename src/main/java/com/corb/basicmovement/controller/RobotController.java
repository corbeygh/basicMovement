package com.corb.basicmovement.controller;

import com.pi4j.io.gpio.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Calvin on 14/12/2016.
 */
@RestController
public class RobotController {

    private static GpioPinDigitalOutput frontLeft;
    private static GpioPinDigitalOutput frontRight;
    private static GpioPinDigitalOutput backLeft;
    private static GpioPinDigitalOutput backRight;

    @RequestMapping("/")
    public String greeting(){
        return "Robot is Online";
    }

    @RequestMapping("/frontLeft")
    public String frontLeft() {
        initPins();

        frontLeft.high();
        frontRight.low();
        backLeft.low();
        backRight.low();

        return "Moving frontLeft.";
    }

    @RequestMapping("/frontRight")
    public String frontRight() {
        initPins();

        frontLeft.low();
        frontRight.high();
        backLeft.low();
        backRight.low();

        return "Moving frontRight.";
    }

    @RequestMapping("/backLeft")
    public String backLeft() {
        initPins();

        frontLeft.low();
        frontRight.low();
        backLeft.high();
        backRight.low();

        return "Moving backLeft.";
    }

    @RequestMapping("/backRight")
    public String backRight() {
        initPins();

        frontLeft.low();
        frontRight.low();
        backLeft.low();
        backRight.high();

        return "Moving backRight.";
    }

    @RequestMapping("/forward")
    public String forward() {
        initPins();

        frontLeft.high();
        frontRight.high();
        backLeft.low();
        backRight.low();

        return "Moving Forward.";
    }

    @RequestMapping("/stop")
    public String stop() {
        initPins();

        frontLeft.low();
        frontRight.low();
        backLeft.low();
        backRight.low();

        return "Moving Forward.";
    }


    private void initPins(){
        if(frontLeft == null){
            GpioController gpio = GpioFactory.getInstance();
            frontLeft = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "frontLeft", PinState.LOW);
        }
        if(frontRight == null){
            GpioController gpio = GpioFactory.getInstance();
            frontRight = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "frontRight", PinState.LOW);
        }
        if(backLeft == null){
            GpioController gpio = GpioFactory.getInstance();
            backLeft = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "backLeft", PinState.LOW);
        }
        //---
        if(backRight == null){
            GpioController gpio = GpioFactory.getInstance();
            backRight = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "backRight", PinState.LOW);
        }
    }
}

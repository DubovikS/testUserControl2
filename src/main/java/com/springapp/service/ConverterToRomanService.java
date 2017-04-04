package com.springapp.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ConverterToRomanService {

    private Map<Integer, String> dump;

    public ConverterToRomanService() {
        dump = new HashMap<Integer, String>();
        dump.put(0,"");
        dump.put(1,"I");
        dump.put(2,"II");
        dump.put(3,"III");
        dump.put(4,"IV");
        dump.put(5,"V");
        dump.put(6,"VI");
        dump.put(7,"VII");
        dump.put(8,"VIII");
        dump.put(9,"IX");
        dump.put(10,"X");
        dump.put(20,"XX");
        dump.put(30,"XXX");
        dump.put(40,"XL");
        dump.put(50,"L");
        dump.put(60,"LX");
        dump.put(70,"LXX");
        dump.put(80,"LXXX");
        dump.put(90,"XC");
        dump.put(100,"C");
        dump.put(200,"CC");
        dump.put(300,"CCC");
        dump.put(400,"CD");
        dump.put(500,"D");
        dump.put(600,"DC");
        dump.put(700,"DCC");
        dump.put(800,"DCCC");
        dump.put(900,"CM");
        dump.put(1000,"M");
        dump.put(2000,"MM");
        dump.put(3000,"MMM");
    }

    public String ConvertToArabic(int arabicNumber){
        String result = "";
        int multiplier = 1;
        while(arabicNumber > 0){
            int module = arabicNumber % 10;
            result = "" + dump.get(module*multiplier) + result;
            arabicNumber = arabicNumber / 10;
            multiplier = multiplier*10;
        }


        return result;
    }
}

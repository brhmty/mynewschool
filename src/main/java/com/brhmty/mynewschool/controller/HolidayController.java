package com.brhmty.mynewschool.controller;

import com.brhmty.mynewschool.model.Holiday;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HolidayController {

    @GetMapping("/holidays")
    public String displayHolidays(Model model){
        List<Holiday> holidayList = Arrays.asList(
                new Holiday("Jan 1", "New year's Day", Holiday.Type.FESTIVAL),
                new Holiday("OCT 31", "Halloween", Holiday.Type.FESTIVAL),
                new Holiday("Sep 5", "Labor Day", Holiday.Type.FEDERAL)
        );

        Holiday.Type[] types = Holiday.Type.values();
        for(Holiday.Type type : types){
            model.addAttribute(type.toString(), (holidayList.stream().filter(holiday -> holiday.getType().equals(type)).
                    collect(Collectors.toList())));
        }
        return "holidays.html";
    }

}

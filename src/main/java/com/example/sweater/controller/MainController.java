package com.example.sweater.controller;

import com.example.sweater.domain.Good;
import com.example.sweater.domain.User;
import com.example.sweater.repos.GoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private GoodRepo goodRepo;

    private List<String> goodList = new ArrayList<>();

    @GetMapping("/")
    public String greeting(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Good> goods = goodRepo.findAll();
        if (filter != null && !filter.isEmpty()) {
            goods = goodRepo.findByTag(filter);
        } else {
            goods = goodRepo.findAll();
        }
        model.addAttribute("goods", goods);
        model.addAttribute("filter", filter);

        return "greeting";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Good> goods = goodRepo.findAll();
        if (filter != null && !filter.isEmpty()) {
            goods = goodRepo.findByTag(filter);
        } else {
            goods = goodRepo.findAll();
        }
        model.addAttribute("goods", goods);
        model.addAttribute("filter", filter);
        return "main";
    }

    @GetMapping("/cart")
    public String bask(@RequestParam(required = false, defaultValue = "") String basket, Model model) {
        Iterable<Good> goods = goodRepo.findAll();

        model.addAttribute("goods", goods);
        model.addAttribute("basket", basket);
        goodList.add(basket);
        System.out.println(basket);
        System.out.println(goodList);
        return "greeting";
    }

    @GetMapping("/youcart")
    public String yourcart(Model model) {
        Iterable<Good> goods = goodRepo.findAll();
        model.addAttribute("goods", goods);
        model.addAttribute("goodList", goodList);

        return "youcart";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String cat,
            @RequestParam String tag, @RequestParam String price, @RequestParam String img, Map<String, Object> model
    ) throws IOException {
        Good good = new Good(cat, tag, price, img);
        goodRepo.save(good);
        Iterable<Good> goods = goodRepo.findAll();
        model.put("goods", goods);
        return "main";
    }
}

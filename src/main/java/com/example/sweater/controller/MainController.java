package com.example.sweater.controller;

import com.example.sweater.domain.Cart;
import com.example.sweater.domain.Good;
import com.example.sweater.domain.User;
import com.example.sweater.repos.CartRepo;
import com.example.sweater.repos.GoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;

@Controller
public class MainController {

    @Autowired
    private GoodRepo goodRepo;

    @Autowired
    private CartRepo cartRepo;

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
    public String yourcart(@AuthenticationPrincipal User user, Model model) {
        Iterable<Good> goods = goodRepo.findAll();
        Set<Good> selectedGoods = new HashSet<>();

        for (String strinId : goodList) {
            System.out.println(goodRepo.findById(Long.parseLong(strinId)).orElse(new Good()));
            Good good = goodRepo.findById(Long.parseLong(strinId)).orElse(new Good());
            selectedGoods.add(good);
        }

        cartRepo.save(new Cart(user, selectedGoods));

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

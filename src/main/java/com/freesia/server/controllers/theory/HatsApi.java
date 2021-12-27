package com.freesia.server.controllers.theory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping({"/hats"})
public class HatsApi {

    private ArrayList<Hat> hatsDB = new ArrayList<>();

    //todo Welcome to the theory!
    // To start put these classes into my.project.controller.theory so you can check these using swagger or browser
    // Each team member has to do only 1 assignment and commit/push it to your repository.
    // (So 2 people - 2 assignments, 3 people - 3 assignments, 4 people - 4 assignments).
    // Make sure to commit under your user otherwise the points won't count. Each team member has to score at least 50%.
    // Don't add unnecessary code (no need for services or database).
    // We are doing mock-api design. I am grading urls and structure of the methods.
    // It should still work, i.e I can access this api from swagger or browser.
    // A good source for learning about proper API design is https://docs.microsoft.com/en-us/azure/architecture/best-practices/api-design

    //todo The Story
    // Mad Hatter. Another Telliskivi butique. Hat know-how link (:  https://www.youtube.com/watch?v=6lYuL_kz9Ak
    // ---
    // Hey, I am Max Hatter. I'm from the states (US). I played basketball in my youth and I fell in love with hats.
    // I came to Estonia few years ago and started a business selling hats. I have a busy shop in Telliskivi region.
    // However during winter-time our sales are slow, so I am thinking of expanding our online presence.
    // I think we need to do something on the web. Like a shop or gallery or both. Connect it to tik-tok, instagram, facebook.
    // Do the online thing. Can you help?
    // I guess I need like a landing page where you can see many hats.
    // And each hat has some info, so once you click on it, it displays it.
    // And then there are buttons for saving and updating when I have new hats or some info was wrong.
    // Oh, and some way to remove hats.
    // For landing page it is important that the hats can be filtered by style and colour.
    // Also I'd like to order them by size and price.

    //todo A first things first, please add necessary annotations to this class

    //todo B "I guess I need like a landing page where you can see many hats"
    // create a method to query hats (plural)

    // EXPLANATION
    // http://localhost:8081/api/hats/null/null  - when we need to get all hats (no filter/sorting)
    // http://localhost:8081/api/hats/colour/black - when we need to get all hats by asked colour
    // http://localhost:8081/api/hats/style/lala - when we need to get all hats by asked style

    // http://localhost:8081/api/hats/size/increase - when we need to get all hats in ascending order by size
    // http://localhost:8081/api/hats/size/decrease - when we need to get all hats in descending order by size

    // http://localhost:8081/api/hats/price/increase - when we need to get all hats in ascending price by size
    // http://localhost:8081/api/hats/price/decrease - when we need to get all hats in descending price by size

    @GetMapping("/{filter}/{property}")
    public List<Hat> getAllHats(@PathVariable(required = false) String filter,@PathVariable(required = false) String property){
        if (filter.equals("colour")){
            ArrayList<Hat> neededHats = new ArrayList<>();
            for (Hat hat : hatsDB) {
                if (hat.getColour().equals(property)) {
                    neededHats.add(hat);
                }
            }
            return neededHats;
        } else if (filter.equals("style")){
            ArrayList<Hat> neededHats = new ArrayList<>();
            for (Hat hat : hatsDB) {
                if (hat.getStyle().equals(property)) {
                    neededHats.add(hat);
                }
            }
            return neededHats;
        } else if (filter.equals("size") && property.equals("increase")){
            return hatsDB.stream().sorted(Comparator.comparing(Hat::getSize)).collect(Collectors.toList());
        } else if (filter.equals("size") && property.equals("decrease")){
            return hatsDB.stream().sorted(Comparator.comparing(Hat::getSize).reversed()).collect(Collectors.toList());
        } else if (filter.equals("price") && property.equals("increase")){
            return hatsDB.stream().sorted(Comparator.comparing(Hat::getPrice)).collect(Collectors.toList());
        } else if (filter.equals("price") && property.equals("decrease")){
            return hatsDB.stream().sorted(Comparator.comparing(Hat::getPrice).reversed()).collect(Collectors.toList());
        }

        return hatsDB;


    }

    //todo C "And each hat has some info, so once you click on it, it displays it"
    // create a method to query a single hat

    // EXPLANATION
    // http://localhost:8081/api/hats/1 - when we need only the one hat by id

    @GetMapping("/{id}")
    public  Hat getById(@PathVariable Long id){
        for (Hat hat : hatsDB) {
            if (Objects.equals(hat.getId(), id)) {
                return hat;
            }
        }
        return null;
    }

    //todo D "And then there are buttons for saving [..] when I have new hats [..]"
    // create a method to save a new hat


    @PostMapping
    public boolean createAndSaveHat(@RequestBody Hat hat)
    {
        return hatsDB.add(hat);
    }

    //todo E "And then there are buttons for [..] updating when [..] some info was wrong"
    // create a method to update a hat

    // EXPLANATION
    // http://localhost:8081/api/hats/update/1?size=3 - when we need to update particular info of the
    // particular hat (in this case I want to change the size for the hat with 1 ID)

    @PutMapping("/update/{id}")
    private Hat update(@PathVariable("id") Long id, @RequestParam(required = false) String color,@RequestParam(required = false) String brand,@RequestParam(required = false) String price,@RequestParam(required = false) String style,@RequestParam(required = false) String size){
        Hat hatToUpdate = null;
        for (Hat h : hatsDB) {
            if (Objects.equals(h.getId(), id)) {
                hatToUpdate = h;
            }
        }
        if (hatToUpdate != null) {
            if (color != null) {
                hatToUpdate.setColour(color);
            }
            if (brand != null){
                hatToUpdate.setBrand(brand);
            }
            if (price != null){
                hatToUpdate.setPrice(price);
            }
            if (style != null){
                hatToUpdate.setStyle(style);
            }
            if (size != null){
                hatToUpdate.setSize(size);
            }
            return hatToUpdate;
        }
        else {
            throw new IllegalArgumentException("Hat with id " + id + " does not exist!");
        }
    }

    //todo F "Oh, and some way to remove hats."
    // create a method to delete a hat

    // EXPLANATION
    // http://localhost:8081/api/hats/1 - when we need to delete the hat with id 1.

    @DeleteMapping("/{id}")
    public void deleteHat(@PathVariable Long id){
        for (int i = 0; i < hatsDB.size(); i++) {
            if (Objects.equals(hatsDB.get(i).getId(), id)){
                hatsDB.remove(i);
            }
        }
    }


    //todo G, H "For landing page it is important that the hats can be filtered by style and colour."
    // G modify correct method to filter by hat style (59fifty, 9twenty, cap, etc)
    // G modify correct method to filter by hat colour (red, blue, etc)
    // make sure existing functionality doesn't break

    //todo I-J "Also I'd like to order them [the hats] by size and price."
    // I modify correct method to provide sorting by size and price
    // J modify correct method to support sorting in ascending and descending order
    // in addition write some examples for how you will sort using your api (provide urls)
}

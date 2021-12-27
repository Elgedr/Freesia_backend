package com.freesia.server.controllers.theory;

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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/coins")
public class CoinsApi {

    ArrayList<Coin> coinsArrayList = new ArrayList<>();
    //todo Welcome to the theory!
    // To start put these classes into my.project.controller.theory so you can check these using swagger or browser
    // Each team member has to do only 1 assignment and commit/push it to your repository.
    // (So 2 people - 2 assignments, 3 people - 3 assignments, 4 people - 4 assignments).
    // Make sure to commit under your user otherwise the points won't count. Each team member has to score at least 50%.
    // Don't add unnecessary code (no need for services or database).
    // We are doing mock-api design. I am grading urls and structure of the methods.
    // It should still work, i.e I can access this api from swagger or browser.
    // A good source for learning about proper API design is https://docs.microsoft.com/en-us/azure/architecture/best-practices/api-design

    //todo A first things first, please add necessary annotations to this class

    //todo B "I need to have like a list view with many coins"
    // create a method to query coins (plural)

    public void addCoinsForTesting() {
        Coin c1 = new Coin(1L, "HEY", "True", "Good", "100", "Me", "lool", "never");
        Coin c2 = new Coin(2L, "lll", "lll", "lll", "llll", "Me", "lool", "never");
        Coin c3 = new Coin(3L, "HEY", "True", "Good", "ppp", "Me", "lool", "never");
        Coin c4 = new Coin(4L, "kk", "kkk", "kkk", "lkkkk", "kkk", "kkk", "kkk");
        Coin c5 = new Coin(5L, "dddd", "ddd", "ddd", "dddd", "ddd", "ddd", "ddd");

        coinsArrayList.add(c1);
        coinsArrayList.add(c2);
        coinsArrayList.add(c3);
        coinsArrayList.add(c4);
        coinsArrayList.add(c5);
    }

    //todo G, H "There should be some filtering, by period and region"
    // G modify correct method to filter by period (ancient times, 18th century, 19th century)
    // H modify correct method to filter by region (americas, europe)
    // make sure existing functionality doesn't break

    //todo I-J "And sorting, by value and date added. By default it can sort with latest coins first."
    // I modify correct method to provide sorting by value and date added
    // J modify correct method to support sorting in ascending and descending order
    // in addition write some examples for how you will sort using your api (provide urls)

    // example: /api/coins?period=ancient
    // example: /api/coins?period=18th
    // example: /api/coins?period=19th
    // example: /api/coins?region=americas
    // example: /api/coins?region=europe

    // example: /api/coins?sort=value,ascending
    // example: /api/coins?sort=date,ascending
    // example: /api/coins?sort=value,descending
    // example: /api/coins?sort=date,descending
    // example: /api/coins?period=ancient&region=europe&sort=value,descending&sort=date,ascending

    @GetMapping
    public List<Coin> getAllCoins(@RequestParam(value = "region", required = false) String region,
                                  @RequestParam(value = "period", required = false) String period,
                                  @RequestParam(value = "sort", required = false) String sortBy) {
        addCoinsForTesting();
        List<Coin> res = coinsArrayList;
        if (period != null) {
            switch (period) {
                case "ancient":
                    res = res.stream().filter(x -> x.getPeriod().equals("ancient")).collect(Collectors.toList());
                    break;
                case "18th":
                    res = res.stream().filter(x -> x.getPeriod().equals("18th")).collect(Collectors.toList());
                    break;
                case "19th":
                    res = res.stream().filter(x -> x.getPeriod().equals("19th")).collect(Collectors.toList());
                    break;
                default:
                    break;
            }
        }
        if (region != null) {
            switch (region) {
                case "americas":
                    res = res.stream().filter(x -> x.getRegion().equals("americas")).collect(Collectors.toList());
                    break;
                case "europe":
                    res = res.stream().filter(x -> x.getRegion().equals("europe")).collect(Collectors.toList());
                    break;
                default:
                    break;
            }
        }
        if (sortBy != null) {
            String[] descOrInc = sortBy.split(",");
            if (descOrInc.length > 1 && descOrInc[1].equals("descending")) {
                switch (descOrInc[0]) {
                    case "value":
                        res = res.stream().sorted(Comparator.comparingInt((Coin x) -> Integer.parseInt(x.getValue())).reversed()).collect(Collectors.toList());
                        break;
                    case "date":
                        res = res.stream().sorted(Comparator.comparing(Coin::getDateAdded).reversed()).collect(Collectors.toList());
                        break;
                    default:
                        break;
                }
            } else {
                switch (descOrInc[0]) {
                    case "value":
                        res = res.stream().sorted(Comparator.comparingInt(x -> Integer.parseInt(x.getValue()))).collect(Collectors.toList());
                        break;
                    case "date":
                        res = res.stream().sorted(Comparator.comparing(Coin::getDateAdded)).collect(Collectors.toList());
                        break;
                    default:
                        break;
                }
            }
        }
        return res;
    }

    //todo C "If I click on a single coin, I get to a detail page."
    // create a method to query a single coin
    @GetMapping("/{id}")
    public Coin getCoinById(@PathVariable Long id) {
        addCoinsForTesting();
        for (Coin coin : coinsArrayList) {
            if (coin.getId().equals(id)) {
                return coin;
            }
        }
        return null;
    }

    //todo D "I want to add new coins"
    // create a method to save a new coin

    @PostMapping
    public boolean addCoin(@RequestBody Coin newCoin) {
        return coinsArrayList.add(newCoin);
    }


    //todo E "update existing ones"
    // create a method to update a coin

    @PutMapping("{id}")
    private void updateCoin(@PathVariable("id") Long id, @RequestParam(required = false, value = "name") String name, @RequestParam(required = false) String period, @RequestParam(required = false) String region,
                            @RequestParam(required = false) String age, @RequestParam(required = false) String condition, @RequestParam(required = false) String value, @RequestParam(required = false) String dateAdded) {
        addCoinsForTesting();
        Coin coinToUpdate = coinsArrayList.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);
        if (coinToUpdate != null) {
            if (name != null) {
                coinToUpdate.setName(name);
            }
            if (period != null) {
                coinToUpdate.setPeriod(period);
            }
            if (region != null) {
                coinToUpdate.setRegion(region);
            }
            if (age != null) {
                coinToUpdate.setAge(age);
            }
            if (condition != null) {
                coinToUpdate.setCondition(condition);
            }
            if (value != null) {
                coinToUpdate.setValue(value);
            }
            if (dateAdded != null) {
                coinToUpdate.setDateAdded(dateAdded);
            }
        }
    }

    //todo F "occasionally delete some"
    // create a method to delete a blog

    @DeleteMapping("/{id}")
    public List<Coin> deleteCoin(@PathVariable Long id) {
        addCoinsForTesting();
        Coin toDelete = coinsArrayList.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);
        coinsArrayList.remove(toDelete);
        return coinsArrayList;
    }


}

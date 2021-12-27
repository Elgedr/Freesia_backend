package com.freesia.server.controllers.theory.skateboards;

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
@RequestMapping("/skateboards")
public class SkateboardsApi {

    private List<Skateboard> skateboards = new ArrayList<>();

    //todo The Story
    // Fred has a Skateboard shop in Telliskivi.
    // ---
    // Hi. I'm Fred the hipster. I studied law and music, but now I'm selling and making skateboards. Wild life!
    // Our business has grown and I need some help automating it.
    // Currently our inventory is managed by pen and paper. You need to make it better.
    // This is what I need:
    // - an overview of the skateboards we sell
    // - I want to know which ones are in stock and which ones are new (vs used)
    // - I want to order by the price or by the name alphabetically
    // and a
    // - page for each skateboard where I can see it's info
    // - button to add a new skateboard
    // - button to update existing skateboard
    // - button to delete skateboard

    // A
    // first things first, please add necessary annotations to this class

    // B
    // "an overview of the skateboards we sell"
    // create a method to query skateboards (plural)
    // G, H
    // "I want to know which ones are in stock and which ones are new (vs used)"
    // G modify correct method to filter whether the skateboard is in stock or out of stock
    // H modify correct method to filter by condition (new, used, broken)
    // make sure existing functionality doesn't break
    // I-J
    // "I want to order by the price or by the name alphabetically"
    // I modify correct method to provide sorting by price and name
    // J modify correct method to support sorting in ascending and descending order
    // in addition write some examples for how you will sort using your api (provide urls)
    @GetMapping
    public List<Skateboard> allSkateboards(@RequestParam(value = "instock", required = false) String instock,
                                           @RequestParam(value = "condition", required = false) String condition,
                                           @RequestParam(value = "sort", required = false) String sortby) {
        // URL EXAMPLES:
        // example: /api/skateboards
        // example: /api/skateboards?instock=true
        // example: /api/skateboards?instock=false
        // example: /api/skateboards?condition=new
        // example: /api/skateboards?condition=used
        // example: /api/skateboards?condition=broken
        // example: /api/skateboards?sort=price [SAME AS /api/skateboards?sort=price,asc]
        // example: /api/skateboards?sort=name [SAME AS /api/skateboards?sort=name,asc]
        // example: /api/skateboards?sort=name,desc
        // example: /api/skateboards?instock=true&condition=new&sort=price,desc&sort=name,asc
        List<Skateboard> filteredSkateboards = skateboards;
        if (instock != null) {
            switch (instock) {
                case "true":
                    filteredSkateboards = filteredSkateboards.stream().filter(x -> x.getInStock().equals("true")).collect(Collectors.toList());
                    break;
                case "false":
                    filteredSkateboards = filteredSkateboards.stream().filter(x -> x.getInStock().equals("false")).collect(Collectors.toList());
                    break;
                default:
                    break;
            }
        }
        if (condition != null) {
            switch (condition) {
                case "new":
                    filteredSkateboards = filteredSkateboards.stream().filter(x -> x.getCondition().equals("new")).collect(Collectors.toList());
                    break;
                case "used":
                    filteredSkateboards = filteredSkateboards.stream().filter(x -> x.getCondition().equals("used")).collect(Collectors.toList());
                    break;
                case "broken":
                    filteredSkateboards = filteredSkateboards.stream().filter(x -> x.getCondition().equals("broken")).collect(Collectors.toList());
                    break;
                default:
                    break;
            }
        }
        if (sortby != null) {
            String[] sortFilter = sortby.split(",");
            if (sortFilter.length > 1 && sortFilter[1].equals("desc")) {
                switch (sortFilter[0]) {
                    case "price":
                        filteredSkateboards =
                                filteredSkateboards.stream()
                                        .sorted(Comparator.comparingInt((Skateboard x) ->
                                                Integer.parseInt(x.getPrice())).reversed()).collect(Collectors.toList());
                        break;
                    case "name":
                        filteredSkateboards =
                                filteredSkateboards.stream()
                                        .sorted(Comparator.comparing(Skateboard::getName).reversed()).collect(Collectors.toList());
                        break;
                    default:
                        break;
                }
            } else {
                switch (sortFilter[0]) {
                    case "price":
                        filteredSkateboards = filteredSkateboards.stream().sorted(Comparator.comparingInt(x -> Integer.parseInt(x.getPrice()))).collect(Collectors.toList());
                        break;
                    case "name":
                        filteredSkateboards = filteredSkateboards.stream().sorted(Comparator.comparing(Skateboard::getName)).collect(Collectors.toList());
                        break;
                    default:
                        break;
                }
            }
        }
        return filteredSkateboards;
    }

    // C
    // "page for each skateboard where I can see its info"
    // create a method to query a single skateboard
    @GetMapping("/{id}")
    public Skateboard oneSkateboard(@PathVariable Long id) {
        return skateboards.stream().filter(x -> x.getId().equals(id)).findFirst().get();
    }

    // D
    // "button to add a new skateboard"
    // create a method to save a new skateboard
    @PostMapping
    public boolean addSkateboard(@RequestBody Skateboard newSkateboard) {
        return skateboards.add(newSkateboard);
    }

    // E
    // "button to update existing skateboard"
    // create a method to update a skateboard
    @PutMapping("/{id}")
    public Skateboard updateSkateboard(@RequestBody Skateboard newSkateboard, @PathVariable Long id) {
        Skateboard toUpdate = skateboards.stream().filter(x -> x.getId().equals(id)).findFirst().get();
        int index = skateboards.indexOf(toUpdate);
        return skateboards.set(index, newSkateboard);
    }

    // F
    // "button to delete skateboard"
    // create a method to delete a skateboard
    @DeleteMapping("/{id}")
    public void deleteSkateboard(@PathVariable Long id) {
        Skateboard toDelete = skateboards.stream().filter(x -> x.getId().equals(id)).findFirst().get();
        skateboards.remove(toDelete);
    }
}

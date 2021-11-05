package org.danicv.apiservlet.webapp.httpsession.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Carro {
    private List<ItemCarro> items;

    public Carro() {
        this.items = new ArrayList<>();
    }

    public List<ItemCarro> getItems() {
        return items;
    }

    public void addItemCarro(ItemCarro itemCarro) {
        if (items.contains(itemCarro)) {
            Optional<ItemCarro> optionalItemCarro = items.stream().
                    filter(i -> i.equals(itemCarro)).
                    findAny();
            if (optionalItemCarro.isPresent()) {
                ItemCarro i = optionalItemCarro.get();
                i.setCantidad(i.getCantidad() + 1);
            }
        }
        this.items.add(itemCarro);
    }

    public int getTotal() {
        return items.stream().mapToInt(ItemCarro::getTotal).sum();
    }
}

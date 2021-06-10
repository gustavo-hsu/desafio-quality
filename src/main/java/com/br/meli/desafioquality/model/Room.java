package com.br.meli.desafioquality.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Room {
    private String name;
    private Double width;
    private Double length;

    public Double getSize() {
        return this.getWidth() * this.getLength();
    }
}

package com.fedorchenko.socks.entities;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "socks")
@IdClass(SockEntity.SockId.class)
public class SockEntity {

    @Id
    @Column(name = "color")
    @NotBlank
    private String color;

    @Column(name = "cotton_part")
    @Id
    @Min(0)
    @Max(100)
    private Integer cottonPart;

    @PositiveOrZero
    @Column(name = "quantity")
    private Integer quantity;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getCottonPart() {
        return cottonPart;
    }

    public void setCottonPart(Integer cottonPart) {
        this.cottonPart = cottonPart;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    public static class SockId implements Serializable {

        private String color;
        private Integer cottonPart;


        public SockId() {
        }

        public SockId(String color, Integer cottonPart) {
            this.color = color;
            this.cottonPart = cottonPart;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SockId sockId = (SockId) o;
            return Objects.equals(color, sockId.color) && Objects.equals(cottonPart, sockId.cottonPart);
        }

        @Override
        public int hashCode() {
            return Objects.hash(color, cottonPart);
        }
    }
}

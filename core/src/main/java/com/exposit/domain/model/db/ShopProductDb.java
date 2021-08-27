package com.exposit.domain.model.db;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class ShopProductDb extends BaseDb {

    private Integer quantity;
    private StoreDb store;
    private ProductDb product;

    @CsvBindByName(column = "price")
    private Double price;

    @CsvBindByName(column = "description")
    private String description;

    @Override
    public String toString() {
        return "ShopProduct{"
                + "id=" + id
                + ", product=" + product
                + ", price=" + price
                + ", quantity=" + quantity
                + ", store=" + store
                + ", description='" + description + '\''
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShopProductDb)) return false;
        ShopProductDb that = (ShopProductDb) o;
        return Objects.equals(quantity, that.quantity) &&
                Objects.equals(store, that.store) &&
                Objects.equals(product, that.product) &&
                Objects.equals(price, that.price) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, store, product, price, description);
    }
}

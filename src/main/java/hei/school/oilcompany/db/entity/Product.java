package hei.school.oilcompany.db.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Product implements Serializable {
    private String id;
    private String name;
    private Double price;
}

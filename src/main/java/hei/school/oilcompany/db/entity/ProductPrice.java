package hei.school.oilcompany.db.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ProductPrice implements Serializable {
    private String id;
    private double unitPrice;
    private LocalDateTime date;
}

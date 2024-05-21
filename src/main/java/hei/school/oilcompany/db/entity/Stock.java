package hei.school.oilcompany.db.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Stock implements Serializable {
    private String id;
    private double evaporationRate;
    private LocalDateTime dateTime;
    private double quantity;
    private Integer idProduct;
    private Integer idGasStation;
}

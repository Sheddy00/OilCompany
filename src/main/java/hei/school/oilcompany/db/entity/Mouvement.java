package hei.school.oilcompany.db.entity;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Mouvement {
    private String id;
    private LocalDate date;
    private String type;
    private double quantity;
    private Integer gasStation;
    private Integer product;
}

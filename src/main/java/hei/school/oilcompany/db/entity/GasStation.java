package hei.school.oilcompany.db.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class GasStation implements Serializable {
    private String id;
    private String stationName;
    private String location;
}

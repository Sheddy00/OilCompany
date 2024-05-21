package hei.school.oilcompany.controller;

import hei.school.oilcompany.db.entity.Stock;
import hei.school.oilcompany.operation.StockOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Stocks")
public class StockController {

    @Autowired
    StockOperation stockOperation;

    @GetMapping({"", "/"})
    public List<Stock> getAllStocks() {
        return stockOperation.findAll();
    }
    @GetMapping("/{id}")
    public Stock getStockById(@PathVariable("id") String id) {
        return stockOperation.getById(Integer.valueOf(id));
    }

}

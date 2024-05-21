package hei.school.oilcompany.controller;

import hei.school.oilcompany.db.entity.Stock;
import hei.school.oilcompany.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Stocks")
public class StockController {

    @Autowired
    StockService stockService;

    @GetMapping({"", "/"})
    public List<Stock> getAllStocks() {
        return stockService.findAll();
    }
    @GetMapping("/{id}")
    public Stock getStockById(@PathVariable("id") String id) {
        return stockService.findById(id);
    }

    @DeleteMapping("delete/{id}")
    public Stock deleteStationById(@PathVariable("id") String id) { return stockService.delete(id); }

    @PostMapping("/saveStock")
    public Stock savingStock(@RequestBody Stock stock) { return stockService.save(stock); }

}

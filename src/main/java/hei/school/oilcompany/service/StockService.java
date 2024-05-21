package hei.school.oilcompany.service;

import hei.school.oilcompany.db.entity.Stock;
import hei.school.oilcompany.operation.StockOperation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {
    StockOperation stockOperation;

    public List<Stock> findAll() {
        return stockOperation.findAll();
    }

    public Stock findById(String id) {
        return stockOperation.getById(Integer.valueOf(id));
    }

    public Stock save(Stock stock) {
        return stockOperation.save(stock);
    }
}

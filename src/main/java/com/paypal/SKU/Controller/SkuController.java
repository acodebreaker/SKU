package com.paypal.SKU.Controller;

import com.paypal.SKU.Exceptions.CodeAlreadyExistException;
import com.paypal.SKU.Exceptions.CodeDoesNotExistException;
import com.paypal.SKU.Model.StockKeepingUnit;
import com.paypal.SKU.Service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
public class SkuController {

    @Autowired
    SkuService skuService;


    @GetMapping("sku/{skuCode}")
    public StockKeepingUnit getSKU(@PathVariable String skuCode) {
        return skuService.getStockKeepingUnitByCode(skuCode);
    }

    @PostMapping("sku")
    public void addSKU(@RequestBody StockKeepingUnit stockKeepingUnit) {
        try {
            skuService.addStockKeepingUnit(stockKeepingUnit);
        } catch (CodeAlreadyExistException e) {
            e.printStackTrace();
        }
    }

    @PutMapping("sku")
    public void updateSKU(@RequestBody StockKeepingUnit stockKeepingUnit) {

        try {
            skuService.updateStockKeepingUnit(stockKeepingUnit);
        } catch (CodeDoesNotExistException e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping("sku/{skuCode}")
    public void deleteSKU(@PathVariable String skuCode) {
        try {
            skuService.deleteStockKeepingUnit(skuCode);
        } catch (CodeDoesNotExistException e) {
            e.printStackTrace();
        }
    }
}

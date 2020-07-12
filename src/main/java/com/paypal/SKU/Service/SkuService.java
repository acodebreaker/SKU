package com.paypal.SKU.Service;

import com.paypal.SKU.Exceptions.CodeAlreadyExistException;
import com.paypal.SKU.Exceptions.CodeDoesNotExistException;
import com.paypal.SKU.Model.StockKeepingUnit;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SkuService {

    private List<StockKeepingUnit> stockKeepingUnits;
    private Set<String> skuCodes;


    SkuService() {
        this.stockKeepingUnits = new ArrayList<>();
        this.skuCodes = new HashSet<>();
    }


    public StockKeepingUnit getStockKeepingUnitByCode(String skuCode) {
        return stockKeepingUnits.stream().filter(stockKeepingUnit -> stockKeepingUnit.getSkuCode().equals(skuCode)).findFirst().orElse(null);
    }

    public void addStockKeepingUnit(StockKeepingUnit stockKeepingUnit) throws CodeAlreadyExistException {
        if (skuCodes.contains(stockKeepingUnit)) {
            throw new CodeAlreadyExistException("Sorry the provided skuCode already Exist");
        }
        stockKeepingUnits.add(stockKeepingUnit);
        skuCodes.add(stockKeepingUnit.getSkuCode());
    }


    public void updateStockKeepingUnit(StockKeepingUnit stockKeepingUnit) throws CodeDoesNotExistException {

        if (!skuCodes.contains(stockKeepingUnit.getSkuCode())) {
            throw new CodeDoesNotExistException("Sorry the provide SKU Code doesnot exist");
        }
        stockKeepingUnits = stockKeepingUnits.stream().filter(stockKeeping -> stockKeeping.getSkuCode().equals(stockKeepingUnit.getSkuCode())).map(stockKeeping -> stockKeeping = stockKeepingUnit).collect(Collectors.toList());
    }
}

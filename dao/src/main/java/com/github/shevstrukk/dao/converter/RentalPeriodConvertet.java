package com.github.shevstrukk.dao.converter;

import com.github.shevstrukk.dao.entity.RentalPeriodEntity;
import com.github.shevstrukk.model.RentalPeriod;

import java.util.ArrayList;
import java.util.List;

public class RentalPeriodConvertet {
    public static RentalPeriodEntity toEntity(RentalPeriod period) {
        if (period == null) {
            return null;
        }
        final RentalPeriodEntity rentalPeriodEntity = new RentalPeriodEntity();
        if(period.getId()!=null){
            rentalPeriodEntity.setId(period.getId());}
        if(period.getStart()!=null){
            rentalPeriodEntity.setStart(period.getStart());}
        if(period.getEnd()!=null){
            rentalPeriodEntity.setEnd(period.getEnd());}
        if(period.getCar()!=null){
            rentalPeriodEntity.setCar(CarConverter.toEntity(period.getCar()));}
        return rentalPeriodEntity;
    }

    public static RentalPeriod createCarfromEntity(RentalPeriodEntity entity){
        if(entity==null){
            return null;
        }
        return new RentalPeriod(entity.getId(),
                entity.getStart(),
                entity.getEnd(),
                null
        );
    }
    public static RentalPeriod fromEntity(RentalPeriodEntity entity){
        if(entity==null){
            return null;
        }
        return new RentalPeriod(entity.getId(),
                entity.getStart(),
                entity.getEnd(),
                null
        );
    }
    public static RentalPeriod fromEntityRental(RentalPeriodEntity entity){
        if(entity==null){
            return null;
        }
        return new RentalPeriod(entity.getId(),
                entity.getStart(),
                entity.getEnd(),
                CarConverter.fromEntityRental(entity.getCar())
        );
    }

    public static List<RentalPeriod> fromRentalPeriodListEntity(List<RentalPeriodEntity> rentalPeriodEntityList){
        List<RentalPeriod> periodList = new ArrayList<>();
        for(RentalPeriodEntity elem: rentalPeriodEntityList){
            periodList.add(RentalPeriodConvertet.fromEntity(elem));
        }
        return periodList;

    }
}
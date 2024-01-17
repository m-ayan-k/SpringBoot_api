package com.mayank.liveasy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mayank.liveasy.dao.CargoDao;
import com.mayank.liveasy.model.Cargo;

@Service
public class CargoServiceImpl implements CargoService{

    // List<Cargo> list;
    @Autowired
    private CargoDao cargoDao;
    public CargoServiceImpl(){
        // list = new ArrayList<>();
        // list.add(new Cargo("delhi","jaipur","chemicals","canter",1,100,"faltu","123bjjk23j12"));
    }

    @Override
    public List<Cargo> getLoads() {
        return cargoDao.findAll();
    }

    @Override
    public Cargo getLoad(long loadId) {
        return cargoDao.findById(loadId).get();
    }

    @Override
    public Cargo addLoad(Cargo cargo){
        
        return cargoDao.save(cargo);
    }

    @Override
    public Void deleteLoad(long loadId){
        cargoDao.deleteById(loadId);
        return null;
    }

    @Override 
    public Cargo updateLoad(long loadId, Cargo updatedCargo){
        Cargo existingCargo = cargoDao.findById(loadId).get();
        if (existingCargo != null) {
            existingCargo.setLoadingPoint(updatedCargo.getLoadingPoint());
            existingCargo.setUnloadingPoint(updatedCargo.getUnloadingPoint());
            existingCargo.setProductType(updatedCargo.getProductType());
            existingCargo.setTruckType(updatedCargo.getTruckType());
            existingCargo.setNoOfTrucks(updatedCargo.getNoOfTrucks());
            existingCargo.setWeight(updatedCargo.getWeight());
            existingCargo.setComment(updatedCargo.getComment());
            existingCargo.setShipperId(updatedCargo.getShipperId());
            
            return cargoDao.save(existingCargo);
        }
        return null;

    }

    @Override
    public List<Cargo> getLoadByShipperId(String shipperId){
        return cargoDao.findByShipperId(shipperId);
    }
}

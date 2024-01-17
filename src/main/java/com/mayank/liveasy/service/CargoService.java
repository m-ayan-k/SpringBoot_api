package com.mayank.liveasy.service;
import com.mayank.liveasy.model.Cargo;
import java.util.*;

import org.springframework.stereotype.Service;

@Service
public interface CargoService {

    public List<Cargo> getLoads();
    public Cargo getLoad(long loadId);
    public Cargo addLoad(Cargo cargo);
    public Void deleteLoad(long loadId);
    public Cargo updateLoad(long loadId, Cargo cargo);
    public List<Cargo> getLoadByShipperId(String shipperId);
}

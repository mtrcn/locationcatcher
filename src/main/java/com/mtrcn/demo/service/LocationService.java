package com.mtrcn.demo.service;

import com.mtrcn.demo.domain.LocationMessage;
import com.mtrcn.demo.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mtrcn
 * Date: 3/14/13
 * Time: 10:04 AM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class LocationService {

    @Autowired
    LocationRepository locationRepository;

    @Transactional
    public void save(LocationMessage message){
        locationRepository.save(message);
    }
}

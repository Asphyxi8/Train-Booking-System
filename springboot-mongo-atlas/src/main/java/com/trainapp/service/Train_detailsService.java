package com.trainapp.service;
import java.util.*;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.trainapp.model.Train_details;
import com.trainapp.repository.Train_detailsRepository;

@Service
public class Train_detailsService {

    @Autowired
private Train_detailsRepository repository;

//CRUD NOW:
public Train_details addTrain(Train_details train){
train.setId(UUID.randomUUID().toString().split("-")[0]);
return repository.save(train);

}

public List<Train_details> findAllTrains(){
    return repository.findAll();
}

public Train_details getTrainById(String trainId){
    return repository.findById(trainId).get();

}
//as a method
public List<Train_details> getTrainByOrigin(String origin){
    return repository.findByOrigin(origin);

}
//as a query
public List<Train_details> getTrainByDestination(String destination){
    return repository.getTrainByDestination(destination);

}

public Train_details updateTrain(Train_details train){
    //get the existing document from DB:
    Train_details existingTrain = repository.findById(train.getId()).get();
    existingTrain.setOrigin(train.getOrigin());
    existingTrain.setDestination(train.getDestination());
    existingTrain.setDepTime(train.getDepTime());
    existingTrain.setFare(train.getFare());
    existingTrain.setTrainName(train.getTrainName());
    return repository.save(existingTrain);
}

public String deleteTrain(String trainId){
    repository.deleteById(trainId);
    return "DELETED TRAIN OF ID: "+trainId;
}

}

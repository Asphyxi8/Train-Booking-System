package com.trainapp.controller;
import java.util.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.trainapp.service.Train_detailsService;
import com.trainapp.model.Train_details;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/train")
public class TrainController {
@Autowired
private Train_detailsService service;

@PostMapping
public Train_details createTrain(@RequestBody Train_details train){
return service.addTrain(train);
}

@GetMapping
public List<Train_details> getAllTrains(){
    return service.findAllTrains();
}

@GetMapping("/{Id}")
public Train_details getTrain(@PathVariable String Id){
    return service.getTrainById(Id);

}

@GetMapping("/origin/{origin}")
public List<Train_details> getTrainByOrigin(@PathVariable String origin){
    return service.getTrainByOrigin(origin);
}
@GetMapping("/destination/{destination}")
public List<Train_details> getTrainByDestination(@PathVariable String destination){
    return service.getTrainByDestination(destination);
}

@PutMapping
public Train_details modifyTrainDetails(@RequestBody Train_details train){
    return service.updateTrain(train);
}

@DeleteMapping("/{Id}")
public String deleteTrain(@PathVariable String Id){
    return service.deleteTrain(Id);
}
}


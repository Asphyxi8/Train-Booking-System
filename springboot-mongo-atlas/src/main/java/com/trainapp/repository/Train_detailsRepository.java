package com.trainapp.repository;
import java.util.List;


import org.springframework.data.mongodb.repository.*;
import com.trainapp.model.Train_details;

public interface Train_detailsRepository extends MongoRepository<Train_details,String>{
    List<Train_details> findByOrigin(String origin);
    @Query("{destination:?0}")
    List<Train_details> getTrainByDestination(String destination);

}


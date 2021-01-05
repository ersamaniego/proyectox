package com.example.proyecto_x.api.service;


import com.example.proyecto_x.api.model.DatabaseSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;


@Service
public class SequenceGeneratorService {
    @Autowired
    MongoOperations mongoOperations;

    public int generateSequence(String seqName) {
        //get sequence no
        Query query = new Query(Criteria.where("id").is(seqName));

        //update sequence no
        Update update = new Update().inc("seq",1);

        //modify in document
        DatabaseSequence counter = mongoOperations.findAndModify(query, update, options().returnNew(true).upsert(true),DatabaseSequence.class);
        return !Objects.isNull(counter) ? (int) counter.getSeq() : 1;
    }

}

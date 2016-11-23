package com.nhsbsa.service;

import com.nhsbsa.RFT1CSV;
import com.nhsbsa.reports.rft1.RFT1;
import com.nhsbsa.repos.RFT1Repository;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * Created by MattHood on 15/11/2016.
 */

@Log4j
@Service
@Transactional
public class RFT1Service {

    private final RFT1Repository rft1Repository;

    @Autowired
    public RFT1Service(final RFT1Repository RFT1Repository) {
        this.rft1Repository = RFT1Repository;
    }

    public RFT1 findByCsvFileID(final int csvFileID) {
        return rft1Repository.findByCsvFileID(csvFileID);
    }


    public void save(final RFT1 rft1) {
        rft1Repository.save(rft1);
    }

    public File write(final Collection<RFT1> rft1Entries, final File file) {
        try {
            RFT1CSV.writeCsvFile(rft1Entries, file);
        } catch (IOException e) {
            log.error(e);
        }
        return file;
    }

    public List<RFT1> read(final File file) throws IOException {
        return RFT1CSV.read(file);
    }

    public RFT1 load(final int id) {
        return rft1Repository.findByCsvFileID(id);
    }

    public List<RFT1> loadAll() {
        return rft1Repository.findAll();
    }
}
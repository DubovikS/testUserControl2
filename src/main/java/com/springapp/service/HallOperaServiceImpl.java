package com.springapp.service;

import com.springapp.dao.HallDao;
import com.springapp.model.HallOpera;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HallOperaServiceImpl implements HallOperaService {

    private HallDao hallOperaperaDao;

    public HallDao getHallOperaperaDao() {
        return hallOperaperaDao;
    }

    public void setHallOperaperaDao(HallDao hallOperaperaDao) {
        this.hallOperaperaDao = hallOperaperaDao;
    }

    @Override
    @Transactional
    public void updateHall(HallOpera hall) {
        this.hallOperaperaDao.updateHall(hall);
    }

    @Override
    @Transactional
    public HallOpera getHallById(int id) {
        return this.hallOperaperaDao.getHallById(id);
    }

    @Override
    @Transactional
    public List<HallOpera> getListHall() {
        return this.hallOperaperaDao.getListHall();
    }
}

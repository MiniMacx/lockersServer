package org.tustcs.lockers.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tustcs.lockers.dao.LogMapper;
import org.tustcs.lockers.entity.Log;
import org.tustcs.lockers.service.LogService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Airmacx on 2017/11/5.
 */
@Service
@Transactional
public class LogServiceImpl implements LogService {

    @Resource
    LogMapper logMapper;

    @Override
    public boolean addLog(Log log) {
        return false;
    }

    @Override
    public boolean updateLog(Log log) {
        return false;
    }

    @Override
    public List<Log> getLogList(int userId) {
        return null;
    }

    @Override
    public Log getLog(int logId) {
        return null;
    }
}

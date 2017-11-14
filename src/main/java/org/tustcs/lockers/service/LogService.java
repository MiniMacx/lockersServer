package org.tustcs.lockers.service;

import org.tustcs.lockers.entity.Log;

import java.util.List;

/**
 * Created by Airmacx on 2017/11/4.
 */
public interface LogService {
    boolean addLog(Log log);

    boolean updateLog(Log log);

    List<Log> getLogList(int userId);

    Log getLog(int logId);


}

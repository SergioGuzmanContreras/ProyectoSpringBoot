package mx.com.ersoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.ersoft.dao.LogDao;
import mx.com.ersoft.entity.LogEntity;
import mx.com.ersoft.service.LogService;

@Service
public class LogServiceImpl implements LogService{

	@Autowired
	private LogDao logDao;
	
	@Override
	public void saveLog(LogEntity log) {
		logDao.save(log);
	}

}

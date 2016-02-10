package scafe.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import scafe.domain.AppManager;
import scafe.domain.dao.AppManagerDao;
import scafe.service.AppManagerService;

@Service
public class AppManagerServiceImpl implements AppManagerService {
	
	@Autowired
	AppManagerDao appManagerDao;
	
	@Override
	public void addAppManager (AppManager appManager){
		appManagerDao.save(appManager);
	}
	
	@Override
	public Page <AppManager > findAll(Pageable pageable){
		return appManagerDao.findAll(pageable);
	}
	
	@Override
	public List <AppManager > findAll(){
		return appManagerDao.findAll();		
	}
	
	@Override
	public AppManager findOne (int id){
		return appManagerDao.findOne(id);
	}
			
	@Override
	public void deleteAppManager (AppManager appManager){
		appManagerDao.delete(appManager);
	}
	
}

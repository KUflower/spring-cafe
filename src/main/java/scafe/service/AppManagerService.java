package scafe.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import scafe.domain.AppManager;

public interface AppManagerService {
		
	public void addAppManager (AppManager appManager);	
	public List <AppManager > findAll();
	public Page <AppManager > findAll(Pageable pageable);
	public AppManager findOne (int id);
	public void deleteAppManager (AppManager appManager);

}

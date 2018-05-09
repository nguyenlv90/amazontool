package bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import service.TrademarkService;
import entities.Trademark;

@ManagedBean
@ViewScoped
public class TrademarkBean {
	
	static TrademarkService trademarkService;
	static {
		  try {

			 trademarkService = new TrademarkService();

		  } catch (Throwable t) {
		    throw t;
		  }
	}
	
	private List<Trademark> listAllTrademark;
	private List<Trademark> listTrademarkResult;
	private String valueForSearch;
	private Trademark currentTM;
	
	@PostConstruct
	private void init() {
		listAllTrademark = new ArrayList<Trademark>();
		listAllTrademark = trademarkService.getAll();
		if(currentTM == null) {
			currentTM = new Trademark();
		}
	}
	
	//------------------------------ACTION-----------------------------------
	
	public void findResultForSearch() {
		listTrademarkResult = new ArrayList<Trademark>();
		if(valueForSearch != null && !valueForSearch.trim().equalsIgnoreCase("")) {
			String listTitleSplit[] = valueForSearch.split(" ");
			
			int lengthOfListTitle = listTitleSplit.length;
			HashSet<String> setOfTitleSplit=new HashSet<String>();  
			for(int i = 0; i <lengthOfListTitle; i++) {
				setOfTitleSplit.add(listTitleSplit[i]);
			}
			
			for(String strTitle : setOfTitleSplit) {
				for(Trademark tm : listAllTrademark) {
					if(strTitle.equalsIgnoreCase(tm.getName())) {
						listTrademarkResult.add(tm);
					}
				}
				
			}
		}
	}
	
	public void addTM() {
		trademarkService.add(currentTM);
		this.listAllTrademark.add(currentTM);
		
		currentTM = new Trademark();
	}
	
	public void deleteTM() {
		
		trademarkService.delete(currentTM);
		this.listAllTrademark.remove(currentTM);
		
		currentTM = new Trademark();
		
	}

	
	
	//------------------------------GET-SET----------------------------------
	
	
	
	public List<Trademark> getListAllTrademark() {
		if(listAllTrademark == null || listAllTrademark.isEmpty()) {
			listAllTrademark = trademarkService.getAll();
		}
		return listAllTrademark;
	}



	public List<Trademark> getListTrademarkResult() {
		return listTrademarkResult;
	}



	public String getValueForSearch() {
		return valueForSearch;
	}



	public void setValueForSearch(String valueForSearch) {
		this.valueForSearch = valueForSearch;
	}



	public Trademark getCurrentTM() {
		return currentTM;
	}



	public void setCurrentTM(Trademark currentTM) {
		this.currentTM = currentTM;
	}
	
	

}

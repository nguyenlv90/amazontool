package entities;

import java.io.Serializable;
import javax.persistence.*;

import until.Constance;


/**
 * The persistent class for the trademark database table.
 * 
 */
@Entity
public class Trademark implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static String GETALL = "SELECT t FROM Trademark t";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="trademark_id")
	private int trademarkId;

	private String category;

	private String good;

	private String name;

	private String status;

	public Trademark() {
	}

	public int getTrademarkId() {
		return this.trademarkId;
	}

	public void setTrademarkId(int trademarkId) {
		this.trademarkId = trademarkId;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getGood() {
		return this.good;
	}

	public void setGood(String good) {
		this.good = good;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getStatus() {
		if(status != null && status.equals(Constance.YES)) {
			return "Đã dính";
		} else if(status != null) {
			return "Không dính";
		} else {
			return status;
		}
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public boolean isHaveTrademark() {
		if(status != null && status.equals(Constance.YES)) {
			return true;
		} 
		return false;
	}
	
	public String background () {
		if (status.equalsIgnoreCase(Constance.YES)) {
			return "#B71C1C";
		}
		return "";
	}

}
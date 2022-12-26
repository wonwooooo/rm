package vo;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ProductVO {
	
	private int id;
	private String product_name;
	private int price;
	private Timestamp register_date;
	private int company_id;
	
	private CompanyVO companyVO;

}

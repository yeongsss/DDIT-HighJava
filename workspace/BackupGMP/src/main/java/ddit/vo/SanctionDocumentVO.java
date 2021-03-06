package ddit.vo;

public class SanctionDocumentVO {
    private int san_no;
	private String san_nm;
	private String san_write_date;
	private String san_conf_date;
	private String san_content;
	private String san_deadline;
	private String san_status;
	
	public SanctionDocumentVO() {}

	public SanctionDocumentVO(int san_no, String sen_nm, String san_write_date, String san_conf_date,
			String san_content, String san_deadline, String san_status) {
		this.san_no = san_no;
		this.san_nm = sen_nm;
		this.san_write_date = san_write_date;
		this.san_conf_date = san_conf_date;
		this.san_content = san_content;
		this.san_deadline = san_deadline;
		this.san_status = san_status;
	}

	public int getSan_no() {
		return san_no;
	}

	public void setSan_no(int san_no) {
		this.san_no = san_no;
	}

	public String getSen_nm() {
		return san_nm;
	}

	public void setSen_nm(String sen_nm) {
		this.san_nm = sen_nm;
	}

	public String getSan_write_date() {
		return san_write_date;
	}

	public void setSan_write_date(String san_write_date) {
		this.san_write_date = san_write_date;
	}

	public String getSan_conf_date() {
		return san_conf_date;
	}

	public void setSan_conf_date(String san_conf_date) {
		this.san_conf_date = san_conf_date;
	}

	public String getSan_content() {
		return san_content;
	}

	public void setSan_content(String san_content) {
		this.san_content = san_content;
	}

	public String getSan_deadline() {
		return san_deadline;
	}

	public void setSan_deadline(String san_deadline) {
		this.san_deadline = san_deadline;
	}

	public String getSan_status() {
		return san_status;
	}

	public void setSan_status(String san_status) {
		this.san_status = san_status;
	}

	@Override
	public String toString() {
		return "SanctionDocumentVO [san_no=" + san_no + ", san_nm=" + san_nm + ", san_write_date=" + san_write_date
				+ ", san_conf_date=" + san_conf_date + ", san_content=" + san_content + ", san_deadline=" + san_deadline
				+ ", san_status=" + san_status + "]";
	}
	
}

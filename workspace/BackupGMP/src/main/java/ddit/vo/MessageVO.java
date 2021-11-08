package ddit.vo;

public class MessageVO {

	private int mes_idx;
	private int chat_no;
	private int mem_no;
	private String chat_content;
	private String chat_time;
	
	public MessageVO() {}

	public MessageVO(int mes_idx, int chat_no, int mem_no, String chat_content, String chat_time) {
		this.mes_idx = mes_idx;
		this.chat_no = chat_no;
		this.mem_no = mem_no;
		this.chat_content = chat_content;
		this.chat_time = chat_time;
	}

	public int getMes_idx() {
		return mes_idx;
	}

	public void setMes_idx(int mes_idx) {
		this.mes_idx = mes_idx;
	}

	public int getChat_no() {
		return chat_no;
	}

	public void setChat_no(int chat_no) {
		this.chat_no = chat_no;
	}

	public int getMem_no() {
		return mem_no;
	}

	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}

	public String getChat_content() {
		return chat_content;
	}

	public void setChat_content(String chat_content) {
		this.chat_content = chat_content;
	}

	public String getChat_time() {
		return chat_time;
	}

	public void setChat_time(String chat_time) {
		this.chat_time = chat_time;
	}

	@Override
	public String toString() {
		return "MessageVO [mes_idx=" + mes_idx + ", chat_no=" + chat_no + ", mem_no=" + mem_no + ", chat_content="
				+ chat_content + ", chat_time=" + chat_time + "]";
	}

}
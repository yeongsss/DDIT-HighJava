package ddit.vo;

public class BoardCommentVO {

	private int comm_no;
	private int board_no;
	private int mem_no;
	private String comm_content;
	private String comm_time;
	private String mem_nm;
	
	public BoardCommentVO() {}

	public BoardCommentVO(int comm_no, int board_no, int mem_no, String comm_content, String comm_time, String mem_nm) {
		this.comm_no = comm_no;
		this.board_no = board_no;
		this.mem_no = mem_no;
		this.comm_content = comm_content;
		this.comm_time = comm_time;
		this.mem_nm = mem_nm;
	}

	public int getComm_no() {
		return comm_no;
	}

	public void setComm_no(int comm_no) {
		this.comm_no = comm_no;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public int getMem_no() {
		return mem_no;
	}

	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}

	public String getComm_content() {
		return comm_content;
	}

	public void setComm_content(String comm_content) {
		this.comm_content = comm_content;
	}

	public String getComm_time() {
		return comm_time;
	}

	public void setComm_time(String comm_time) {
		this.comm_time = comm_time;
	}

	public String getMem_nm() {
		return mem_nm;
	}

	public void setMem_nm(String mem_nm) {
		this.mem_nm = mem_nm;
	}

	@Override
	public String toString() {
		return "BoardCommentVO [comm_no=" + comm_no + ", board_no=" + board_no + ", mem_no=" + mem_no
				+ ", comm_content=" + comm_content + ", comm_time=" + comm_time + ", mem_nm=" + mem_nm + "]";
	}

}
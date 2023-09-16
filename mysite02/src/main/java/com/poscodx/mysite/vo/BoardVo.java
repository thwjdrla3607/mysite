package com.poscodx.mysite.vo;

public class BoardVo {
	private int no;				// 게시글 번호
	private String title;		// 게시글 제목
	private String contents;	// 게시글 내용
	private int hit;			// 조회수
	private String regDate;		// 등록일자
	private int groupNo;		// 게시글 그룹 번호
	private int orderNo;		// 게시글 순서
	private int depth;			// 게시글 깊이
	private int userNo;			// 작성자 no
	private String userName;	// 게시글 작성자 이름 (join으로 받아오기)
	
	public BoardVo(int no, String title, String contents, int hit, 
			String regDate, int groupNo, int orderNo, int depth, 
			int userNo, String userName) {
		this.no = no;
		this.title = title;
		this.contents = contents;
		this.hit = hit;
		this.regDate = regDate;
		this.groupNo = groupNo;
		this.orderNo = orderNo;
		this.depth = depth;
		this.userNo = userNo;
		this.userName = userName;
	}
	
	public BoardVo() {
	}
	
	public BoardVo(int groupNo, int orderNo, int depth) {
		super();
		this.groupNo = groupNo;
		this.orderNo = orderNo;
		this.depth = depth;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public int getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", title=" + title + ", contents=" + contents + ", hit=" + hit + ", regDate="
				+ regDate + ", groupNo=" + groupNo + ", orderNo=" + orderNo + ", depth=" + depth + ", userNo=" + userNo
				+ ", userName=" + userName + "]";
	}
		
}

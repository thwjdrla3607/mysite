package com.poscodx.mysite.web.mvc.board;

public class PageInfo {
	int curNo;
	int begin;
	int end;
	boolean hasPrev;
	boolean hasNext;

	public PageInfo(int curNo, int maxPageNo, int window) {
		this.curNo = curNo;
		this.begin = (curNo/window) + 1;
		this.end = this.begin + window;
		this.end = this.end > maxPageNo ? maxPageNo : this.end;
		this.hasPrev = (this.curNo != 1);
		this.hasNext = (this.curNo != maxPageNo);
	}

	public int getCurNo() {
		return curNo;
	}

	public void setCurNo(int curNo) {
		this.curNo = curNo;
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public boolean isHasPrev() {
		return hasPrev;
	}

	public void setHasPrev(boolean hasPrev) {
		this.hasPrev = hasPrev;
	}

	public boolean isHasNext() {
		return hasNext;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

	@Override
	public String toString() {
		return "PageInfo [begin=" + begin + ", end=" + end + ", hasPrev=" + hasPrev + ", hasNext=" + hasNext + "]";
	}
}

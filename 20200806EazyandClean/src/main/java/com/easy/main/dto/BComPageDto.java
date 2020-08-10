package com.easy.main.dto;

public class BComPageDto {
	
	private int pageCoDataCount;//한 목록화면에 보여줄 게시글 수
	private int currentCoPageNum;//현재 선택된 페이지 번호
	private int totalCoDataCount;//전체 데이터 개수
	private int pageCoSize;//한 화면에 보여줄 페이지 개수
	//<< < 1 2 3 4 5 6 7 8 9 10 > >>
	//
	private int firstCoPageNum;//전체 페이지의 첫번째 페이지 번호
	private int lastCoPageNum; //전체 페이지의 마지막 페이지 번호
	private int prevCoPageNum;//이전 페이지 번호
	private int nextCoPageNum;//다음 페이지 
	private int startCoPageNum;//페이징의 시작 페이지 번호
	private int endCoPageNum;//페이징의 마지막 페이지 번호
	
	public BComPageDto() {
		
	}
	
	public void makeCoPage(int pageCo, int pageCoDataCount, int totalCoDataCount) {
		if(totalCoDataCount == 0) {
			return;
		}
		this.totalCoDataCount = totalCoDataCount;
		this.currentCoPageNum = pageCo;
		this.pageCoDataCount = pageCoDataCount;
		this.pageCoSize = 10;
		this.firstCoPageNum = 1;
		this.lastCoPageNum = (totalCoDataCount - 1)/pageCoDataCount+1;
		
		this.startCoPageNum = ((this.currentCoPageNum-1)/this.pageCoSize)*10+1;
		this.endCoPageNum = this.startCoPageNum+9;
		
		if(this.endCoPageNum>this.lastCoPageNum) {
			this.endCoPageNum = this.lastCoPageNum;
		}
		this.prevCoPageNum = this.startCoPageNum-this.pageCoSize;
		if(this.prevCoPageNum < 1) {
			prevCoPageNum = 1;
		}
		this.nextCoPageNum = this.endCoPageNum+this.pageCoSize;
		if(this.nextCoPageNum>this.lastCoPageNum) {
			this.nextCoPageNum = this.lastCoPageNum;
		}
		
		System.out.println("makeCoPage : "+this.startCoPageNum+", "+this.endCoPageNum);
	}
	
	
	public int getPageCoDataCount() {
		return pageCoDataCount;
	}

	public void setPageCoDataCount(int pageCoDataCount) {
		this.pageCoDataCount = pageCoDataCount;
	}

	public int getCurrentCoPageNum() {
		return currentCoPageNum;
	}

	public void setCurrentCoPageNum(int currentCoPageNum) {
		this.currentCoPageNum = currentCoPageNum;
	}

	public int getTotalCoDataCount() {
		return totalCoDataCount;
	}

	public void setTotalCoDataCount(int totalCoDataCount) {
		this.totalCoDataCount = totalCoDataCount;
	}

	public int getPageCoSize() {
		return pageCoSize;
	}

	public void setPageCoSize(int copageSize) {
		pageCoSize = copageSize;
	}

	public int getFirstCoPageNum() {
		return firstCoPageNum;
	}

	public void setFirstCoPageNum(int firstCoPageNum) {
		this.firstCoPageNum = firstCoPageNum;
	}

	public int getLastCoPageNum() {
		return lastCoPageNum;
	}

	public void setLastCoPageNum(int lastCoPageNum) {
		this.lastCoPageNum = lastCoPageNum;
	}

	public int getPrevCoPageNum() {
		return prevCoPageNum;
	}

	public void setPrevCoPageNum(int prevCoPageNum) {
		this.prevCoPageNum = prevCoPageNum;
	}

	public int getNextCoPageNum() {
		return nextCoPageNum;
	}

	public void setNextCoPageNum(int nextCoPageNum) {
		this.nextCoPageNum = nextCoPageNum;
	}

	public int getStartCoPageNum() {
		return startCoPageNum;
	}

	public void setStartCoPageNum(int startCoPageNum) {
		this.startCoPageNum = startCoPageNum;
	}

	public int getEndCoPageNum() {
		return endCoPageNum;
	}

	public void setEndCoPageNum(int endCoPageNum) {
		this.endCoPageNum = endCoPageNum;
	}

	
}

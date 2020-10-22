package com.maggie.s4.util;

public class Pager {
	private Integer curPage;
	
	private int perPage, perBlock;
	// makeRow에서 계산
	private long startRow, lastRow;
	
	// QnaDAO.qnaCount로 DB에서 표시할 전체 row 수를 구해 직접 set하기
	private long totalCount;

	// search
	private String kind;
	private String search;
	
	// jsp에서 사용
	private int startPage, lastPage;
	private boolean nextCheck, prevCheck;	
	

	public Pager() {
		this.perPage = 10;
		this.perBlock = 5;
	}

	// startRow, lastRow 계산 메서드
	public void makeRow() {
		startRow = ((this.getCurPage() - 1)*this.getPerPage() + 1);
		lastRow = this.getCurPage()*this.getPerPage();
	}

	// 페이징 계산
	public void makePage() {
		// 전체 페이지 개수 구하기
		long totalPage = this.getTotalCount()/this.getPerPage();
		if(this.getTotalCount()%this.getPerPage() > 0) {
			totalPage += 1;
		}
		
		// 전체 블록의 개수 구하기(to display)
		long totalBlock = totalPage/5;
		
		if(totalPage%this.perBlock > 0) {
			totalBlock += 1;
		}
		
		// curPage를 이용해 현재 블럭 번호 찾기
		long curBlock = this.curPage/this.perBlock;
		if(this.getCurPage()%this.perBlock > 0) {
			curBlock += 1;
		}
		
		// curBlock으로 시작, 끝 페이지 번호 계산
		this.startPage = (int) ((curBlock-1)*this.perBlock + 1);
		this.lastPage = (int) (curBlock*this.perBlock);
		if(this.lastPage > totalPage) {
			this.lastPage = (int) totalPage;
		}		
		if(this.startPage < 1) {
			this.startPage = 1;
		}
		
		// nextCheck: 현 블록이 마지막 블록이 아닌지 결정
		this.nextCheck = true;
		if(curBlock == totalBlock) {
			nextCheck = !nextCheck;
		}
		// prevCheck: 현 블록이 첫 블로이 아닌지 결정
		prevCheck = true;
		if(curBlock == 1) {
			prevCheck = !prevCheck;
		}
			
	}
	
	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSearch() {
		if(search == null) {
			search = "";
		}
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
	public Integer getCurPage() {
		if(curPage == null) {
			curPage = 1;
		}
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		if(curPage == null) {
			curPage = 1;
		}
		this.curPage = curPage;
	}	
		
		public int getPerBlock() {
		return perBlock;
	}

	public void setPerBlock(int perBlock) {
		this.perBlock = perBlock;
	}



	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public boolean isNextCheck() {
		return nextCheck;
	}

	public void setNextCheck(boolean nextCheck) {
		this.nextCheck = nextCheck;
	}

	public boolean isPrevCheck() {
		return prevCheck;
	}

	public void setPrevCheck(boolean prevCheck) {
		this.prevCheck = prevCheck;
	}

		public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	
	public long getStartRow() {
		return startRow;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		if(this.totalCount == 0) {
			this.totalCount = 1;
		}
		this.totalCount = totalCount;
	}

	public void setStartRow(long startRow) {
		this.startRow = startRow;
	}

	public long getLastRow() {
		return lastRow;
	}

	public void setLastRow(long lastRow) {
		this.lastRow = lastRow;
	}
	
}


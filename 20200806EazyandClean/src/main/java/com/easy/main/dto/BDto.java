package com.easy.main.dto;
import java.sql.Timestamp;

public class BDto {
	private int bId,bHit,bGroup,bStep,bIndent,memType;
	private String bName,bTitle,bContent,memID,bFile;

	private Timestamp bDate;
	
	
	public BDto() {}
	public BDto(int bId, int bHit, int bGroup, int bStep, int bIndent, String bName, String bTitle, String bContent,
			Timestamp bDate, String memID, int memType, String bFile) {
		super();
		this.bId = bId;
		this.bHit = bHit;
		this.bGroup = bGroup;
		this.bStep = bStep;
		this.bIndent = bIndent;
		this.bName = bName;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bDate = bDate;
		this.memID = memID;
		this.memType = memType;
		this.bFile = bFile;
	}


	@Override
	public String toString() {
		return "BDto [bId=" + bId + ", bHit=" + bHit + ", bGroup=" + bGroup + ", bStep=" + bStep + ", bIndent="
				+ bIndent + ", memType=" + memType + ", bName=" + bName + ", bTitle=" + bTitle + ", bContent="
				+ bContent + ", memID=" + memID + ", bFile=" + bFile + ", bDate=" + bDate + "]";
	}
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	public int getbHit() {
		return bHit;
	}
	public void setbHit(int bHit) {
		this.bHit = bHit;
	}
	public int getbGroup() {
		return bGroup;
	}
	public void setbGroup(int bGroup) {
		this.bGroup = bGroup;
	}
	public int getbStep() {
		return bStep;
	}
	public void setbStep(int bStep) {
		this.bStep = bStep;
	}
	public int getbIndent() {
		return bIndent;
	}
	public void setbIndent(int bIndent) {
		this.bIndent = bIndent;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	public Timestamp getbDate() {
		return bDate;
	}
	public void setbDate(Timestamp bDate) {
		this.bDate = bDate;
	}
	public int getMemType() {
		return memType;
	}
	public void setMemType(int memType) {
		this.memType = memType;
	}
	public String getMemID() {
		return memID;
	}
	public void setMemID(String memID) {
		this.memID = memID;
	}
	public String getbFile() {
		return bFile;
	}
	public void setbFile(String bFile) {
		this.bFile = bFile;
	}
}

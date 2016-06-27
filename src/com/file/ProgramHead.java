package com.file;

/**
 * 节目头部实体
 * @author yf
 * 2015-6-24
 *
 */
public class ProgramHead {

	private byte informationPartition;//信息分割符号
	
	private byte dataHeadType;//数据头类型参数
	
	private byte programNumber;//节目编号
	
	private byte programUpdateMark;//节目更新标志
	
	private byte contentTotal;//内容项总数
	
	private byte notificationCapabilities;//提示功能
	
	private byte serviceClassification;//服务分类
	
	private byte[] figureColumnNumber;//图幅列编号
	
	private byte[] figureLineNumber;//图幅行编号

	public byte getInformationPartition() {
		return informationPartition;
	}

	public void setInformationPartition(byte informationPartition) {
		this.informationPartition = informationPartition;
	}

	public byte getDataHeadType() {
		return dataHeadType;
	}

	public void setDataHeadType(byte dataHeadType) {
		this.dataHeadType = dataHeadType;
	}

	public byte getProgramNumber() {
		return programNumber;
	}

	public void setProgramNumber(byte programNumber) {
		this.programNumber = programNumber;
	}

	public byte getProgramUpdateMark() {
		return programUpdateMark;
	}

	public void setProgramUpdateMark(byte programUpdateMark) {
		this.programUpdateMark = programUpdateMark;
	}

	public byte getContentTotal() {
		return contentTotal;
	}

	public void setContentTotal(byte contentTotal) {
		this.contentTotal = contentTotal;
	}

	public byte getNotificationCapabilities() {
		return notificationCapabilities;
	}

	public void setNotificationCapabilities(byte notificationCapabilities) {
		this.notificationCapabilities = notificationCapabilities;
	}

	public byte getServiceClassification() {
		return serviceClassification;
	}

	public void setServiceClassification(byte serviceClassification) {
		this.serviceClassification = serviceClassification;
	}

	public byte[] getFigureColumnNumber() {
		return figureColumnNumber;
	}

	public void setFigureColumnNumber(byte[] figureColumnNumber) {
		this.figureColumnNumber = figureColumnNumber;
	}

	public byte[] getFigureLineNumber() {
		return figureLineNumber;
	}

	public void setFigureLineNumber(byte[] figureLineNumber) {
		this.figureLineNumber = figureLineNumber;
	}

	
}

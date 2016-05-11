package com.uis.connector.ws.pojo;

import org.apache.commons.lang.StringEscapeUtils;

import com.uis.connector.entity.Series;

public class SeriesPojo {

	private long seriesId;
	private long modelId;
	private String series;
	
	public SeriesPojo(Series series){
		this.seriesId = series.getSerial();
		this.modelId = series.getModelId();
		this.series = StringEscapeUtils.escapeSql(series.getSeries());
	}

	public long getSeriesId() {
		return seriesId;
	}

	public void setSeriesId(long seriesId) {
		this.seriesId = seriesId;
	}

	public long getModelId() {
		return modelId;
	}

	public void setModelId(long modelId) {
		this.modelId = modelId;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

}

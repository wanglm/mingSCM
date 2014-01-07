package com.taglib;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

import com.util.Dates;

/**
 * 日期转换自定义标签处理类
 * 
 * @author ming
 * 
 */
public class DataFormatTag extends TagSupport {
	private static final long serialVersionUID = -7544625607069499873L;
	protected Long value; // 'value' attribute
	protected String type; // 'type' attribute
	protected String pattern; // 'pattern' attribute

	// Constructor and initialization
	public DataFormatTag() {
		super();
		init();
	}

	private void init() {
		type = null;
		pattern = null;
		value = null;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	/*
	 * Formats the given date and time.
	 */
	public int doEndTag() throws JspException {
		String formatted = (value != null && value.compareTo(0L) > 0) ? Dates
				.format(new Date(value),
						pattern != null ? new SimpleDateFormat(pattern)
								: new SimpleDateFormat("yyyyMMdd")) : "";
		try {
			pageContext.getOut().print(formatted);
		} catch (IOException ioe) {
			throw new JspTagException(ioe.toString(), ioe);
		}
		return EVAL_PAGE;
	}

	// Releases any resources we may have (or inherit)
	public void release() {
		init();
	}
}

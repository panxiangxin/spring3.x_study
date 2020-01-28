package com.baobaotao.oxm.xstream.converters;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * @author pxx
 * Date 2020/1/28 16:06
 * @Description
 */
public class DateConverter implements Converter {
	private Locale locale;
	
	public DateConverter(Locale locale) {
		this.locale = locale;
	}
	
	public void marshal(Object o, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DATE_FIELD, this.locale);
		hierarchicalStreamWriter.setValue(dateFormat.format(o));
	}
	
	public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
		GregorianCalendar calendar = new GregorianCalendar();
		DateFormat format = DateFormat.getDateInstance(DateFormat.DATE_FIELD, this.locale);
		
		try {
			calendar.setTime(format.parse(hierarchicalStreamReader.getValue()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return calendar.getGregorianChange();
	}
	
	public boolean canConvert(Class aClass) {
		return Date.class.isAssignableFrom(aClass);
	}
}

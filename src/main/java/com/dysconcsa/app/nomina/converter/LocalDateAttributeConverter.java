package com.dysconcsa.app.nomina.converter;

import javax.persistence.AttributeConverter;
import java.sql.Date;
import java.time.LocalDate;

//@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date> {

	@Override
	public Date convertToDatabaseColumn(LocalDate locDate) {
		System.out.println(locDate);
		return locDate == null ? null : Date.valueOf(locDate);
	}

	@Override
	public LocalDate convertToEntityAttribute(Date sqlDate) {
		System.out.println(sqlDate);
		return sqlDate == null ? null : sqlDate.toLocalDate();
	}
}
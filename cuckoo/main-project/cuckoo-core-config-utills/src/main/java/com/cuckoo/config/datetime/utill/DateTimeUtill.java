package com.cuckoo.config.datetime.utill;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateTimeUtill {
	
	public static Timestamp getCurrentSqlTimeStamp(String provideZoneID) {
		return Timestamp.valueOf(getCurrentLocalDateTime(provideZoneID));
	}

	private static LocalDateTime getCurrentLocalDateTime(String provideZoneID) {
		return getCurrentZoneDateTime(provideZoneID).toLocalDateTime();
	}

	private static ZonedDateTime getCurrentZoneDateTime(String provideZoneID) {
		return ZonedDateTime.now(ZoneId.of(provideZoneID));
	}

	public static Timestamp getAuthExpireTime(String expireTime, Timestamp currentTime) {
		return Timestamp.from(currentTime.toInstant().plus(Duration.ofMinutes(Long.valueOf(expireTime))));
	}
}

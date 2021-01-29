package data;

import java.sql.Date;

public class SwimmingWorkout extends Workout
{
	int meterBreaststroke;
	int meterbutterfly;
	int meterCrowl;
	int meterback;
	
public SwimmingWorkout(Date date, int duration, int meterBreaststroke, int meterbutterfly, int meterCrowl,
		int meterback) {
	super(date, duration);
	this.meterBreaststroke = meterBreaststroke;
	this.meterbutterfly = meterbutterfly;
	this.meterCrowl = meterCrowl;
	this.meterback = meterback;
}
public int getMeterBreaststroke() {
	return meterBreaststroke;
}
public void setMeterBreaststroke(int meterBreaststroke) {
	this.meterBreaststroke = meterBreaststroke;
}
public int getMeterbutterfly() {
	return meterbutterfly;
}
public void setMeterbutterfly(int meterbutterfly) {
	this.meterbutterfly = meterbutterfly;
}
public int getMeterCrowl() {
	return meterCrowl;
}
public void setMeterCrowl(int meterCrowl) {
	this.meterCrowl = meterCrowl;
}
public int getMeterback() {
	return meterback;
}
public void setMeterback(int meterback) {
	this.meterback = meterback;
}


}

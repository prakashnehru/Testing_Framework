package core.datatypes;

import core.Log;
import core.web.WebItem;
import org.openqa.selenium.By;

public class Slider extends WebItem {

	WebItem sliderInput;

	public Slider(By byID, By byIDInput) {
		super(byID);
		sliderInput = new WebItem(byIDInput);
	}
	
	public int getValue() {
		return Integer.parseInt(sliderInput.getText());
	}
	
	public void changeSliderByOffset(int offset) {
		sliderInput.dragAndDropBy(Math.round(getOffsetRatio() * offset), 0);
		Log.info("Slider changed by offset [offset = " + offset + "].");
	}
	
	public void changeSliderTo(int value) {
		changeSliderByOffset(value - getValue());
	}
	
	public void changeSliderTo(String value) {
		try {
			changeSliderTo(Integer.parseInt(value));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
	
	private float getOffsetRatio() {
		return (float) getSize().width / 100;
	}

}

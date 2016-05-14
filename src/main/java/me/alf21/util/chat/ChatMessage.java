/**
 * 
 */
package me.alf21.util.chat;

import java.util.regex.Matcher;

import net.gtaun.shoebill.constant.TextDrawAlign;
import net.gtaun.shoebill.constant.TextDrawFont;
import net.gtaun.shoebill.data.Color;
import net.gtaun.shoebill.object.Destroyable;
import net.gtaun.shoebill.object.Player;
import net.gtaun.shoebill.object.PlayerTextdraw;
import net.gtaun.shoebill.object.Timer;

/**
 * @author Alf21
 *
 */
public class ChatMessage implements Destroyable{

	private PlayerTextdraw textdraw;
	private int slot, count;
	private Timer timer;
	private boolean sliding;
	private String text;
	private Player player;
	private Long time;
	private String[] slideInStrings, slideOutStrings;
	
	public ChatMessage(Player player, String text, int slot) {
		this.player = player;
		this.text = removeNonColorCodes(text.trim()).trim();
		this.slot = slot;
		this.count = 1;
		createTextdraw(0,0);
		if(getTextLength() > 0) {
			//initialize the string snippets to slide the text in
			slideInStrings = new String[getTextLength()];
			slideOutStrings = new String[slideInStrings.length-1];
			
			//calculate the string snippets
			int currentEndIndex = 0;
			for(int i=0; i<slideInStrings.length; i++) {
				currentEndIndex++;
				currentEndIndex = cutTextIn(currentEndIndex);
				slideInStrings[i] = text.substring(0, currentEndIndex);
			}
			currentEndIndex = text.length();
			for(int i=0; i<slideOutStrings.length; i++) {
				currentEndIndex--;
				currentEndIndex = cutTextOut(currentEndIndex);
				slideOutStrings[i] = text.substring(0, currentEndIndex);
			}
		}
		time = System.currentTimeMillis();
	}
	
	public void slideIn() {
		setSliding(true);
		reset();
		final int length = slideInStrings.length;
		final int interval = Chat.slideTime /length;
		timer = Timer.create(interval, length, (factualInterval) -> {
			hide();
			getTextdraw().setText(slideInStrings[count-1]);
			show();
			if(count == length) {
				setSliding(false);
				timer.stop();
			}
			count++;
		});
		timer.start();
	}
	
	public void slideOut() {
		setSliding(true);
		reset();
		final int length = slideOutStrings.length;
		final int interval = Chat.slideTime /length;
		timer = Timer.create(interval, length, (factualInterval) -> {
			hide();
			getTextdraw().setText(slideOutStrings[count-1]);
			show();
			if(count == length) {
				setSliding(false);
				timer.stop();
			}
			count++;
		});
		timer.start();
	}
	
	public void moveUp() {
		reset();
		final int maxCount = 15;
		final int interval = Chat.slideTime /maxCount;
		timer = Timer.create(interval, maxCount, (factualInterval) -> {
			hide();
			getTextdraw().destroy();
			createTextdraw(0, (float) -count*(15f/(float) maxCount));
			show();
			if(count == maxCount) {
				slot++;
				timer.stop();
			}
			count++;
		});
		timer.start();
	}
	
	public void hide() {
		textdraw.hide();
	}
	
	public void show() {
		textdraw.show();
	}
	
	private void reset() {
		if(timer != null)
			timer.destroy();
		count = 1;
	}
	
	private void createTextdraw(float x, float y) {
		textdraw = PlayerTextdraw.create(player, 630+x, 385-15*slot+y);
		textdraw.setText(text);
		textdraw.setAlignment(TextDrawAlign.RIGHT);
		textdraw.setBackgroundColor(Color.BLACK);
		textdraw.setFont(TextDrawFont.get(1));
		textdraw.setLetterSize(0.5f, 1);
		textdraw.setColor(Color.WHITE);
		textdraw.setOutlineSize(1);
		textdraw.setProportional(true);
		textdraw.setSelectable(false);
	}
	
	/**
	 * @return the sliding
	 */
	public boolean isSliding() {
		return sliding;
	}
	/**
	 * @param sliding the sliding to set
	 */
	private void setSliding(boolean sliding) {
		this.sliding = sliding;
	}
	
	/**
	 * @return the time when textdraw was created
	 */
	public Long getTime() {
		return time;
	}
	
	/**
	 * @return the textdraw
	 */
	public PlayerTextdraw getTextdraw() {
		return textdraw;
	}
	
	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/* (non-Javadoc)
	 * @see net.gtaun.shoebill.object.Destroyable#destroy()
	 */
	@Override
	public void destroy() {
		if(timer != null) {
			if(timer.isRunning())
				timer.stop();
			timer.destroy();
			timer = null;
		}
		if(textdraw != null) {
			textdraw.hide();
			textdraw.destroy();
			textdraw = null;
		}
	}

	/* (non-Javadoc)
	 * @see net.gtaun.shoebill.object.Destroyable#isDestroyed()
	 */
	@Override
	public boolean isDestroyed() {
		return !(timer != null || textdraw != null);
	}
	
	private String removeNonColorCodes(String text) {
		final String prefixOfColorCodes = "COLOR";					//The prefix of any color code like "COLOR_RED" <- HERE>> if String == "": "_RED"
		final String connectionOfColorCodes = "\u005F";				//The connection label or Unicode, here: "\u005F" == "_" <- HERE>> if String == "": "COLORRED"
		String replaceStr = prefixOfColorCodes + connectionOfColorCodes;
    	text = text.replaceAll("\u007E" + "w" + "\u007E", replaceStr + "WHITE");
    	text = text.replaceAll("\u007E" + "r" + "\u007E", replaceStr + "RED");
    	text = text.replaceAll("\u007E" + "g" + "\u007E", replaceStr + "GREEN");
    	text = text.replaceAll("\u007E" + "b" + "\u007E", replaceStr + "DARK" + connectionOfColorCodes + "BLUE");
    	text = text.replaceAll("\u007E" + "y" + "\u007E", replaceStr + "YELLOW");
    	text = text.replaceAll("\u007E" + "p" + "\u007E", replaceStr + "PURPLE");
    	text = text.replaceAll("\u007E" + "l" + "\u007E", replaceStr + "BLACK");
    	text = text.replaceAll("\u007E" + "h" + "\u007E", replaceStr + "LIGHTER");
    	
    	text = text.replaceAll("\u007E+([\\w[\u003C\u003E&&[\\S]]]?)\u007E", ""); //replace unknown colors and Commands
       	text = text.replaceAll("\u007E", ""); //replace other "~"

    	text = text.replaceAll(replaceStr + "WHITE", "\u007E" + "w" + "\u007E");
    	text = text.replaceAll(replaceStr + "RED", "\u007E" + "r" + "\u007E");
    	text = text.replaceAll(replaceStr + "GREEN", "\u007E" + "g" + "\u007E");
    	text = text.replaceAll(replaceStr + "DARK" + connectionOfColorCodes + "BLUE", "\u007E" + "b" + "\u007E");
    	text = text.replaceAll(replaceStr + "YELLOW", "\u007E" + "y" + "\u007E");
    	text = text.replaceAll(replaceStr + "PURPLE", "\u007E" + "p" + "\u007E");
    	text = text.replaceAll(replaceStr + "BLACK", "\u007E" + "l" + "\u007E");
    	text = text.replaceAll(replaceStr + "LIGHTER", "\u007E" + "h" + "\u007E");
    	return text;
	}

	
	private int cutTextIn(int endIndex) {
		int currentEndIndex = endIndex;
		String string = text.substring(0, currentEndIndex);
    	while(string.trim().length() < string.length()){
    		currentEndIndex++;
    		string = text.substring(0, currentEndIndex);
    	}
		
		//check whether string contains color codes
		Matcher matcher = Chat.colorStringPattern.matcher(text);
        if(matcher.find()) {
        	int matcherState;
	        matcher = Chat.colorStringEndPattern.matcher(string);
	        Matcher matcher2 = Chat.wrongColorStringPattern.matcher(string);
	        if(matcher.find() && !matcher2.find()) {
	        	matcher = Chat.colorStringEndPattern.matcher(string); //update the matcher
	        	matcherState = 3;
	        }
	        else {
		        matcher = Chat.tildeLetterPattern.matcher(string);
		        if(matcher.find()) {
		        	matcher = Chat.tildeLetterPattern.matcher(string); //update the matcher
		        	matcherState = 4;
		        }
		        else {
			        matcher = Chat.tildePattern.matcher(string); //update the matcher
			        matcherState = 5;
		        }
	        }
	        while(matcher.find()) {
	        	//also check whether color code is after this color code
	        	if(currentEndIndex+matcherState <= text.length()) {
	        		currentEndIndex += matcherState;
	        		
		        	string = text.substring(0, currentEndIndex);
			    	while(string.trim().length() < string.length()){
			    		currentEndIndex++;
			    		string = text.substring(0, currentEndIndex);
			    	}
			    	
		        	matcher = Chat.colorStringEndPattern.matcher(string); //update the matcher
		        	if(!matcher.find()) {
			    		currentEndIndex -= 2;
		        	}
		        	else 
		        		matcher = Chat.colorStringEndPattern.matcher(string); //update the matcher
		        	matcherState = 3;
		        }
	        }

        	string = text.substring(0, currentEndIndex);
	    	while(string.trim().length() < string.length()){
	    		currentEndIndex++;
	    		string = text.substring(0, currentEndIndex);
	    	}
	    	
	    	matcher2 = Chat.tildePattern.matcher(string);
    		if(matcher2.find()) {
    			if(currentEndIndex+3 <= text.length())
    				currentEndIndex += 3;
    		}
        }
		return currentEndIndex;
	}
	
	private int cutTextOut(int endIndex) {
		int currentEndIndex = endIndex;
		String string = text.substring(0, currentEndIndex);
    	while(string.trim().length() < string.length()){
    		currentEndIndex--;
    		string = text.substring(0, currentEndIndex);
    	}
		
		//check whether string contains color codes
		Matcher matcher = Chat.colorStringPattern.matcher(text);
        if(matcher.find()) {
        	int matcherState;
	        matcher = Chat.colorStringEndPattern.matcher(string);
	        if(matcher.find()) {
	        	matcher = Chat.colorStringEndPattern.matcher(string); //update the matcher
	        	matcherState = 3;
	        }
	        else {
		        matcher = Chat.tildeLetterPattern.matcher(string);
		        if(text.length() >= currentEndIndex+1) {
			        String string2 = text.substring(0, currentEndIndex+1);
			        Matcher matcher2 = Chat.colorStringEndPattern.matcher(string2);
			        if(matcher.find() && matcher2.find()) {
			        	matcher = Chat.tildeLetterPattern.matcher(string); //update the matcher
			        	matcherState = 2;
			        }
			        else {
				        matcher = Chat.tildePattern.matcher(string); //update the matcher
				        matcherState = 1;
			        }
		        }
		        else {
			        matcher = Chat.tildePattern.matcher(string); //update the matcher
			        matcherState = 1;
		        }
	        }
	        while(matcher.find()) {
	        	//also check whether color code is before this color code
	        	if(currentEndIndex-matcherState > 0) {
	        		currentEndIndex -= matcherState;
		        	string = text.substring(0, currentEndIndex);
			    	while(string.trim().length() < string.length()){
			    		currentEndIndex--;
			    		string = text.substring(0, currentEndIndex);
			    	}
			    	
		        	matcher = Chat.colorStringEndPattern.matcher(string); //update the matcher
		        	matcherState = 3;
	        	}
	        }

        	string = text.substring(0, currentEndIndex);
	    	while(string.trim().length() < string.length()){
	    		currentEndIndex--;
	    		string = text.substring(0, currentEndIndex);
	    	}
        }
		return currentEndIndex;
	}
	
	private int getTextLength() {
		int length = text.replace(" ", "").length();
		Matcher matcher = Chat.colorStringPattern.matcher(text);
        while(matcher.find()) {
        	length -= 3;
        }
		return length;
	}

}

package me.alf21.util;

import java.util.ArrayList;

import net.gtaun.shoebill.Shoebill;
import net.gtaun.shoebill.constant.TextDrawAlign;
import net.gtaun.shoebill.constant.TextDrawFont;
import net.gtaun.shoebill.data.Color;
import net.gtaun.shoebill.object.Destroyable;
import net.gtaun.shoebill.object.Player;
import net.gtaun.shoebill.object.PlayerTextdraw;
import net.gtaun.shoebill.object.Timer;

/**
 * @author Alf21
 * create some styled GameTexts with timer effects visible as bar width increasing and transitions
 */
public class GameTextTD implements Destroyable {
	//TODO add String as Countdown ((int) milliseconds/updateDuration - count) at the right top corner [00:15])
	
	//delay between each animation update
	private final static int updateDelay = 50;
	
	//to calculate transition
	private static Color 	backgroundColor = new Color(255,0,0,60),
							textColor = new Color(255,255,255,255),
							textBackgroundColor = new Color(0,0,0,255),
							barColor = new Color(255,255,255,255),
							barBackgroundColor = new Color(0,0,0,150);
	
	private PlayerTextdraw 	textTD,
							backgroundTD,
							topBarTD,
							bottomBarTD,
							topBarBackgroundTD,
							bottomBarBackgroundTD;
	
	private boolean 	destroyable,
						hided,
						useAnimation,
						useTransition;

	private int 	count,
					milliseconds,
					transitionMilliseconds;
	
	private Player player;
	private Timer timer;
	
	/**
	 * create static GameTextTD Class without timer
	 * @param player the target
	 * @param text the text of TextDraw
	 */
	public GameTextTD(Player player, String text) {
		this.player = player;
		destroyable = false;
		hided = false;
		milliseconds = -1;
		useAnimation = false;
		transitionMilliseconds = 500;
		useTransition = false;
		createGameTextTD(text);
	}
	
	/**
	 * create GameTextTD Class with timer to disappear TextDraw Construction after the specified duration
	 * @param player the target
	 * @param text the text of TextDraw
	 * @param milliseconds the duration (MUST be bigger than the updateDelay!)
	 * @param useAnimation the use of animation
	 */
	public GameTextTD(Player player, String text, int milliseconds, boolean useAnimation) {
		this(player, text);
		this.milliseconds = milliseconds;
		this.useAnimation = useAnimation;
		if(milliseconds >= updateDelay)
			initializeTimer();
	}
	
	/**
	 * create GameTextTD Class with timer to disappear TextDraw Construction after the specified duration and transition
	 * @param player the target
	 * @param text the text of TextDraw
	 * @param milliseconds the duration (MUST be bigger than the updateDelay!)
	 * @param useAnimation the use of animation
	 * @param useTransition the use of transition (alpha color effects)
	 */
	public GameTextTD(Player player, String text, int milliseconds, boolean useAnimation, boolean useTransition) {
		this(player, text);
		this.milliseconds = milliseconds;
		this.useAnimation = useAnimation;
		this.useTransition = useTransition;
		if(milliseconds >= updateDelay)
			initializeTimer();
	}
	
	/**
	 * create GameTextTD Class with timer to disappear TextDraw Construction after the specified duration with specified transition delay
	 * @param player the target
	 * @param text the text of TextDraw
	 * @param milliseconds the duration (MUST be bigger than the updateDelay!)
	 * @param useAnimation the use of animation
	 * @param transitionMilliseconds the milliseconds of transition (IMPORTANT! need to be bigger than the half of milliseconds)
	 */
	public GameTextTD(Player player, String text, int milliseconds, boolean useAnimation, int transitionMilliseconds) {
		this(player, text);
		this.milliseconds = milliseconds;
		this.useAnimation = useAnimation;
		this.transitionMilliseconds = transitionMilliseconds;
		this.useTransition = true;
		if(milliseconds >= updateDelay && milliseconds/2 >= transitionMilliseconds)
			initializeTimer();
	}
	
	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}
	
	/**
	 * to stop, resume or modify the timer / animation
	 * @return the timer
	 */
	public Timer getTimer() {
		return timer;
	}
	
	/**
	 * to modify the text
	 * @return the TextDraw
	 */
	public PlayerTextdraw getTextdraw() {
		return textTD;
	}
	
	/**
	 * to modify the background
	 * @return the backgroundTD
	 */
	public PlayerTextdraw getBackgroundTextdraw() {
		return backgroundTD;
	}
	
	/**
	 * to modify the bar TextDraws
	 * @return the barTextdraws an ArrayList of TextDraws
	 */
	public ArrayList<PlayerTextdraw> getBarTextdraws() {
		ArrayList<PlayerTextdraw> barTextdraws = new ArrayList<>();
		barTextdraws.add(topBarTD);
		barTextdraws.add(bottomBarTD);
		return barTextdraws;
	}
	
	/**
	 * to modify the bar background TextDraws
	 * @return the barBackgroundTextdraws an ArrayList of TextDraws
	 */
	public ArrayList<PlayerTextdraw> getBarBackgroundTextdraws() {
		ArrayList<PlayerTextdraw> barBackgroundTextdraws = new ArrayList<>();
		barBackgroundTextdraws.add(topBarBackgroundTD);
		barBackgroundTextdraws.add(bottomBarBackgroundTD);
		return barBackgroundTextdraws;
	}
	
	/**
	 * @return the destroyable
	 */
	public boolean isDestroyable() {
		return destroyable;
	}
	
	/**
	 * @return the hided
	 */
	public boolean isHided() {
		return hided;
	}
	
//The functions
	/**
	 * hide TextDraw for player
	 */
	private void hide() {
		hided = true;
		textTD.hide();
		topBarTD.hide();
		bottomBarTD.hide();
		topBarBackgroundTD.hide();
		bottomBarBackgroundTD.hide();
		backgroundTD.hide();
	}
	
	/**
	 * hide TextDraw for player
	 * @param stopTimer stop background calculation of the animation
	 */
	public void hide(boolean stopTimer) {
		if(stopTimer && timer != null && timer.isRunning())
			timer.stop();
		hide();
	}
	
	/**
	 * show TextDraw for player
	 */
	public void show() {
		hided = false;
		backgroundTD.show();
		topBarBackgroundTD.show();
		bottomBarBackgroundTD.show();
		topBarTD.show();
		bottomBarTD.show();
		textTD.show();
		if(timer != null && timer.isDestroyed()) {
			reset();
			initializeTimer();
		}
		if(timer != null && !timer.isRunning()) {
			timer.start();
		}
	}
	
//Advanced timer functions
	/**
	 * initializes the Timer
	 */
	private void initializeTimer() {
		if(milliseconds > 0) {
			reset();
			timer = Timer.create(updateDelay, milliseconds /updateDelay, (factualInterval) -> Shoebill.get().runOnSampThread(() -> {
				if(useAnimation) {
					float factor = milliseconds /updateDelay;
					int transitionFactor = (int) factor;
					factor = (640-20) / factor;
					if(!hided) {
						topBarTD.hide();
						bottomBarTD.hide();

						if(useTransition) {
							int step = transitionMilliseconds /updateDelay;
							if(count <= step-1 || count == step || count >= transitionFactor-(step-2)) {
								textTD.hide();
								topBarBackgroundTD.hide();
								bottomBarBackgroundTD.hide();
								backgroundTD.hide();
								if(count <= step-1) {
									backgroundTD.setBoxColor(new Color(backgroundColor.getR(), backgroundColor.getG(), backgroundColor.getB(), backgroundColor.getA()*(count+1)/step));
									topBarBackgroundTD.setBoxColor(new Color(barBackgroundColor.getR(), barBackgroundColor.getG(), barBackgroundColor.getB(), barBackgroundColor.getA()*(count+1)/step));
									bottomBarBackgroundTD.setBoxColor(new Color(barBackgroundColor.getR(), barBackgroundColor.getG(), barBackgroundColor.getB(), barBackgroundColor.getA()*(count+1)/step));
									topBarTD.setBoxColor(new Color(barColor.getR(), barColor.getG(), barColor.getB(), barColor.getA()*(count+1)/step));
									bottomBarTD.setBoxColor(new Color(barColor.getR(), barColor.getG(), barColor.getB(), barColor.getA()*(count+1)/step));
									textTD.setBackgroundColor(new Color(textBackgroundColor.getR(), textBackgroundColor.getG(), textBackgroundColor.getB(), textBackgroundColor.getA()*(count+1)/step));
									textTD.setColor(new Color(textColor.getR(), textColor.getG(), textColor.getB(), textColor.getA()*(count+1)/step));
								}
								else if(count >= transitionFactor-(step-2)) {
									backgroundTD.setBoxColor(new Color(backgroundColor.getR(), backgroundColor.getG(), backgroundColor.getB(), backgroundColor.getA()*(transitionFactor+1-count)/step));
									topBarBackgroundTD.setBoxColor(new Color(barBackgroundColor.getR(), barBackgroundColor.getG(), barBackgroundColor.getB(), barBackgroundColor.getA()*(transitionFactor+1-count)/step));
									bottomBarBackgroundTD.setBoxColor(new Color(barBackgroundColor.getR(), barBackgroundColor.getG(), barBackgroundColor.getB(), barBackgroundColor.getA()*(transitionFactor+1-count)/step));
									topBarTD.setBoxColor(new Color(barColor.getR(), barColor.getG(), barColor.getB(), barColor.getA()*(transitionFactor+1-count)/step));
									bottomBarTD.setBoxColor(new Color(barColor.getR(), barColor.getG(), barColor.getB(), barColor.getA()*(transitionFactor+1-count)/step));
									textTD.setBackgroundColor(new Color(textBackgroundColor.getR(), textBackgroundColor.getG(), textBackgroundColor.getB(), textBackgroundColor.getA()*(transitionFactor+1-count)/step));
									textTD.setColor(new Color(textColor.getR(), textColor.getG(), textColor.getB(), textColor.getA()*(transitionFactor+1-count)/step));
								}
								else if(count == step) {
									backgroundTD.setBoxColor(backgroundColor);
									topBarBackgroundTD.setBoxColor(barBackgroundColor);
									bottomBarBackgroundTD.setBoxColor(barBackgroundColor);
									topBarTD.setBoxColor(barColor);
									bottomBarTD.setBoxColor(barColor);
									textTD.setBackgroundColor(textBackgroundColor);
									textTD.setColor(textColor);
								}
								backgroundTD.show();
								topBarBackgroundTD.show();
								bottomBarBackgroundTD.show();
								textTD.show();
							}
						}
						topBarTD.setTextSize(0, 20+count*factor);
						bottomBarTD.setTextSize(0, 20+count*factor);

						topBarTD.show();
						bottomBarTD.show();
					}
				}
				if(count == milliseconds /updateDelay) {
					reset();
					destroyable = true;
				}
				else count++;
			}));
		}
	}
	
	/**
	 * reset the data for timer 
	 */
	private void reset() {
		hide(false);
		count = 1;
		if(useAnimation) {
			if(useTransition) {
				int i = transitionMilliseconds /updateDelay;
				backgroundTD.setBoxColor(new Color(backgroundColor.getR(), backgroundColor.getG(), backgroundColor.getB(), backgroundColor.getA()/i));
				topBarBackgroundTD.setBoxColor(new Color(barBackgroundColor.getR(), barBackgroundColor.getG(), barBackgroundColor.getB(), barBackgroundColor.getA()/i));
				bottomBarBackgroundTD.setBoxColor(new Color(barBackgroundColor.getR(), barBackgroundColor.getG(), barBackgroundColor.getB(), barBackgroundColor.getA()/i));
				topBarTD.setBoxColor(new Color(barColor.getR(), barColor.getG(), barColor.getB(), barColor.getA()/i));
				bottomBarTD.setBoxColor(new Color(barColor.getR(), barColor.getG(), barColor.getB(), barColor.getA()/i));
				textTD.setBackgroundColor(new Color(textBackgroundColor.getR(), textBackgroundColor.getG(), textBackgroundColor.getB(), textBackgroundColor.getA()/i));
				textTD.setColor(new Color(textColor.getR(), textColor.getG(), textColor.getB(), textColor.getA()/i));
			}
			topBarTD.setTextSize(0, 20);
			bottomBarTD.setTextSize(0, 20);
		}
		destroyable = false;
	}
	
//The TextDraws
	/**
	 * create the textDraws
	 * @param text the text of TextDraw
	 */
	private void createGameTextTD(String text) {
		backgroundTD = PlayerTextdraw.create(player, 320, 177);
		backgroundTD.setText("_");
		backgroundTD.setAlignment(TextDrawAlign.CENTER);
		backgroundTD.setBackgroundColor(Color.BLACK);
		backgroundTD.setFont(TextDrawFont.get(1));
		backgroundTD.setLetterSize(0.5f, 9.7f);
		backgroundTD.setColor(Color.WHITE);
		backgroundTD.setOutlineSize(0);
		backgroundTD.setProportional(true);
		backgroundTD.setUseBox(true);
		backgroundTD.setBoxColor(backgroundColor);
		backgroundTD.setTextSize(0, 640);
		backgroundTD.setSelectable(false);
		
		topBarBackgroundTD = PlayerTextdraw.create(player, 320, 177);
		topBarBackgroundTD.setText("_");
		topBarBackgroundTD.setAlignment(TextDrawAlign.CENTER);
		topBarBackgroundTD.setBackgroundColor(Color.BLACK);
		topBarBackgroundTD.setFont(TextDrawFont.get(1));
		topBarBackgroundTD.setLetterSize(0.5f, -0.3f);
		topBarBackgroundTD.setColor(Color.WHITE);
		topBarBackgroundTD.setOutlineSize(0);
		topBarBackgroundTD.setProportional(true);
		topBarBackgroundTD.setUseBox(true);
		topBarBackgroundTD.setBoxColor(barBackgroundColor);
		topBarBackgroundTD.setTextSize(0, 640);
		topBarBackgroundTD.setSelectable(false);

		bottomBarBackgroundTD = PlayerTextdraw.create(player, 320, 267);
		bottomBarBackgroundTD.setText("_");
		bottomBarBackgroundTD.setAlignment(TextDrawAlign.CENTER);
		bottomBarBackgroundTD.setBackgroundColor(Color.BLACK);
		bottomBarBackgroundTD.setFont(TextDrawFont.get(1));
		bottomBarBackgroundTD.setLetterSize(0.5f, -0.3f);
		bottomBarBackgroundTD.setColor(Color.WHITE);
		bottomBarBackgroundTD.setOutlineSize(0);
		bottomBarBackgroundTD.setProportional(true);
		bottomBarBackgroundTD.setUseBox(true);
		bottomBarBackgroundTD.setBoxColor(barBackgroundColor);
		bottomBarBackgroundTD.setTextSize(0, 640);
		bottomBarBackgroundTD.setSelectable(false);
		
		topBarTD = PlayerTextdraw.create(player, 320, 177);
		topBarTD.setText("_");
		topBarTD.setAlignment(TextDrawAlign.CENTER);
		topBarTD.setBackgroundColor(Color.BLACK);
		topBarTD.setFont(TextDrawFont.get(1));
		topBarTD.setLetterSize(0.5f, -0.3f);
		topBarTD.setColor(Color.WHITE);
		topBarTD.setOutlineSize(0);
		topBarTD.setProportional(true);
		topBarTD.setUseBox(true);
		topBarTD.setBoxColor(barColor);
		topBarTD.setTextSize(0, 640);
		topBarTD.setSelectable(false);
		
		bottomBarTD = PlayerTextdraw.create(player, 320, 267);
		bottomBarTD.setText("_");
		bottomBarTD.setAlignment(TextDrawAlign.CENTER);
		bottomBarTD.setBackgroundColor(Color.BLACK);
		bottomBarTD.setFont(TextDrawFont.get(1));
		bottomBarTD.setLetterSize(0.5f, -0.3f);
		bottomBarTD.setColor(Color.WHITE);
		bottomBarTD.setOutlineSize(0);
		bottomBarTD.setProportional(true);
		bottomBarTD.setUseBox(true);
		bottomBarTD.setBoxColor(barColor);
		bottomBarTD.setTextSize(0, 640);
		bottomBarTD.setSelectable(false);
		
		textTD = PlayerTextdraw.create(player, 320, 214);
		textTD.setText(text);
		textTD.setAlignment(TextDrawAlign.CENTER);
		textTD.setBackgroundColor(textBackgroundColor);
		textTD.setFont(TextDrawFont.get(2));
		textTD.setLetterSize(0.56f, 1.4f);
		textTD.setColor(textColor);
		textTD.setOutlineSize(1);
		textTD.setProportional(true);
		textTD.setUseBox(true);
		textTD.setBoxColor(new Color(0,0,0,0));
		textTD.setTextSize(89, 620);
		textTD.setSelectable(false);
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
		
		hide();
		textTD.destroy();
		bottomBarTD.destroy();
		topBarTD.destroy();
		bottomBarBackgroundTD.destroy();
		topBarBackgroundTD.destroy();
		backgroundTD.destroy();
		textTD = bottomBarTD = topBarTD = backgroundTD = bottomBarBackgroundTD = topBarBackgroundTD = null;
	}
	
	/* (non-Javadoc)
	 * @see net.gtaun.shoebill.object.Destroyable#isDestroyed()
	 */
	@Override
	public boolean isDestroyed() {
		return !(textTD != null
				|| bottomBarTD != null
				|| topBarTD != null
				|| backgroundTD != null
				|| bottomBarBackgroundTD != null
				|| topBarBackgroundTD != null);
	}
}

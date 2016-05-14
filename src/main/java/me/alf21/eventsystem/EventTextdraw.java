/**
 * @author Alf21 on 18.12.2015 in project event-system.
 * Copyright (c) 2015 Alf21. All rights reserved.
 */

package me.alf21.eventsystem;

import javax.security.auth.Destroyable;

import net.gtaun.shoebill.constant.TextDrawAlign;
import net.gtaun.shoebill.constant.TextDrawFont;
import net.gtaun.shoebill.data.Color;
import net.gtaun.shoebill.object.Player;
import net.gtaun.shoebill.object.Textdraw;

public class EventTextdraw implements Destroyable {
	private int count;
	private Textdraw textdraw;
	private String type;
	private Textdraw scoreTextdraw;
	private Color color;
	public EventTextdraw(String text, int count, String type, int score) {
		this.count = count;
		this.type = type;
		color = new Color(218, 172, 5, 102);
		textdraw = createTextdraw(text);
		scoreTextdraw = createScoreTextdraw(String.valueOf(score));
	}
	
	public void move(int count) {
		this.count = count;
		String text = textdraw.getText();
		String score = scoreTextdraw.getText();
		destroy();
		this.textdraw = createTextdraw(text);
		this.scoreTextdraw = createScoreTextdraw(score);
	}
	
	public void show(Player player) {
		textdraw.show(player);
		scoreTextdraw.show(player);
	}
	public void hide(Player player) {
		textdraw.hide(player);
		scoreTextdraw.hide(player);
	}
	public void showForAll() {
		textdraw.showForAll();
		scoreTextdraw.showForAll();
	}
	public void hideForAll() {
		textdraw.hideForAll();
		scoreTextdraw.hideForAll();
	}
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
		if(textdraw != null) textdraw.setBoxColor(color);
		if(scoreTextdraw != null) scoreTextdraw.setBoxColor(new Color(color.getR(),color.getG(),color.getB(),color.getA()*2>255?255:color.getA()*2));
	}
	
	public int getCount() {
		return count;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public Textdraw getTextdraw() {
		return textdraw;
	}
	
	private Textdraw createTextdraw(String text) {
	/*
		Textdraw textdraw = Textdraw.create(79, 106+20*count);
		textdraw.setText(text);
		textdraw.setAlignment(TextDrawAlign.CENTER);
		textdraw.setBackgroundColor(new Color(0,0,0,0));
		textdraw.setFont(TextDrawFont.get(1));
		textdraw.setLetterSize(0.39f, 1.9f);
		textdraw.setColor(Color.WHITE);
		textdraw.setOutlineSize(1);
		textdraw.setProportional(true);
		textdraw.setUseBox(true);
		textdraw.setBoxColor(color);
		textdraw.setTextSize(50, 140);
		textdraw.setSelectable(false);
	*/
		Textdraw textdraw = Textdraw.create(68, 120+13*count);
		textdraw.setText(text);
		textdraw.setAlignment(TextDrawAlign.CENTER);
		textdraw.setBackgroundColor(new Color(0,0,0,0));
		textdraw.setFont(TextDrawFont.FONT2);
		textdraw.setLetterSize(0.24f, 1f);
		textdraw.setColor(Color.BLACK);
		textdraw.setOutlineSize(0);
		textdraw.setProportional(true);
		textdraw.setShadowSize(1);
		textdraw.setUseBox(true);
		textdraw.setBoxColor(color);
		textdraw.setTextSize(4, 128);
		textdraw.setSelectable(false);
		return textdraw;
	}
	private Textdraw createScoreTextdraw(String score) {
	/*
		Textdraw textdraw = Textdraw.create(169, 106+13*count);
		textdraw.setText(score);
		textdraw.setAlignment(TextDrawAlign.CENTER);
		textdraw.setBackgroundColor(new Color(0,0,0,0));
		textdraw.setFont(TextDrawFont.get(1));
		textdraw.setLetterSize(0.39f, 1.9f);
		textdraw.setColor(Color.WHITE);
		textdraw.setOutlineSize(1);
		textdraw.setProportional(true);
		textdraw.setUseBox(true);
		textdraw.setBoxColor(color);
		textdraw.setTextSize(50, 40);
		textdraw.setSelectable(false);
	*/
		Textdraw textdraw = Textdraw.create(154, 120+13*count);
		textdraw.setText(score);
		textdraw.setAlignment(TextDrawAlign.CENTER);
		textdraw.setBackgroundColor(new Color(0,0,0,0));
		textdraw.setFont(TextDrawFont.PRICEDOWN);
		textdraw.setLetterSize(0.51f, 1f);
		textdraw.setColor(Color.WHITE);
		textdraw.setOutlineSize(0);
		textdraw.setProportional(true);
		textdraw.setShadowSize(1);
		textdraw.setUseBox(true);
		textdraw.setBoxColor(new Color(color.getR(),color.getG(),color.getB(),color.getA()*2>255?255:color.getA()*2));
		textdraw.setTextSize(0, -44);
		textdraw.setSelectable(false);
		return textdraw;
	}
	
	public Textdraw getScoreTextdraw() {
		return scoreTextdraw;
	}
	
	public void destroy() {
		textdraw.hideForAll();
		textdraw.destroy();
		scoreTextdraw.hideForAll();
		scoreTextdraw.destroy();
	}
}

/**
 * 
 */
package me.alf21.util.chat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import net.gtaun.shoebill.object.Destroyable;
import net.gtaun.shoebill.object.Player;
import net.gtaun.shoebill.object.Timer;

/**
 * @author Alf21
 */
public class Chat implements Destroyable {
	
	private Timer timer;
	public static final int updateDelay = 50;
	public static final int displayTime = 5000;
	public static final int slideTime = 500;
	public static final Pattern 	colorStringPattern = Pattern.compile("\u007E+([\\w[\u003C\u003E&&[\\S]]]{1})\u007E"), //...~r~...
									colorStringEndPattern = Pattern.compile("\u007E+([\\w[\u003C\u003E&&[\\S]]]{1})\u007E\\z"), //...~r~|
									tildeLetterPattern = Pattern.compile("\u007E+([\\w[\u003C\u003E&&[\\S]]]{1})\\z"), //...~r|
									tildePattern = Pattern.compile("\u007E\\z"), //...~|
									wrongColorStringPattern = Pattern.compile("\u007E+([\\w[\u003C\u003E&&[\\S]]]{1})\u007E+([\\w[\u003C\u003E&&[\\S]]]{1})\u007E\\z"); //...~s~r|
	private ArrayList<ChatMessage> chatMessages;
	private ChatMessage currentChatMessage;
	private Map<Player, String> queue;

	public Chat() {
		reset();
		initializeTimer();
	}
	
	public void sendMessage(Player player, String text) {
		queue.put(player, text);
		if(!timer.isRunning())
			timer.start();
	}
	
	private void reset() {
		if(chatMessages != null && !chatMessages.isEmpty()) {
			chatMessages.stream().forEach((chatMessage) -> {
				chatMessage.hide();
				chatMessage.destroy();
			});
		}
		chatMessages = new ArrayList<>();
		queue = new HashMap<>();
		currentChatMessage = null;
	}
	
	private void initializeTimer() {
		timer = Timer.create(updateDelay, (factualInterval) -> {
			Long systemTime = System.currentTimeMillis();
			ArrayList<ChatMessage> removeMessages = new ArrayList<>(); //TODO Solution with Iterator
			if(chatMessages != null && !chatMessages.isEmpty()) {
				chatMessages.stream().forEach((chatMessage) -> {
					if(systemTime-chatMessage.getTime() >= slideTime) {
						if(currentChatMessage != null) {
							currentChatMessage = null;
						}
					}
					if(systemTime-chatMessage.getTime() >= displayTime+2*slideTime) {
						removeMessages.add(chatMessage);
					}
					else if(systemTime-chatMessage.getTime() >= displayTime+slideTime) {
						if(!chatMessage.isSliding()) {
							chatMessage.slideOut();
						}
					}
				});
				removeMessages.stream().forEach(this::removeChatMessage);
				removeMessages.clear();
			}
			if(currentChatMessage == null && !queue.isEmpty()) {
				Map.Entry<Player,String> entry = queue.entrySet().iterator().next();
				Player player = entry.getKey();
				currentChatMessage = new ChatMessage(player, entry.getValue(), 0);
				queue.remove(player);
				chatMessages.add(currentChatMessage);
			}
			if(currentChatMessage != null) {
				if (chatMessages != null && chatMessages.size() > 1) {
					chatMessages.stream().forEach((chatMessage) -> {
						if (chatMessage != currentChatMessage)
							chatMessage.moveUp();
					});
				}
				if(!currentChatMessage.isSliding()) {
					currentChatMessage.slideIn();
				}
			}
			
			if(chatMessages != null && chatMessages.isEmpty()) {
				timer.stop();
				reset();
			}
		});
	}
	
	private void removeChatMessage(ChatMessage chatMessage) {
		if(chatMessages.contains(chatMessage)) {
			chatMessages.remove(chatMessage);
		}
		chatMessage.destroy();
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
		if(currentChatMessage != null) {
			currentChatMessage.destroy();
			currentChatMessage = null;
		}
		if(chatMessages != null) {
			chatMessages.stream().forEach(ChatMessage::destroy);
			chatMessages = null;
		}
		if(queue != null) {
			queue = null;
		}
	}

	/* (non-Javadoc)
	 * @see net.gtaun.shoebill.object.Destroyable#isDestroyed()
	 */
	@Override
	public boolean isDestroyed() {
		return !(timer != null || currentChatMessage != null || chatMessages != null || queue != null);
	}
	
	//TODO: add background box and increase if new message and resize on message destroy / destroy if there is no message
}

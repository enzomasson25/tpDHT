package tpDHT;

import peersim.edsim.*;

public class Message {

    public final static int HELLOWORLD = 0;
    public static final int HAND_SHAKE = 1;
    public static final int DISCOVERY = 2;
    public static final int DISCOVERY_FOLLOW_UP = 3;
    public static final int INVITE = 4;

    private int type;
    private String content;

    Message(int type, String content) {
	this.type = type;
	this.content = content;
    }

    public String getContent() {
	return this.content;
    }

    public int getType() {
	return this.type;
    }
    
}
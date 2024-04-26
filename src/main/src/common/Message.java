// Message.java
package common;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String text;
    private String username;


    public Message(String text, String username) {
        this.text = text;
        this.username = username;

    }

}


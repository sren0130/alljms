package org.james.standaloneactivemqdemo.model;

import java.io.Serializable;

public class SystemMessage implements Serializable {
    private static final long serialVersionUID = -378507890827471811L;

    private String source;
    private String message;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return "SystemMessage{" +
                "source='" + '\'' +
                ", message='" + message + '\'' +
                "}";
    }

}

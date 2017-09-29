package com.example.usuario.sendmessagebutterknife.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Clase POJO que representa un objeto Mensaje.
 */

public class Message implements Parcelable {

    private String message;
    private String user;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Message(String message, String user) {
        this.message = message;
        this.user = user;
    }

    protected Message(Parcel in) {
        message = in.readString();
        user = in.readString();
    }

    public static final Creator<Message> CREATOR = new Creator<Message>() {
        @Override
        public Message createFromParcel(Parcel in) {
            return new Message(in);
        }

        @Override
        public Message[] newArray(int size) {
            return new Message[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(message);
        dest.writeString(user);
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                ", user='" + user + '\'' +
                '}';
    }

    //Refactorizado
    @Override
    public boolean equals(Object o) {
        boolean result;
        if (this == o) return true;
        if(o == null && getClass() != o.getClass()) return false;

        Message message1 = (Message) o;
        result = ((message.equals(message1.message)) ||
                user.equals(message1.user));

        return result;

    }

}

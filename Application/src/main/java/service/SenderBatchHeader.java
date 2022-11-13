package service;

public class SenderBatchHeader {
    public String sender_batch_id;
    public String email_subject;
    public String email_message;
    
    
    
    public SenderBatchHeader(String sender_batch_id, String email_subject, String email_message) {
        this.sender_batch_id = sender_batch_id;
        this.email_subject = email_subject;
        this.email_message = email_message;
    }
    public SenderBatchHeader() {
    }
    public String getSender_batch_id() {
        return sender_batch_id;
    }
    public void setSender_batch_id(String sender_batch_id) {
        this.sender_batch_id = sender_batch_id;
    }
    public String getEmail_subject() {
        return email_subject;
    }
    public void setEmail_subject(String email_subject) {
        this.email_subject = email_subject;
    }
    public String getEmail_message() {
        return email_message;
    }
    public void setEmail_message(String email_message) {
        this.email_message = email_message;
    }

}

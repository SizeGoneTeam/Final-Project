package service;

public class BatchHeader {
    public String payout_batch_id;
    public String batch_status;
    public SenderBatchHeader sender_batch_header;
    public BatchHeader(String payout_batch_id, String batch_status, SenderBatchHeader sender_batch_header) {
        super();
        this.payout_batch_id = payout_batch_id;
        this.batch_status = batch_status;
        this.sender_batch_header = sender_batch_header;
    }
    public BatchHeader() {
        super();
        // TODO Auto-generated constructor stub
    }
    public String getPayout_batch_id() {
        return payout_batch_id;
    }
    public void setPayout_batch_id(String payout_batch_id) {
        this.payout_batch_id = payout_batch_id;
    }
    public String getBatch_status() {
        return batch_status;
    }
    public void setBatch_status(String batch_status) {
        this.batch_status = batch_status;
    }
    public SenderBatchHeader getSender_batch_header() {
        return sender_batch_header;
    }
    public void setSender_batch_header(SenderBatchHeader sender_batch_header) {
        this.sender_batch_header = sender_batch_header;
    }
    

}

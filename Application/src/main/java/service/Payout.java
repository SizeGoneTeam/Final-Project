package service;

public class Payout {
    private BatchHeader batch_header;
    
    public Payout() {
        super();
    }

    public Payout(BatchHeader sender_batch_header) {
        super();
        this.batch_header = sender_batch_header;
    }

    public BatchHeader getBatch_header() {
        return batch_header;
    }

    public void setBatch_header(BatchHeader sender_batch_header) {
        this.batch_header = sender_batch_header;
    }
    

}

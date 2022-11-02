package TimerTask;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.TimerTask;

public class MyTask extends TimerTask {
    private Date TimeEnd;
    
    
    public MyTask(Date timeEnd) {
        TimeEnd = timeEnd;
    }
    @Override
    public void run() {
        Date now = new Date();
        if(now.getTime() - TimeEnd.getTime() >=0)
        {
            System.out.println("Stop");
            return;
        }
        
        System.out.println("Run my Task Giam Gia");
        
    }

    public Date getTimeEnd() {
        return TimeEnd;
    }
    public void setTimeEnd(Date timeEnd) {
        TimeEnd = timeEnd;
    }

}

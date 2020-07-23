package algorithms;


import java.text.NumberFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author weiyuan
 * @date 2018/10/30 12:23
 */

public class ResellerTime {
    private final String id;
    private final String methodDesc;
    private final Date methodStart;
    private final List<TaskInfo> taskList;
    private String methodDone;
    private boolean keepTaskList;
    private long startTimeMillis;
    private boolean running;
    private String currentTaskName;
    private TaskInfo lastTaskInfo;
    private int taskCount;
    private long totalTimeMillis;

    public ResellerTime() {
        this("", "");
    }

    public ResellerTime(String id, String methodDesc) {
        this.keepTaskList = true;
        this.taskList = new LinkedList();
        this.id = id;
        this.methodDesc = methodDesc;
        this.methodStart = new Date();
    }

    public String getMethodDone() {
        return methodDone;
    }

    public void setMethodDone(String methodDone) {
        if (this.running) {
            this.stop();
        }
        this.methodDone = methodDone;
    }

    public String getId() {
        return this.id;
    }

    public void setKeepTaskList(boolean keepTaskList) {
        this.keepTaskList = keepTaskList;
    }

    public void start() throws IllegalStateException {
        this.start("");
    }

    public void start(String taskName) throws IllegalStateException {
        if (this.running) {
            stop();
        }
        this.running = true;
        this.currentTaskName = taskName;
        this.startTimeMillis = System.currentTimeMillis();
    }

    public void stop() throws IllegalStateException {
        if (!this.running) {
            throw new IllegalStateException("Can't stop StopWatch: it's not running");
        } else {
            long endTimeMillis = System.currentTimeMillis();
            long lastTime = endTimeMillis - this.startTimeMillis;
            this.totalTimeMillis += lastTime;
            this.lastTaskInfo = new TaskInfo(this.currentTaskName, lastTime, this.startTimeMillis, endTimeMillis);
            if (this.keepTaskList) {
                this.taskList.add(this.lastTaskInfo);
            }

            ++this.taskCount;
            this.running = false;
            this.currentTaskName = null;
        }
    }

    public boolean isRunning() {
        return this.running;
    }

    public String currentTaskName() {
        return this.currentTaskName;
    }

    public long getLastTaskTimeMillis() throws IllegalStateException {
        if (this.lastTaskInfo == null) {
            throw new IllegalStateException("No tasks run: can't get last task interval");
        } else {
            return this.lastTaskInfo.getTimeMillis();
        }
    }

    public String getLastTaskName() throws IllegalStateException {
        if (this.lastTaskInfo == null) {
            throw new IllegalStateException("No tasks run: can't get last task name");
        } else {
            return this.lastTaskInfo.getTaskName();
        }
    }

    public TaskInfo getLastTaskInfo() throws IllegalStateException {
        if (this.lastTaskInfo == null) {
            throw new IllegalStateException("No tasks run: can't get last task info");
        } else {
            return this.lastTaskInfo;
        }
    }

    public long getTotalTimeMillis() {
        return this.totalTimeMillis;
    }

    private String getMethodStart() {
        return DateUtil.format(this.methodStart, "yyyy-MM-dd HH:mm:ss.SSS");

    }

    public double getTotalTimeSeconds() {
        return (double) this.totalTimeMillis / 1000.0D;
    }

    public int getTaskCount() {
        return this.taskCount;
    }

    public TaskInfo[] getTaskInfo() {
        if (!this.keepTaskList) {
            throw new UnsupportedOperationException("Task info is not being kept!");
        } else {
            return (TaskInfo[]) this.taskList.toArray(new TaskInfo[this.taskList.size()]);
        }
    }

    public String shortSummary() {
        return "订单号:[" + this.getId() + "] 调用时间:[" + this.getMethodStart() + "] 「" + methodDesc + "」:总用时(毫秒):[" + String.format("%,dms", this.getTotalTimeMillis()) + "] 调用任务数:[" + this.taskCount + "]";
    }

    public String prettyPrint() {
        StringBuilder sb = new StringBuilder(this.shortSummary());
        sb.append('\n');
        if (!this.keepTaskList) {
            sb.append("No task info kept");
        } else {
            sb.append("-----------------------------------------------------------\n");
            sb.append("耗时(ms)   占比(%)   开始时间       结束时间      任务名称      \n");
            sb.append("-----------------------------------------------------------\n");

            NumberFormat nf = NumberFormat.getNumberInstance();
            nf.setMinimumIntegerDigits(5);
            nf.setGroupingUsed(false);

            NumberFormat pf = NumberFormat.getPercentInstance();
            pf.setMinimumIntegerDigits(2);
            pf.setGroupingUsed(false);
            TaskInfo[] taskInfos = this.getTaskInfo();
            int length = taskInfos.length;

            for (int i = 0; i < length; ++i) {
                TaskInfo task = taskInfos[i];
                sb.append(nf.format(task.getTimeMillis())).append("      ");
                sb.append(pf.format(task.getTimeSeconds() / this.getTotalTimeSeconds())).append("   ");
                sb.append(task.getStartTime()).append("   ");
                sb.append(task.getEndTime()).append("   ");
                sb.append(task.getTaskName()).append("\n");
            }
            sb.append("-----------------------------------------------------------\n");
            sb.append(this.methodDone);
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.shortSummary());
        if (this.keepTaskList) {
            TaskInfo[] var2 = this.getTaskInfo();
            int var3 = var2.length;

            for (int var4 = 0; var4 < var3; ++var4) {
                TaskInfo task = var2[var4];
                sb.append("; [").append(task.getTaskName()).append("] took ").append(task.getTimeMillis());
                long percent = Math.round(100.0D * task.getTimeSeconds() / this.getTotalTimeSeconds());
                sb.append(" = ").append(percent).append("%");
            }
        } else {
            sb.append("; no task info kept");
        }

        return sb.toString();
    }

    public static final class TaskInfo {
        private final String taskName;
        private final long timeMillis;
        private final long startTimeMillis;
        private final long endTimeMillis;

        TaskInfo(String taskName, long timeMillis, long startTimeMillis, long endTimeMillis) {
            this.taskName = taskName;
            this.timeMillis = timeMillis;
            this.startTimeMillis = startTimeMillis;
            this.endTimeMillis = endTimeMillis;
        }

        public String getTaskName() {
            return this.taskName;
        }

        public long getTimeMillis() {
            return this.timeMillis;
        }

        public double getTimeSeconds() {
            return (double) this.timeMillis / 1000.0D;
        }

        public long getStartTimeMillis() {
            return startTimeMillis;
        }

        public long getEndTimeMillis() {
            return endTimeMillis;
        }

        public String getStartTime() {
            return DateUtil.format(new Date(this.startTimeMillis), "HH:mm:ss.SSS");
        }

        public String getEndTime() {
            return DateUtil.format(new Date(this.endTimeMillis), "HH:mm:ss.SSS");
        }
    }
}

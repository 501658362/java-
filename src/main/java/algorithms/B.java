package algorithms;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: chenchaopeng
 * Date: 2019/11/1
 */
public class B {

    private static ThreadLocal<ResellerTime> timeThreadLocal = new ThreadLocal<>();

    public ResellerTime getUuid(String uuid, String desc) {
        ResellerTime uuidRan = timeThreadLocal.get();
        if (uuidRan == null) {
            uuidRan = new ResellerTime(uuid, desc);
            timeThreadLocal.set(uuidRan);
        }
        return uuidRan;
    }

    public ResellerTime getUuid() {
        ResellerTime uuidRan = timeThreadLocal.get();

        return uuidRan;
    }

    public void removeUuid() {
        try {
            timeThreadLocal.remove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

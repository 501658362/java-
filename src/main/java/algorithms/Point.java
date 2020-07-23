package algorithms;


import com.google.common.collect.Lists;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

@Data
public class Point implements Serializable {
    private Integer x;
    private Integer y;

    public Point(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public double getDis(Point b) {
        return Math.sqrt(Math.pow(this.x - b.x, 2) + Math.pow(this.y - b.y, 2));
    }

    public static void main(String[] args) {

        // 生成坐标点
        List<Point> pointList = Lists.newArrayList();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            pointList.add(new Point(random.nextInt(20), random.nextInt(20)));
        }
        List<List<Point>> group = Lists.newArrayList();
        for (int i = 0; i < pointList.size(); i++) {
            // 获取
            List<Point> currentPointList = null;
            for (List<Point> list : group) {
                if (list.contains(pointList.get(i))) {
                    currentPointList = list;
                }
            }
            if (currentPointList == null) {
                currentPointList = Lists.newArrayList(pointList.get(i));
            }
            for (Point point : pointList) {
                if (pointList.get(i).getDis(point) < 11) {
                    if (!currentPointList.contains(point)) {
                        boolean flag = true;
                        for (Point p2 : currentPointList) {
                            if (!(p2.getDis(point) < 11)) {
                                flag = false;
                            }
                        }
                        if (flag) {
                            currentPointList.add(point);
                        }

                    }
                }
            }
            if (!group.contains(currentPointList)) {
                group.add(currentPointList);
            }

        }
        System.out.println(group);
    }
}

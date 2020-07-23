package algorithms;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import lombok.Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public class AiPicResult implements Serializable {
    private String dataId;
    private String imageId;
    private Integer y1;
    private Integer labelType;
    private Integer order;


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("G:\\新建文件夹\\WeChat Files\\Cc501658362\\FileStorage\\File\\2020-07\\111.json"));
        String str = in.readLine();
        if (str != null) {
            JSONObject jsonObject = JSON.parseObject(str);
            if (jsonObject.containsKey("data")) {
                List<AiPicResult> data = JSON.parseArray(jsonObject.getString("data"), AiPicResult.class);
                Map<String, Map<String, List<AiPicResult>>> map = new HashMap<>();
                for (AiPicResult datum : data) {
                    if (map.containsKey(datum.dataId)) {
                        if (map.get(datum.dataId).containsKey(datum.getImageId())) {
                            map.get(datum.dataId).get(datum.getImageId()).add(datum);
                        } else {
                            map.get(datum.dataId).put(datum.getImageId(), Lists.newArrayList(datum));
                        }
                    } else {
                        Map<String, List<AiPicResult>> imageMap = new HashMap<>();
                        imageMap.put(datum.getImageId(), Lists.newArrayList(datum));
                        map.put(datum.dataId, imageMap);
                        map.get(datum.dataId).put(datum.getImageId(), Lists.newArrayList(datum));
                    }
                }
                for (Map<String, List<AiPicResult>> value : map.values()) {
                    for (String key : value.keySet()) {
                        List<AiPicResult> collect = value.get(key).stream().sorted(Comparator.comparing(AiPicResult::getY1)).collect(Collectors.toList());
                        int i = 1;
                        for (AiPicResult aiPicResult : collect) {
                            aiPicResult.setOrder(i);
                            i++;
                        }
                        value.put(key, collect);
                    }
                }
                for (Map<String, List<AiPicResult>> value : map.values()) {
                    for (List<AiPicResult> aiPicResults : value.values()) {
                        System.out.println(aiPicResults);
                    }
                }
            }
        }
    }
}

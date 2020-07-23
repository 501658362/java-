package algorithms;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * 商品类型枚举
 * Created by diaozhenfei on 2016/12/6.
 */
public enum ProductType implements I18nMessage<Integer> {

    DAY_TOUR(1, "观光日游", "product.type.day.tour"),
    EXPERIENCE(2, "体验日游", "product.type.experience"),
    TICKET(3, "公园、景点", "product.type.ticket"),//公园、景点
    SHOW(4, "演出、赛事", "product.type.show"),
    //    TRANSPORT_INTERCHANGE(7, "交通接驳", "product.type.transport.interchange"),
    FOOD(8, "美食", "product.type.food"),
    //    WIFI(10, "WIFI、通讯", "product.type.wifi"),
//    SHOPPING(9, "购物", "product.type.shopping"),
    CHARTERED(11, "交通接驳", "product.type.chartered"),
//    TRANSFER(12, "接送机", "product.type.transfer");

    //20171123新加实物商品(旅游周边和WIFI电话卡)
    WIFI(10, "WIFI、电话卡", "product.type.wifi"),
    AROUND(13, "旅游周边", "product.type.around"),
    TRAFFIC_TICKET(14, "交通票券", "product.type.traffic.ticket");

    private int code;
    private String text;
    private String key;

    ProductType(int code, String text, String key) {
        this.code = code;
        this.text = text;
        this.key = key;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getText() {
        return text;
    }


    /**
     * 根据code获取枚举
     *
     * @param code
     * @return
     */
    public static ProductType getProductType(int code) {
        for (ProductType productType : ProductType.values()) {
            if (productType.getCode() == code) {
                return productType;
            }
        }
        return null;
    }

    /**
     * 预设spu商品类别,如果是交通票券类需要根据子类判断，此方法仅仅在新增商品时用到，其他地方判断是否是预设spu必须根据小类判断
     */
    private static List<ProductType> presetList = Lists.newArrayList(ProductType.TICKET, ProductType.SHOW);

    /**
     * 20171127新加预设实物商品类别
     */
    private static List<ProductType> actualList = Lists.newArrayList(ProductType.WIFI, ProductType.AROUND);

    private static HashSet<Integer> hashSet;
    private static HashSet<Integer> noPresetHashSet;
    private static HashSet<Integer> presetHashSet;
    private static HashSet<Integer> actualHashSet;

    static {
        hashSet = new HashSet<Integer>();
        hashSet.clear();
        noPresetHashSet = new HashSet<Integer>();
        noPresetHashSet.clear();
        presetHashSet = new HashSet<Integer>();
        presetHashSet.clear();

        actualHashSet = new HashSet<Integer>();
        actualHashSet.clear();

        for (ProductType value : ProductType.values()) {
            hashSet.add(value.getCode());
            if (presetList.contains(value)) {
                presetHashSet.add(value.getCode());
            } else {
                noPresetHashSet.add(value.getCode());
            }

            if (actualList.contains(value)) {
                actualHashSet.add(value.getCode());
            }
        }
    }

    public static boolean isDefined(int value) {
        return hashSet.contains(value);
    }

    /**
     * 是否是预设SPU商品类别
     * 如果是交通票券类需要根据子类判断，此方法仅仅在新增商品时用到，其他地方判断是否是预设spu不用此方法必须根据小类判断
     *
     * @param value
     * @return true：预设；false：非预设
     */
    public static boolean isPreset(int value) {
        return presetHashSet.contains(value);
    }

    /**
     * 是否是实物商品
     *
     * @param value
     * @return
     */
    public static boolean isActual(int value) {
        return actualHashSet.contains(value);
    }

    /**
     * 转换为MAP集合
     *
     * @return Map<String, Integer> Map<enum, code>
     */
    public static Map<String, Integer> toMap() {
        Map<String, Integer> map = Maps.newHashMap();
        ProductType[] enums = ProductType.values();
        for (int i = 0; i < enums.length; i++) {
            map.put(enums[i].toString(), enums[i].getCode());
        }
        return map;
    }

    /**
     * 转换为MAP集合
     *
     * @param list 枚举列表
     * @return Map<Integer, String> Map<code, text>
     */
    public static Map<Integer, String> toTextMap(List<ProductType> list) {
        Map<Integer, String> map = Maps.newHashMap();
        if (list != null && list.size() > 0) {
            for (ProductType productType : list) {
                map.put(productType.getCode(), productType.getText());
            }
        }
        return map;
    }

    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public void setText(String message) {
        this.text = message;

    }

}

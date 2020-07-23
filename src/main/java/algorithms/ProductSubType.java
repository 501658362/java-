package algorithms;

import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * 商品子类型枚举
 * Created by diaozhenfei on 2016/12/6.
 */
public enum ProductSubType implements I18nMessage<Integer> {

    ONE_DAY_TOUR(101, "一日游", "product.sub.type.one.day.tour"),
    HALF_DAY_TOUR(102, "半日游", "product.sub.type.half.day.tour"),
    MORE_DAY_TOUR(103, "多日游", "product.sub.type.multi.day.tour"),//20180403增加多日游子类

    SPA(201, "SPA", "product.sub.type.spa"),
    DIVING(202, "潜水", "product.sub.type.diving"),
    PHOTOGRAPHY_PORTRAIT(203, "摄影写真", "product.sub.type.photography.portrait"),
    SHOOTING(204, "射击", "product.sub.type.shooting"),
    GOLF(205, "高尔夫", "product.sub.type.golf"),
    PARACHUTE(206, "跳伞", "product.sub.type.parachute"),
    SKIING(207, "滑雪", "product.sub.type.skiing"),
    HELICOPTER(208, "直升机", "product.sub.type.helicopter"),
    CURRICULUM(209, "课程", "product.sub.type.curriculum"),
    SURFING(2010, "冲浪", "product.sub.type.surfing"),
    RIDING(2011, "动物骑行", "product.sub.type.riding"),
    JUNGLE(2012, "丛林", "product.sub.type.jungle"),
    SUBMARINE(2013, "潜水艇", "product.sub.type.submarine"),
    CROSS_COUNTRY(2014, "越野", "product.sub.type.cross.country"),
    SMALL_AIRCRAFT(2015, "小飞机", "product.sub.type.small.aircraft"),
    PARASAIL(2016, "帆伞", "product.sub.type.parasail"),
    MASSAGE(2017, "按摩", "product.sub.type.massage"),
    HOT_AIR_BALLOON(2018, "热气球", "product.sub.type.hot.air.balloon"),
    SIGHTSEEING_BOAT(2019, "游船", "product.sub.type.sightseeing.boat"),
    SEA_FISHING(2020, "海钓", "product.sub.type.sea.fishing"),
    ROCK_CLIMBING(2021, "攀岩", "product.sub.type.rock.climbing"),
    GLIDE(2022, "滑翔", "product.sub.type.glide"),
    AERIAL_TOUR(2023, "空中游览", "product.sub.type.aerial.tour"),
    THE_PICKING(2024, "采摘", "product.sub.type.the.picking"),
    WATCH_SHARKS(2025, "观鲨", "product.sub.type.watch.sharks"),
    KIMONO(2026, "和服体验", "product.sub.type.kimono"),
    SAWANOBORI(2027, "溯溪", "product.sub.type.sawanobori"),
    VIEW_DOLPHINS(2028, "观海豚", "product.sub.type.view.dolphins"),
    VEHICLE_RIDING(2029, "车辆骑行", "product.sub.type.vehicle.riding"),
    HOT_SPRING(2030, "温泉", "product.sub.type.hot.spring"),
    AQUATIC_SPORTS(2031, "水上运动", "product.sub.type.aquatic.sports"),
    TEA_CEREMONY(2032, "茶道", "product.sub.type.tea.ceremony"),
    SPORTS_EVENTS(2033, "体育比赛", "product.sub.type.sporting.competition"),

    CONCERT(2034, "演唱会", "product.sub.type.concert"),
    MUSIC_FESTIVAL(2035, "音乐节", "product.sub.type.music.festival"),
    EXHIBITION(2036, "展览", "product.sub.type.exhibition"),
    THEATRE(2037, "戏剧", "product.sub.type.theatre"),
    KID_FRIENDLY(2038, "亲子活动", "product.sub.type.kidfriendly"),
    WINTER_SPORTS(2039, "冬季项目", "product.sub.type.winter.sports"),
    HIKING(2040, "徒步", "product.sub.type.hiking"),

    PARK_TICKETS(301, "公园门票", "product.sub.type.park.tickets"),
    //SIGHTSEEING_TICKET(302, "交通票券", "product.sub.type.sightseeing.ticket"),//观光通票

    SHOW(401, "演出,秀场", "product.sub.type.show"),
    SPORTING_EVENTS(402, "体育赛事", "product.sub.type.sporting.events"),

    //STEAMER_TICKET(701, "船票", "product.sub.type.steamer.ticket"),
    //TRAIN_TICKETS(702, "火车票", "product.sub.type.train.tickets"),
    //CABLE_CAR(703, "缆车", "product.sub.type.cable.car"),
    //TRAFFIC_TICKET(704, "交通通票", "product.sub.type.traffic.ticket"),
    //SIGHTSEEING_BUS(705, "观光巴士", "product.sub.type.sightseeing.bus"),

    RESTAURANT_RESERVATION(801, "餐厅预订", "product.sub.type.restaurant.reservation"),
    PACKAGES_VOUCHER(802, "套餐餐券", "product.sub.type.packages.voucher"),
    FOOD_DISCOUNT(803, "美食折扣", "product.sub.type.food.discount"),

    OVERSEAS_WIFI(1001, "境外WIF", "product.sub.type.overseas.wifi"),
    PHONECARD(1002, "电话卡", "product.sub.type.phonecard"),

    CHARTERED(1101, "按天包车", "product.sub.type.chartered"),
    TRANSFER(1102, "接送机", "product.sub.type.transfer"),
    VOYAGE_CHARTER(1103, "单次用车", "product.sub.type.voyage.charter"),

    COMBO_TICKET(1401, "交通套票", "product.sub.type.combo.ticket"),//20180403增加
    POINT_TO_POINT_TICKET_BOAT(1502, "点对点船票", "product.sub.type.point.to.point.ticket.boat"),//20180403增加
    POINT_TO_POINT_TICKET_BUS(1503, "点对点巴士票", "product.sub.type.point.to.point.ticket.bus"),//20180403增加
    POINT_TO_POINT_TICKET_TRAIN(1504, "点对点火车票", "product.sub.type.point.to.point.ticket.train"),//20180403增加
    POINT_TO_POINT_TICKET_OTHER(1505, "点对点其他", "product.sub.type.point.to.point.ticket.other");//20180403增加

    private int code;
    private String text;
    private String key;

    ProductSubType(int code, String text, String key) {
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

    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public void setText(String message) {
        this.text = message;
    }

    /**
     * 根据code获取枚举
     *
     * @param code
     * @return
     */
    public static ProductSubType getProductSubType(int code) {
        for (ProductSubType productSubType : ProductSubType.values()) {
            if (productSubType.getCode() == code) {
                return productSubType;
            }
        }
        return null;
    }

    /**
     * no poi商品子类别
     */
    private static List<ProductSubType> noPoiList = Lists.newArrayList(TRANSFER);

    /**
     * 预设spu商品子类别
     */
    private static List<ProductSubType> presetList = Lists.newArrayList(
            ProductSubType.PARK_TICKETS, ProductSubType.COMBO_TICKET, ProductSubType.SPORTING_EVENTS, ProductSubType.SHOW);

    /**
     * 需要根据商品出发城市默认生成出发片区的商品子类别
     */
    private static List<ProductSubType> hasDefaultAreaList = Lists.newArrayList(CHARTERED, VOYAGE_CHARTER);

    private static HashSet<Integer> hashSet;
    private static HashSet<Integer> noPoiHashSet;
    private static HashSet<Integer> hasDefaultAreaHashSet;

    private static HashSet<Integer> noPresetHashSet;
    private static HashSet<Integer> presetHashSet;
    private static Map<Integer, List<ProductSubType>> subTypeMap;

    static {
        hashSet = new HashSet<Integer>();
        hashSet.clear();
        noPoiHashSet = new HashSet<Integer>();
        noPoiHashSet.clear();
        hasDefaultAreaHashSet = new HashSet<Integer>();
        hasDefaultAreaHashSet.clear();

        noPresetHashSet = new HashSet<Integer>();
        noPresetHashSet.clear();
        presetHashSet = new HashSet<Integer>();
        presetHashSet.clear();

        subTypeMap = new HashMap<>();
        subTypeMap.clear();


        for (ProductSubType value : ProductSubType.values()) {
            hashSet.add(value.getCode());
            if (noPoiList.contains(value)) {
                noPoiHashSet.add(value.getCode());
            }
            if (hasDefaultAreaList.contains(value)) {
                hasDefaultAreaHashSet.add(value.getCode());
            }

            if (presetList.contains(value)) {
                presetHashSet.add(value.getCode());
            } else {
                noPresetHashSet.add(value.getCode());
            }
        }

        List<ProductSubType> dayTourSub = Lists.newArrayList();
        dayTourSub.add(ProductSubType.ONE_DAY_TOUR);
        dayTourSub.add(ProductSubType.HALF_DAY_TOUR);
        dayTourSub.add(ProductSubType.MORE_DAY_TOUR);
        subTypeMap.put(ProductType.DAY_TOUR.getCode(), dayTourSub);

        List<ProductSubType> experienceSub = Lists.newArrayList();
        experienceSub.add(ProductSubType.SPA);
        experienceSub.add(ProductSubType.DIVING);
        experienceSub.add(ProductSubType.PHOTOGRAPHY_PORTRAIT);
        experienceSub.add(ProductSubType.SHOOTING);
        experienceSub.add(ProductSubType.GOLF);
        experienceSub.add(ProductSubType.PARACHUTE);
        experienceSub.add(ProductSubType.SKIING);
        experienceSub.add(ProductSubType.HELICOPTER);
        experienceSub.add(ProductSubType.CURRICULUM);
        experienceSub.add(ProductSubType.SURFING);
        experienceSub.add(ProductSubType.RIDING);
        experienceSub.add(ProductSubType.JUNGLE);
        experienceSub.add(ProductSubType.SUBMARINE);
        experienceSub.add(ProductSubType.CROSS_COUNTRY);
        experienceSub.add(ProductSubType.SMALL_AIRCRAFT);
        experienceSub.add(ProductSubType.PARASAIL);
        experienceSub.add(ProductSubType.MASSAGE);
        experienceSub.add(ProductSubType.HOT_AIR_BALLOON);
        experienceSub.add(ProductSubType.SIGHTSEEING_BOAT);
        experienceSub.add(ProductSubType.SEA_FISHING);
        experienceSub.add(ProductSubType.ROCK_CLIMBING);
        experienceSub.add(ProductSubType.GLIDE);
        experienceSub.add(ProductSubType.AERIAL_TOUR);
        experienceSub.add(ProductSubType.THE_PICKING);
        experienceSub.add(ProductSubType.WATCH_SHARKS);
        experienceSub.add(ProductSubType.KIMONO);
        experienceSub.add(ProductSubType.SAWANOBORI);
        experienceSub.add(ProductSubType.VIEW_DOLPHINS);
        experienceSub.add(ProductSubType.VEHICLE_RIDING);
        experienceSub.add(ProductSubType.HOT_SPRING);
        experienceSub.add(ProductSubType.AQUATIC_SPORTS);
        experienceSub.add(ProductSubType.TEA_CEREMONY);
        experienceSub.add(ProductSubType.SPORTS_EVENTS);
        experienceSub.add(ProductSubType.CONCERT);
        experienceSub.add(ProductSubType.MUSIC_FESTIVAL);
        experienceSub.add(ProductSubType.EXHIBITION);
        experienceSub.add(ProductSubType.THEATRE);
        experienceSub.add(ProductSubType.KID_FRIENDLY);
        experienceSub.add(ProductSubType.WINTER_SPORTS);
        experienceSub.add(ProductSubType.HIKING);
        subTypeMap.put(ProductType.EXPERIENCE.getCode(), experienceSub);

        List<ProductSubType> ticketSub = Lists.newArrayList();
        ticketSub.add(ProductSubType.PARK_TICKETS);
        subTypeMap.put(ProductType.TICKET.getCode(), ticketSub);

        List<ProductSubType> showSub = Lists.newArrayList();
        showSub.add(ProductSubType.SHOW);
        showSub.add(ProductSubType.SPORTING_EVENTS);
        subTypeMap.put(ProductType.SHOW.getCode(), showSub);

        List<ProductSubType> foodSub = Lists.newArrayList();
        foodSub.add(ProductSubType.RESTAURANT_RESERVATION);
        foodSub.add(ProductSubType.PACKAGES_VOUCHER);
        foodSub.add(ProductSubType.FOOD_DISCOUNT);
        subTypeMap.put(ProductType.FOOD.getCode(), foodSub);

        List<ProductSubType> charteredSub = Lists.newArrayList();
        charteredSub.add(ProductSubType.CHARTERED);
        charteredSub.add(ProductSubType.TRANSFER);
        charteredSub.add(ProductSubType.VOYAGE_CHARTER);
        subTypeMap.put(ProductType.CHARTERED.getCode(), charteredSub);

        List<ProductSubType> wifiSub = Lists.newArrayList();
        wifiSub.add(ProductSubType.OVERSEAS_WIFI);
        wifiSub.add(ProductSubType.PHONECARD);
        subTypeMap.put(ProductType.WIFI.getCode(), wifiSub);

        List<ProductSubType> trafficTicketSub = Lists.newArrayList();
        trafficTicketSub.add(ProductSubType.COMBO_TICKET);
        trafficTicketSub.add(ProductSubType.POINT_TO_POINT_TICKET_BOAT);
        trafficTicketSub.add(ProductSubType.POINT_TO_POINT_TICKET_BUS);
        trafficTicketSub.add(ProductSubType.POINT_TO_POINT_TICKET_TRAIN);
        trafficTicketSub.add(ProductSubType.POINT_TO_POINT_TICKET_OTHER);
        subTypeMap.put(ProductType.TRAFFIC_TICKET.getCode(), trafficTicketSub);
    }

    public static boolean isDefined(int value) {
        return hashSet.contains(value);
    }

    /**
     * 判断参数productSubType是否是有POI的商品子类
     * true：没有poi；false：有poi
     *
     * @param value
     * @return
     */
    public static boolean noPoi(int value) {
        return noPoiHashSet.contains(value);
    }

    /**
     * 判断参数productSubType是否需要根据商品出发城市默认生成出发片区的商品子类别
     * true：需要；false：不需要
     *
     * @param value
     * @return
     */
    public static boolean hasDefaultArea(int value) {
        return hasDefaultAreaHashSet.contains(value);
    }

    /**
     * 是否是预设SPU商品子类别
     *
     * @param value
     * @return true：预设；false：非预设
     */
    public static boolean isPreset(int value) {
        return presetHashSet.contains(value);
    }

    /**
     * 根据商品大类获取子类
     *
     * @param productType 商品大类
     * @return 商品子类集合
     */
    public static List<ProductSubType> getProductSubTypes(int productType) {
        if (subTypeMap.containsKey(productType)) {
            return subTypeMap.get(productType);
        }
        if (productType == 0) {
            return Lists.newArrayList(ProductSubType.values());
        }
        return null;
    }
}

//package algorithms;
//
//import com.google.common.collect.Lists;
//import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.io.Serializable;
//import java.util.List;
//
///**
// * Created by IntelliJ IDEA.
// *
// * @author: chenchaopeng
// * Date: 2019/11/8
// */
//@Data
//public class TestP {
//    private Integer UseType = 1;
//    private Integer PatternType = 1;
//    private List<Integer> VehicleTypeList = Lists.newArrayList(51);
//    private GeoDTO DuseLocation;
//    private GeoDTO DuseLocation;
//    @Getter
//    @Setter
//    public static class GeoDTO implements Serializable {
//        /**
//         * 到达地址最长200位
//         */
//        private String address;
//        /**
//         * 到达详细地址最长200位
//         */
//        private String detailAddress;
//        /**
//         * 经度
//         */
//        private Double longitude;
//        /**
//         * 维度
//         */
//        private Double latitude;
//
//    }
//    {
//        "UseType": 1,
//            "PatternType": 1,
//            "VehicleTypeList": [
//        51
//    ],
//        "DuseLocation": {
//        "Address": " 樟 宜 机 场 ",
//                "DetailAddress": " 樟 宜 机 场 ",
//                "Longitude": 103.991531,
//                "Latitude": 1.36442
//    },
//        "Aus eLocation": {
//        "Address": "新加坡洲际酒店(Intercontinental Singapore)",
//                "DetailAddress": "80Mid dleRd",
//                "Longitude": 103.85626,
//                "Latitude": 1.297311
//    },
//        "UseTime": "2016-04-05 23:05",
//            "FixedCod e": "SIN"
//    }
//}

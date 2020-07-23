package algorithms;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: chenchaopeng
 * Date: 2019/2/20
 */
@Data
public class ContractVo {


    private ContractBaseInfoVo baseInfo;


    private ContractBankInfoVo bankInfo;


    private ContactVo contactInfo;


    private CommissionInfoVo commissionInfo;


    private SettlementInfoVo settlementInfo;


    @Data
    public static class SettlementInfoVo {


        private Integer settlementPeriod;


        private String settlementCurrency;


        private Integer settlementType;


        private Integer settlementDays;


        private List<SettlementRuleInfoVo> otherRule;

    }

    @Data
    public static class SettlementRuleInfoVo {


        private Integer productType;


        private Integer productSubType;


        private Integer settlementType;


        private Integer settlementDays;
    }


    @Data
    public static class CommissionInfoVo {

        private List<CommissionVo> commissionList;
    }


    @Data
    public static class CommissionVo {


        private Integer productType;


        private Integer productSubType;


        private Integer commissionType;


        private Integer amount;


        private Integer rate;

        private Date startDate;


        private Date endDate;


        private refundCommissionVo refundCommission;
    }

    @Data
    public static class refundCommissionVo {


        private Integer commissionType;


        private Integer returnType;


        private Integer amount;


        private Integer rate;


    }


    @Data
    public static class ContractBaseInfoVo {


        private Integer contractId;
        /**
         * 合同号: 正常合同: “C+YYYYMMDDHHMMSS+商户编号(五位, 不足用0 补足); 续签合同 “R+YYYYMMDDHHMMSS+商户编号(五位, 不足用0 补足)
         */

        private String code;


        private String name;


        private Integer partnerType;


        private Integer partnerId;


        private String partnerName;


        private Date startDate;


        private Date endDate;


        private Integer autoSign;


        private ContractVo.ContractContactVo contractManager;

    }

    @Data
    public static class ContractBankInfoVo {

        private String bankName;


        private String bankAddress;


        private String bankSwiftCode;


        private Integer bankPayType;


        private String bankAccountName;


        private String bankAccountNumber;


        private String bankCurrency;


        private Integer bankIban;


        private String bankTransferSwiftCode;


        private String bankTransferBankName;


        private String bankTransferBankAccountNumber;
        /**
         * 中转银行账户名称
         */

        private String bankTransferBankAccountName;
    }

    @Data
    public static class ContactVo {


        private ContractContactVo billManager;


        private List<ContractContactVo> otherContacts;

    }

    @Data
    public static class ContractContactVo {


        private String name;


        @JSONField(serialize = false)
        private String info;


        private List<ContactInfoVo> contactInfoList;

        public void setContactName(String contactName) {
            this.name = contactName;
        }

        public String getContactName() {
            return name;
        }

    }

    @Data
    public static class ContactInfoVo {


        private Integer type;


        private String info;


        private String areaCode;

    }

}

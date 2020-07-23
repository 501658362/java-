package algorithms;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: chenchaopeng
 * Date: 2019/11/1
 */
public class C extends B {

    public static void main(String[] args) throws InterruptedException {
        List<ContractVo.CommissionVo> commissionList = Lists.newArrayList();
        for (ProductType value : ProductType.values()) {
            if (value.getCode() == 0) {
                continue;
            }
            if (ProductSubType.getProductSubTypes(value.getCode()) != null) {
                for (ProductSubType productSubType : ProductSubType.getProductSubTypes(value.getCode())) {
                    if (productSubType.getCode() == 0) {
                        continue;
                    }
                    ContractVo.CommissionVo commissionVo = new ContractVo.CommissionVo();
                    commissionVo.setProductType(value.getCode());
                    commissionVo.setProductSubType(productSubType.getCode());
                    commissionVo.setCommissionType(0);
//                    commissionVo.setStartDate(createContractParam.getStartDate());
//                    commissionVo.setEndDate(createContractParam.getEndDate());
                    commissionList.add(commissionVo);
                }
            }


        }
        List<ContractCommissionRuleDto> refundCommissionList = getRefundCommissionList(commissionList);
        System.out.println(1);

    }

    private static List<ContractCommissionRuleDto> getRefundCommissionList(List<ContractVo.CommissionVo> commissionList) {
        List<ContractCommissionRuleDto> refundCommissionList = Lists.newArrayList();
        for (ContractVo.CommissionVo commissionVo : commissionList) {
            ContractCommissionRuleDto refundCommission = new ContractCommissionRuleDto();
            refundCommission.setReturnType(2);
            refundCommission.setProductSubType(commissionVo.getProductSubType());
            refundCommission.setProductType(commissionVo.getProductType());
            refundCommission.setStartDate(commissionVo.getStartDate());
            refundCommission.setEndDate(commissionVo.getEndDate());
            refundCommissionList.add(refundCommission);
        }
        return refundCommissionList;
    }

    public static void sdfsd(C c) throws InterruptedException {

        ResellerTime uuid = c.getUuid();
        uuid.start("回家做法");
        Thread.sleep(100L);
        uuid.stop();
    }


}

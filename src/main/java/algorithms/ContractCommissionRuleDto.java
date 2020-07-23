package algorithms;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: chenchaopeng
 * Date: 2019/2/20
 */
@Data
public class ContractCommissionRuleDto implements Serializable {
    /**
     * 自增id
     */
    private Integer id;

    /**
     * 关联合同id
     */
    private Integer contractId;

    /**
     * 商品类型, 存放品类枚举值
     */
    private Integer productType;
    private Integer productSubType;


    /**
     * 规则类型 1=收佣、2=退佣 @see
     */
    private Integer ruleType;

    /**
     * 计算金额类型 0=无佣金、1=固定单价、2=百分比 @see
     */
    private Integer commissionType;

    /**
     * 退佣时：0=不退佣、1=部分退、2=全退 @see
     */
    private Integer returnType;

    /**
     * 金额, 单位分
     */
    private Integer amount;

    /**
     * rate  百分比 乘以100，如80% 存8000
     */
    private Integer rate;

    /**
     * 生效时间
     */
    private Date startDate;

    /**
     * 失效时间
     */
    private Date endDate;

    /**
     * 删除标识
     */
    private Integer yn;

    /**
     * 时间戳
     */
    private Date ts;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private String createPin;

    /**
     * 更新人
     */
    private String updatePin;

    /**
     * 合同ids 用于查询
     */
    List<Integer> contractIds;
}
package com.vip.vpal.basereport.entity;

import java.math.BigDecimal;
import java.util.Date;

public class BankCapitalFlow {
    private Integer id;

    private String bankCode;

    private String bankName;

    private String accountCode;

    private String accountAbbrName;

    private String accountDate;

    private BigDecimal lastBalance;

    private BigDecimal bankPayAmount;

    private BigDecimal bankRefundAmount;

    private BigDecimal bankPayFee;

    private BigDecimal quickPayAmount;

    private BigDecimal quickRefundAmount;

    private BigDecimal quickPayFee;

    private BigDecimal collectPayAmount;

    private BigDecimal collectPayFee;

    private BigDecimal withdrawalPayAmount;

    private BigDecimal refundPayAmount;

    private BigDecimal payFee;

    private BigDecimal bankRefundFee;

    private BigDecimal quickRefundFee;

    private BigDecimal interestAmount;

    private BigDecimal settleInterestFee;

    private BigDecimal currentApplyStoreFund;

    private BigDecimal currentTakeoutApplyStoreFund;

    private BigDecimal bankFee;

    private BigDecimal settleFeeIncome;

    private BigDecimal riskProvision;

    private BigDecimal settlementFee;

    private BigDecimal settlementFeeCost;

    private BigDecimal transferAmountIn;

    private BigDecimal transferAmountOut;

    private BigDecimal capitalTransferAmount;

    private BigDecimal transferMyself;

    private BigDecimal interestIncomeIn;

    private BigDecimal interestIncomeOut;

    private Integer status;

    private BigDecimal regularCurrentAmountIn;

    private BigDecimal regularCurrentAmountOut;

    private BigDecimal currentRegularAmountIn;

    private BigDecimal currentRegularAmountOut;

    private BigDecimal otherAmount;

    private BigDecimal currentBalance;

    private BigDecimal downlineAmount;

    private String trailResult;

    private Date createTime;

    private Date updateTime;

    private String ext1;

    private String ext2;

    private String ext3;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getAccountAbbrName() {
        return accountAbbrName;
    }

    public void setAccountAbbrName(String accountAbbrName) {
        this.accountAbbrName = accountAbbrName;
    }

    public String getAccountDate() {
        return accountDate;
    }

    public void setAccountDate(String accountDate) {
        this.accountDate = accountDate;
    }

    public BigDecimal getLastBalance() {
        return lastBalance;
    }

    public void setLastBalance(BigDecimal lastBalance) {
        this.lastBalance = lastBalance;
    }

    public BigDecimal getBankPayAmount() {
        return bankPayAmount;
    }

    public void setBankPayAmount(BigDecimal bankPayAmount) {
        this.bankPayAmount = bankPayAmount;
    }

    public BigDecimal getBankRefundAmount() {
        return bankRefundAmount;
    }

    public void setBankRefundAmount(BigDecimal bankRefundAmount) {
        this.bankRefundAmount = bankRefundAmount;
    }

    public BigDecimal getBankPayFee() {
        return bankPayFee;
    }

    public void setBankPayFee(BigDecimal bankPayFee) {
        this.bankPayFee = bankPayFee;
    }

    public BigDecimal getQuickPayAmount() {
        return quickPayAmount;
    }

    public void setQuickPayAmount(BigDecimal quickPayAmount) {
        this.quickPayAmount = quickPayAmount;
    }

    public BigDecimal getQuickRefundAmount() {
        return quickRefundAmount;
    }

    public void setQuickRefundAmount(BigDecimal quickRefundAmount) {
        this.quickRefundAmount = quickRefundAmount;
    }

    public BigDecimal getQuickPayFee() {
        return quickPayFee;
    }

    public void setQuickPayFee(BigDecimal quickPayFee) {
        this.quickPayFee = quickPayFee;
    }

    public BigDecimal getCollectPayAmount() {
        return collectPayAmount;
    }

    public void setCollectPayAmount(BigDecimal collectPayAmount) {
        this.collectPayAmount = collectPayAmount;
    }

    public BigDecimal getCollectPayFee() {
        return collectPayFee;
    }

    public void setCollectPayFee(BigDecimal collectPayFee) {
        this.collectPayFee = collectPayFee;
    }

    public BigDecimal getWithdrawalPayAmount() {
        return withdrawalPayAmount;
    }

    public void setWithdrawalPayAmount(BigDecimal withdrawalPayAmount) {
        this.withdrawalPayAmount = withdrawalPayAmount;
    }

    public BigDecimal getRefundPayAmount() {
        return refundPayAmount;
    }

    public void setRefundPayAmount(BigDecimal refundPayAmount) {
        this.refundPayAmount = refundPayAmount;
    }

    public BigDecimal getPayFee() {
        return payFee;
    }

    public void setPayFee(BigDecimal payFee) {
        this.payFee = payFee;
    }

    public BigDecimal getBankRefundFee() {
        return bankRefundFee;
    }

    public void setBankRefundFee(BigDecimal bankRefundFee) {
        this.bankRefundFee = bankRefundFee;
    }

    public BigDecimal getQuickRefundFee() {
        return quickRefundFee;
    }

    public void setQuickRefundFee(BigDecimal quickRefundFee) {
        this.quickRefundFee = quickRefundFee;
    }

    public BigDecimal getInterestAmount() {
        return interestAmount;
    }

    public void setInterestAmount(BigDecimal interestAmount) {
        this.interestAmount = interestAmount;
    }

    public BigDecimal getSettleInterestFee() {
        return settleInterestFee;
    }

    public void setSettleInterestFee(BigDecimal settleInterestFee) {
        this.settleInterestFee = settleInterestFee;
    }

    public BigDecimal getCurrentApplyStoreFund() {
        return currentApplyStoreFund;
    }

    public void setCurrentApplyStoreFund(BigDecimal currentApplyStoreFund) {
        this.currentApplyStoreFund = currentApplyStoreFund;
    }

    public BigDecimal getCurrentTakeoutApplyStoreFund() {
        return currentTakeoutApplyStoreFund;
    }

    public void setCurrentTakeoutApplyStoreFund(BigDecimal currentTakeoutApplyStoreFund) {
        this.currentTakeoutApplyStoreFund = currentTakeoutApplyStoreFund;
    }

    public BigDecimal getBankFee() {
        return bankFee;
    }

    public void setBankFee(BigDecimal bankFee) {
        this.bankFee = bankFee;
    }

    public BigDecimal getSettleFeeIncome() {
        return settleFeeIncome;
    }

    public void setSettleFeeIncome(BigDecimal settleFeeIncome) {
        this.settleFeeIncome = settleFeeIncome;
    }

    public BigDecimal getRiskProvision() {
        return riskProvision;
    }

    public void setRiskProvision(BigDecimal riskProvision) {
        this.riskProvision = riskProvision;
    }

    public BigDecimal getSettlementFee() {
        return settlementFee;
    }

    public void setSettlementFee(BigDecimal settlementFee) {
        this.settlementFee = settlementFee;
    }

    public BigDecimal getSettlementFeeCost() {
        return settlementFeeCost;
    }

    public void setSettlementFeeCost(BigDecimal settlementFeeCost) {
        this.settlementFeeCost = settlementFeeCost;
    }

    public BigDecimal getTransferAmountIn() {
        return transferAmountIn;
    }

    public void setTransferAmountIn(BigDecimal transferAmountIn) {
        this.transferAmountIn = transferAmountIn;
    }

    public BigDecimal getTransferAmountOut() {
        return transferAmountOut;
    }

    public void setTransferAmountOut(BigDecimal transferAmountOut) {
        this.transferAmountOut = transferAmountOut;
    }

    public BigDecimal getCapitalTransferAmount() {
        return capitalTransferAmount;
    }

    public void setCapitalTransferAmount(BigDecimal capitalTransferAmount) {
        this.capitalTransferAmount = capitalTransferAmount;
    }

    public BigDecimal getTransferMyself() {
        return transferMyself;
    }

    public void setTransferMyself(BigDecimal transferMyself) {
        this.transferMyself = transferMyself;
    }

    public BigDecimal getInterestIncomeIn() {
        return interestIncomeIn;
    }

    public void setInterestIncomeIn(BigDecimal interestIncomeIn) {
        this.interestIncomeIn = interestIncomeIn;
    }

    public BigDecimal getInterestIncomeOut() {
        return interestIncomeOut;
    }

    public void setInterestIncomeOut(BigDecimal interestIncomeOut) {
        this.interestIncomeOut = interestIncomeOut;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getRegularCurrentAmountIn() {
        return regularCurrentAmountIn;
    }

    public void setRegularCurrentAmountIn(BigDecimal regularCurrentAmountIn) {
        this.regularCurrentAmountIn = regularCurrentAmountIn;
    }

    public BigDecimal getRegularCurrentAmountOut() {
        return regularCurrentAmountOut;
    }

    public void setRegularCurrentAmountOut(BigDecimal regularCurrentAmountOut) {
        this.regularCurrentAmountOut = regularCurrentAmountOut;
    }

    public BigDecimal getCurrentRegularAmountIn() {
        return currentRegularAmountIn;
    }

    public void setCurrentRegularAmountIn(BigDecimal currentRegularAmountIn) {
        this.currentRegularAmountIn = currentRegularAmountIn;
    }

    public BigDecimal getCurrentRegularAmountOut() {
        return currentRegularAmountOut;
    }

    public void setCurrentRegularAmountOut(BigDecimal currentRegularAmountOut) {
        this.currentRegularAmountOut = currentRegularAmountOut;
    }

    public BigDecimal getOtherAmount() {
        return otherAmount;
    }

    public void setOtherAmount(BigDecimal otherAmount) {
        this.otherAmount = otherAmount;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public BigDecimal getDownlineAmount() {
        return downlineAmount;
    }

    public void setDownlineAmount(BigDecimal downlineAmount) {
        this.downlineAmount = downlineAmount;
    }

    public String getTrailResult() {
        return trailResult;
    }

    public void setTrailResult(String trailResult) {
        this.trailResult = trailResult;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1;
    }

    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2;
    }

    public String getExt3() {
        return ext3;
    }

    public void setExt3(String ext3) {
        this.ext3 = ext3;
    }
}
package payment.service.skf.models;

import jakarta.persistence.*;


@Entity
@Table(name = "operations")
public class Operation {


    @Column(name = "account_id")
    private int accountId;
    @Id
    @Column(name = "operation_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long operationId;
    @Column(name = "operation_type")
    private int operationType;
    @Column(name = "operation_amount")
    private long operationAmount;
    @Column(name = "sender_id")
    private int senderId;


    public Operation() {

    }


    public Operation(int accountId, long operationId, int operationType, long operationAmount) {
        this.accountId = accountId;
        this.operationId = operationId;
        this.operationType = operationType;
        this.operationAmount = operationAmount;
    }

    public Operation(int accountId, long operationId, int operationType, long operationAmount, int senderId) {
        this.accountId = accountId;
        this.operationId = operationId;
        this.operationType = operationType;
        this.operationAmount = operationAmount;
        this.senderId = senderId;
    }


    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public long getOperationId() {
        return operationId;
    }

    public void setOperationId(long operationId) {
        this.operationId = operationId;
    }

    public int getOperationType() {
        return operationType;
    }

    public void setOperationType(int operationType) {
        this.operationType = operationType;
    }

    public long getOperationAmount() {
        return operationAmount;
    }

    public void setOperationAmount(long operationAmount) {
        this.operationAmount = operationAmount;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }
}

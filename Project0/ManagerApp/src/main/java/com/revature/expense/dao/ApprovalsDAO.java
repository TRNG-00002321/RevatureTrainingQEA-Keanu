package com.revature.expense.dao;

import com.revature.expense.model.Approvals;

import java.util.List;

public interface ApprovalsDAO {
    public void addApproval(Approvals approval);
    public Approvals getApproval(int id);
    public List<Approvals> getAllApprovals();

}

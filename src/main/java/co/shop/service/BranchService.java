package co.shop.service;

import co.shop.model.entity.Branch;

import java.util.Optional;

public interface BranchService extends GenericService<Branch, Integer> {

    Optional<Branch> findByBranchCode(Integer branchCode);

    void deleteByCode(Integer code);
}

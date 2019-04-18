package com.busyqa.crm_project.repositories;

import com.busyqa.crm_project.pojo.control_access.CrmUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CrmUserRepository extends JpaRepository<CrmUser, Long> {

    CrmUser findFirst1ByUserNameAndPassword(String userName, String password);
}

package com.eletronicbanking.kftc.transaction.repository;

import com.eletronicbanking.kftc.transaction.table.ComId;
import com.eletronicbanking.kftc.transaction.table.Receive;
import com.eletronicbanking.kftc.transaction.table.Send;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SendRepository extends JpaRepository<Send, ComId> {
}

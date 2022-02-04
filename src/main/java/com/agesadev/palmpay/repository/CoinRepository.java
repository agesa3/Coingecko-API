package com.agesadev.palmpay.repository;

import com.agesadev.palmpay.model.Coin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoinRepository  extends JpaRepository<Coin, String> {
}

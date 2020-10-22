package com.laurelautolease.laurelAutoLease;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface LalRepository extends CrudRepository<Lal, String> {
}

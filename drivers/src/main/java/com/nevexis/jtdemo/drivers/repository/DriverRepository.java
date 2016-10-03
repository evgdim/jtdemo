package com.nevexis.jtdemo.drivers.repository;

import com.nevexis.jtdemo.drivers.domain.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by evgeni on 10/3/2016.
 */
@RestResource(path = "drivers", rel = "drivers")
public interface DriverRepository extends JpaRepository<Driver, Long>{
}
